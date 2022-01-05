package com.example.sweprojekt.ui.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.sweprojekt.R;
import com.example.sweprojekt.databinding.FragmentListBinding;
import com.example.sweprojekt.ui.list.buildings.BuildingsListFragment;
import com.example.sweprojekt.ui.list.protocol.ProtocolFragment;
import com.example.sweprojekt.ui.list.rooms.RoomsListFragment;
import com.google.android.material.tabs.TabLayout;

public class ListFragment extends Fragment {
    private FragmentListBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        createLayoutList(root);

        return root;
    }

    private void createLayoutList(View v) {
        if (true){
            createFragmentManagerRooms();
        }
        TabLayout tabLayout = v.findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (tab.getPosition()){
                    case 0:
                        createFragmentManagerRooms();
                        break;
                    case 1:
                        createFragmentManagerBuildings();
                        break;
                    case 2:
                        createFragmentManagerProtocol();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void createFragmentManagerProtocol() {
        FragmentManager fragmentManager = getParentFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerList, ProtocolFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
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