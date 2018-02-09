package in.techfantasy.thepapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FeedBackFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FeedBackFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FeedBackFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    EditText etxmsg,etxname;
    Button btnsnd;
    Boolean check=false;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FeedBackFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FeedBackFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FeedBackFragment newInstance(String param1, String param2) {
        FeedBackFragment fragment = new FeedBackFragment();
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(resultCode==RESULT_OK&&requestCode==123) {
            if (check) {
                Toast.makeText(getActivity(), "FeedBack Send Successfully", Toast.LENGTH_SHORT).show();
                etxname.getText().clear();
                etxmsg.getText().clear();
                loadContent(new HomeFragment());

            }
        }else{
            Toast.makeText(getActivity(), "Sending failed Try again later", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_feed_back, container, false);
        // Inflate the layout for this fragment
        etxmsg=v.findViewById(R.id.feedmsg);
        etxname=v.findViewById(R.id.feedname);
        btnsnd=v.findViewById(R.id.feedsend);
        btnsnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nam,msg;
                nam=etxname.getText().toString();
                msg=etxmsg.getText().toString();

                if(nam.equals("")||msg.equals("")){
                    Toast.makeText(getActivity(),"All fields are mandatory!",Toast.LENGTH_SHORT).show();
                }else {

                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("message/rfc822");
                    i.putExtra(Intent.EXTRA_EMAIL, new String[]{"appthepp@gmail.com"});
                    i.putExtra(Intent.EXTRA_SUBJECT, "FeedBack - Thepp App - " + nam);
                    i.putExtra(Intent.EXTRA_TEXT, msg);
                    try {
                        startActivityForResult(Intent.createChooser(i, "Send mail..."), 123);
                        //startActivity(Intent.createChooser(i, "Send mail..."));
                        check = true;

                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(getActivity(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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

    private void loadContent(Fragment f){
        FragmentManager fm=getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frameLayout,f);
        ft.commit();
    }
}
