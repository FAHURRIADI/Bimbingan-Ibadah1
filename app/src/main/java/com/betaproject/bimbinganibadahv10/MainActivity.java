package com.betaproject.bimbinganibadahv10;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    public String alamat[];



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.dasbord:
                    FragmentManager dasfg = getSupportFragmentManager();
                    FragmentTransaction ftdas = dasfg.beginTransaction();
                    DashboardFragment dashboardFragment = new DashboardFragment();
                    ftdas.replace(R.id.cont, dashboardFragment);
                    ftdas.commit();
                    return true;
                case R.id.kalender:
                    FragmentManager kalenderM = getSupportFragmentManager();
                    FragmentTransaction kelenderT = kalenderM.beginTransaction();
                    CalenderFragment calenderFragment=new CalenderFragment();
                    kelenderT.replace(R.id.cont, calenderFragment);
                    kelenderT.addToBackStack(null);
                    kelenderT.commit();
                    return true;
                case R.id.rating:


                    Toast.makeText(MainActivity.this,"Berikan kami nilai di google play ",Toast.LENGTH_SHORT).show();




                    return true;



            }
            return false;
        }

    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


       DashboardFragment dashboardFragment = new DashboardFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fth = fragmentManager.beginTransaction();
        fth.replace(R.id.cont,dashboardFragment);
        fth.commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigasion);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.profil) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransactionP = fragmentManager.beginTransaction();
            ProfilFragment profilFragment = new ProfilFragment();
            fragmentTransactionP.replace(R.id.cont, profilFragment);
            fragmentTransactionP.addToBackStack("ProfilFragment");
            fragmentTransactionP.commit();
        } else if (id == R.id.infoA) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransactionP = fragmentManager.beginTransaction();
            InformasiAplikasiFragment informasiAplikasiFragment = new InformasiAplikasiFragment();
            fragmentTransactionP.replace(R.id.cont, informasiAplikasiFragment);
            fragmentTransactionP.addToBackStack("informasiAplikasiFragment");
            fragmentTransactionP.commit();
        } else if (id == R.id.share) {
            String URL="https://googleplay.com";
            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT," "+URL);
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent,"Where You Want Share Application ?"));
        }

        return super.onOptionsItemSelected(item);

    }

}
