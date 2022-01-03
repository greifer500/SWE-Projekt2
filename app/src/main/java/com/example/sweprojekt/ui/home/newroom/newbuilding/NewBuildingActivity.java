package com.example.sweprojekt.ui.home.newroom.newbuilding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sweprojekt.MainActivity;
import com.example.sweprojekt.R;
import com.example.sweprojekt.data.Building;
import com.example.sweprojekt.data.rcDataBase;

import java.util.List;

public class NewBuildingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivity mainActivity = MainActivity.getInstance();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_new_building);

        createLayoutNewBuilding(mainActivity);
    }

    private void createLayoutNewBuilding(MainActivity mainActivity) {
        EditText eTNewDescriptionBuildings = findViewById(R.id.editTextNewDescriptionBuildings);

        EditText eTNewBuildingName = findViewById(R.id.editTextNewBuildingName);

        CheckBox cBDescriptionBuilding = findViewById(R.id.checkBoxDescriptionBuildings);
        eTNewDescriptionBuildings.setEnabled(false);
        cBDescriptionBuilding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eTNewDescriptionBuildings.setEnabled(((CheckBox) v).isChecked());
            }
        });

        Button btnCreateNewBuilding = findViewById(R.id.buttonCreateNewBuilding);
        btnCreateNewBuilding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo testcode
                //todo check ob Gebäudenummer nicht leer/vergeben ist
                EditText etBuildingPrefix = findViewById(R.id.editTextNewBuildingName);
                EditText etBuildingName = findViewById(R.id.editTextNewDescriptionBuildings);
                String buildingPrefix = etBuildingPrefix.getText().toString();
                String buildingName = etBuildingName.getText().toString();

                rcDataBase db = rcDataBase.getInstance(mainActivity);
                Building building = new Building();
                building.buildingPrefix = buildingPrefix;
                building.description = buildingName;
                db.buildingDao().insertAll(building);
                mainActivity.loadItemBuilding();



                Toast toast = Toast.makeText(mainActivity,"Eintrag Erstellt", Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }
        });
    }
}