package com.example.unitconvertor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class timeFragment extends Fragment {
    EditText cm, m, km;
    TextView cmans, mans, kmans;
    double cmc, mc, kmc, value;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_time, container, false);
        cm = view.findViewById(R.id.cm);
        m = view.findViewById(R.id.m);
        km = view.findViewById(R.id.km);
        cmans = view.findViewById(R.id.cmans);
        mans = view.findViewById(R.id.mans);
        kmans = view.findViewById(R.id.kmans);

        // if cm work other clear
        cm.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    m.setText("");
                    km.setText("");
                }
            }
        });

        // if m work other clear
        m.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    cm.setText("");
                    km.setText("");
                }
            }
        });

        // if km work other clear
        km.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    cm.setText("");
                    m.setText("");
                }
            }
        });
//convert sec
        cm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String userInput = s.toString();
                if (!userInput.isEmpty()) {
                    value = Double.parseDouble(userInput);
                    mc = value /60;
                    kmc = value /3600;
                    mans.setText(String.valueOf(mc));
                    kmans.setText(String.valueOf(kmc));
                } else {
                    mans.setText("");
                    kmans.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
//convert min
        m.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String userInput = s.toString();
                if (!userInput.isEmpty()) {
                    value = Double.parseDouble(userInput);
                    cmc = value * 60;
                    kmc = value /60;
                    cmans.setText(String.valueOf(cmc));
                    kmans.setText(String.valueOf(kmc));
                } else {
                    cmans.setText("");
                    kmans.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
//convert hour
        km.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String userInput = s.toString();
                if (!userInput.isEmpty()) {
                    value = Double.parseDouble(userInput);
                    mc = value * 3600;
                    cmc = value * 60;
                    cmans.setText(String.valueOf(cmc));
                    mans.setText(String.valueOf(mc));
                } else {
                    cmans.setText("");
                    mans.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
       return view;
    }
}