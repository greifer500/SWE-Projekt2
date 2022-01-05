package com.example.sweprojekt.ui.list.rooms;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
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
import com.example.sweprojekt.ui.list.showroom.ShowRoomActivity;

public class RoomsListFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.rooms_list_fragment, container, false).getRootView();

        ListView lv = root.findViewById(R.id.ListRooms);
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.setAdapterRooms(lv);

        //todo vielleicht mehr Icons für die Räume geben wie zb Stuhl-Icon + Zahl ect
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ShowRoomActivity.class);
                String roomName = parent.getItemAtPosition(position).toString();
                intent.putExtra("roomName", roomName);
                startActivity(intent);
            }
        });

        return root;
    }
}

