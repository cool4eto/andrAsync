package com.example.upr8async1;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;



public class ProgressFragment extends DialogFragment{
    private TextView textView2;
    public ProgressFragment() {
        // Required empty public constructor
    }
    public static ProgressFragment newInstance(int time) {
       return new ProgressFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_progress, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView2 = view.findViewById(R.id.textView2);
    }
    public void UpdateValue(int value)
    {
        textView2.setText("Remaining: "+value);
    }

}
