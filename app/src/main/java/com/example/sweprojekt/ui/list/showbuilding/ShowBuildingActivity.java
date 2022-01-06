package com.example.sweprojekt.ui.list.showbuilding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;

import com.example.sweprojekt.MainActivity;
import com.example.sweprojekt.R;
import com.example.sweprojekt.data.Attribute;
import com.example.sweprojekt.data.Building;
import com.example.sweprojekt.data.Room;
import com.example.sweprojekt.data.RoomAttribute;
import com.example.sweprojekt.data.rcDataBase;

public class ShowBuildingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_show_building);

        MainActivity mainActivity = MainActivity.getInstance();

        String buildingName = getIntent().getExtras().getString("buildingName");

        String[] buildingSplit = buildingName.split(" - ");
        String prefix = buildingSplit[0];
        rcDataBase db = rcDataBase.getInstance(mainActivity);
        Building building = db.buildingDao().getByPrefix(prefix);



        Toolbar tSB = findViewById(R.id.toolbarBuildings);
        tSB.setTitle("Gebäude "  + "Nummer"); //todo funktion für Gebaäudename

        EditText etSBN = findViewById(R.id.editTextShowBuildingDescription);
        etSBN.setText(building.description);
        etSBN.setEnabled(false);

        EditText etSBD = findViewById(R.id.editTextShowBuildingName);
        etSBD.setText(building.buildingPrefix);

        etSBD.setEnabled(false);
    }
}