package com.example.pc.pokemon;

import android.app.AlertDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;


public class PokemonesActivity extends ActionBarActivity implements View.OnClickListener {

    AlertDialog ventanita;
    ImageView muestra;
    int posicion;
    Animation animar;

    Integer[] galeria ={
            R.drawable.articuno,
            R.drawable.beedrill,
            R.drawable.blastoise,
            R.drawable.bulbasaur,
            R.drawable.charizard,
            R.drawable.charmander,
            R.drawable.charmeleon,
            R.drawable.ivysaur,
            R.drawable.kakuna,
            R.drawable.megabeedrill,
            R.drawable.megablastoise,
            R.drawable.megacharizardx,
            R.drawable.megacharizardy,
            R.drawable.megamewtwox,
            R.drawable.megamewtwoy,
            R.drawable.megapidgeottox,
            R.drawable.megapidgeottoy,
            R.drawable.megavenasaur,
            R.drawable.mew,
            R.drawable.mewtwo,
            R.drawable.moltres,
            R.drawable.pidgeotto,
            R.drawable.pidgey,
            R.drawable.squirtle,
            R.drawable.venusaur,
            R.drawable.wartortle,
            R.drawable.weedle,
            R.drawable.zapdos,
                };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemones);

        animar = AnimationUtils.loadAnimation(this, R.anim.secuencia);
        //la variable animar de la clase Animation carga la animacion definida en el reruso animacion
        animar.reset ();

        posicion = 0;
        muestra = (ImageView) findViewById(R.id.visor);
        muestra.setImageResource(galeria[posicion]);
        ImageButton bRetroceder = (ImageButton) findViewById(R.id.btnRetroceder);
        ImageButton bAvanzar = (ImageButton) findViewById(R.id.btnAvanzar);


        bRetroceder.setOnClickListener(this);
        bAvanzar.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pokemones, menu);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAvanzar:
                posicion++;
                if(posicion==galeria.length){
                    posicion = 0;
                }
                muestra.setImageResource(galeria[posicion]);
                muestra.startAnimation(animar);
                break;
            case R.id.btnRetroceder:
                posicion--;
                if(posicion == -1){
                    posicion = galeria.length - 1;
                }
                muestra.setImageResource(galeria[posicion]);
                muestra.startAnimation(animar);
                break;

        }

    }
}
