package in.techfantasy.thepapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    GridView gv;

    TextView txtdecnav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        gv=findViewById(R.id.gridview);


        View hView =  navigationView.getHeaderView(0);

        TextView nav_user = (TextView)hView.findViewById(R.id.textViewdecnav);
        Typeface typeFace = Typeface.createFromAsset(getAssets(),"ML-NILA03_NewLipi.ttf");
        nav_user.setTypeface(typeFace);
        nav_user.setText("തേപ്പ് ഒരു കലയാണ്");

        TextView nav_title = (TextView)hView.findViewById(R.id.textViewtitlenav);
        nav_title.setTypeface(typeFace);
        nav_title.setText("തേപ്പ്");



        int[] img={R.drawable.menu1,R.drawable.menu2,R.drawable.menu03,R.drawable.menu04,R.drawable.menu1,R.drawable.menu2,R.drawable.menu03,R.drawable.menu04};
        gv.setAdapter(new CustomAdapter(Main2Activity.this,img));





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
        getMenuInflater().inflate(R.menu.main2, menu);
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
                gv.setVisibility(View.GONE);
                return true;
            case R.id.tdeclare:
                loadContent(new DeclareFragment());
                drawer.closeDrawer(GravityCompat.START);
                gv.setVisibility(View.GONE);
                return true;
            case R.id.tstories:
                loadContent(new ThepStories());
                drawer.closeDrawer(GravityCompat.START);
                gv.setVisibility(View.GONE);
                return true;
            case R.id.tsongs:
                loadContent(new ThepSongs());
                drawer.closeDrawer(GravityCompat.START);
                gv.setVisibility(View.GONE);
                return true;
            case R.id.ttroll:
                loadContent(new TrollsFragment());
                drawer.closeDrawer(GravityCompat.START);
                gv.setVisibility(View.GONE);
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

    public static int convertDpToPixels(float dp, Context context){
        Resources resources = context.getResources();
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                resources.getDisplayMetrics()
        );
    }
}
