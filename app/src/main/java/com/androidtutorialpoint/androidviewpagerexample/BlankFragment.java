package com.androidtutorialpoint.androidviewpagerexample;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class BlankFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView textView;
    String reuselt_object;
    public List<Movie> List;
    private ProgressDialog dialog;




    public BlankFragment() {
        // Required empty public constructor

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog=new ProgressDialog(getContext());
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        dialog.setMessage("Loading...");
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getContext()).defaultDisplayImageOptions(defaultOptions).build();
        ImageLoader.getInstance().init(config);


        new Task().execute();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }
    public class Task extends AsyncTask<Void,Void,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.show();
        }

        @Override
        protected String doInBackground(Void... voids) {
            APIHandler H= new APIHandler();
            reuselt_object=H.APICall("https://api.themoviedb.org/3/movie/now_playing?api_key=5b7b90a6e3498ae7267efbfece0ddf15&language=en-US");

            return reuselt_object;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            dialog.dismiss();
            try {
                JSONObject root =new JSONObject(s);
                JSONArray Contact =root.getJSONArray("results");
                List = new ArrayList<>();

                for (int i=0;i<Contact.length();i++){
                    Movie Film=new Movie();
                    JSONObject obj_contact =Contact.getJSONObject(i);
                    Film.setId(obj_contact.getString("id"));
                    Film.setName("\tName:\n "+obj_contact.getString("title"));
                    Film.setImage("https://image.tmdb.org/t/p/w500"+obj_contact.getString("poster_path"));
                    if(obj_contact.getString("backdrop_path")!=null) {
                        Film.setImage2("https://image.tmdb.org/t/p/w500" + obj_contact.getString("backdrop_path"));
                    }
                    else{Film.setImage2("https://image.tmdb.org/t/p/w500"+obj_contact.getString("poster_path"));}
                    Film.setOverview("OverView:\n "+obj_contact.getString("overview"));
                    Film.setRating((float) obj_contact.getDouble("vote_average"));
                    Film.setRelease_date("Date:\n"+obj_contact.getString("release_date"));


                    List.add(Film);

                    // Toast.makeText(getApplicationContext(),Film.getName()+"\n"+Film.getImage()+"",Toast.LENGTH_LONG).show();
                    //    ListAdapter list = new SimpleAdapter(getApplicationContext(),);
                }

                GridView gridview = (GridView) getView().findViewById(R.id.lvMovie);

                MovieAdapter adapter =new MovieAdapter(getContext(),R.layout.row,List);
                gridview.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

}
