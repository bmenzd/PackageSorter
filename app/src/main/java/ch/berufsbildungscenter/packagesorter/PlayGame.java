package ch.berufsbildungscenter.packagesorter;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class PlayGame extends ActionBarActivity {



    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            onPause();
            ZruegGo();
            return true;
        } else {
            return super.onKeyUp(keyCode, event);
        }
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onPause();
            ZruegGo();
            return true;
        } else {
            return super.onKeyUp(keyCode, event);
        }
    }

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_play_game);

                final Button buttonPa = (Button) findViewById(R.id.pauseButton);
                buttonPa.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        ZruegGo();

                    }
                });
            }


            @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.menu_play_game, menu);
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

            public void ZruegGo() {

                        final Dialog dlgPause = new Dialog(PlayGame.this);
                        dlgPause.setContentView(R.layout.activity_pause_menu);
                        dlgPause.setTitle(R.string.title_pause);

                        Button resumeButton = (Button) dlgPause.findViewById(R.id.resumeButton);
                        resumeButton.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                dlgPause.hide();
                            }
                        });
                        dlgPause.show();
                        onPause();

                        Button restartButton = (Button) dlgPause.findViewById(R.id.restartButton);
                        restartButton.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                dlgPause.hide();
                                finish();
                                startActivity(getIntent());
                            }
                        });

                        Button endButton = (Button) dlgPause.findViewById(R.id.endMenuButton);
                        endButton.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                dlgPause.hide();
                                finish();
                            }
                        });

                        Button helpButton = (Button) dlgPause.findViewById(R.id.help_pause);
                        helpButton.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                final Dialog dlg = new Dialog(PlayGame.this);
                                dlg.setContentView(R.layout.activity_help);
                                dlg.setTitle(R.string.title_help);

                                Button dlgButton = (Button) dlg.findViewById(R.id.buttonDlg);
                                dlgButton.setOnClickListener(new View.OnClickListener() {

                                    @Override
                                    public void onClick(View v) {
                                        dlg.hide();
                                    }
                                });
                                dlg.show();
                            }

                        });

                        Button rateButton = (Button) dlgPause.findViewById(R.id.rate_pause);
                        rateButton.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View arg0) {

                                Intent intent = new Intent(Intent.ACTION_VIEW,
                                        Uri.parse("https://play.google.com/store?hl=de"));
                                startActivity(intent);
                            }

                        });

                        Button shareButton = (Button) dlgPause.findViewById(R.id.share_pause);
                        shareButton.setOnClickListener(new View.OnClickListener() {

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


                    }
        }