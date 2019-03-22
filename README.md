 Smart Ticketing service using Android
 	 The Objective of the application is to develop a mobile application to digitalize the ticketing process in public transportation organization by generating a QR code. The QR contains the information of the source and destination. It also provides gps facility for the users to locate their bus. It also uses the e-wallet for the payment process.

User authentication:
The user information is obtained through the registration and the registered information is used to authenticate the user.
The database connections are established with interfacing android with a php files that can add and retrieve information from the same.

There are two different login/registration page one for the user and the other for the conductor more or less the information used is the same.


QR module:
 zxing api is used to generate the QR code. it takes the source, destination and number of tickets as input. The QR is 200*200 in size which is static and the generated qr will be dynamically change with size of data. the QR can be saved as a image in the mobile external storage to operate it in offline.
 
 
