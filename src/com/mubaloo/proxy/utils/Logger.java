/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mubaloo.proxy.utils;

import com.mubaloo.proxy.cache.BuildConfig;


/**
 *
 * @author Zahid
 */
public class Logger {

    private static boolean isDebug = BuildConfig.DEBUG;

    static public void d(String tag, String msgFormat) {
        if (isDebug) {
            android.util.Log.d(tag, msgFormat);
        }
    }

    static public void d(String tag, String msgFormat, Object... args) {
        if (isDebug) {
            android.util.Log.d(tag, String.format(msgFormat, args));
        }
    }

    static public void d(String tag, Throwable t, String msgFormat, Object... args) {
        if (isDebug) {
            android.util.Log.d(tag, String.format(msgFormat, args), t);
        }
    }

        static public void w(String tag, String msgFormat) {
        if (isDebug) {
            android.util.Log.w(tag, msgFormat);
        }
    }

    static public void w(String tag, String msgFormat, Object... args) {
        if (isDebug) {
            android.util.Log.w(tag, String.format(msgFormat, args));
        }
    }

    static public void w(String tag, Throwable t, String msgFormat, Object... args) {
        if (isDebug) {
            android.util.Log.w(tag, String.format(msgFormat, args), t);
        }
    }
    
    static public void e(String tag, String msgFormat) {
        if (isDebug) {
            android.util.Log.e(tag, msgFormat);
        }
    }

    static public void e(String tag, String msgFormat, Object... args) {
        if (isDebug) {
            android.util.Log.e(tag, String.format(msgFormat, args));
        }
    }

    static public void e(String tag, Throwable t, String msgFormat, Object... args) {
        if (isDebug) {
            android.util.Log.e(tag, String.format(msgFormat, args), t);
        }
    }
}