package com.androidtutorialpoint.androidviewpagerexample.View;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.androidtutorialpoint.androidviewpagerexample.Adapter.APIHandler;
import com.androidtutorialpoint.androidviewpagerexample.Adapter.MovieAdapter;
import com.androidtutorialpoint.androidviewpagerexample.Model.Movie;
import com.androidtutorialpoint.androidviewpagerexample.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Tablayout_in_Android extends Fragment {
       String reuselt_object;
       public List<Movie> List;
    GridView gridview ;
        public Tablayout_in_Android() {
            // Required empty public constructor
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);


        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            new Task().execute();
            return inflater.inflate(R.layout.fragment_tablayout_in__android, container, false);

        }

    public class Task extends AsyncTask<Void,Void,String> {


        @Override
        protected String doInBackground(Void... voids) {
            APIHandler H= new APIHandler();
            reuselt_object=H.APICall("https://api.themoviedb.org/3/movie/now_playing?api_key=5b7b90a6e3498ae7267efbfece0ddf15&language=en-US&region=eg");

            return reuselt_object;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject root =new JSONObject(s);
                JSONArray Contact =root.getJSONArray("results");
                List = new ArrayList<>();

                for (int i=0;i<Contact.length();i++){
                    Movie Film=new Movie();
                    JSONObject obj_contact =Contact.getJSONObject(i);
                    Film.setId(obj_contact.getString("id"));
                    Film.setName("Name:\n"+obj_contact.getString("title"));
                    Film.setImage("https://image.tmdb.org/t/p/w500"+obj_contact.getString("poster_path"));
                    if (obj_contact.getString("backdrop_path")!="null") {
                        Film.setImage2("https://image.tmdb.org/t/p/w500" + obj_contact.getString("backdrop_path"));
                    }
                    else {Film.setImage2("https://image.tmdb.org/t/p/w500"+obj_contact.getString("poster_path"));}
                    Film.setOverview("OverView:\n "+obj_contact.getString("overview"));
                    Film.setRating((float) obj_contact.getDouble("vote_average"));
                    Film.setRelease_date("Name:\n "+obj_contact.getString("release_date"));

                    List.add(Film);

                    // Toast.makeText(getApplicationContext(),Film.getName()+"\n"+Film.getImage()+"",Toast.LENGTH_LONG).show();
                    //    ListAdapter list = new SimpleAdapter(getApplicationContext(),);
                }

                GridView gridview = (GridView) getView().findViewById(R.id.lvMovieA);

                MovieAdapter adapter =new MovieAdapter(getContext(),R.layout.row,List);
                gridview.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
        }




}
