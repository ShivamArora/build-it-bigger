package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.shivora.example.androidjokes.DisplayJokeActivity;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    public static final String TAG = EndpointsAsyncTask.class.getSimpleName();
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Context... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    //TODO: Enter your device ip address below
                    .setRootUrl("http://192.168.31.134:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0];

        try {
            return myApiService.displayJoke().execute().getData();
        } catch (IOException e) {
            Log.e(TAG, "doInBackground: "+e.getMessage() );
            return "";
        }
    }

    @Override
    protected void onPostExecute(String jokeText) {
        launchDisplayJokeActivity(context,jokeText);
    }

    private void launchDisplayJokeActivity(Context context,String joke) {
        Intent displayJokeActivity = new Intent(context,DisplayJokeActivity.class);
        displayJokeActivity.putExtra(DisplayJokeActivity.EXTRA_JOKE_TEXT,joke);
        context.startActivity(displayJokeActivity);
    }
}
