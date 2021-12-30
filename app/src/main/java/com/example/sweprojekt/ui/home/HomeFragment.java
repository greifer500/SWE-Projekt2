package com.example.sweprojekt.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.sweprojekt.R;
import com.example.sweprojekt.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        createButtonsHome(root);

        return root;
    }

    public void createButtonsHome(View v){
        ImageButton btnQRCS = v.findViewById(R.id.buttonQRCS);
        btnQRCS.setOnClickListener(v1 -> {
            Context context = v1.getContext();
            CharSequence text = "QR";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        });

        ImageButton btnNbrs = v.findViewById(R.id.buttonNumbers);
        btnNbrs.setOnClickListener(v12 -> {
            Context context = v12.getContext();
            CharSequence text = "123";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        });

        ImageButton btnNewR = v.findViewById(R.id.buttonNewRoom);
        btnNewR.setOnClickListener(v13 -> {
            Context context = v13.getContext();
            CharSequence text = "+";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

