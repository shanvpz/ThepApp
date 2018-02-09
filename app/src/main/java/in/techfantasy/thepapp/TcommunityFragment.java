package in.techfantasy.thepapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TcommunityFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TcommunityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TcommunityFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView txthtml;
    WebView wb;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TcommunityFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TcommunityFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TcommunityFragment newInstance(String param1, String param2) {
        TcommunityFragment fragment = new TcommunityFragment();
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
        View v=inflater.inflate(R.layout.fragment_tcommunity, container, false);
      //  txthtml=v.findViewById(R.id.txthtml);
        //txthtml.setText(Html.fromHtml(" <ul><li><a href=\"https://www.facebook.com/%E0%B4%A4%E0%B5%87%E0%B4%AA%E0%B5%8D%E0%B4%AA%E0%B5%8D-Theppu-1591277881164162/?ref=br_rs\">Theppu</a></li></ul>"));

        wb=v.findViewById(R.id.webview);
        //wb.getSettings().setLoadWithOverviewMode(true);
       // wb.getSettings().setUseWideViewPort(true);
        wb.setWebViewClient(new WebViewClient());
        final String mimeType = "text/html";
        final String encoding = "UTF-8";
        wb.getSettings().setJavaScriptEnabled(true);
        String html = "<h2>FaceBook Links</h2><br><ul style=\"list-style-type: none;font-size: 20px;\"><li><a href=\"https://www.facebook.com/%E0%B4%A4%E0%B5%87%E0%B4%AA%E0%B5%8D%E0%B4%AA%E0%B5%8D-Theppu-1591277881164162/?ref=br_rs\">Theppu</a></li><li><a href=\"https://www.facebook.com/CopyPasteAvk/?ref=br_rs\">Theppu Gang</a></li><li><a href=\"https://www.facebook.com/theppu787/?ref=br_rs\">Theppu Productions</a></li><li><a href=\"https://www.facebook.com/Theppu-petti-735983669906528/?ref=br_rs\">Theppu Petti</a></li><li><a href=\"https://www.facebook.com/Theppu-kittiyavar-248675448987361/?ref=br_rs\">Theppu Kittiyavar</a></li><li><a href=\"https://www.facebook.com/Theppu-KATTA-Theppu-1262802060500778/?ref=br_rs\">Katta Theppu</a></li><li><a href=\"https://www.facebook.com/ThEpPuPetTiIiIii/?ref=br_rs\">Theppu Petti</a></li><li><a href=\"https://www.facebook.com/Theppu1/?ref=br_rs\">Theppu</a></li><li><a href=\"https://www.facebook.com/thenjaliya/?ref=br_rs\">Theppu New</a></li></ul>";


        wb.loadDataWithBaseURL("", html, mimeType, encoding, "");

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
