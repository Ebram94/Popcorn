package com.androidtutorialpoint.androidviewpagerexample;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



import java.util.List;

public class CinemaAdapter extends ArrayAdapter {

    private List<Cinema> movieModelList;
    private int resourse;
    private LayoutInflater inflater;
    private Context c;
    public CinemaAdapter(Context context, int resource, List<Cinema> objects) {
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

        TextView tvMNAme= (TextView) convertView.findViewById(R.id.tvCname);

        tvMNAme.setText("Cinema: \n"+movieModelList.get(position).get_Name());
        tvMNAme.setTypeface(tvMNAme.getTypeface(), Typeface.BOLD_ITALIC);
        TextView tvCV= (TextView) convertView.findViewById(R.id.tvCV);

        tvCV.setText("Address: \n"+movieModelList.get(position).getVicinity()+"\n");
        tvCV.setTypeface(tvCV.getTypeface(), Typeface.BOLD_ITALIC);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(),MapsActivity2.class);
                intent.putExtra("Name",movieModelList.get(position).get_Name());
                intent.putExtra("Vicinity",movieModelList.get(position).getVicinity());
                intent.putExtra("lat",movieModelList.get(position).getLat());
                intent.putExtra("lng",movieModelList.get(position).getLon());

                Toast.makeText(getContext(),movieModelList.get(position).getLon()+"",Toast.LENGTH_LONG).show();
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                c.startActivity(intent);
            }
        });
        return convertView;
    }
}
