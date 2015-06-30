package ch.berufsbildungscenter.packagesorter;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.app.Dialog;

public class MainActivity extends ActionBarActivity {

    @Override
    public Resources getResources() {
        return super.getResources();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* ImageView für den Titel "Package Sorter" */
        ImageView imageViewTitle = (ImageView) findViewById(R.id.imageViewTitle);
        imageViewTitle.setImageResource(R.drawable.package_sorter_menu);

        final Button buttonPl = (Button) findViewById(R.id.playButton);
        buttonPl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intentPlayGame = new Intent(getApplicationContext(), PlayGame.class);
                startActivity(intentPlayGame);
                onPause();

            }
        });

        //Button Listener
        final Button buttonHi = (Button) findViewById(R.id.highscoreButton);
        buttonHi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intentHighscore = new Intent(getApplicationContext(), Highscore.class);
                startActivity(intentHighscore);
            }
        });

        final  Button buttonP = (Button) findViewById(R.id.diePostButton);
        buttonP.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.post.ch/de"));
                startActivity(intent);
            }

        });

        final Button buttonH = (Button) findViewById(R.id.help);
        buttonH.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                final Dialog dlg = new Dialog(MainActivity.this);
                dlg.setContentView(R.layout.activity_help);
                dlg.setTitle(R.string.title_help);

                Button dlgButton = (Button) dlg.findViewById(R.id.buttonDlg);
                dlgButton.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        dlg.hide();
                    }
                });
                dlg.show();
            }
        });

        final  Button buttonS = (Button) findViewById(R.id.share);
        buttonS.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey there, \n \ncheck out this cool App: \n \npost.ch");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                sendIntent.setPackage("com.whatsapp");

                // Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                // sharingIntent.setType("plain/text");
                // sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Hey there, \n \ncheck out this cool App: \n \npost.ch");
                // startActivity(Intent.createChooser(sharingIntent,"Use the following apps to share..."));
            }
        });

        final  Button buttonR = (Button) findViewById(R.id.rate);
        buttonR.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store?hl=de"));
                startActivity(intent);
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}
