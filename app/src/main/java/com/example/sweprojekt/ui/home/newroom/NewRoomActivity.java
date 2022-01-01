package com.example.sweprojekt.ui.home.newroom;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sweprojekt.MainActivity;
import com.example.sweprojekt.R;

public class NewRoomActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivity ma = MainActivity.getInstance();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_newroom);

        //todo diese Activity vervollständigen, alles miteinander Verknüpfen, Gebäudeauswahl zu Liste machen,
        // QRCode Generator hinzufügen, Knöpfe anpassen(da diese grade nur paar Sachen testen), Room-Klasse vervollständigen/verbessern

        createButtonsNewRoom(ma);

        Room newRoom = new Room(5, 5);
    }

    private void createButtonsNewRoom(MainActivity mainActivity){
        Button btnRandQRCode = findViewById(R.id.buttonRandQRCode);
        btnRandQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo Random QRCode hier rein
                //todo testcode
                for (int i = 0; i < 20; i++){
                    mainActivity.addItemBuildings("Test");
                }

                Toast toast = Toast.makeText(mainActivity,"Eintrag Erstellt", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        Button btnCreateRoom = findViewById(R.id.buttonCreateRoom);
        mainActivity.getCallingActivity();
        btnCreateRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 20; i++){
                    mainActivity.addItemRooms("Test");
                }

                Toast toast = Toast.makeText(mainActivity,"Eintrag Erstellt", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    private void createTextInputNewRoom(MainActivity mainActivity){
        //todo den Rest von NewRoom implementieren, initialiseren
    }

    private class Room {
        //todo richtig implementieren, für Datenbank fertig machen, leere Eingaben nicht erlauben
        public Room(int RoomID_in, int BuildingID_in){
            setRoomID(RoomID_in);
            setBuildingID(BuildingID_in);
        }

        private int RoomID_p = 0;
        private void setRoomID(int RoomID_in){
            while(true) {
                //todo neuInput für RoomID_in
                if (RoomID_in <= 0) {
                    Context context = getApplicationContext();
                    CharSequence text = "Bitte gültige Raumnummer eingeben";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    RoomID_p = RoomID_in;
                    break;
                }
            }
        }
        public int getRoomID(){ return RoomID_p; }

        private int BuildingID_p = 0;
        private void setBuildingID(int BuildingID_in){
            while(true) {
                //todo neuInput für GebäudeID_in
                if (BuildingID_in < 0) {
                    Context context = getApplicationContext();
                    CharSequence text = "Bitte gültige Gebäudenummer eingeben";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    BuildingID_p = BuildingID_in;
                    break;
                }
            }
        }
    }
}