/**
 --------------------------------------------------------------------------

 SOFTWARE FILE HEADER
 -----------------------------

 Classification : UNCLASSIFIED

 Project Name   : ASTRAEA 2 - Mobile I.P. Node

 --------------------------------------------------------------------------

 Copyright Notice
 ----------------

 The copyright in this document is the property of Cassidian
 Systems Limited.

 Without the written consent of Cassidian Systems Limited
 given by Contract or otherwise the document must not be copied, reprinted or
 reproduced in any material form, either wholly or in part, and the contents
 of the document or any method or technique available there from, must not be
 disclosed to any other person whomsoever.

 Copyright 2014 Cassidian Systems Limited.
 --------------------------------------------------------------------------

 */
package uk.co.droidinactu.taskcoach;

import android.app.Application;
import android.util.Log;

import uk.co.droidinactu.taskcoach.data.DataModel;

/**
 * @author aspela
 */
public final class MyApplication extends Application {

    public static final String simpleDateFmtStrDb = "yyyyMMdd";
    public static final String simpleDateFmtStrView = "dd-MMM-yyyy";
    public static final String TASKCOACH_FILENAME_EXT = "tsk";
    private static final String LOG_TAG = "TaskCoachForAndroid";
    private static final int TWO_MINUTES = 1000 * 60 * 2;
    private static MyApplication singleton = null;
    private DataModel dataModel;

    public static void d(final String msg) {
        Log.d(LOG_TAG, msg);
    }

    public static void e(final String msg) {
        Log.e(LOG_TAG, msg);
    }

    public static void e(final String msg, final Throwable thr) {
        Log.e(LOG_TAG, msg, thr);
    }

    public static MyApplication getInstance() {
        return MyApplication.singleton;
    }

    public static void i(final String msg) {
        Log.i(LOG_TAG, msg);
    }

    public static void v(final String msg) {
        Log.v(LOG_TAG, msg);
    }

    public static void w(final String msg) {
        Log.w(LOG_TAG, msg);
    }

    public static void wtf(final String msg) {
        Log.wtf(LOG_TAG, msg);
    }

    public DataModel getDataModel() {
        return dataModel;
    }

    /*
     * (non-Javadoc)
     *
     * @see android.app.Application#onCreate()
     */
    @Override
    public void onCreate() {
        super.onCreate();
        MyApplication.singleton = this;
        dataModel = DataModel.getInstance();
        dataModel.initialise(getApplicationContext());
    }

    /*
     * (non-Javadoc)
     *
     * @see android.app.Application#onTerminate()
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
        dataModel.destroy();
        dataModel = null;
    }
}
