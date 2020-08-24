package ru.example.startandroid.develop.fitnesstracker;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ru.startandroid.develop.fitnesstracker.R;

public class SecondActivity extends AppCompatActivity {
    //private boolean LocationPermission = false;
    //public static final int PERMISSIONS_REQUEST_ENABLE_GPS = 9001;
    //public static final int PERMISSIONS_REQUEST_ACESS_FINE_LOCATION = 9002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new MapFragment()).commit();


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = item -> {
        Fragment selectedFragment = null;

        switch (item.getItemId()){
            case R.id.nav_run:
                selectedFragment = new MapFragment();
                break;
            case R.id.nav_history:
                selectedFragment = new InfoFragment();
                break;
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                selectedFragment).commit();

        return true;
    };


   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.second_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                //saveInventory();
                return true;
            case R.id.action_delete:
                //showAlertDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }*/
}
