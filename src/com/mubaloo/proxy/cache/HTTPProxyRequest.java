/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mubaloo.proxy.cache;

import com.mubaloo.proxy.utils.Logger;
import com.mubaloo.proxy.utils.Mubaloo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import static org.apache.http.params.CoreProtocolPNames.USER_AGENT;

/**
 *
 * @author Zahid
 */
public class HTTPProxyRequest {

    private final String url;   //server url

    public HTTPProxyRequest(String url) {
        this.url = url;
    }


    /*
     private final List<Parameter> parameters;
     private final String url;

     public HTTPProxyRequest(String url, List<Parameter> parameters) {
     this.parameters = parameters;
     this.url = url;
     }

     public String buildEncodedURL() {
     String s = url;

     Parameter p;
     for (int i = 0; i < parameters.size(); i++) {
     p = parameters.get(i);

     s += p.encodeParameter((i == 0) ? "?" : "&");
     }

     s += (parameters.size() == 0) ? "?" : "&" + "platform=android";

     return s;
     }

     public List<NameValuePair> buildPostUrl() {
     List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();

     for (int i = 0; i < parameters.size(); i++) {

     nameValuePairList.add(new BasicNameValuePair(parameters.get(i).getKey(), parameters.get(i).getValue().toString()));
     }

     return nameValuePairList;
     }
     */
    //Can implement in future
    public HTTPProxyResponse httpPOST() {
        return null;

    }

    public HTTPProxyResponse httpGET() {

        HttpClient client = new DefaultHttpClient();
        HttpGet request;

        try {
            //can add more logic such time out and so on
            
            request = new HttpGet(url);
            // add request header
            request.addHeader("User-Agent", USER_AGENT);

            HttpResponse response = client.execute(request);

            Logger.d(Mubaloo.TAG.toString(), "\nSending 'GET' request to URL : " + url);
            Logger.d(Mubaloo.TAG.toString(), "Response Code : " + response.getStatusLine().getStatusCode());

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                buffer.append(line);
            }
            return new HTTPProxyResponse(200, buffer.toString());
        } catch (UnknownHostException e) {
            Logger.d(Mubaloo.TAG.toString(), e + "UnknownHostException ", e.getMessage());
        } catch (SocketTimeoutException e) {
            Logger.d(Mubaloo.TAG.toString(), e + "SocketTimeoutException ", e.getMessage());
        } catch (SocketException e) {
            Logger.d(Mubaloo.TAG.toString(), e + "SocketException ", e.getMessage());
        } catch (IOException ex) {
            Logger.d(Mubaloo.TAG.toString(), ex + "IOException ", ex.getMessage());
        }

        return null;
    }

    private Exception urlRule(String server) {
        if (server.endsWith("/")) {
            return new Exception("Server url must not end with a '/' character");
        }

        return null;
    }



}
