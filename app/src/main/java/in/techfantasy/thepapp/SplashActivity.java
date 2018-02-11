package in.techfantasy.thepapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.FirebaseDatabase;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        DBOps.getImageArray();

        Thread t=new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent in=new Intent(SplashActivity.this,Main2Activity.class);
                    startActivity(in);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        getSupportActionBar().hide();
        t.start();
    }
}
