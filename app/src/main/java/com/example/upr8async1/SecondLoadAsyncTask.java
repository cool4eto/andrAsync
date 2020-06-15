package com.example.upr8async1;

import android.os.AsyncTask;
import android.util.Log;

import java.util.Random;

public class SecondLoadAsyncTask extends AsyncTask<Integer,Integer,Boolean> {
    SecondFinishListener listener;
    Integer secs;


    public SecondLoadAsyncTask(SecondFinishListener listener) {
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        secs=new Random().nextInt(3)+2;//da pitam kak raboti
        Log.d("FirstSecs", "value: " + secs);
    }
    @Override
    protected Boolean doInBackground(Integer... integers) {
        for(int i=secs;i>=0;i--)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
        }
        return Math.random() < 0.5;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        listener.SecondResult(aBoolean);
    }
}
