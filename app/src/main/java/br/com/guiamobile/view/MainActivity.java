package br.com.guiamobile.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.guiamobile.R;

/**
 * Created by Gilberto on 27/04/2016.
 */
public class MainActivity extends Activity {

    private EditText textoBuscar;
    private static final int BUSCAR = 1;

    //sem comentarios
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoBuscar = (EditText) findViewById(R.id.textoBuscar);
    }

    //Menu do Main
    public void Menu(View view) {
        switch (view.getId()) {
            case R.id.button:
                buscarPontosDeTurismo();
                break;

        }
    }


    public void buscarPontosDeTurismo() {
        String buscarNoBanco = textoBuscar.getText().toString();
        if (!buscarNoBanco.equals("")) {
            Intent intent = new Intent(this, RetornoDaBusca.class);
            intent.putExtra("buscarNoBanco", buscarNoBanco);
            startActivityForResult(intent, BUSCAR);
            finish();
        } else {
            Toast.makeText(MainActivity.this, "O Campo busca não pode está em branco", Toast.LENGTH_SHORT).show();
        }


    }
}
