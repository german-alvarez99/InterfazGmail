package com.example.interfazgmail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Buscar en el correo electrónico");

        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

        //colocar botom de HOME
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //agregar el navegatin View
        navView = (NavigationView) findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);

        //colocar fragment qal cargar activity
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new fragmentTodosRecibidos())
                .commit();
    }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_toolbar, menu);
            return true;
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        boolean fragmentTransaction = false;

        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.todos_recibidos:
                fragment = new fragmentTodosRecibidos();
                fragmentTransaction = true;
                break;
            case R.id.recibidos:
                fragment = new fragmentRecibidos();
                fragmentTransaction = true;
                break;
            case R.id.no_leidos:
                fragment = new fragmentNoLeidos();
                fragmentTransaction = true;
                break;
            case R.id.destacados:
                fragment = new fragmentDestacados();
                fragmentTransaction = true;
                break;
            case R.id.pospuestos:
                fragment = new fragmentPospuestos();
                fragmentTransaction = true;
                break;
            case R.id.importantes:
                fragment = new fragmentImportantes();
                fragmentTransaction = true;
                break;
            case R.id.enviados:
                fragment = new fragmentEnviados();
                fragmentTransaction = true;
                break;
            case R.id.programados:
                fragment = new fragmentProgramados();
                fragmentTransaction = true;
                break;
            case R.id.bandeja_salida:
                fragment = new fragmentBandejaSalida();
                fragmentTransaction = true;
                break;
            case R.id.borradores:
                fragment = new fragmentBorradores();
                fragmentTransaction = true;
                break;
            case R.id.todos:
                fragment = new fragmentTodos();
                fragmentTransaction = true;
                break;
            case R.id.span:
                fragment = new fragmentSpan();
                fragmentTransaction = true;
                break;
            case R.id.papelera:
                fragment = new fragmentPapelera();
                fragmentTransaction = true;
                break;
            case R.id.calendario:
                fragment = new fragmentCalendario();
                fragmentTransaction = true;
                break;
            case R.id.contactos:
                fragment = new fragmentContactos();
                fragmentTransaction = true;
                break;
            case R.id.configuracion:
                fragment = new fragmentConfiguracion();
                fragmentTransaction = true;
                break;
            case R.id.ayuda:
                fragment = new fragmentAyudaComentarios();
                fragmentTransaction = true;
                break;
        }

        if (fragmentTransaction) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .commit();

            menuItem.setChecked(true);
            getSupportActionBar().setTitle(menuItem.getTitle());
        }
        drawerLayout.closeDrawers();
        return true;
    }
}