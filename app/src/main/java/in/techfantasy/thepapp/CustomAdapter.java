package in.techfantasy.thepapp;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    public View getView(final int i, View view, ViewGroup viewGroup) {
       View row;
        LayoutInflater inflater = ( LayoutInflater )cc. getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        row=inflater.inflate(R.layout.custom,viewGroup,false);
        im=row.findViewById(R.id.imageView);
        im.setImageResource(img[i]);

        im.setId(i);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(cc,""+view.getId(),Toast.LENGTH_SHORT).show();


                switch (view.getId()) {
                    case 0:
                        loadContent(new ThepCalculator());
                        break;
                    case 1:
                        loadContent(new DeclareFragment());
                        break;
                    case 2:
                        loadContent(new TrecentFragment() );
                        break;
                    case 3:
                        loadContent(new TrollsFragment());
                        break;
                    case 4:
                        loadContent(new ThepStories());
                        break;
                    case 5:
                        loadContent(new ThepSongs());
                        break;
                    case 6:
                        loadContent(new TcommunityFragment());
                        break;
                    case 7:
                        loadContent(new AboutFragment());
                        break;
                }

            }
        });
        return row;
    }
    private void loadContent(Fragment f){
        FragmentManager fm=((Activity)cc).getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frameLayout,f);
        ft.commit();
    }
}

