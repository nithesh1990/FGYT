package com.fgyt.utils;

import android.util.Log;

import com.fgyt.BuildConfig;

public class Logger {

	private final String TAG = "FGYTLogger";
	
	public void dLog(String module, String heading, String Content) {
		if(BuildConfig.DEBUG) {
			Log.d(TAG, "["+module+"]"+heading+": "+Content);
		}
	}

	public void eLog(String module, String heading, String Content) {
		if(BuildConfig.DEBUG) {
			Log.e(TAG, "["+module+"]"+heading+": "+Content);
		}
	}

	public void iLog(String module, String heading, String Content) {
		if(BuildConfig.DEBUG) {
			Log.i(TAG, "["+module+"]"+heading+": "+Content);
		}
	}

	public void vLog(String module, String heading, String Content) {
		if(BuildConfig.DEBUG) {
			Log.v(TAG, "["+module+"]"+heading+": "+Content);
		}
	}

}
