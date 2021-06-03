package com.choirulhuda.belajarsharedpreference.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.choirulhuda.belajarsharedpreference.MainActivity;
import com.choirulhuda.belajarsharedpreference.R;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private EditText edtUsername, edtPassword;
    private Button btnLogin;
    private CheckBox checkBoxRemember;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;


    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        edtUsername = rootView.findViewById(R.id.edt_username);
        edtPassword = rootView.findViewById(R.id.edt_password);
        btnLogin = rootView.findViewById(R.id.btn_login);
        checkBoxRemember = rootView.findViewById(R.id.check_box_remember);

        btnLogin.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pref = PreferenceManager.getDefaultSharedPreferences(getActivity());

        if (pref.getString("LOGIN_PREF", "") != null) {
            edtUsername.setText(pref.getString("LOGIN_PREF", ""));
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_login:
                boolean isCompleted = false;
                String username = "";
                if (edtUsername.getText().toString().isEmpty()){
                    edtUsername.setError(getString(R.string.tidak_boleh_kosong));
                    edtUsername.requestFocus();
                    isCompleted = false;
                } else {
                    isCompleted = true;
                    username = edtUsername.getText().toString();
                }

                if (edtPassword.getText().toString().isEmpty()){
                    edtPassword.setError(getString(R.string.tidak_boleh_kosong));
                    edtPassword.requestFocus();
                    isCompleted = false;
                } else {
                    isCompleted = true;
                }

                if (checkBoxRemember.isChecked()){
                    if (!username.isEmpty()) {
                        editor = pref.edit();
                        editor.putString("LOGIN_PREF", username);
                        editor.apply();
                    }
                } else {
                    if (!pref.getString("LOGIN_PREF", "").isEmpty()){
                        editor = pref.edit();
                        editor.putString("LOGIN_PREF", "");
                        editor.apply();
                    }
                }

                if (isCompleted) {
                    Fragment fragment = null;
                    Class fragmentClass = null;
                    fragmentClass = LoggedInFragment.class;
                    try {
                        fragment = (Fragment) fragmentClass.newInstance();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (java.lang.InstantiationException e) {
                        e.printStackTrace();
                    }

                    Bundle arguments = new Bundle();
                    arguments.putString("PESAN_SUKSES", "sukses login pada aplikasi");
                    arguments.putString("USERNAME", username);
                    fragment.setArguments(arguments);

                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.frameLayoutContent, fragment).commit();
                }
                break;
        }
    }
}