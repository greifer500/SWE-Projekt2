package com.example.sweprojekt.ui.home.numberinput;

import android.graphics.ImageDecoder;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sweprojekt.MainActivity;
import com.example.sweprojekt.R;

public class NumberInputFragment extends Fragment {

    public static NumberInputFragment newInstance() {
        return new NumberInputFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        MainActivity mainActivity = MainActivity.getInstance();

        View root = inflater.inflate(R.layout.number_input_fragment, container, false).getRootView();

        //todo dieses Fragment vervollständigen, nach Raum suchen muss implementiert werden

        createLayoutNumInput(root, mainActivity);

        return root;
    }

    private void createLayoutNumInput(View v, MainActivity mainActivity) {
        EditText editNumberInput = v.findViewById(R.id.editNumberInput);
        Button btnNumberSearch = v.findViewById(R.id.buttonNumberSearch);
        btnNumberSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editNumberInput.getText().toString();
                if (mainActivity.checkIfRoomExists(str)){

                } else {

                }
            }
        });
    }


}