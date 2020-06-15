package com.example.upr8async1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondAsyncActivity extends AppCompatActivity implements SecondFinishListener{
    private Button button;
    private Boolean firstTaskResult=null;
    private Boolean secondTaskResult=null;
    private TextView textView;
    private  ProgressFragment progressFragment=new ProgressFragment();
    private int progressHide=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_async);
        button=findViewById(R.id.button6);
        textView=findViewById(R.id.textView3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressHide=0;
                progressFragment=ProgressFragment.newInstance(1);
                progressFragment.show(getSupportFragmentManager(),"Dialog");
                SecondLoadAsyncTask firstTask=new SecondLoadAsyncTask(SecondAsyncActivity.this);
                firstTask.execute();
                SecondLoadAsyncTask1 secondTask=new SecondLoadAsyncTask1(SecondAsyncActivity.this);
                secondTask.execute();
            }
        });
    }

    @Override
    public void FirstResult(Boolean value) {
        firstTaskResult=value;
        textChanger();
    }

    @Override
    public void SecondResult(Boolean value) {
        secondTaskResult=value;
        textChanger();
    }
    public void textChanger()
    {
        progressHide++;
        if(progressHide==2)
        progressFragment.dismiss();

        if(firstTaskResult!=null&&secondTaskResult!=null)
            if(firstTaskResult==true&&secondTaskResult==true)
            {
                textView.setText("Success!!!");
            }
            else textView.setText("Fail!!!");
    }
}
