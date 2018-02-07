package in.techfantasy.thepapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v4.view.GravityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
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
//
//
//                switch (view.getId()) {
//                    case 0:
//                        loadContent(new ThepCalculator());
//                        gv.setVisibility(View.GONE);
//
//                    case 1:
//                        loadContent(new DeclareFragment());
//                        gv.setVisibility(View.GONE);
//
//                    case 2:
//                        loadContent(new RecentFragment() );
//                        gv.setVisibility(View.GONE);
//
//                    case 3:
//                        loadContent(new TrollsFragment());
//                        gv.setVisibility(View.GONE);
//
//                    case 4:
//                        loadContent(new ThepStories());
//                        gv.setVisibility(View.GONE);
//
//                    case 5:
//                        loadContent(new ThepSongs());
//                        gv.setVisibility(View.GONE);
//
//
//                    case 6:
//                        loadContent(new ThepCommunityFragment());
//                        gv.setVisibility(View.GONE);
//
//
//                    case 7:
//                        loadContent(new TrollsFragment());
//                        gv.setVisibility(View.GONE);
//

  //              }

            }
        });
        return row;
    }
//    private void loadContent(Fragment f){
//        FragmentManager fm=getFragmentManager();
//        FragmentTransaction ft=fm.beginTransaction();
//        ft.replace(R.id.frameLayout,f);
//        ft.commit();
//    }

}
