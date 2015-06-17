package com.example.pc.pokemon;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class JuegoActivity extends ActionBarActivity {

    private String[] nombre_pokemon={"articuno","beedrill","blastoise","bulbasaur","charizard","charmander","charmeleon",
            "ivysaur","kakuna","mew","mewtwo","moltres","pidgeotto","pidgey","squirtle","venusaur",
            "wartortle","weedle","zapdos"};
    private String[] sombra_pokemon={"s_articuno","s_beedrill","s_blastoise","s_bulbasaur","s_charizard","s_charmander","s_charmeleon",
            "s_ivysaur","s_kakuna","s_mew","s_mewtwo","s_moltres","s_pidgeotto","s_pidgey","s_squirtle","s_venusaur",
            "s_wartortle","s_weedle","s_zapdos"};
    private int intentos = 3;
    private Button aceptar;
    private TextView mensaje_intentos, mensaje_tiempo;
    private EditText usuario_pokemon;
    private int numero_generado=0;
    private ImageView miimagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        aceptar=(Button)findViewById(R.id.btnAceptar);
        mensaje_intentos=(TextView)findViewById(R.id.lblIntento);
        mensaje_tiempo=(TextView)findViewById(R.id.lblTiempo);
        usuario_pokemon=(EditText)findViewById(R.id.txtPokemon);
        miimagen=(ImageView)findViewById(R.id.imageView);
        numero_generado=generaraleatorio();

        establecer_sombra(numero_generado);

        mensaje_intentos.setText("Tiene " + intentos + " intentos.");
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre=usuario_pokemon.getText().toString().toLowerCase();
                if(nombre.equals(nombre_pokemon[numero_generado]))
                {
                    establecer_pokemon(numero_generado);
                    esperar();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"No es el pokemon", Toast.LENGTH_SHORT).show();
                    intentos=intentos-1;
                    mensaje_intentos.setText("Tiene " + intentos + " intentos.");
                    usuario_pokemon.setText("");
                }

                if(intentos==0)
                {
                    finish();
                }
            }
        });
    }

    private void esperar()
    {
        new CountDownTimer(5000, 1000)
        {

            @Override
            public void onTick(long millisUntilFinished) {
                mensaje_tiempo.setText("Generando en " + (millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                numero_generado=generaraleatorio();
                establecer_sombra(numero_generado);
                mensaje_tiempo.setText("");
                usuario_pokemon.setText("");
            }
        }.start();
    }

    private void establecer_pokemon(int numero)
    {
        int resId=getResources().getIdentifier(nombre_pokemon[numero],"drawable",getPackageName());
        miimagen.setImageResource(resId);
        MediaPlayer mediaPlayer = MediaPlayer.create(JuegoActivity.this,R.raw.pikachu1);
        mediaPlayer.start();
    }

    private void establecer_sombra(int numero)
    {
        int resId=getResources().getIdentifier(sombra_pokemon[numero],"drawable",getPackageName());
        miimagen.setImageResource(resId);
    }

    private int generaraleatorio()
    {
        return (int)(Math.random()* nombre_pokemon.length);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_juego, menu);
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
