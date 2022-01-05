package com.example.sweprojekt.ui.home.protocol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;

import com.example.sweprojekt.R;
import com.google.android.material.tabs.TabLayout;

public class ProtocolActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protocol);
        TableLayout tLProtocol = findViewById(R.id.tableLayoutProtocol);

    }
}