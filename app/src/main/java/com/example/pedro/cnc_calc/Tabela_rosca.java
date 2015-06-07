package com.example.pedro.cnc_calc;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;


public class Tabela_rosca extends ActionBarActivity {

    EditText et_M;
    TextView passoFina_M, passoGrossa_M, externo_fina_M, externo_grossa_M;
    TextView passoFina_W, passoGrossa_W, externo_fina_W, externo_grossa_W;
    Double P;
    Double M;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabela_rosca);

        /** Inicia as variaveis textView (Exibição valores Whithworth) */
        passoFina_W = (TextView) findViewById(R.id.tv_fina_Ww);
        passoGrossa_W = (TextView) findViewById(R.id.tv_grossa_Ww);
        externo_fina_W = (TextView) findViewById(R.id.tv_externo_fina_Ww);
        externo_grossa_W = (TextView) findViewById(R.id.tv_externo_grossa_Ww);

        /** Inicia as variaveis textView (Exibição valores Métricos) */
        passoFina_M = (TextView) findViewById(R.id.tv_fina_M);
        passoGrossa_M = (TextView) findViewById(R.id.tv_grossa_M);
        externo_fina_M = (TextView) findViewById(R.id.tv_externo_fina_M);
        externo_grossa_M = (TextView) findViewById(R.id.tv_externo_grossa_M);

        et_M = (EditText) findViewById(R.id.et_M);
        M = Double.parseDouble(et_M.getText().toString());

        if (et_M != null){
            formula_M(M);
            passoFina_M.setText(M.toString());
        }

    }

    private Double formula_M(double m){
        return m;
    }

    private Double formula_Ww(double m){
        return m;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_tabela_rosca, menu);
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
