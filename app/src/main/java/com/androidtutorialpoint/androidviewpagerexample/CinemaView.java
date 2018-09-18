package com.androidtutorialpoint.androidviewpagerexample;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CinemaView extends Fragment {
    public String Places = "{\n" +
            "   \"html_attributions\" : [],\n" +
            "   \"results\" : [\n" +
            "      {\n" +
            "         \"geometry\" : {\n" +
            "            \"location\" : {\n" +
            "               \"lat\" : 30.08132149999999,\n" +
            "               \"lng\" : 31.3055527\n" +
            "            },\n" +
            "            \"viewport\" : {\n" +
            "               \"northeast\" : {\n" +
            "                  \"lat\" : 30.08267132989272,\n" +
            "                  \"lng\" : 31.30690252989272\n" +
            "               },\n" +
            "               \"southwest\" : {\n" +
            "                  \"lat\" : 30.07997167010728,\n" +
            "                  \"lng\" : 31.30420287010728\n" +
            "               }\n" +
            "            }\n" +
            "         },\n" +
            "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/movies-71.png\",\n" +
            "         \"id\" : \"46ff1c81982669132be61a5101c474e9a44dfb6c\",\n" +
            "         \"name\" : \"Engineering Authority Guest House Cinema\",\n" +
            "         \"photos\" : [\n" +
            "            {\n" +
            "               \"height\" : 2448,\n" +
            "               \"html_attributions\" : [\n" +
            "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/115317274362957560571/photos\\\"\\u003eMohamed Saber\\u003c/a\\u003e\"\n" +
            "               ],\n" +
            "               \"photo_reference\" : \"CmRaAAAA1AglSGvlfE0qLT9DS9Hp9foRuUFkzj2AMHlYTESkaSbo_RDOXStI013vKqbw8Ho_NG0i8qAFcsbBejYzAaY1WTskL2VApXf8c43_JSoxI6HxFp-O49vPuhjL8edXaPfyEhBy9BAekvh7_7Of2RorhzIkGhR9ikB3Slk7dzWqZnY_seqi0tMv5g\",\n" +
            "               \"width\" : 3264\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJPw0I18o_WBQRYvSrGnPUYA8\",\n" +
            "         \"plus_code\" : {\n" +
            "            \"compound_code\" : \"38J4+G6 Mansheya El-Bakry, Heliopolis, Egypt\",\n" +
            "            \"global_code\" : \"8G2H38J4+G6\"\n" +
            "         },\n" +
            "         \"rating\" : 4.1,\n" +
            "         \"reference\" : \"CmRbAAAArgFkayYhSfpQ2r5Lab-drnBAaeUYZBZY_mmHuuHmsyqUQeAl9h2MhZBKWgA4XcewJWTr6qYj-3804ZXrKSEtp4IlFyxhaPyTkantbfgup97E2hhC4-JPDimfsYiFTEYoEhD33dlVRZ163fSHhGRw8fl9GhSTRU0gs3U3peJYv1yzZ3RsygBFNw\",\n" +
            "         \"scope\" : \"GOOGLE\",\n" +
            "         \"types\" : [ \"movie_theater\", \"point_of_interest\", \"establishment\" ],\n" +
            "         \"vicinity\" : \"6 Ihsan Abdel Quddous St., Mansheyet El Bakry, Heliopolis, Cairo\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"geometry\" : {\n" +
            "            \"location\" : {\n" +
            "               \"lat\" : 30.0675155,\n" +
            "               \"lng\" : 31.3297892\n" +
            "            },\n" +
            "            \"viewport\" : {\n" +
            "               \"northeast\" : {\n" +
            "                  \"lat\" : 30.06886532989271,\n" +
            "                  \"lng\" : 31.33113902989271\n" +
            "               },\n" +
            "               \"southwest\" : {\n" +
            "                  \"lat\" : 30.06616567010727,\n" +
            "                  \"lng\" : 31.32843937010727\n" +
            "               }\n" +
            "            }\n" +
            "         },\n" +
            "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/movies-71.png\",\n" +
            "         \"id\" : \"5609e4da2cd91f5c5dff4edc429f2cf3dac5fcc8\",\n" +
            "         \"name\" : \"Renaissance Cinema Teeba Mall\",\n" +
            "         \"photos\" : [\n" +
            "            {\n" +
            "               \"height\" : 4032,\n" +
            "               \"html_attributions\" : [\n" +
            "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/103804380078846261539/photos\\\"\\u003emustafa shagluf\\u003c/a\\u003e\"\n" +
            "               ],\n" +
            "               \"photo_reference\" : \"CmRaAAAAsKO7KlvC1Uwfcrl_ec_AJOWJdSaL1_Sb3NZcbO2ojLzR_PVRsyWqbWpF-lXUHa_0N7IT_BW9i8J9JscWYRc719qfIZaQ1pL0XKVyIvLGSGfbd3rHJ5_UmjjfqUgrUkBtEhC0n0wBa2lUz-jWvTA8JjMsGhSA71jDgchwiePZ2SbiCibIFCFo1A\",\n" +
            "               \"width\" : 3024\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJByWKuEE-WBQRWGPBeJ4TAy0\",\n" +
            "         \"plus_code\" : {\n" +
            "            \"compound_code\" : \"389H+2W Rabaa Buildings, Al Golf, Nasr City, Egypt\",\n" +
            "            \"global_code\" : \"8G2H389H+2W\"\n" +
            "         },\n" +
            "         \"rating\" : 3.8,\n" +
            "         \"reference\" : \"CmRbAAAA0Pg52sk2F9cj-sLqg5D3FlnLXD-efUAqMtFWnnM8xEpzlpEoo2Y2E21aEzOt-5otuaEDPWcF0aIByX0fHSY1VaphdUz8FFRu4BTW7bklaHp_3nuB-XLN6mVm-Xa_B8KEEhCVjc5jKrotYvzoOtEAAzXzGhScJZjlDfi_vk9g12ZEs68QkctF_A\",\n" +
            "         \"scope\" : \"GOOGLE\",\n" +
            "         \"types\" : [ \"movie_theater\", \"point_of_interest\", \"establishment\" ],\n" +
            "         \"vicinity\" : \"Teeba Mall, El Nasr Road, Nasr City, Cairo\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"geometry\" : {\n" +
            "            \"location\" : {\n" +
            "               \"lat\" : 30.0595654,\n" +
            "               \"lng\" : 31.317862\n" +
            "            },\n" +
            "            \"viewport\" : {\n" +
            "               \"northeast\" : {\n" +
            "                  \"lat\" : 30.06091522989272,\n" +
            "                  \"lng\" : 31.31921182989272\n" +
            "               },\n" +
            "               \"southwest\" : {\n" +
            "                  \"lat\" : 30.05821557010728,\n" +
            "                  \"lng\" : 31.31651217010727\n" +
            "               }\n" +
            "            }\n" +
            "         },\n" +
            "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/movies-71.png\",\n" +
            "         \"id\" : \"bc4d7ef414013879812ac1f02e5215647c4555c9\",\n" +
            "         \"name\" : \"Al Masah Cinema\",\n" +
            "         \"opening_hours\" : {\n" +
            "            \"open_now\" : true\n" +
            "         },\n" +
            "         \"photos\" : [\n" +
            "            {\n" +
            "               \"height\" : 3024,\n" +
            "               \"html_attributions\" : [\n" +
            "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/117149668491524025863/photos\\\"\\u003eAhmed Farghal\\u003c/a\\u003e\"\n" +
            "               ],\n" +
            "               \"photo_reference\" : \"CmRaAAAAaNFAk2XzRKOkWxd-ZZgfC1pkceSkpTYUhuGxW5Z8-JI_W_3yBaxBbq999pZ463gOogMSIM7Yv-w1iMb_EL3dxORC7x8jwutESl7Ce8y4YS6p7daetRatft9nN5TWJ3fjEhB7ebr0ZbkQ_jz01yrsd4LRGhTVY3ZCgFnpyOmAliV5KPM8qdnckQ\",\n" +
            "               \"width\" : 4032\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJB_oLw1A-WBQR5qqWGEnuNLM\",\n" +
            "         \"plus_code\" : {\n" +
            "            \"compound_code\" : \"3859+R4 Nasr City, Al Manteqah Al Oula, Nasr City, Egypt\",\n" +
            "            \"global_code\" : \"8G2H3859+R4\"\n" +
            "         },\n" +
            "         \"rating\" : 4.3,\n" +
            "         \"reference\" : \"CmRbAAAAhyx3zl1iwGY3bGFGBVu5szLF-YA-_aHYKRLFyOG_QybGDb2gvlYCBWTEfUeEuEBEB8QNsXH4WlZd-X8qqi0HX944R1p02K3Sz9HmHuz-iZwuf-LM_hA_6Bm9jZP7xa3OEhA75O-N-DA8pfT0fjNMd_51GhSsUe8BcpOfoNBg6rri36AEiQ-UNg\",\n" +
            "         \"scope\" : \"GOOGLE\",\n" +
            "         \"types\" : [ \"movie_theater\", \"point_of_interest\", \"establishment\" ],\n" +
            "         \"vicinity\" : \"Gameat Al Azhar, Nasr City\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"geometry\" : {\n" +
            "            \"location\" : {\n" +
            "               \"lat\" : 30.0794912,\n" +
            "               \"lng\" : 31.324194\n" +
            "            },\n" +
            "            \"viewport\" : {\n" +
            "               \"northeast\" : {\n" +
            "                  \"lat\" : 30.08084102989273,\n" +
            "                  \"lng\" : 31.32554382989273\n" +
            "               },\n" +
            "               \"southwest\" : {\n" +
            "                  \"lat\" : 30.07814137010728,\n" +
            "                  \"lng\" : 31.32284417010728\n" +
            "               }\n" +
            "            }\n" +
            "         },\n" +
            "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/movies-71.png\",\n" +
            "         \"id\" : \"3cb1dd2770f11e5482f51c1e3c15306d9ed99497\",\n" +
            "         \"name\" : \"Air Forces Cinema\",\n" +
            "         \"photos\" : [\n" +
            "            {\n" +
            "               \"height\" : 3120,\n" +
            "               \"html_attributions\" : [\n" +
            "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/112141443849261753930/photos\\\"\\u003eA Google User\\u003c/a\\u003e\"\n" +
            "               ],\n" +
            "               \"photo_reference\" : \"CmRZAAAAmzPKRfZsJizzAyutIxDB02lNAABEc_6tVszv5ulSsY2SqQI2kOdd-NGgOTgAjCmTpJ3Nm-9ZAsn33OME4t3YiteAa-HB3ozDhxlGkeGQOUNlbssmflEq5OyygKNGD8DwEhAPkE5dHWnv8TaFjK5aOp2MGhRXSUVy46fFUX5Hv6VyT74oeOt6PQ\",\n" +
            "               \"width\" : 4160\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJ2dTolzs-WBQRE5scAGwDvvI\",\n" +
            "         \"plus_code\" : {\n" +
            "            \"compound_code\" : \"38HF+QM Rabaa Buildings, Al Golf, Nasr City, Egypt\",\n" +
            "            \"global_code\" : \"8G2H38HF+QM\"\n" +
            "         },\n" +
            "         \"rating\" : 4,\n" +
            "         \"reference\" : \"CmRbAAAAqxVOfQZp-PgptRdlIGCPu7FV8INTYdaHjpRR5whc1ksSNtt4hzYUKxvYio9Po4xTFEd2nrtze1FDuq9LPE9a5FOajgsPUjHIzYBkKs0mHV0MlXb4cuvPxyvBZuRgVhIkEhDJw_djUnhdOrgWUq4qzytsGhSS6JJdqy7uMbHhKSVM-1LThD9fIQ\",\n" +
            "         \"scope\" : \"GOOGLE\",\n" +
            "         \"types\" : [ \"movie_theater\", \"point_of_interest\", \"establishment\" ],\n" +
            "         \"vicinity\" : \"Al Golf, Nasr City\"\n" +
            "      }\n" +
            "   ],\n" +
            "   \"status\" : \"OK\"\n" +
            "}";



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    GridView gridview;
    List<Cinema> list;
    ListView res;


    public CinemaView() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


                    Jsonparser(Places);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cinema_view, container, false);
         gridview = (GridView) view.findViewById(R.id.gvMovieV);
         Button v= (Button) view.findViewById(R.id.btnShowAll);
        CinemaAdapter adapter = new CinemaAdapter(getContext(), R.layout.row2, list);
        gridview.setAdapter(adapter);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extra = new Bundle();
                extra.putSerializable("objects", (Serializable) list);
                Intent i =new Intent(getContext(),MapsActivity.class);
               i.putExtra("extra", extra);
                startActivity(i);
            }
        });
        return view;
    }

    private void Jsonparser(String result) {
        try {
            JSONObject root = new JSONObject(result);
            JSONArray cinema = root.getJSONArray("results");
            list = new ArrayList<>();

            for (int i = 0; i < cinema.length(); i++) {
                Cinema c = new Cinema();
                JSONObject obj_contact = cinema.getJSONObject(i);

                c.set_Name(obj_contact.getString("name"));
                c.setVicinity(obj_contact.getString("vicinity"));
                JSONObject location =obj_contact.getJSONObject("geometry");
                JSONObject LonLat =location.getJSONObject("location");
                c.setLat(LonLat.getDouble("lat"));
                c.setLon(LonLat.getDouble("lng"));




                list.add(c);


                //    ListAdapter list = new SimpleAdapter(getApplicationContext(),);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }





}
