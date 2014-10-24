// Copyright 2013 Google Inc. All Rights Reserved.

package uk.co.droidinactu.taskcoach.data;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.drive.Drive;

import java.util.concurrent.CountDownLatch;

/**
 * An AsyncTask that maintains a connected client.
 */
public abstract class ApiClientAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {

    private final GoogleApiClient mClient;

    public ApiClientAsyncTask(final Context context) {
        final GoogleApiClient.Builder builder = new GoogleApiClient.Builder(context).addApi(Drive.API).addScope(Drive.SCOPE_FILE);
        mClient = builder.build();
    }

    @Override
    protected final Result doInBackground(final Params... params) {
        Log.d("TAG", "in background");
        final CountDownLatch latch = new CountDownLatch(1);
        mClient.registerConnectionCallbacks(new ConnectionCallbacks() {
            @Override
            public void onConnected(final Bundle arg0) {
                latch.countDown();
            }

            @Override
            public void onConnectionSuspended(final int cause) {
            }
        });
        mClient.registerConnectionFailedListener(new OnConnectionFailedListener() {
            @Override
            public void onConnectionFailed(final ConnectionResult arg0) {
                latch.countDown();
            }
        });
        mClient.connect();
        try {
            latch.await();
        } catch (final InterruptedException e) {
            return null;
        }
        if (!mClient.isConnected()) {
            return null;
        }
        try {
            return doInBackgroundConnected(params);
        } finally {
            mClient.disconnect();
        }
    }

    /**
     * Override this method to perform a computation on a background thread,
     * while the client is connected.
     */
    protected abstract Result doInBackgroundConnected(Params... params);

    /**
     * Gets the GoogleApliClient owned by this async task.
     */
    protected GoogleApiClient getGoogleApiClient() {
        return mClient;
    }
}
