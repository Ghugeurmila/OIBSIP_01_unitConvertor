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


public class weightFragment extends Fragment {

    EditText gm,kg,pound;
    TextView cgm,ckg,cpound;
    double gmc,kgc,poundc, value;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_weight, container, false);
        kg = view.findViewById(R.id.kg);
        gm = view.findViewById(R.id.gm);
        pound = view.findViewById(R.id.pound);
        ckg = view.findViewById(R.id.ckg);
        cgm = view.findViewById(R.id.cgm);
        cpound = view.findViewById(R.id.cpound);
        kg.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    gm.setText("");
                    pound.setText("");
                }
            }
        });

        // if m work other clear
        gm.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    kg.setText("");
                    pound.setText("");
                }
            }
        });

        // if km work other clear
        pound.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    kg.setText("");
                    gm.setText("");
                }
            }
        });

        kg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String userInput = s.toString();
                if (!userInput.isEmpty()) {
                    value = Double.parseDouble(userInput);
                    gmc = value * 1000;
                    poundc = value *2.204;
                    cgm.setText(String.valueOf(gmc));
                    cpound.setText(String.valueOf(poundc));
                } else {
                    cgm.setText("");
                    cpound.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        gm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String userInput = s.toString();
                if (!userInput.isEmpty()) {
                    value = Double.parseDouble(userInput);
                    kgc = value * 0.001;
                    poundc = value * 0.0022;
                    ckg.setText(String.valueOf(kgc));
                    cpound.setText(String.valueOf(poundc));
                } else {
                    ckg.setText("");
                    cpound.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        pound.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String userInput = s.toString();
                if (!userInput.isEmpty()) {
                    value = Double.parseDouble(userInput);
                    kgc = value *0.453;
                    gmc = value * 453.59;
                    ckg.setText(String.valueOf(kgc));
                    cgm.setText(String.valueOf(gmc));
                } else {
                    ckg.setText("");
                    cgm.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        return view;
    }
}