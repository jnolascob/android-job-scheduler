package me.doapps.androidmeetup.service;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

/**
 * Created by jonathannolasco on 5/1/18.
 */

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class JobSchedulerService extends JobService {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
    }

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.e("onStartJob", "ok");
        runFakeProcess(jobParameters);
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.e("onStopJob", "ok");
        return false;
    }

    private void runFakeProcess(JobParameters jobParameters) {
        int i = 0;
        while (true) {
            i++;
            if (i == 3) {
                jobFinished(jobParameters, false);
                break;
            }
            Log.e("->", i + "");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
