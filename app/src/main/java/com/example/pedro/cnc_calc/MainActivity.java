package com.example.pedro.cnc_calc;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    Tabela_rosca_DAO tabela_rosca_DAO;

    Metrica_fina metrica_fina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabela_rosca_DAO = new Tabela_rosca_DAO(this);

        Popular_Banco();

        Button btn_param = (Button) findViewById(R.id.btn_param);
        btn_param.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Parametros.class);
                startActivity(intent);
            }
        });

        Button btn_barra = (Button) findViewById(R.id.btn_barra);
        btn_barra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Tabela_rosca.class);
                startActivity(intent);
            }
        });
    }


    public void Popular_Banco(){

        Resources res_macho = this.getResources();
        Resources res_d_broca = this.getResources();
        Resources res_passo = this.getResources();

        if (tabela_rosca_DAO.VerificaRegistro() != true) {

            String[] macho = res_macho.getStringArray(R.array.macho_met);
            String[] d_broca = res_d_broca.getStringArray(R.array.d_int_met_fina);
            String[] passo = res_passo.getStringArray(R.array.passo_met_fina);

            int cont = macho.length;
            int i = 0;
            while (i< cont){
                String m = macho[i].toString();
                String broca = d_broca[i].toString();
                String pass = passo[i].toString();

                metrica_fina = new Metrica_fina(String.valueOf(m.toString()), broca.toString(), pass.toString());
                tabela_rosca_DAO.popular_tabela_MF(metrica_fina);
                i++;
            }
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
