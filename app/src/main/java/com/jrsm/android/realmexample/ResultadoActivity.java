package com.jrsm.android.realmexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmResults;


public class ResultadoActivity extends AppCompatActivity {
    @BindView(R.id.tvResultado)
    TextView resultado;
    String sbUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_activity_resultado,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_nuevo_usuario:
                nuevoUsuario();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void nuevoUsuario(){
        Intent i = new Intent(ResultadoActivity.this, MainActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.btnVerRegistros)
    public void onClick(View view){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Usuario> usuarios = realm.where(Usuario.class).findAll();
        sbUsuario = usuarios.toString();
        resultado.setText(sbUsuario);
    }

}
