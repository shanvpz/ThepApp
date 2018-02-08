package in.techfantasy.thepapp;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AboutFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AboutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView txtabt;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AboutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AboutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AboutFragment newInstance(String param1, String param2) {
        AboutFragment fragment = new AboutFragment();
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
        View v=inflater.inflate(R.layout.fragment_about, container, false);
        txtabt=v.findViewById(R.id.textviewabout);

        Typeface typeFace = Typeface.createFromAsset(getActivity().getAssets(),"ML-NILA03_NewLipi.ttf");
        txtabt.setTypeface(typeFace);
        txtabt.setText("ജീവിതത്തിൽ ഒരു തേപ്പ് എങ്കിലും കിട്ടിയവരും കൊടുത്തവരും ആയിരിക്കും കൂടുതൽ ആളുകളും.\nചിലർ തേപ്പ് കിട്ടിയതിനു ശേഷം ജീവിതത്തിൽ എല്ലാം നഷ്ടപ്പെട്ടവരെ പോലെ നടക്കും മറ്റുചിലർ ഒന്ന് പോയാൽ മറ്റൊന്ന് എന്ന് വിചാരിച്ചു ജീവിക്കും, മികച്ചത് കിട്ടുമെന്ന് തോന്നിക്കഴിഞ്ഞാൽ ആത്മാർത്ഥ പ്രണയം പോലും ഉപേക്ഷിക്കുന്ന ചിലരും ഈ ഭൂമിയിൽ ഉണ്ട്.\nഅങ്ങനെ നല്ല ജീവിതം കിട്ടും അല്ലെങ്കിൽ കുറച്ചു കൂടി നല്ലത് എനിക്ക് കിട്ടുമല്ലോ എന്ന് കരുതി തന്നെ ജീവന് തുല്യം സ്നേഹിക്കുന്നത് പോലും മറന്നു കളയുന്ന പ്രതിഭാസത്തെ ആണല്ലോ തേപ്പ് എന്ന് അഭിസംബോധന ചെയ്യപ്പെടുന്നത്.\nആണുങ്ങളും പെണ്ണുങ്ങളും ഒരേപോലെ തന്നെ ആ പ്രതിഭാസത്തിനു പാത്രങ്ങൾ ആകേണ്ടി വരുന്നു ചിലപ്പോ അതിനു കാരണങ്ങളും ആകുന്നു.\nഎന്തായാലും ഞങ്ങൾ കൂടുതൽ സാഹിത്യം പറയുന്നില്ല... ഈ പ്രണയിക്കുന്നവരുടെ മാസത്തിൽ പ്രണയം നഷ്ടപ്പെട്ടവർക്കും നഷ്ടപെടുത്തിയവർക്കും എല്ലാം വേണ്ടി ഞങ്ങൾ ചെറിയൊരു അപ്ലിക്കേഷൻ സമർപ്പിക്കുന്നു...\n");




        // Inflate the layout for this fragment
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
