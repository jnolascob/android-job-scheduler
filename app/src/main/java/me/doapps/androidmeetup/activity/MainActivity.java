package me.doapps.androidmeetup.activity;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import me.doapps.androidmeetup.R;
import me.doapps.androidmeetup.broadcast.SampleReceiver;
import me.doapps.androidmeetup.service.CounterIntentService;
import me.doapps.androidmeetup.service.CounterService;
import me.doapps.androidmeetup.service.JobSchedulerService;

public class MainActivity extends AppCompatActivity {
    private static int jobId = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        IntentFilter filter = new IntentFilter();
//        filter.addAction("me.doapps.Sample");
//        filter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
//        SampleReceiver sampleReceiver = new SampleReceiver();
//        registerReceiver(sampleReceiver, filter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

//                Log.e("sendBroadcast", "ok");
//                Intent intent = new Intent();
//                intent.setAction("me.doapps.Sample");
//                intent.putExtra("status", "complete");
//                sendBroadcast(intent);
                Log.e("jobScheduler", "ok");

                ComponentName componentName = new ComponentName(MainActivity.this, JobSchedulerService.class);
                JobInfo jobInfo = new JobInfo.Builder(jobId, componentName)
                        .setPeriodic(1000 * 60 * 15)
//                        .setMinimumLatency(1000 * 5)
                        .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                        .build();

                JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
                jobScheduler.schedule(jobInfo);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
//        startService(new Intent(this, CounterService.class));
//        startService(new Intent(this, CounterIntentService.class));
        super.onResume();
    }
}
