package in.techfantasy.thepapp;

import android.os.Build;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import static android.content.ContentValues.TAG;

/**
 * Created by campusiq on 09/02/18.
 */

public class TokenAccess extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
//        sendRegistrationToServer(refreshedToken);
        String token = refreshedToken;
        String model = Build.MODEL;
        User u = new User(token, model);
        DatabaseReference mFirebaseInstance = FirebaseDatabase.getInstance().getReference("User");
        String id = mFirebaseInstance.push().getKey();
        mFirebaseInstance.child(id).setValue(u);


    }


}
