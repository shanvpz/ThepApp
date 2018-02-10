package in.techfantasy.thepapp;

import android.*;
import android.Manifest;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,ConnectivityReceiver.ConnectivityReceiverListener {

    boolean doubleBackToExitPressedOnce = false;
    final int REQUEST_CODE_ASK_PERMISSIONS = 123;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (Build.VERSION.SDK_INT < 23) {
            //your code here
        } else {
            requestruntimePermission();
        }
        checkConnection();
        loadContent(new HomeFragment());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View hView =  navigationView.getHeaderView(0);

        TextView nav_user = (TextView)hView.findViewById(R.id.textViewdecnav);
        Typeface typeFace = Typeface.createFromAsset(getAssets(),"ML-NILA03_NewLipi.ttf");
        nav_user.setTypeface(typeFace);
        nav_user.setText("തേപ്പ് ഒരു കലയാണ്");

        TextView nav_title = (TextView)hView.findViewById(R.id.textViewtitlenav);
        nav_title.setTypeface(typeFace);
        nav_title.setText("തേപ്പ്");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try{
            File f = new File(getBaseContext().getExternalFilesDir("Temp"), "Temporary_Trollz.jpg");
            f.delete();
        }catch (Exception E){

        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
//            super.onBackPressed();
            if (DBOps.atHome) {
                if (doubleBackToExitPressedOnce) {
                    super.onBackPressed();
                    return;
                }

                this.doubleBackToExitPressedOnce = true;
                Toast.makeText(this,"Please click BACK again to exit",Toast.LENGTH_SHORT).show();

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        doubleBackToExitPressedOnce = false;
                    }
                }, 2000);
            }
            else {
                finish();
                startActivity(new Intent(Main2Activity.this,Main2Activity.class));
                DBOps.atHome=true;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }


    @Override
    protected void onResume() {
        super.onResume();
        MyApplication.getInstance().setConnectivityListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        switch (item.getItemId()) {
            case R.id.tCalc:
                loadContent(new ThepCalculator());
                drawer.closeDrawer(GravityCompat.START);
                DBOps.atHome=false;
                return true;
            case R.id.tdeclare:
                loadContent(new DeclareFragment());
                drawer.closeDrawer(GravityCompat.START);
                DBOps.atHome=false;
                return true;
            case R.id.tstories:
                loadContent(new ThepStories());
                drawer.closeDrawer(GravityCompat.START);
                DBOps.atHome=false;
                return true;
            case R.id.tsongs:
                loadContent(new ThepSongs());
                drawer.closeDrawer(GravityCompat.START);
                DBOps.atHome=false;
                return true;
            case R.id.ttroll:
                loadContent(new TrollsFragment());
                drawer.closeDrawer(GravityCompat.START);
                DBOps.atHome=false;
                return true;
            case R.id.trecent:
                loadContent(new TrecentFragment());
                drawer.closeDrawer(GravityCompat.START);
                DBOps.atHome=false;
                return true;
            case R.id.tcommunity:
                loadContent(new TcommunityFragment());
                drawer.closeDrawer(GravityCompat.START);
                DBOps.atHome=false;
                return true;
            case R.id.tabout:
                loadContent(new AboutFragment());
                drawer.closeDrawer(GravityCompat.START);
                DBOps.atHome=false;
                return true;
            case R.id.tfeed:
                loadContent(new FeedBackFragment());
                drawer.closeDrawer(GravityCompat.START);
                DBOps.atHome=false;
                return true;
        }
        //return false;


        return true;
    }

    private void loadContent(Fragment f){
        FragmentManager fm=getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frameLayout,f);
        ft.commit();
    }


    private void requestruntimePermission() {

        int hasCameraPermission = ActivityCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.ACCESS_NETWORK_STATE)+
                ActivityCompat.checkSelfPermission(Main2Activity.this, android.Manifest.permission.READ_EXTERNAL_STORAGE)+
                ActivityCompat.checkSelfPermission(Main2Activity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (hasCameraPermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Main2Activity.this, new String[]{Manifest.permission.ACCESS_NETWORK_STATE,android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_ASK_PERMISSIONS);
        } else {
            //Toast.makeText(DefaultActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                // Check if the only required permission has been granted
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Runtime Permission is Granted", Toast.LENGTH_SHORT).show();
                } else {
                    LinearLayout layout;
                    layout=findViewById(R.id.drawer_layout);

                    Snackbar.make(layout, "Please enable permission from settings",
                            Snackbar.LENGTH_INDEFINITE)
                            .setAction("OK", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent();
                                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                    Uri uri = Uri.fromParts("package", Main2Activity.this.getPackageName(), null);
                                    intent.setData(uri);
                                    startActivity(intent);
                                }
                            })
                            .show();
                }
                break;
        }
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        DBOps.connected=isConnected;
        showToast(isConnected);
    }

    public void checkConnection() {
        DBOps.connected = ConnectivityReceiver.isConnected();
        showToast(DBOps.connected);
    }
    public void showToast(boolean status){
        if(status==true){
        }
        else {
            Toast.makeText(Main2Activity.this,"Please enable internet",Toast.LENGTH_SHORT).show();
        }

    }
}
