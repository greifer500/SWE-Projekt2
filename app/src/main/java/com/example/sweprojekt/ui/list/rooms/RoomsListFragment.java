package com.example.sweprojekt.ui.list.rooms;

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

public class RoomsListFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.rooms_list_fragment, container, false).getRootView();

        ListView lv = root.findViewById(R.id.ListRooms);
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.setAdapterRooms(lv);
        //todo Öffnen vom Raum mit spezifischer Information (wahrscheinlich in einer Activity die als Host für 2 Fragmente gilt,
        // diese sollten sein: Raum-Infos und Logger)

        //todo vielleicht mehr Icons für die Räume geben wie zb Stuhl-Icon + Zahl ect
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                mainActivity.deleteItemRooms(position);
                ((ArrayAdapter<String>) lv.getAdapter()).notifyDataSetChanged();

                Toast toast = Toast.makeText(getActivity().getApplicationContext(),"YEET", Toast.LENGTH_SHORT);
                toast.show();

                return true;
            }
        });

        return root;
    }
}

