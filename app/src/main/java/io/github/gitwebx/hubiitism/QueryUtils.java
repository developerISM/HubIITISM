package io.github.gitwebx.hubiitism;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manan J on 26/01/17.
 */

public final class QueryUtils {

    public static List<News> fetchFeedData(String request) {
        URL url = createUrl(request);

        String jsonResponse = null;

        try {
            jsonResponse = makeHttpRequest(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<News> news = extractFeaturefromJson(jsonResponse);

        return news;
    }

    private static List<News> extractFeaturefromJson(String jsonResponse) {

        if (TextUtils.isEmpty(jsonResponse))
            return null;

        List<News> news = new ArrayList<>();

        try {
            JSONObject baseJsonResponse = new JSONObject(jsonResponse);
            JSONArray feeds = baseJsonResponse.getJSONArray("data");

            for (int i = 0; i < feeds.length(); i++) {
                JSONObject current = feeds.getJSONObject(i);

                String msg = (current.has("message")) ? current.getString("message") : "This post cannot be displayed at the moment :(";
                String time = current.getString("created_time");

                News ob = new News(msg, time);

                news.add(ob);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return news;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        if (url == null)
            return jsonResponse;

        HttpURLConnection conn = null;
        InputStream is = null;

        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.connect();

            if (conn.getResponseCode() == 200) {
                is = conn.getInputStream();
                jsonResponse = readFromStream(is);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (conn != null)
                conn.disconnect();

            if (is != null)
                is.close();
        }

        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    private static URL createUrl(String request) {
        URL url = null;

        try {
            url = new URL(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return url;
    }


}
