package com.example.test;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class fd extends AsyncTask<String, Void, String> {
  AlertDialog dialog;
  Context context;
     fd(Context context) {
        this.context = context;
    }
    @Override
    protected void onPreExecute() {
        dialog = new AlertDialog.Builder(context).create();
        dialog.setTitle("Register status");
    }
    @Override
    protected void onPostExecute(String s1) {

        dialog.setMessage(s1);
        if (s1.contains("Registration successfull")) {
            Intent intent_name = new Intent();
            intent_name.setClass(context.getApplicationContext(), database.class);
            context.startActivity(intent_name);
        }
    }
    @Override
    protected String doInBackground(String... voids) {
        StringBuilder result = new StringBuilder();
        String name = voids[0];
        String age = voids[1];
        String phone=voids[2];
        String email=voids[3];
        String password=voids[4];
        String gender=voids[5];
        String tt=voids[6];
        String constr = "http://192.168.43.105/insert.php";
        try {
            URL url = new URL(constr);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);
            OutputStream ops = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops, StandardCharsets.UTF_8));
            String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&&" + URLEncoder.encode("age", "UTF-8") + "=" + URLEncoder.encode(age, "UTF-8")+ "&&" + URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8")+ "&&" + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8")+ "&&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8")+"&&" + URLEncoder.encode("gender", "UTF-8") + "=" + URLEncoder.encode(gender, "UTF-8")+"&&" + URLEncoder.encode("tt", "UTF-8") + "=" + URLEncoder.encode(tt, "UTF-8");
            writer.write(data);
            writer.flush();
            writer.close();
            ops.close();
            InputStream ips = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ips, StandardCharsets.ISO_8859_1));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
            ips.close();
            http.disconnect();
            return result.toString();
        } catch (MalformedURLException e) {
            result = new StringBuilder(e.getMessage());
        } catch (IOException e) {
            result = new StringBuilder(e.getMessage());
        }
        return result.toString();
    }
}
