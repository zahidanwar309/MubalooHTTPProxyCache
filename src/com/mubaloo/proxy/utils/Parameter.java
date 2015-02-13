/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mubaloo.proxy.utils;


/**
 * TODO - Subclass Parameter to support URL encoding; something like EncodedParameter
 */

/**
 * A key-value pair mapping the parameter
 * name (key) to a value.
 *
 * @param <T> The value's type
 * @author Zahid
 */
public class Parameter<T> {
    private String key;
    private T value;
    
    public Parameter(String key, T value) {
        this.key = key;
        this.value = value;
    }
    
    /**
     * Ensure the parameter is correctly formatted.
     * 
     * @param appender '?' for the first parameter, '&' for subsequent parameters.
     * @return 
     */
    public String encodeParameter(String appender) {
        return String.format("%s%s=%s", appender, key.toString(), value.toString());
    }

    public String getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }
    
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Parameter) &&
                ((Parameter)obj).getKey().equals(key) && ((Parameter)obj).getValue().equals(value);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.key != null ? this.key.hashCode() : 0);
        hash = 59 * hash + (this.value != null ? this.value.hashCode() : 0);
        return hash;
    }
    
    
}
