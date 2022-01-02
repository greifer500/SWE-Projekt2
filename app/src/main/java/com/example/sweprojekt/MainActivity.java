package com.example.sweprojekt;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sweprojekt.ui.home.HomeFragment;
import com.example.sweprojekt.ui.home.qrcodescanner.CameraActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.sweprojekt.databinding.ActivityMainBinding;

import java.util.ArrayList;

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
    public void addItemBuildings(String s){ arrayListBuildings.add(s); }
    public void deleteItemBuildings(int position){ arrayListBuildings.remove(position); }

    private static final String[] CAMERA_PERMISSION = new String[]{Manifest.permission.CAMERA};
    private static final int CAMERA_REQUEST_CODE = 10;
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


        CallCamera();

        aradRooms = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayListRooms);
        aradBuildings = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayListBuildings);

    }

    private void CallCamera() {
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
    public void callCamera(){
        if (hasCameraPermission()) {
            enableCamera();
        } else {
            requestPermission();
        }
    }
    private boolean hasCameraPermission() {
        return ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED;
    }
    private void requestPermission() {
        ActivityCompat.requestPermissions(
                this,
                CAMERA_PERMISSION,
                CAMERA_REQUEST_CODE
        );
    }
    private void enableCamera() {
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }

}