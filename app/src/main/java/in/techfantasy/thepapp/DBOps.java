package in.techfantasy.thepapp;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by campusiq on 06/02/18.
 */

public class DBOps {
    public static boolean atHome=true;
    static String value;
    public static boolean connected=false;
    public static String[] imglinks;
    public static void getImageArray(){

        DatabaseReference rootRef;
        rootRef = FirebaseDatabase.getInstance().getReference();
        rootRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                value =  dataSnapshot.child("TrollLinks").getValue(String.class);
                Log.i("data from db", value);
                try {
                    imglinks = value.split(",");
                }
                catch (Exception e){
                    Log.e("from dbops",e.getMessage());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        //return new String[]{value};
    }

}
