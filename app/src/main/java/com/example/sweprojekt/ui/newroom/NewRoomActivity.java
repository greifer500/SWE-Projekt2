package com.example.sweprojekt.ui.newroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.sweprojekt.R;

public class NewRoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_newroom);

        Room newRoom = new Room(5, 5);
    }

    private class Room {
        public Room(int RoomID_in, int BuildingID_in){
            setRoomID(RoomID_in);
            setBuildingID(BuildingID_in);
        }

        private int RoomID_p = 0;
        private void setRoomID(int RoomID_in){
            while(true) {
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