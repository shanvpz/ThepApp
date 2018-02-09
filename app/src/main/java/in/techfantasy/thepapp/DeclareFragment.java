package in.techfantasy.thepapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DeclareFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DeclareFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeclareFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    EditText etxtMyName,etxtPartnerName,etxtStory,etxtStartDate,etxtEndDate;
    Button btnDeclare;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DeclareFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DeclareFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DeclareFragment newInstance(String param1, String param2) {
        DeclareFragment fragment = new DeclareFragment();
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
        View v = inflater.inflate(R.layout.fragment_declare, container, false);
        etxtMyName=v.findViewById(R.id.etxtUrNamethep);
        etxtPartnerName=v.findViewById(R.id.etxtPatNameThep);
        etxtStory=v.findViewById(R.id.etxtUrstorythep);
        etxtStartDate=v.findViewById(R.id.date1);
        etxtEndDate=v.findViewById(R.id.date2);
        btnDeclare=v.findViewById(R.id.btnDeclare);
        etxtStartDate.addTextChangedListener(new TextWatcher() {
            int prevL = 0;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                prevL = etxtStartDate.getText().toString().length();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int length = editable.length();
                if ((prevL < length) && (length == 2 || length == 5)) {
                    editable.append("/");
                }
            }
        });



        etxtEndDate.addTextChangedListener(new TextWatcher() {
            int prevL = 0;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                prevL = etxtEndDate.getText().toString().length();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int length = editable.length();
                if ((prevL < length) && (length == 2 || length == 5)) {
                    editable.append("/");
                }
            }
        });


        btnDeclare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String myname,hername,startdate,enddate,story;
                    myname=etxtMyName.getText().toString();
                    hername=etxtPartnerName.getText().toString();
                    story=etxtStory.getText().toString();
                    startdate=etxtStartDate.getText().toString();
                    enddate=etxtEndDate.getText().toString();
                    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("DeclarationModel");
                    String declarationId = mDatabase.push().getKey();
                    DeclarationModel dm = new DeclarationModel(myname,hername,story,startdate,enddate);
                    if(myname.equals("")||hername.equals("")||startdate.equals("")||enddate.equals("")){
                        Toast.makeText(getActivity().getApplicationContext(),"All fields with * are mandatory!",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        mDatabase.child(declarationId).setValue(dm);
                        Toast.makeText(getActivity().getApplicationContext(), "Success!", Toast.LENGTH_SHORT).show();
                        etxtMyName.getText().clear();
                        etxtPartnerName.getText().clear();
                        etxtStory.getText().clear();
                        etxtStartDate.getText().clear();
                        etxtEndDate.getText().clear();
                    }
                }
                catch (Exception e){
                    Toast.makeText(getActivity().getApplicationContext(),"Something went wrong, Try Again Later!",Toast.LENGTH_SHORT).show();
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
}
