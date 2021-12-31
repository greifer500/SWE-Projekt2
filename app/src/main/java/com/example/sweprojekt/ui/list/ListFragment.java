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
import com.google.android.material.tabs.TabLayout;

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
        TabLayout tabLayout = v.findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText("Räume"));

        tabLayout.addTab(tabLayout.newTab().setText("Gebäude"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (tab.getPosition()){
                    case 1:
                        createFragmentManagerRooms();
                        break;
                    case 2:
                        createFragmentManagerBuildings();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//        Button btnRooms = (Button) v.findViewById(R.id.tabRooms);
//        btnRooms.setOnClickListener(v1 -> createFragmentManagerRooms());
//
//        Button btnBuildings =  v.findViewById(R.id.tabBuildings);
//        btnBuildings.setOnClickListener(v1 -> createFragmentManagerBuildings());
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