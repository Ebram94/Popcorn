package com.androidtutorialpoint.androidviewpagerexample;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.List;

public class MovieAdapter extends ArrayAdapter {

    private List<Movie> movieModelList;
    private int resourse;
    private LayoutInflater inflater;
    private Context c;
    public MovieAdapter(Context context, int resource, List<Movie> objects) {
        super(context, resource, objects);
        movieModelList =objects;
        this.resourse=resource;
        c=context;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null){
            convertView = inflater.inflate(resourse,null);
        }
        ImageView ivMovie = (ImageView) convertView.findViewById(R.id.ivMovie);
        final ProgressBar progressBar = (ProgressBar)convertView.findViewById(R.id.progressBar);
      //  TextView tvMNAme= (TextView) convertView.findViewById(R.id.tvName);


// Then later, when you want to display image
        ImageLoader.getInstance().displayImage(movieModelList.get(position).getImage(), ivMovie, new ImageLoadingListener() {
            public void onLoadingStarted(String imageUri, View view) {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                progressBar.setVisibility(View.GONE);
            }
        });




        // Default options will be used
        //tvMNAme.setText(movieModelList.get(position).getName());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(),MovieDetials.class);
                intent.putExtra("id",movieModelList.get(position).getId());
                intent.putExtra("image",movieModelList.get(position).getImage());
                intent.putExtra("image2",movieModelList.get(position).getImage2());
                intent.putExtra("name",movieModelList.get(position).getName());
                intent.putExtra("rate",movieModelList.get(position).getRating()/2);
                intent.putExtra("overview",movieModelList.get(position).getOverview());
                intent.putExtra("releasedate",movieModelList.get(position).getRelease_date());
                c.startActivity(intent);
            }
        });
        return convertView;
    }
}

