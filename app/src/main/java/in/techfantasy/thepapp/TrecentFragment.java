package in.techfantasy.thepapp;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TrecentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TrecentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrecentFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    //TextView data;
    ListView lv;
    ProgressBar progressBar;
    DatabaseReference rootRef;
    List<DeclarationModel> val=new ArrayList<>();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TrecentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TrecentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TrecentFragment newInstance(String param1, String param2) {
        TrecentFragment fragment = new TrecentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_trecent, container, false);

        //data=v.findViewById(R.id.datafromserver);
        lv=v.findViewById(R.id.declarationList);
        progressBar = v.findViewById(R.id.progressBar);

        rootRef = FirebaseDatabase.getInstance().getReference();

        /////////////////////////////////////////////////////

        ////////////////////////////////////////////////////


        //progressBar.setVisibility(View.VISIBLE);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        new DownloadWebPageTask().execute();
    }


    /////////////////////////////////////////////////////////////

    class DownloadWebPageTask extends AsyncTask<String, Integer, List<DeclarationModel>> {

        @Override
        protected void onPreExecute() {
            //textView.setText("Hello !!!");

            progressBar.setVisibility(View.VISIBLE);
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected List<DeclarationModel> doInBackground(String... urls) {

            rootRef.addValueEventListener(new ValueEventListener() {


                String list;
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for(DataSnapshot ds:dataSnapshot.child("DeclarationModel").getChildren()){
                        val.add(ds.getValue(DeclarationModel.class));
                    }//getValue(String.class);
                    for(DeclarationModel dm:val) {
                        list=list+(dm.getUrName()+"+"+dm.getPartName()+"\n"+dm.getStory()+"\nStart Date:"+dm.getStDate()+"\nEnd Date:"+dm.getEnDate()+"\n-----------------");
                    }
                    //data.setText(list);
                    Log.i("data",list);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            return val;
        }

        @Override
        protected void onPostExecute(List<DeclarationModel> val) {
            progressBar.setVisibility(View.INVISIBLE);
            lv.setAdapter(new DeclareListAdapter(getActivity(),R.layout.declarationlistitem,val));
        }
    }
    /////////////////////////////////////////////////////////
    @Override
    public void onStart() {
        super.onStart();
        
        new DownloadWebPageTask().execute();
        //Log.i("Count",String.valueOf(val.size()));
        //getFragmentManager().beginTransaction().replace(R.id.frameLayout,new TrecentFragment());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
