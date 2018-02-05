package in.techfantasy.thepapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomAdapter extends BaseAdapter {

  int[] img;
  Context cc;

  ImageView im;

   public CustomAdapter(Context c, int[] img) {
       this.img=img;
       cc=c;
   }



    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       View row;
        LayoutInflater inflater = ( LayoutInflater )cc. getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        row=inflater.inflate(R.layout.custom,viewGroup,false);
        im=row.findViewById(R.id.imageView);
        im.setImageResource(img[i]);



        return row;
    }
}