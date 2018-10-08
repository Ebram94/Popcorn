package com.androidtutorialpoint.androidviewpagerexample.Adapter;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class APIHandler {

    String result="";
    public String APICall(String APIUrl){

        try {
            URL url=new URL(APIUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream =new BufferedInputStream(connection.getInputStream());

            result = ReadJSONFile(inputStream);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }

    private String ReadJSONFile(InputStream inputStream) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(inputStream));
        String line ="";
        String Data="";
        while ((line = reader.readLine()) !=null)   {
            Data += line+"\n";
        }
        inputStream.close();
        return Data;
    }
}

