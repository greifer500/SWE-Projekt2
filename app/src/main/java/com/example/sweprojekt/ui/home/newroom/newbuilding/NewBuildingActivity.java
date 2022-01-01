package com.example.sweprojekt.ui.home.newroom.newbuilding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;

import com.example.sweprojekt.R;

public class NewBuildingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        //todo diese Activity vervollständigen + Layout

        setContentView(R.layout.activity_new_building);
    }
}