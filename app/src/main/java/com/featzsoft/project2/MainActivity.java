package com.featzsoft.project2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {
    // implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;// private DrawerLayout mDrawer;
    // ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;
   // ImageView imgView;
    private NavigationView nvDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // imgView=findViewById(R.id.menuicon);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);      //adds  (<--default) icon on tool bar
        getSupportActionBar().setDisplayShowTitleEnabled(false);    //removes title in toolbar

     //  getSupportActionBar().setHomeButtonEnabled(true);
        //nv--navigationView

     ViewPager viewPager = findViewById(R.id.viewPager);

        drawerLayout = findViewById(R.id.drawer_layout);
        nvDrawer = findViewById(R.id.nvView);
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        setupDrawerContent(nvDrawer);

        //        AuthenticationPagerAdapter pagerAdapter = new AuthenticationPagerAdapter(getSupportFragmentManager());
//      //  pagerAdapter.addFragmet(new Fragment2());
//     //   pagerAdapter.addFragmet(new Fragment3());
//     //   pagerAdapter.addFragmet(new Fragment4());
//        viewPager.setAdapter(pagerAdapter);





    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
//        Menu menu = navigationView.getMenu();
//        MenuItem menuItem = menu.findItem(R.id.nav_switch);
//        View actionView = MenuItemCompat.getActionView(menuItem);
//        actionView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    class AuthenticationPagerAdapter extends FragmentPagerAdapter {

        private ArrayList<Fragment> fragmentList = new ArrayList<>();

        public AuthenticationPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        void addFragmet(Fragment fragment) {
            fragmentList.add(fragment);
        }
    }


    public void selectDrawerItem(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.home: // case R.id.item1:

                Toast.makeText(getApplicationContext(), "Item h Selected", Toast.LENGTH_LONG).show();
                break;

            case R.id.profile: // case R.id.item1:
                Intent i1 = new Intent(MainActivity.this, Fragment2.class);
                startActivity(i1);

                Toast.makeText(getApplicationContext(), "Item 1 Selected", Toast.LENGTH_LONG).show();
                break;

            case R.id.settings:
                Toast.makeText(getApplicationContext(), "Item 2 Selected", Toast.LENGTH_LONG).show();
                break;

            case R.id.logout:

                Intent i = new Intent(MainActivity.this, Login.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Logout Successful", Toast.LENGTH_LONG).show();
                break;
            //  return true;
            default:
                break;
        }
    }

/*
        Fragment fragment = null;
        Class fragmentClass;
        switch(item.getItemId()) {
            case R.id.profile:
                fragmentClass = Fragment2.class;
                break;
            case R.id.settings:
                fragmentClass = Fragment3.class;
                break;
            case R.id.logout:
                fragmentClass = Fragment4.class;
                break;
            default:
                fragmentClass = MainActivity.class;
                break;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.viewPager, fragment).commit();

        item.setChecked(true);
        drawerLayout.closeDrawers();
*/
 //   }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home: drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }
}




