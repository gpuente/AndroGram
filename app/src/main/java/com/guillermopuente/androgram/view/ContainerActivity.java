package com.guillermopuente.androgram.view;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.guillermopuente.androgram.R;
import com.guillermopuente.androgram.view.fragment.HomeFragment;
import com.guillermopuente.androgram.view.fragment.ProfileFragment;
import com.guillermopuente.androgram.view.fragment.SearchFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottombar);
        bottomBar.setDefaultTab(R.id.home);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId){
                    case R.id.home:
                        HomeFragment homeFragment = new HomeFragment();
                        switchFragment(homeFragment);
                        break;
                    case R.id.search:
                        SearchFragment searchFragment = new SearchFragment();
                        switchFragment(searchFragment);
                        break;
                    case R.id.profile:
                        ProfileFragment profileFragment = new ProfileFragment();
                        switchFragment(profileFragment);
                        break;
                }
            }
        });

    }

    private void switchFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null)
                .commit();
    }
}
