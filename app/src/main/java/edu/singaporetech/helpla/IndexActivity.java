package edu.singaporetech.helpla;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import edu.singaporetech.helpla.homeView.HomeFragment;
import edu.singaporetech.helpla.leadershipBoard.LeadershipBoardFragment;
import edu.singaporetech.helpla.notificationView.NotificaitonFragment;
import edu.singaporetech.helpla.postView.CreatePostFragment;
import edu.singaporetech.helpla.profileView.ProfileFragment;

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
                            tag = "Index";
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_leadership:
                            tag = "Leadership";
                            selectedFragment = new LeadershipBoardFragment();
                            break;
                        case R.id.nav_create:
                            tag = "Create";
                            selectedFragment = new CreatePostFragment();
                            break;
                        case R.id.nav_notificaiton:
                            tag = "Notification";
                            selectedFragment = new NotificaitonFragment();
                            break;
                        case R.id.nav_profile:
                            tag = "Profile";
                            selectedFragment = new ProfileFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.indexfc,
                            selectedFragment,tag).commit();
                    return true;
                }
            };
}
