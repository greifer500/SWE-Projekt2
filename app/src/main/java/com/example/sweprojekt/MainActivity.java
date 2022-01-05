package com.example.sweprojekt;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sweprojekt.data.Building;
import com.example.sweprojekt.data.Room;
import com.example.sweprojekt.data.RoomAndBuilding;
import com.example.sweprojekt.data.rcDataBase;
import com.example.sweprojekt.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.sweprojekt.databinding.ActivityMainBinding;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Kann und WIRD wahrscheinlich Memoryleaks verursachen
    private static MainActivity mainActivityInstance;

    private ActivityMainBinding binding;

    private ArrayList<String> arrayListRooms = new ArrayList<>();
    private ArrayAdapter<String> aradRooms;

    public void setAdapterRooms(ListView lv){ lv.setAdapter(aradRooms); }
    public void addItemRooms(String s){ arrayListRooms.add(s); }
    public void deleteItemRooms(int position){ arrayListRooms.remove(position); }

    private ArrayList<String> arrayListBuildings = new ArrayList<>();
    private ArrayAdapter<String> aradBuildings;
    public void setAdapterBuildings(ListView lv){ lv.setAdapter(aradBuildings); }
    public void loadItemBuilding(){
        rcDataBase db = rcDataBase.getInstance(getApplicationContext());
        List<Building> buildings = db.buildingDao().getAll();
        for (Building bul:buildings) {
            arrayListBuildings.add(bul.buildingPrefix + " - " + bul.description);
        }
    }
    public void loadItemRoom() {
        rcDataBase db = rcDataBase.getInstance(getApplicationContext());
        List<RoomAndBuilding> buildings = db.roomAndBuildingDao().getAll();
        for (RoomAndBuilding rab : buildings) {
            arrayListRooms.add(rab.building.buildingPrefix + rab.room.roomNumber);
        }
    }

    public void deleteItemBuildings(int position){ arrayListBuildings.remove(position); }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //todo hier werden todo's aufgelistet für Klassen, die noch nicht erstellt wurden: LogIn
        // schreibt mir wenn ich noch was vergessen habe

        mainActivityInstance = this;

        Context context = getApplicationContext();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_list)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        aradRooms = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayListRooms);
        aradBuildings = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayListBuildings);
        loadItemBuilding();
        loadItemRoom();

    }

    public static MainActivity getInstance(){
        return mainActivityInstance;
    }

    @Override
    public void onBackPressed() {
        ListFragment f = (ListFragment) getSupportFragmentManager().findFragmentByTag("FragmentList");
        //todo f ist null, schauen wie man das fixt (das soll wenn man im Listenbereich ist dafür sorgen,
        // dass man anstatt aus dem Programm komplett raus geht nur auf den Home Screen geht und dann vom Home Screen raus)
        if (f != null && f.isVisible()){
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_activity_main, HomeFragment.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        } else {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult.getContents()!= null){
            checkIfRoomExists(intentResult.getContents());
        } else {
            Toast.makeText(this, "Kein Raum gefunden",Toast.LENGTH_SHORT).show();
        }
    }

    public boolean checkIfRoomExists(String result_in){
        String[] buildingSplit = result_in.split("(?<=\\D)(?=\\d)");
        String prefix = buildingSplit[0];
        int roomNumber= Integer.parseInt(buildingSplit[1]);
        rcDataBase db = rcDataBase.getInstance(this);
        Building building = db.buildingDao().getByPrefix(prefix);
        Room room = db.roomDao().getByRoomNumberAndBuildingID(roomNumber,building.id);

        return room == null;
    }

    public ArrayAdapter<String> getAradBuildings() {
        return aradBuildings;
    }
}