# Build It Bigger

------------------

Build it bigger is an app developed as part of the projects under Android Developer Nanodegree by Udacity.

**To run and test this app:**

1. Find out your ip address

   - On Windows, use the `ipconfig` command.
   - On Unix/Linux, use the `ifconfig` command.

2. Inside `EndpointsAsyncTask` class of the `/app/src/main/com/udacity/gradle/builditbigger/` folder, provide your ip address here:

   ```java
   protected String doInBackground(Context...context){
       ...
           .setRootUrl("http://<your-device-ip-address>:8080/_ah/api")
       ...
   }
   ```

   **Note:** For a quick reference to this location, open up the `TODO` pane in Android Studio and click on the TODO task.

3. If you're using Android Studio's default emulator, replace the ip address with `10.0.2.2`.



**Starting the server**:

Before running the app, make sure you've started the local server by running the `appengineStart` task.