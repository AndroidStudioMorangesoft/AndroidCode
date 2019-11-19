package com.carloss2020.menub;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.carloss2020.menub.fragment.HomeFragment;
import com.carloss2020.menub.fragment.ProfileFragment;
import com.carloss2020.menub.fragment.SettingFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView mBottonNV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottonNV=(BottomNavigationView) findViewById(R.id.bottonNavigation);


        //**********************************************************
        //fragemnto por defecto que se mirara
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new SettingFragment()).commit();

        //para saber cual de las opciones se escogio
        mBottonNV.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                //buscamos la opcion
                if (menuItem.getItemId() == R.id.menu_home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();
                }
                if (menuItem.getItemId() == R.id.menu_profile){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,new ProfileFragment()).commit();
                }
                if (menuItem.getItemId() == R.id.menu_settings){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,new SettingFragment()).commit();
                }
                return true;
            }
        });
        //FIN Opcion buscado
        //-------------------------------------------
    }

    private void showSelectedFragment(Fragment fragment) {
      /* getSupportFragmentManager().beginTransaction().
               replace(R.id.container,fragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();*/

    }


}
