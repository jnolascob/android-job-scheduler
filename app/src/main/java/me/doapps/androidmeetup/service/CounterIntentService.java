package me.doapps.androidmeetup.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by jonathannolasco on 5/1/18.
 */

public class CounterIntentService extends IntentService {
    public CounterIntentService() {
        super("CounterIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        runFakeProcess();
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
