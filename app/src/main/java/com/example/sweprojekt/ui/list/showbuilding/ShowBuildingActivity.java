package com.example.sweprojekt.ui.list.showbuilding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;

import com.example.sweprojekt.R;

public class ShowBuildingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        //todo diese Klasse + Layout

        setContentView(R.layout.activity_show_building);
    }
}