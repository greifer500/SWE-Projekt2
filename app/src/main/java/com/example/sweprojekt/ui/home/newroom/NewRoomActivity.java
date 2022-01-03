package com.example.sweprojekt.ui.home.newroom;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
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

        Room newRoom = new Room(5, 5);
    }

    private void createLayoutNewRoom(MainActivity mainActivity){
        EditText eTRoomNumber = findViewById(R.id.editTextRoomNumber);
        EditText eTBuildingNumb = findViewById(R.id.editTextBuildingNumber);

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

    private class Room {
        //todo richtig implementieren, für Datenbank fertig machen, leere Eingaben nicht erlauben
        public Room(int RoomID_in, int BuildingID_in){
            setRoomID(RoomID_in);
            setBuildingID(BuildingID_in);
        }

        private int RoomID_p = 0;
        private void setRoomID(int RoomID_in){
            if (RoomID_in <= 0) {
                Context context = getApplicationContext();
                CharSequence text = "Bitte gültige Raumnummer eingeben";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            } else {
                RoomID_p = RoomID_in;
            }
        }
        public int getRoomID(){ return RoomID_p; }

        private int BuildingID_p = 0;
        private void setBuildingID(int BuildingID_in){
            if (BuildingID_in < 0) {
                Context context = getApplicationContext();
                CharSequence text = "Bitte gültige Gebäudenummer eingeben";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            } else {
                BuildingID_p = BuildingID_in;
            }
        }
    }
}
