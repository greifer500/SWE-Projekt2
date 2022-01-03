package com.example.sweprojekt.ui.list.showroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.sweprojekt.R;

public class ShowRoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_show_room);

        EditText eTVRM = findViewById(R.id.editTextViewRoomNumber);
        eTVRM.setText("");
        eTVRM.setEnabled(false);

        EditText eTVRB = findViewById(R.id.editTextViewRoomBuilding);
        eTVRB.setText("");
        eTVRB.setEnabled(false);

        EditText eTVCN = findViewById(R.id.editTextViewRoomChairNumb);
        eTVCN.setText("");
        eTVCN.setEnabled(false);

        EditText eTVRS = findViewById(R.id.editTextViewRoomSeats);
        eTVRS.setText("");
        eTVRS.setEnabled(false);

        Button btnCRA = findViewById(R.id.buttonChangeRoomAttributes);
        btnCRA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}