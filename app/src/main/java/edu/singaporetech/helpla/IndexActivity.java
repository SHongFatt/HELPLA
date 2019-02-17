package edu.singaporetech.helpla;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class IndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        BottomNavigationView bottomNav = findViewById(R.id.indexbn);

        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.indexfc,new HomeFragment()).commit();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    String tag = "";
                    switch (item.getItemId()){
                        case R.id.nav_index:
                            tag = "index";
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_trips:
                            tag = "trips";
                            selectedFragment = new LeadershiipBoardFragment();
                            break;
                        case R.id.nav_strips:
                            tag = "shareTrips";
                              selectedFragment = new CreatePostFragment();
                            break;
                        case R.id.nav_profile:
                            tag = "profile";
                            selectedFragment = new ProfileFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.indexfc,
                            selectedFragment,tag).commit();
                    return true;
                }
            };
}
