package com.example.upr8async1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LoadAsyncTask extends AsyncTask<Void,Integer,Integer> {
    Context context;
    ProgressBar progressBar;
    TextView textView;
    EditText editText;
    Button button;

    public LoadAsyncTask(Context context, ProgressBar progressBar, TextView textView, EditText editText, Button button) {
        this.context = context;
        this.progressBar = progressBar;
        this.textView = textView;
        this.editText = editText;
        this.button = button;
    }

    protected void onPreExecute() {
        super.onPreExecute();
        progressBar.setVisibility(ProgressBar.VISIBLE);
        progressBar.setMax(Integer.parseInt(editText.getText().toString()));

    }
    protected void onProgressUpdate(Integer... values) {
        // Изпълнява се всеки път, когато се публикува прогрес извиква се от doInBackground
        // Използва се за актуализиране на индикатора за напредък

        textView.setTextColor(Color.parseColor("#FF0000"));
        textView.setText("Running!");
        super.onProgressUpdate(values);
        progressBar.setProgress(values[0]);
    }
    @SuppressLint("WrongThread")
    @Override
    protected Integer doInBackground(Void... voids) {
        //tuk moje da e problem
        for(int i=0;i<Integer.parseInt(editText.getText().toString());i++)
        {
            publishProgress(i);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
        return null;
    }
    protected void onPostExecute(Integer result) {
        // Този метод се изпълнява от UIThread
        // като достъпва резултата от продължителната задача
        textView.setTextColor(Color.parseColor("#7FFF00"));
        textView.setText("Finished!");
        // Скриване на индикатор за напредък
        progressBar.setVisibility(ProgressBar.INVISIBLE);
        button.setEnabled(true);
    }



}
