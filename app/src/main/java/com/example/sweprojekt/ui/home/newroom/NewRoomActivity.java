package com.example.sweprojekt.ui.home.newroom;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sweprojekt.MainActivity;
import com.example.sweprojekt.R;
import com.example.sweprojekt.ui.home.HomeFragment;
import com.example.sweprojekt.ui.home.newroom.newbuilding.NewBuildingActivity;

public class NewRoomActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivity mainActivity = MainActivity.getInstance();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_newroom);

        //todo diese Activity vervollständigen, alles miteinander Verknüpfen, Gebäudeauswahl zu Liste machen,
        // QRCode Generator hinzufügen, Knöpfe anpassen(da diese grade nur paar Sachen testen), Room-Klasse vervollständigen/verbessern

        createLayoutNewRoom(mainActivity);
    }


    private void createLayoutNewRoom(MainActivity mainActivity){

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(mainActivity.getAradBuildings());

        EditText eTRoomChairs = findViewById(R.id.editTextQuantityChairs);
        EditText eTRoomSeats =  findViewById(R.id.editTextQuantitySeats);

        eTRoomChairs.setEnabled(false);
        eTRoomSeats.setEnabled(false);

        CheckBox cBChairs= findViewById(R.id.checkBoxChairs);
        CheckBox cBSeats= findViewById(R.id.checkBoxSeat);

        cBChairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cBChairs.isChecked()){
                    eTRoomChairs.setEnabled(true);
                }else {
                    eTRoomChairs.setText("");
                    eTRoomChairs.setEnabled(false);
                }
            }
        });

        cBSeats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cBSeats.isChecked()){
                    eTRoomSeats.setEnabled(true);
                }else {
                    eTRoomSeats.setText("");
                    eTRoomSeats.setEnabled(false);
                }
            }
        });

        cBSeats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cBSeats.isChecked()){
                    eTRoomSeats.setEnabled(true);
                }else {
                    eTRoomSeats.setText("");
                    eTRoomSeats.setEnabled(false);
                }
            }
        });

        Button btnCreateRoom = findViewById(R.id.buttonCreateRoom);
        btnCreateRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 20; i++){
                    mainActivity.addItemRooms("Test");
                }

                Toast toast = Toast.makeText(mainActivity,"Eintrag Erstellt", Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }
        });

        Button testbtn = findViewById(R.id.buttonTemp);
        testbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewRoomActivity.this, NewBuildingActivity.class);
                startActivity(intent);
            }
        });
    }
}
