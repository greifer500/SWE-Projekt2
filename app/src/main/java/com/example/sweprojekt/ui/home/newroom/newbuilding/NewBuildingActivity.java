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

public class NewBuildingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivity mainActivity = MainActivity.getInstance();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        //todo diese Activity vervollständigen + Layout

        setContentView(R.layout.activity_new_building);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo testcode
                for (int i = 0; i < 20; i++){
                    mainActivity.addItemBuildings("Test");
                }

                Toast toast = Toast.makeText(mainActivity,"Eintrag Erstellt", Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }
        });

        createLayoutNewBuilding(mainActivity);
    }

    private void createLayoutNewBuilding(MainActivity mainActivity) {
        EditText eTNewDescriptionBuildings = findViewById(R.id.editTextNewDescriptionBuildings);
        CheckBox cBDescriptionBuilding = findViewById(R.id.checkBoxDescriptionBuildings);
        cBDescriptionBuilding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()){
                    eTNewDescriptionBuildings.setEnabled(true);
                } else {
                    eTNewDescriptionBuildings.setEnabled(false);
                }
            }
        });
    }
}