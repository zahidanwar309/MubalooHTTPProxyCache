/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mubaloo.proxy.cache;

/**
 *
 * @author Zahid
 */
public class HTTPProxyResponse {
    private int responsecode;
    private String responsetext;
    
    public HTTPProxyResponse() {
    }
    
    public HTTPProxyResponse(int responsecode, String responsetext) {
        this.responsecode = responsecode;
        this.responsetext = responsetext;
    }

    public void setResponseCode(int responsecode) {
        this.responsecode = responsecode;
    }

    public void setResponseText(String responsetext) {
        this.responsetext = responsetext;
    }

    public int getResponseCode() {
        return responsecode;
    }

    public String getResponseText() {
        return responsetext;
    }
    

}
