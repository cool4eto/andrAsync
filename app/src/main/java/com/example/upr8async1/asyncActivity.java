package com.example.upr8async1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class asyncActivity extends AppCompatActivity implements ProgressFinishListener {

    private TextView textView;
    private EditText editText;
    private Button button;
    private ProgressBar progressBar;
    private Button button2;
    private Button button5;

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        textView=findViewById(R.id.textView);
        editText=findViewById(R.id.editText);
        button=findViewById(R.id.button);
        progressBar=findViewById(R.id.progressBar);
        button2=findViewById(R.id.button2);
        button5=findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadAsyncTask async1=new LoadAsyncTask(asyncActivity.this,progressBar,textView,editText,button);
                async1.execute();
                button.setEnabled(false);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadAsyncTask2 async2=new LoadAsyncTask2(asyncActivity.this,textView);
                async2.execute(Integer.parseInt(editText.getText().toString()));

            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*FragmentManager fm = getSupportFragmentManager();
                ProgressFragment progressFragment = ProgressFragment.newInstance(editText.getText().toString());
                progressFragment.show(fm, "fragment1");*/
                FragmentManager fm = getSupportFragmentManager();
                LoadAsyncTask3 async3=new LoadAsyncTask3(fm,asyncActivity.this);
                async3.execute(Integer.parseInt(editText.getText().toString()));
            }
        });

    }

    @Override
    public void Result(String Value) {
        textView.setText(Value);
        textView.setTextColor(Color.GREEN);
    }
}
