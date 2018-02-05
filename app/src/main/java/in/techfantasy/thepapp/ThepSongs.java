package in.techfantasy.thepapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ThepSongs.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ThepSongs#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThepSongs extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ThepSongs() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThepSongs.
     */
    // TODO: Rename and change types and number of parameters
    public static ThepSongs newInstance(String param1, String param2) {
        ThepSongs fragment = new ThepSongs();
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
        View v = inflater.inflate(R.layout.fragment_thep_songs, container, false);
        WebView wv=v.findViewById(R.id.webview2);
        wv.getSettings().setLoadWithOverviewMode(true);
        wv.getSettings().setUseWideViewPort(true);
        wv.setWebViewClient(new WebViewClient());
        final String mimeType = "text/html";
        final String encoding = "UTF-8";
        wv.getSettings().setJavaScriptEnabled(true);
        String html = "<style>.meta{display:none} .html5-video-player{} .clip img{margin-right:20px;} .ytlist{text-align:left;}</style>"+
                "<div style=\"width:100%\"><script src=\"http://www.yvoschaap.com/ytpage/ytembed.js\"></script><center><div id=\"ytThumbs\"></div></center></div><script> ytEmbed.init({'block':'ytThumbs','key':'AIzaSyCZEzlbeZgHKnn97NUNIRJ2IvBDS97mQIc','q':'PLS4UjDrkf-h1q1RGfYcJ5XEIWT-Vu4S5g','type':'playlist','results':50,'meta':true,'player':'embed','layout':'full'});</script>";


        wv.loadDataWithBaseURL("", html, mimeType, encoding, "");
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
