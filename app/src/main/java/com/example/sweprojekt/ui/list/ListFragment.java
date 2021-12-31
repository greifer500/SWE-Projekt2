package com.example.sweprojekt.ui.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.sweprojekt.R;
import com.example.sweprojekt.databinding.FragmentListBinding;
import com.example.sweprojekt.ui.list.buildings.BuildingsListFragment;
import com.example.sweprojekt.ui.list.rooms.RoomsListFragment;

public class ListFragment extends Fragment {
    private FragmentListBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        createButtonsList(root);

        return root;
    }

    private void createButtonsList(View v) {
        if (true){
            createFragmentManagerRooms();
        }

        Button btnRooms = v.findViewById(R.id.buttonRooms);
        btnRooms.setOnClickListener(v1 -> createFragmentManagerRooms());

        Button btnBuildings = v.findViewById(R.id.buttonBuilding);
        btnBuildings.setOnClickListener(v1 -> createFragmentManagerBuildings());
    }

    private void createFragmentManagerRooms() {
        FragmentManager fragmentManager = getParentFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerList, RoomsListFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
    }

    private void createFragmentManagerBuildings() {
        FragmentManager fragmentManager = getParentFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerList, BuildingsListFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}