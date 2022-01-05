package com.example.sweprojekt.ui.list.showroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.sweprojekt.MainActivity;
import com.example.sweprojekt.R;
import com.example.sweprojekt.data.Attribute;
import com.example.sweprojekt.data.Building;
import com.example.sweprojekt.data.Room;
import com.example.sweprojekt.data.RoomAttribute;
import com.example.sweprojekt.data.rcDataBase;

import javax.xml.transform.sax.SAXTransformerFactory;

public class ShowRoomActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_show_room);

        MainActivity mainActivity = MainActivity.getInstance();

        String roomName = getIntent().getExtras().getString("roomName");

        String[] roomSplit = roomName.split("(?<=\\D)(?=\\d)");
        String prefix = roomSplit[0];
        int roomNumber= Integer.parseInt(roomSplit[1]);
        rcDataBase db = rcDataBase.getInstance(mainActivity);
        Building building = db.buildingDao().getByPrefix(prefix);
        Room room = db.roomDao().getByRoomNumberAndBuildingID(roomNumber,building.id);
        Attribute chair = db.attributeDao().getByDescription("Chair");
        RoomAttribute roomChairs = db.roomAttributeDao().getByID(room.id,chair.id);
        Attribute table = db.attributeDao().getByDescription("Table");
        RoomAttribute roomTable = db.roomAttributeDao().getByID(room.id,table.id);



        EditText eTVRM = findViewById(R.id.editTextViewRoomNumber);
        eTVRM.setText(room.roomNumber.toString());
        //eTVRM.setEnabled(false);

        EditText eTVRB = findViewById(R.id.editTextViewRoomBuilding);
        eTVRB.setText(roomSplit[0]);
        eTVRB.setEnabled(false);

        EditText eTVCN = findViewById(R.id.editTextViewRoomChairNumb);
        eTVCN.setText(roomChairs.attributeCount.toString());
        //eTVCN.setEnabled(false);

        EditText eTVRS = findViewById(R.id.editTextViewRoomSeats);
        eTVRS.setText(roomChairs.attributeCount.toString());
        //eTVRS.setEnabled(false);

        Button btnCRA = findViewById(R.id.buttonChangeRoomAttributes);
        btnCRA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room.roomNumber = Integer.parseInt(eTVRM.getText().toString());
                roomChairs.attributeCount  = Integer.parseInt(eTVCN.getText().toString());
                roomTable.attributeCount =  Integer.parseInt(eTVRS.getText().toString());
                db.roomDao().update(room);
                db.roomAttributeDao().update(roomChairs);
                db.roomAttributeDao().update(roomTable);
                mainActivity.loadItemRoom();

            }
        });
    }
}