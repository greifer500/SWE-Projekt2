package com.example.sweprojekt.ui.home.qrcodescanner;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sweprojekt.MainActivity;
import com.example.sweprojekt.R;

public class QRFragment extends Fragment {

    public static QRFragment newInstance() {
        return new QRFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.q_r_fragment, container, false).getRootView();

        //todo oh boy i dont know where to start, Martin, Franz und Erik, das hier ist euer Problem XD, welches ihr mit Yannik absprechen müsst,
        // was das Layout betrifft, keine Ahnung was ihr benutzen müsst, vlt ein container?
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.callCamera();

        return root;
    }

}

