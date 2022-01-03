package com.example.sweprojekt.ui.list.showbuilding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;

import com.example.sweprojekt.R;

public class ShowBuildingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_show_building);


        Toolbar tSB = findViewById(R.id.toolbarBuildings);
        tSB.setTitle("Gebäude "  + "Nummer"); //todo funktion für Gebaäudename

        EditText etSBN = findViewById(R.id.editTextShowBuildingName);
        etSBN.setText("Kek, durch Funktion ersetzten");
        etSBN.setEnabled(false);

        EditText etSBD = findViewById(R.id.editTextShowBuildingDescription);
        etSBD.setText("Kek, durch Funktion ersetzten");

        etSBD.setEnabled(false);
    }
}