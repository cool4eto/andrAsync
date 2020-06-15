package com.example.upr8async1;

import android.os.AsyncTask;

import androidx.fragment.app.FragmentManager;

public class LoadAsyncTask3 extends AsyncTask<Integer,Integer,String> {
    ProgressFragment progressFragment;
    FragmentManager fragmentManager;
    ProgressFinishListener listener;

    public LoadAsyncTask3(FragmentManager fragmentManager,ProgressFinishListener listener) {

        this.fragmentManager = fragmentManager;
        this.listener=listener;
    }
    protected void onPreExecute()
    {
        super.onPreExecute();
        progressFragment=ProgressFragment.newInstance(1);
        progressFragment.show(fragmentManager,"Dialog");

    }

    @Override
    protected String doInBackground(Integer... integers) {
        int secs=integers[0];
        for(int i=secs;i>=0;i--)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
        }
        return "Finished!";

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressFragment.UpdateValue(values[0]);
    }
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        listener.Result(s);
        progressFragment.dismiss();
    }
}
