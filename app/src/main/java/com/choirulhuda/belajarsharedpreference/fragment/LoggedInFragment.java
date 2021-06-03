package com.choirulhuda.belajarsharedpreference.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.choirulhuda.belajarsharedpreference.R;

public class LoggedInFragment extends Fragment {

    private String message, username;
    private TextView txtMessage;

    public LoggedInFragment() {
        /*Bundle args = new Bundle();
        args.getBundle("PESAN_SUKSES");*/
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            message = getArguments().getString("PESAN_SUKSES");
            username = getArguments().getString("USERNAME");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_logged_in, container, false);
        txtMessage = rootView.findViewById(R.id.txt_message);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtMessage.setText(username+", "+message);
    }
}