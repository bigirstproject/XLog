package com.ppmoney.xlogdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tencent.mars.xlog.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread() {
            @Override
            public void run() {
                super.run();
                while (cont != -1) {
                    cont++;
                    Log.d(TAG, "setContentView(R.layout.activity_main) cont = " + cont);
                    if (cont == 10000) {
                        cont = -1;
                    }
                }
            }
        }.start();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.appenderClose();
    }


}
