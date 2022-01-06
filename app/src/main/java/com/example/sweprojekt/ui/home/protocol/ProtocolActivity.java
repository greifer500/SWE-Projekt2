package com.example.sweprojekt.ui.home.protocol;

import androidx.appcompat.app.AppCompatActivity;

import android.accessibilityservice.FingerprintGestureController;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.sweprojekt.MainActivity;
import com.example.sweprojekt.R;
import com.example.sweprojekt.data.Attribute;
import com.example.sweprojekt.data.Log;
import com.example.sweprojekt.data.LogAttribute;
import com.example.sweprojekt.data.RoomAttribute;
import com.example.sweprojekt.data.rcDataBase;
import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Attr;

import java.time.Instant;
import java.util.List;

public class ProtocolActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_protocol);

        TableLayout tLProtocol = findViewById(R.id.tableLayoutProtocol);
        Button bntSaveProtocol = findViewById(R.id.buttonActivityProtocol);

        MainActivity mainActivity = MainActivity.getInstance();
        Bundle bundle = getIntent().getExtras();
        int roomID = bundle.getInt("roomID");
        rcDataBase db = rcDataBase.getInstance(mainActivity);
        if (roomID != 0) {
            List<RoomAttribute> roomAttributes = db.roomAttributeDao().getByRoom(roomID);
            for (RoomAttribute ra : roomAttributes) {
                Attribute attribute = db.attributeDao().getByID(ra.attributeID);

                TableRow tableRow = new TableRow(this);
                tableRow.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.FILL_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));


                TextView textViewDesc = new TextView(this);
                textViewDesc.setText(attribute.description);
                textViewDesc.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                textViewDesc.setPadding(5, 5, 5, 0);
                tableRow.addView(textViewDesc);

                TextView textviewExpected = new TextView(this);
                textviewExpected.setText(String.valueOf(ra.attributeCount));
                textviewExpected.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                textviewExpected.setPadding(5, 5, 5, 0);
                tableRow.addView(textviewExpected);

                EditText editText = new EditText(this);
                editText.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                editText.setPadding(5, 5, 5, 0);
                tableRow.addView(editText);

                EditText editText2 = new EditText(this);
                editText2.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                editText2.setPadding(5, 5, 5, 0);
                tableRow.addView(editText2);


                tLProtocol.addView(tableRow, new TableLayout.LayoutParams(
                        TableRow.LayoutParams.FILL_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
            }
        }

        int logID = bundle.getInt("logID");
        Log log = db.logDao().getByID(logID);
        if (logID != 0) {
            List<LogAttribute> logAttributes = db.logAttributeDao().getByLogID(logID);
            for (LogAttribute la : logAttributes) {
                Attribute attribute = db.attributeDao().getByID(la.attributeID);

                TableRow tableRow = new TableRow(this);
                tableRow.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.FILL_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));


                TextView textViewDesc = new TextView(this);
                textViewDesc.setText(attribute.description);
                textViewDesc.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                textViewDesc.setPadding(5, 5, 5, 0);
                tableRow.addView(textViewDesc);

                TextView textviewExpected = new TextView(this);
                textviewExpected.setText(String.valueOf(la.attributeCountExpected));
                textviewExpected.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                textviewExpected.setPadding(5, 5, 5, 0);
                tableRow.addView(textviewExpected);

                TextView textviewIs = new TextView(this);
                textviewIs.setText(String.valueOf(la.attributeCountIs));
                textviewIs.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                textviewIs.setPadding(5, 5, 5, 0);
                tableRow.addView(textviewIs);

                TextView textviewBad = new TextView(this);
                textviewBad.setText(String.valueOf(la.attributeCountBad));
                textviewBad.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                textviewBad.setPadding(5, 5, 5, 0);
                tableRow.addView(textviewBad);


                tLProtocol.addView(tableRow, new TableLayout.LayoutParams(
                        TableRow.LayoutParams.FILL_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
            }
            bntSaveProtocol.setEnabled(false);
        }


        bntSaveProtocol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log log = new Log();
                log.roomId = roomID;
                db.logDao().insertAll(log);
                log = db.logDao().getLatestByRoomID(roomID);
                int count = tLProtocol.getChildCount();
                for (int i = 1; i < count; i++) {
                    TableRow tr = (TableRow) tLProtocol.getChildAt(i);
                    TextView tvAttribute = (TextView) tr.getChildAt(0);
                    String attributeName = tvAttribute.getText().toString();
                    Attribute attribute = db.attributeDao().getByDescription(attributeName);

                    TextView tvExpected = (TextView) tr.getChildAt(1);
                    String sExpected = tvExpected.getText().toString();
                    int expected = Integer.valueOf(sExpected);


                    EditText etIs = (EditText) tr.getChildAt(2);
                    String sIs = etIs.getText().toString();
                    int is = Integer.valueOf(sIs);

                    EditText etBad = (EditText) tr.getChildAt(3);
                    String sBad = etBad.getText().toString();
                    int bad = Integer.valueOf(sBad);

                    LogAttribute logAttribute = new LogAttribute();
                    logAttribute.logID = log.id;
                    logAttribute.attributeID = attribute.id;
                    logAttribute.attributeCountExpected = expected;
                    logAttribute.attributeCountIs = is;
                    logAttribute.attributeCountBad = bad;
                    db.logAttributeDao().insertAll(logAttribute);
                }
                mainActivity.loadItemLog();
                mainActivity.UpdateArrayAdapter();
                finish();
            }
        });

    }
}