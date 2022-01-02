package com.example.sweprojekt.ui.home.numberinput;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sweprojekt.R;

public class NumberInputFragment extends Fragment {

    public static NumberInputFragment newInstance() {
        return new NumberInputFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.number_input_fragment, container, false).getRootView();

        //todo dieses Fragment vervollständigen, Texteingabe mit Knopf verbinden und nach Raum suchen

        createButtonsAndTextInput();

        return root;
    }

    private void createButtonsAndTextInput() {

    }


}