package com.speedoprogrammers.qeematbhakkar;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.enums.Display;
import com.speedoprogrammers.qeematbhakkar.DC.DC_Rates;
import com.speedoprogrammers.qeematbhakkar.ErrorMessages.ErrorAlerts;
import com.speedoprogrammers.qeematbhakkar.Fruits.Fruits;
import com.speedoprogrammers.qeematbhakkar.TeamCredit.TeamCredit;
import com.thefinestartist.finestwebview.FinestWebView;

import cn.pedant.SweetAlert.SweetAlertDialog;
import io.trialy.library.Trialy;
import io.trialy.library.TrialyCallback;

import static io.trialy.library.Constants.STATUS_TRIAL_JUST_ENDED;
import static io.trialy.library.Constants.STATUS_TRIAL_JUST_STARTED;
import static io.trialy.library.Constants.STATUS_TRIAL_NOT_YET_STARTED;
import static io.trialy.library.Constants.STATUS_TRIAL_OVER;
import static io.trialy.library.Constants.STATUS_TRIAL_RUNNING;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

        Trialy mTrialy;
        ErrorAlerts errorAlerts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        errorAlerts= new ErrorAlerts();
        mTrialy =new Trialy(MainActivity.this, "WJZPMS3O6161Y3V7XKE");
        mTrialy.checkTrial("com.speedoprogrammers.qeematbhakkar.tariq", mTrialyCallback);
        mTrialy.startTrial("com.speedoprogrammers.qeematbhakkar.tariq",mTrialyCallback);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        LinearLayout comp= findViewById(R.id.complants);
        comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,Complaints.class);
                startActivity(i);
            }
        });


        LinearLayout dc= findViewById(R.id.dc);
        dc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,DC_Rates.class);
                startActivity(i);
            }
        });

        LinearLayout fruits= findViewById(R.id.fruits);
        fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,Fruits.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            String url="https://sites.google.com/view/livepfl/home";
            new FinestWebView.Builder(MainActivity.this).show(url);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_team) {
            Intent i= new Intent(MainActivity.this,TeamCredit.class);
            startActivity(i);
       } else if (id == R.id.nav_update) {
            new AppUpdater(this)
                    .setDisplay(Display.SNACKBAR)
                    .setDisplay(Display.DIALOG)
                    .start();
            View view = findViewById(android.R.id.content);
            Snackbar.make(view, "Checking For Update", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        } else if (id == R.id.nav_privacy) {
            String url="https://sites.google.com/view/livepfl/home";
            new FinestWebView.Builder(MainActivity.this).show(url);
        } else if (id == R.id.nav_rate) {
            ConformRate();
        } else if (id == R.id.nav_complaint) {
            Intent i= new Intent(MainActivity.this,Complaints.class);
            startActivity(i);
        } else if (id == R.id.nav_credit) {
            FlatIcons(MainActivity.this);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private TrialyCallback mTrialyCallback = new TrialyCallback() {
        @Override
        public void onResult(int status, long timeRemaining, String sku) {
            switch (status){
                case STATUS_TRIAL_JUST_STARTED:
                    //The trial has just started - enable the premium features for the user
                    errorAlerts.Trial(MainActivity.this,"Trial Started");
                    break;
                case STATUS_TRIAL_RUNNING:
                    //The trial is currently running - enable the premium features for the user
                    errorAlerts.Trial(MainActivity.this,"Trial is running");
                    break;
                case STATUS_TRIAL_JUST_ENDED:
                    //The trial has just ended - block access to the premium features
                    TrialEnded(MainActivity.this);

                    break;
                case STATUS_TRIAL_NOT_YET_STARTED:
                    //The user hasn't requested a trial yet - no need to do anything
                    errorAlerts.Trial(MainActivity.this,"Trial not started");
                    break;
                case STATUS_TRIAL_OVER:
                    //The trial is over

                    TrialEnded(MainActivity.this);
                    break;
                default:
                    Log.e("Trial", "Trialy response: " + Trialy.getStatusMessage(status));
                    break;
            }
        }

    };


    public void ConformRate(){
        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE);
        sweetAlertDialog.setTitleText("Are you sure?")
                .setContentText("Want to rate this app")
                .setConfirmText("Yes!")
                .setCancelText("Cancel")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                        try{
                            Uri uri1= Uri.parse("market://details?id="+ getPackageName());
                            Intent goToMarket1 = new Intent(Intent.ACTION_VIEW, uri1);
                            startActivity(goToMarket1);
                        }catch(ActivityNotFoundException e){
                            Uri uri1= Uri.parse("http://play.google.com/store/apps/details?id="+ getPackageName());
                            Intent goToMarket1 = new Intent(Intent.ACTION_VIEW, uri1);
                            startActivity(goToMarket1);

                        }
                    }
                })
                .show();
    }

    public void TrialEnded(final Context context){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(context,SweetAlertDialog.ERROR_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(18)
                .setTitleText("Trial is over")
                .setContentText("You have not paid development cost yet.")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                       // finishAffinity();
                    }
                })
                .show();
    }

    public void FlatIcons(final Context context){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(context,SweetAlertDialog.WARNING_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(18)
                .setTitleText("Icons Credit")
                .setContentText("<div>Icons made by <a href=\"https://www.flaticon.com/authors/pixelmeetup\" title=\"Pixelmeetup\">Pixelmeetup</a> from <a href=\"https://www.flaticon.com/\" \t\t\t    title=\"Flaticon\">www.flaticon.com</a> is licensed by <a href=\"http://creativecommons.org/licenses/by/3.0/\" \t\t\t    title=\"Creative Commons BY 3.0\" target=\"_blank\">CC 3.0 BY</a></div>")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                })
                .show();
    }
}
