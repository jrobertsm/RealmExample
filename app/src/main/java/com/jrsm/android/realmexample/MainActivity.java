package com.jrsm.android.realmexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtName)
    EditText nombre;

    @BindView(R.id.txtPass)
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_activity_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_resultado:
                verResultado();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void verResultado(){
        Intent i = new Intent(MainActivity.this, ResultadoActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.button)
    public void onClick(View view){
        Realm realm = Realm.getDefaultInstance();

        Toast toast = Toast.makeText(getApplicationContext(),"Se ha registrado un nuevo usuario",Toast.LENGTH_SHORT);

        String userName = nombre.getText().toString();
        String userPassword = password.getText().toString();
        int id = realm.where(Usuario.class).findAll().size() + 1;

        realm.beginTransaction();

        Usuario usuario = new Usuario();

        usuario.setId(id);
        usuario.setName(userName);
        usuario.setPassword(userPassword);

        realm.copyToRealmOrUpdate(usuario);
        realm.commitTransaction();

        toast.show();

    }
}
