package uk.co.droidinactu.taskcoach;

import android.os.Debug;

import java.io.File;

/**
 * This class is used to set some debug values used to control tracing.
 * <p>
 * info:
 * <dl>
 * </li>
 * <dt>Log.e</dt>
 * <dd>This is for when bad stuff happens. Use this tag in places like inside a
 * catch statement. You know and error has occurred and therefore you're logging
 * an error.</dd>
 * <dt>
 * Log.w</dt>
 * <dd>Use this when you suspect something shady is going on. You may not be
 * completely in full on error mode, but maybe you recovered from some
 * unexpected behaviour. Basically, use this to log stuff you didn't expect to
 * happen but isn't necessarily an error. Kind of like a
 * "hey, this happened, and it's weird, we should look into it."</dd>
 * <dt>
 * Log.i</dt>
 * <dd>Use this to post useful information to the log. For example: that you
 * have successfully connected to a server. Basically use it to report
 * successes.</dd>
 * <dt>
 * Log.d</dt>
 * <dd>Use this for debugging purposes. If you want to print out a bunch of
 * messages so you can log the exact flow of your program, use this. If you want
 * to keep a log of variable values, use this.</dd>
 * <dt>
 * Log.v</dt>
 * <dd>Use this when you want to go absolutely nuts with your logging. If for
 * some reason you've decided to log every little thing in a particular part of
 * your app, use the Log.v tag.</dd>
 * <dt>
 * Log.wtf</dt>
 * <dd>Use this when stuff goes absolutely, horribly, holy-crap wrong. You know
 * those catch blocks where you're catching errors that you never should
 * get...yea, if you wanna log them use Log.wtf</dd>
 * </dl>
 * </p>
 *
 * @author aspela
 */
public final class MyDebug {

    public static boolean DEBUGGING = false;
    public static boolean TRACE = false;
    public static String TRACE_DIRECTORY = "droidinactu.traces";

    public static void startMethodTracing(final String traceFile) {
        if (DEBUGGING && TRACE) {
            Debug.startMethodTracing(TRACE_DIRECTORY + File.separator + traceFile);
        }
    }

    public static void stopMethodTracing() {
        if (DEBUGGING && TRACE) {
            Debug.stopMethodTracing();
        }
    }
}
