package com.example.sweprojekt.ui.list.buildings;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sweprojekt.MainActivity;
import com.example.sweprojekt.R;

public class BuildingsListFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,  ViewGroup container,
                              Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.buildings_list_fragment, container, false).getRootView();

        ListView lv = root.findViewById(R.id.ListBuildings);
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.setAdapterBuildings(lv);
        //todo Öffnen vom Gebäude mit spezifischer Information (wahrscheinlich in einer Activity mit einem Fragment)
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                mainActivity.deleteItemBuildings(position);
                ((ArrayAdapter<String>) lv.getAdapter()).notifyDataSetChanged();

                Toast toast = Toast.makeText(getActivity().getApplicationContext(),"YEET", Toast.LENGTH_SHORT);
                toast.show();

                return true;
            }
        });

        return root;
    }
}