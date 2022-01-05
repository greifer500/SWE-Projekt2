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
import com.example.sweprojekt.data.Attribute;
import com.example.sweprojekt.data.Building;
import com.example.sweprojekt.data.RoomAttribute;
import com.example.sweprojekt.data.rcDataBase;
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

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            int buildingID = bundle.getInt("buildingID");
            int roomNumber = bundle.getInt("roomNumber");
            rcDataBase db = rcDataBase.getInstance(mainActivity);
            Building building = db.buildingDao().getByID(buildingID);
            String buildingName = building.buildingPrefix + " - " + building.description;
            Spinner spinner = findViewById(R.id.spinner);
            spinner.setSelection(mainActivity.getAradBuildings().getPosition(buildingName));
            EditText editTextRoomNumber = findViewById(R.id.editTextRoomNumber);
            editTextRoomNumber.setText(String.valueOf(roomNumber));
        }
    }


    private void createLayoutNewRoom(MainActivity mainActivity){

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(mainActivity.getAradBuildings());

        EditText eTRoomChairs = findViewById(R.id.editTextQuantityChairs);
        EditText eTRoomSeats =  findViewById(R.id.editTextQuantityTables);

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
                //get Building ID
                //create Attributes
                //create Room
                //create Room Attributes

                rcDataBase db = rcDataBase.getInstance(mainActivity);

                //get BuildingID
                Spinner spinnerBuilding = findViewById(R.id.spinner);
                String buildingText = spinnerBuilding.getSelectedItem().toString();
                String[] buildingTextSplit = buildingText.split(" - ");
                String buildingPrefix = buildingTextSplit[0];
                String buildingDescription = buildingTextSplit[1];
                Building building = db.buildingDao().getByName(buildingPrefix,buildingDescription);

                //get Attributes or create them
                Attribute attributeChair = db.attributeDao().getByDescription("Chair");
                if (attributeChair == null){
                    attributeChair = new Attribute();
                    attributeChair.description = "Chair";
                    db.attributeDao().insertAll(attributeChair);
                    attributeChair = db.attributeDao().getByDescription("Chair");
                }

                Attribute attributeTable = db.attributeDao().getByDescription("Table");
                if (attributeTable == null){
                    attributeTable = new Attribute();
                    attributeTable.description = "Table";
                    db.attributeDao().insertAll(attributeTable);
                    attributeTable = db.attributeDao().getByDescription("Table");
                }

                //create room
                com.example.sweprojekt.data.Room room = new com.example.sweprojekt.data.Room();
                room.buildingID = building.id;
                room.description = "";
                //get room number from EditText
                EditText editTextRoomNumber = findViewById(R.id.editTextRoomNumber);
                String sRoomNumber =   editTextRoomNumber.getText().toString();
                int roomNumber = Integer.valueOf(sRoomNumber);
                room.roomNumber = roomNumber;


                db.roomDao().insertAll(room);
                //get newly created room object
                room = db.roomDao().getByRoomNumberAndBuildingID(roomNumber, building.id);

                //create room attribute chair
                RoomAttribute roomAttributeChair = new RoomAttribute();
                roomAttributeChair.roomID = room.id;
                roomAttributeChair.attributeID = attributeChair.id;
                EditText editTextChairCount = findViewById(R.id.editTextQuantityChairs);
                String sChairCount =   editTextRoomNumber.getText().toString();
                int chairCount = Integer.valueOf(sChairCount);
                roomAttributeChair.attributeCount = chairCount;
                db.roomAttributeDao().insertAll(roomAttributeChair);

                //create room attribute table
                RoomAttribute roomAttributeTable= new RoomAttribute();
                roomAttributeTable.roomID = room.id;
                roomAttributeTable.attributeID = attributeTable.id;
                EditText editTextTableCount = findViewById(R.id.editTextQuantityTables);
                String sTableCount =   editTextTableCount.getText().toString();
                int tableCount = Integer.valueOf(sTableCount);
                roomAttributeTable.attributeCount = tableCount;
                db.roomAttributeDao().insertAll(roomAttributeTable);

                //update list of room
                mainActivity.loadItemRoom();

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
