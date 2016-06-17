package cs639.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity {
    private Button btnSMS;
    private Button btnPhone;
    private Button btnWeb;
    private Button btnMap;
    private Button btnShare;
    private Button btnNewActivity;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnSMS = (Button) findViewById(R.id.btnSMS);
        btnSMS.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Intent intentSMS = new Intent(Intent.ACTION_SENDTO);
                intentSMS.setData(Uri.parse("smsto:" + Uri.encode("8456536931")));
                intentSMS.putExtra("sms_body", "Hello Baby, it's Tom!");
                startActivity(intentSMS);
            }
        });

        btnPhone = (Button) findViewById(R.id.btnPhone);
        btnPhone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Intent intentPhone = new Intent(Intent.ACTION_DIAL);
                intentPhone.setData(Uri.parse("tel:8456536931"));
                startActivity(intentPhone);
            }
        });

        btnMap = (Button) findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String geoUri = "geo:40.868303,-73.224091";
                Uri geo = Uri.parse(geoUri);
                Intent intentMap = new Intent(Intent.ACTION_VIEW, geo);
                startActivity(intentMap);
            }
        });

        btnWeb = (Button) findViewById(R.id.btnWeb);
        btnWeb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
                startActivity(intentWeb);
            }
        });

        btnShare = (Button) findViewById(R.id.btnShare);
        btnShare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Intent intentShare = new Intent(Intent.ACTION_SEND);
                intentShare.setType("text/plain");
                final Intent intentShare2 = new Intent(Intent.ACTION_CHOOSER);
                intentShare2.putExtra(Intent.EXTRA_TEXT, "Share the love");
                intentShare2.putExtra(Intent.EXTRA_SUBJECT, "CS639");
                intentShare2.putExtra(Intent.EXTRA_TEXT, "Join CS639");
                intentShare2.putExtra(Intent.EXTRA_INTENT, intentShare);
                startActivity(intentShare2);
            }
        });

        btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Intent intentNewActivity = new Intent(getApplicationContext(), NewActivity.class);
                startActivity(intentNewActivity);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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
        if (id == R.id.action_settings) {
            Toast t = Toast.makeText(this, "Settings", Toast.LENGTH_SHORT);
            t.show();
            return true;
        } else if (id == R.id.action_help) {
            final Intent intentHelp = new Intent(this, HelpActivity.class);
            startActivity(intentHelp);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://cs639.menuproject/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://cs639.menuproject/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
