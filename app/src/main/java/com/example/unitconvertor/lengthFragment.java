package com.example.unitconvertor;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class lengthFragment extends Fragment {
    EditText cm, m, km;
    TextView cmans, mans, kmans;
    double cmc, mc, kmc, value;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_length, container, false);
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

        cm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String userInput = s.toString();
                if (!userInput.isEmpty()) {
                    value = Double.parseDouble(userInput);
                    mc = value * 0.01;
                    kmc = value * 0.00001;
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

        m.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String userInput = s.toString();
                if (!userInput.isEmpty()) {
                    value = Double.parseDouble(userInput);
                    cmc = value * 100;
                    kmc = value * 0.001;
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

        km.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String userInput = s.toString();
                if (!userInput.isEmpty()) {
                    value = Double.parseDouble(userInput);
                    mc = value * 1000;
                    cmc = value * 100000;
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
