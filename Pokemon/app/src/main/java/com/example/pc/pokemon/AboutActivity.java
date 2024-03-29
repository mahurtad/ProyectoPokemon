package com.example.pc.pokemon;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;


public class AboutActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_about, menu);
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
    public void facebookApp(View view) {
        String ruta ="https://www.facebook.com/Pokemon";
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(ruta));
        startActivity(i);
    }

    public void gplusApp(View view) {
        String ruta ="https://plus.google.com/+Pokemonpets/videos";
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(ruta));
        startActivity(i);
    }

    public void twitterApp(View view) {
        String ruta ="https://twitter.com/pokemon";
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(ruta));
        startActivity(i);
    }

    public void youtubeApp(View view) {
        String ruta ="https://www.youtube.com/user/pokemon";
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(ruta));
        startActivity(i);
    }
}
