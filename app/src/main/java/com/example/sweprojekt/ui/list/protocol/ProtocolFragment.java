package com.example.sweprojekt.ui.list.protocol;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.sweprojekt.MainActivity;
import com.example.sweprojekt.R;
import com.example.sweprojekt.ui.home.protocol.ProtocolActivity;
import com.example.sweprojekt.ui.list.showbuilding.ShowBuildingActivity;

public class ProtocolFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_protocol, container, false).getRootView();

        ListView lv = root.findViewById(R.id.ListProtocol);
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.setAdapterProtocols(lv);



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ProtocolActivity.class);
                String sProtocolID = parent.getItemAtPosition(position).toString();
                String[] splitProtocol = sProtocolID.split(" - ");
                int protocolID = Integer.valueOf(splitProtocol[0]);
                intent.putExtra("logID", protocolID);
                startActivity(intent);
            }
        });

        return root;
    }
}