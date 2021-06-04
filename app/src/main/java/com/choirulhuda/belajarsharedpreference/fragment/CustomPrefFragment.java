package com.choirulhuda.belajarsharedpreference.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.choirulhuda.belajarsharedpreference.R;


public class CustomPrefFragment extends Fragment {

    private EditText edtLampName;
    private Spinner spinnerLampNumber, spinnerDimLevel;
    private CheckBox checkBoxKelapKelip;
    private Switch switchSensor;
    private ToggleButton toggleBtnFireUp;

    public CustomPrefFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_custom_pref, container, false);
        edtLampName = rootView.findViewById(R.id.edt_lamp_name);
        spinnerLampNumber = rootView.findViewById(R.id.spinner_lamp_number);
        spinnerDimLevel = rootView.findViewById(R.id.spinner_dim_level);
        checkBoxKelapKelip = rootView.findViewById(R.id.check_box_kelap_kelip);
        switchSensor = rootView.findViewById(R.id.switch_sensor);
        toggleBtnFireUp = rootView.findViewById(R.id.toggleButton_fire_up);
        toggleBtnFireUp.setChecked(true);

        toggleBtnFireUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = 1;
                /*if (i < 2)
                    toggleBtnFireUp.setChecked(false);*/
            }
        });

        return rootView;
    }
}