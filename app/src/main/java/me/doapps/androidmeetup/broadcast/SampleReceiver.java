package me.doapps.androidmeetup.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by jonathannolasco on 5/1/18.
 */

public class SampleReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("onReceive", "success - " + intent.getAction());
    }
}
