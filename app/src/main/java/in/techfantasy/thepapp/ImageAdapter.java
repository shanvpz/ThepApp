package in.techfantasy.thepapp;

/**
 * Created by campusiq on 06/02/18.
 */

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    String value;
    int imageTotal = 7;
//    public static String[] mThumbIds = {
//            "https://developer.android.com/_static/images/android/touchicon-180.png",
//            "https://androidzone.org/wp-content/uploads/2013/02/android-musical2.jpg",
//            "http://www.jrtstudio.com/sites/default/files/ico_android.png",
//            "https://news4c.com/wp-content/uploads/2016/12/android-nougat.png",
//            "https://androidos.in/wp-content/uploads/2011/12/android-india-e1342675527104.jpg",
//            "http://bestgamesforandroidphone.com/wp-content/uploads/2016/06/free-download-best-games.jpg",
//            "https://cloud.netlifyusercontent.com/assets/344dbf88-fdf9-42bb-adb4-46f01eedd629/d8415e4e-e1cd-4e45-b1ff-b624efe1a418/3.jpg",
//    };
    public String[] mThumbIds=DBOps.imglinks.split(",");

    public ImageAdapter(Context c) {
        mContext = c;
        //getImageArray();
    }

    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public String getItem(int position) {
        return mThumbIds[position];
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(480, 480));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        String url = getItem(position);
        Picasso.with(mContext)
                .load(url)
                .placeholder(R.drawable.loader)
                .fit()
                .centerCrop().into(imageView);
        return imageView;
    }

}