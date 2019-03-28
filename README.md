 Smart Ticketing service using Android
 	 The Objective of the application is to develop a mobile application to digitalize the ticketing process in public transportation / organization by generating
a QR code. The QR contains the information of the source and destination. It also provides GPS facility for the users to locate their bus. It also uses the e-wallet for
the payment process

User authentication:
  The user information is obtained through the registration and the registered information is used to authenticate the user.
The database connections are established with interfacing android with a php files that can add and retrieve information from the same.


protected String doInBackground(String... voids) {
 String result = "";
 String places = voids[0];
 String id = voids[1];
 String constr = "http://192.168.43.105/add.php";
 try {
 URL url = new URL(constr);
 HttpURLConnection http = (HttpURLConnection)
url.openConnection();
 http.setRequestMethod("POST");
 http.setDoInput(true);
 http.setDoOutput(true);
 OutputStream ops = http.getOutputStream();
 BufferedWriter writer = new BufferedWriter(new
OutputStreamWriter(ops, "UTF-8"));
 String data = URLEncoder.encode("places", "UTF-8") + "=" +
URLEncoder.encode(places, "UTF-8") + "&&" + URLEncoder.encode("id",
"UTF-8") + "=" + URLEncoder.encode(id, "UTF-8");
writer.write(data);
 writer.flush();
 writer.close();
 ops.close();
 InputStream ips = http.getInputStream();
 BufferedReader reader = new BufferedReader(new 
 InputStreamReader(ips, "ISO-8859-1"));
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

 
 
 
There are two different login/registration page one for the user and the other for the conductor more or less the information used is the same.


QR module:
 zxing api is used to generate the QR code. it takes the source, destination and number of tickets as input. The QR is 200*200 in size which is static and the generated qr will be dynamically change with size of data. the QR can be saved as a image in the mobile external storage to operate it in offline.
 
 public void onClick(View view) {
 if (message.length() > 0) {
 WindowManager manager = (WindowManager)
getSystemService(WINDOW_SERVICE);
 Display display = manager.getDefaultDisplay();
 Point point = new Point();
 display.getSize(point);
 int width = point.x;
 int height = point.y;
 int smallerDimension = width < height ? width : height;
 smallerDimension = smallerDimension * 3 / 4;
 qrgEncoder = new QRGEncoder(
 message, null,
 QRGContents.Type.TEXT,
 smallerDimension);
 try {
 bitmap = qrgEncoder.encodeAsBitmap();
 qrImage.setImageBitmap(bitmap);
 } catch (WriterException e) {
 Log.v(TAG, e.toString());
 }
 } else {
 edtValue.setError("Required");

 
 Scanner module:
   Scanning of QR codes by the conductor is done here.Once the payment process is done by the passesger,the QR code is generated and those codes are scanned for verification.It is the one time verifications
   
 
