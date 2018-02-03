package in.techfantasy.thepapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ThepCalculator.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ThepCalculator#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThepCalculator extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    EditText etxtUrName,etxtPartnerName;
    Button btnTCalc;
    TextView txtMsg;
    String urName,partnerName;
    char[] nameArray;
    List<String> listAlpha;
    String[] alphabets={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    String[] msgs={"1st","2nd","3rd","4th","5th","6th","7th","8th","9th"};
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ThepCalculator() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThepCalculator.
     */
    // TODO: Rename and change types and number of parameters
    public static ThepCalculator newInstance(String param1, String param2) {
        ThepCalculator fragment = new ThepCalculator();
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
        View v = inflater.inflate(R.layout.fragment_thep_calculator, container, false);
        etxtPartnerName=v.findViewById(R.id.etxtpartnerName);
        etxtUrName=v.findViewById(R.id.etxtUrName);
        btnTCalc=v.findViewById(R.id.btnTCalc);
        txtMsg=v.findViewById(R.id.txtMsg);
        urName=etxtUrName.getText().toString();
        partnerName=etxtPartnerName.getText().toString();
        btnTCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMsg.setText(TCALC(urName,partnerName));
            }
        });

        return v;
    }

    public String TCALC(String urName,String partnerName){

        StringBuilder sb=new StringBuilder();
        sb.append(urName);
        sb.append(partnerName);
        int Total=0;
        nameArray=sb.toString().toCharArray();

        for (int i=0;i<alphabets.length;i++){
            listAlpha.add(alphabets[i]);
        }
        for(int j=0;j<nameArray.length;j++){
            if(listAlpha.contains(nameArray[j])){
                Total+= listAlpha.indexOf(nameArray[j]);
            }
        }
        if(Total>100){
            Total=(Total/2)%10;
        }
        else{
            Total=Total%10;
        }

        return msgs[Total];
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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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
