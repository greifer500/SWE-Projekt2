package com.example.sweprojekt.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.sweprojekt.R;
import com.example.sweprojekt.databinding.FragmentHomeBinding;
import com.example.sweprojekt.ui.home.newroom.NewRoomActivity;
import com.example.sweprojekt.ui.home.newroom.newbuilding.NewBuildingActivity;
import com.example.sweprojekt.ui.home.numberinput.NumberInputFragment;
import com.example.sweprojekt.ui.home.qrcodescanner.QRFragment;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        createLayoutHome(root);

        return root;
    }

    public void createLayoutHome(View v){
        if (true){
            createFragmentManagerQRSC();
        }

        ImageButton btnQRCS = v.findViewById(R.id.buttonQRCS);
        btnQRCS.setOnClickListener(v1 -> createFragmentManagerQRSC());

        ImageButton btnNbrs = v.findViewById(R.id.buttonNumbers);
        btnNbrs.setOnClickListener(v12 -> createFragmentManagerNumbers());

        ImageButton btnNewR = v.findViewById(R.id.buttonNewRoom);
        btnNewR.setOnClickListener(v13 -> goToActivityNewRoom());
    }

    public void createFragmentManagerQRSC(){
        FragmentManager fragmentManager = getParentFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerHome, QRFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack(null) // name can be null
                .commit();
    }

    public void createFragmentManagerNumbers(){
        FragmentManager fragmentManager = getParentFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerHome, NumberInputFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack(null) // name can be null
                .commit();
    }

    public void goToActivityNewRoom(){
        Intent intent = new Intent(getActivity(), NewRoomActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

