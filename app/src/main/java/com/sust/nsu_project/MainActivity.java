package com.sust.nsu_project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;
    private EditText searchView;
    TextView drawerUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);
        setSupportActionBar(toolbar);
        searchView = findViewById(R.id.activity_main_redtv);
        searchView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH
                        || actionId == EditorInfo.IME_ACTION_DONE
                        || event.getAction() == KeyEvent.ACTION_DOWN
                        || event.getAction() == KeyEvent.KEYCODE_ENTER) {
                    search();

                }
                return false;
            }
        });


        getSupportActionBar().setTitle("NSU App");

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close);
        drawerUserName = navigationView.getHeaderView(0).findViewById(R.id.nav_user_id);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void search() {
        String st = searchView.getText().toString();
        if(st.equals("discrete")) {
            startActivity(new Intent(this,BookProfile.class));
        } else {
            startActivity(new Intent(this,Course.class));
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }

        else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();
        Intent intent = null;

        switch(id) {

            case R.id.profile:
                intent = new Intent(this, Profile.class);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.orders:
                intent = new Intent(this,MyOrders.class);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.requests:
                intent = new Intent(this,Requests.class);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.courses:
                intent = new Intent(this,MyCourses.class);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.localWorshops:
                intent = new Intent(this,LocalWorkshops.class);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.borrowed_books:
                intent = new Intent(this,BorrowedBooks.class);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.lent_books:
                intent = new Intent(this,LentBooks.class);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.myBooks:
                intent = new Intent(this,MyBooks.class);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_balance:
                intent = new Intent(this,Balance.class);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.reg_courses:
                intent = new Intent(this,RegisteredCourses.class);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
        }
        this.startActivity(intent);
        return false;
    }

    public void doClickBook(View view) {
        startActivity(new Intent(MainActivity.this,BookProfile.class));
    }
}
