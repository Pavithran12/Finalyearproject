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

    public class background extends AsyncTask<String, Void, String> {
        AlertDialog dialog;
        Context context;
        public background(Context context) {
            this.context = context;
        }
        @Override
        protected void onPreExecute() {
            dialog = new AlertDialog.Builder(context).create();
            dialog.setTitle("Add status");
        }
        @Override
        protected void onPostExecute(String s) {
            dialog.setMessage(s);
            dialog.show();
            if (s.contains("Login Successfull!!!")) {
                Intent intent_name = new Intent();
                intent_name.setClass(context.getApplicationContext(), Main3Activity.class);
                context.startActivity(intent_name);
            }
        }
        @Override
        protected String doInBackground(String... voids) {
            String result = "";
            String places = voids[0];
            String id = voids[1];
            String constr = "http://192.168.43.105/add.php";
            try {
                URL url = new URL(constr);
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                http.setRequestMethod("POST");
                http.setDoInput(true);
                http.setDoOutput(true);
                OutputStream ops = http.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops, "UTF-8"));
                String data = URLEncoder.encode("places", "UTF-8") + "=" + URLEncoder.encode(places, "UTF-8") + "&&" + URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8");
                writer.write(data);
                writer.flush();
                writer.close();
                ops.close();
                InputStream ips = http.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(ips, "ISO-8859-1"));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    result += line;
                }
                reader.close();
                ips.close();
                http.disconnect();
                return result;
            } catch (MalformedURLException e) {

                result = e.getMessage();
            } catch (IOException e) {
                result = e.getMessage();
            }
            return result;
        }
    }
