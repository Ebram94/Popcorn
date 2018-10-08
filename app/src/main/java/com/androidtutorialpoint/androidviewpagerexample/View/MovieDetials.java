package com.androidtutorialpoint.androidviewpagerexample.View;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidtutorialpoint.androidviewpagerexample.R;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.utils.L;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;

public class MovieDetials extends AppCompatActivity {
    Button btnComment;
    TextView tvComment;

    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detials);

        database=FirebaseDatabase.getInstance();
        reference=database.getReference(getIntent().getStringExtra("id"));


        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar2);

        ImageView Image= (ImageView) findViewById(R.id.ivMovieD);
        ImageView Image2= (ImageView) findViewById(R.id.ivMovieD2);
        TextView Name = (TextView) findViewById(R.id.tvMovieD);
        RatingBar rating= (RatingBar) findViewById(R.id.rbMovie);
        TextView Overview = (TextView) findViewById(R.id.tvOverview);
        TextView releasedate = (TextView) findViewById(R.id.tvMovieD2);
        final EditText etComment = (EditText) findViewById(R.id.etComment);
        tvComment = (TextView) findViewById(R.id.tvComment);
        ScrollView scrollview = (ScrollView) findViewById(R.id.sc);
        btnComment = (Button)findViewById(R.id.btnComment);

        tvComment.setMovementMethod(new ScrollingMovementMethod());


        scrollview.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                tvComment.getParent().requestDisallowInterceptTouchEvent(false);

                return false;
            }
        });

        tvComment.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                tvComment.getParent().requestDisallowInterceptTouchEvent(true);

                return false;
            }
        });


        final String image =getIntent().getStringExtra("image");
        String image2 =getIntent().getStringExtra("image2");
        Name.setText( getIntent().getStringExtra("name"));
        rating.setRating(getIntent().getFloatExtra("rate",2));
        Overview.setText(getIntent().getStringExtra("overview"));
        Overview.setMovementMethod(new ScrollingMovementMethod());
        releasedate.setText(getIntent().getStringExtra("releasedate"));
        ImageLoader.getInstance().displayImage(image2,Image2);
        ImageLoader.getInstance().displayImage(image, Image, new ImageLoadingListener() {
            @Override
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
        btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s =etComment.getText().toString();
                if (s.length() != 0){
                String c = etComment.getText().toString();
                String key =reference.push().getKey();
                reference.child(key).setValue(c);
                etComment.setText("");
                }

            }
        });


        reference.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final List<String> lst=new ArrayList<>();
                for (DataSnapshot ds :dataSnapshot.getChildren()){
                    lst.add(ds.getKey());
                }
                tvComment.setText("");

                for (int i=0;i<lst.size();i++){
                    final int finalI = i;
                    reference.child(lst.get(i)).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            String x =dataSnapshot.getValue(String.class);

                            tvComment.append("User"+lst.get(finalI)+" :\n\n"+"Comment : \t \t"+x+"\n__________________________________\n");
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

}
