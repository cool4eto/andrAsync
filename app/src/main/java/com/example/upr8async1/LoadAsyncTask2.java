package com.example.upr8async1;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.widget.TextView;

public class LoadAsyncTask2 extends AsyncTask<Integer, Integer, Void> {

    ProgressDialog progressDialog;
    Context context;
    TextView textView;

    public LoadAsyncTask2(Context context, TextView textView) {
        this.context = context;
        this.textView = textView;
    }

    @Override
    protected Void doInBackground(Integer... integers) {
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
        return null;
    }
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressDialog.setMessage(String.valueOf(values[0]));
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog = ProgressDialog.show(context,
                "ProgressDialog",
                "Wait!");
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        textView.setText("Finished!!!");

        progressDialog.dismiss();
    }

}

