package com.example.sweprojekt;

import android.content.Context;
import android.os.Build;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.sweprojekt.data.Building;
import com.example.sweprojekt.data.rcDataBase;

import java.util.List;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.sweprojekt", appContext.getPackageName());
    }
    @Test
    public void createDBContextAndInsertRooms(){
        rcDataBase db = rcDataBase.getInstance(InstrumentationRegistry.getInstrumentation().getContext());
        Building b = new Building();
        b.description = "Mathe und Ing";
        b.buildingPrefix = "E";
        db.buildingDao().insertAll(b);
        List<Building> b2 = db.buildingDao().getAll();

    }
}