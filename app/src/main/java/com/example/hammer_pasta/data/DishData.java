package com.example.hammer_pasta.data;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DishData {

    List<String> names = new ArrayList<>();

    public DishData(String link, String key, String... n) throws IOException {

        JSONObject api_ans;

        final URL url = new URL(link);
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setConnectTimeout(2000);
        con.setReadTimeout(2000);

        try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            final StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);

                api_ans = new JSONObject(content.toString());
                JSONArray meals = api_ans.getJSONArray(key);
                for (int i = 0; i < meals.length(); i++) {
                    for (String s : n) this.names.add(meals.getJSONObject(i).getString(s));
                }
            }
        }catch (final Exception ex) {
            this.names.add(String.valueOf(ex));
            ex.printStackTrace();
        }
    }

    public List<String> getNames(){
        return this.names;
    }
}