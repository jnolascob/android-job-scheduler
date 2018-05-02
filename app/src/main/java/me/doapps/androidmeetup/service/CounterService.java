package me.doapps.androidmeetup.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by jonathannolasco on 5/1/18.
 */

public class CounterService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("SERVICE", "started");
        new Thread(new Runnable() {
            @Override
            public void run() {
                runFakeProcess();
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    private void runFakeProcess() {
        int i = 0;
        while (true) {
            i++;
            Log.e("->", i + "");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
