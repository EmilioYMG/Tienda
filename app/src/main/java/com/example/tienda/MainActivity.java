package com.example.tienda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.tienda.fragments.BuscarFragment;
import com.example.tienda.fragments.ComprarFragment;
import com.example.tienda.fragments.InicioFragment;
import com.example.tienda.fragments.SesionFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    //region Fragments
    private InicioFragment inicioFragment;
    private BuscarFragment buscarFragment;
    private ComprarFragment comprarFragment;
    private SesionFragment sesionFragment;
    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView btmNavigationPrincipal;
        btmNavigationPrincipal=findViewById(R.id.btmNavigationPrincipal);
        btmNavigationPrincipal.setOnItemSelectedListener(navListener);
        inicioFragment=new InicioFragment();
        buscarFragment=new BuscarFragment();
        comprarFragment=new ComprarFragment();
        sesionFragment=new SesionFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContenedor,inicioFragment).commit();
    }
    NavigationBarView.OnItemSelectedListener navListener = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch(item.getItemId())
            {
                case R.id.nav_home:
                    Toast.makeText(getApplicationContext(),"Inicio",Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContenedor,inicioFragment).commit();
                    break;
                case R.id.nav_buscar:
                    Toast.makeText(getApplicationContext(),"Buscar",Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContenedor,buscarFragment).commit();
                    break;
                case R.id.nav_comprar:
                    Toast.makeText(getApplicationContext(),"Comprar",Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContenedor,comprarFragment).commit();
                    break;
                case R.id.nav_inicia:
                    Toast.makeText(getApplicationContext(),"Sesión",Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContenedor,sesionFragment).commit();
                    break;
            }
            return true;
        }
    };
}