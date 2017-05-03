package com.ppmoney.xlogdemo;

import android.app.Application;
import android.os.Environment;

import com.tencent.mars.xlog.Log;
import com.tencent.mars.xlog.Xlog;

/**
 * Created by lidexian on 2017/4/28.
 */

public class XLogApplication extends Application {

    static {
        System.loadLibrary("stlport_shared");
        System.loadLibrary("marsxlog");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        String SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath();
        String logPath = SDCARD + "/marssample/log";

        //init xlog
        if (BuildConfig.DEBUG) {
            Xlog.appenderOpen(Xlog.LEVEL_DEBUG, Xlog.AppednerModeAsync, "", logPath, "MarsSample");
            Xlog.setConsoleLogOpen(true);

        } else {
            Xlog.appenderOpen(Xlog.LEVEL_INFO, Xlog.AppednerModeAsync, "", logPath, "MarsSample");
            Xlog.setConsoleLogOpen(false);
        }

        Log.setILog(new Xlog());
        Log.d("XLogApplication ", "logPath = " + logPath);
    }


}
