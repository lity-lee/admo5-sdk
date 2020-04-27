package com.tencent.tmsecure.demo;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;


public class LoggingExceptionHandler implements Thread.UncaughtExceptionHandler {
    private final static String TAG = LoggingExceptionHandler.class.getSimpleName();
    private final static String ERROR_FILE = LoggingExceptionHandler.class.getSimpleName() + ".error";
    private final Thread.UncaughtExceptionHandler rootHandler;

    LoggingExceptionHandler(Context context) {
        // we should store the current exception handler -- to invoke it for all not handled exceptions ...
        rootHandler = Thread.getDefaultUncaughtExceptionHandler();
        // we replace the exception handler now with us -- we will properly dispatch the exceptions ...
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(final Thread thread, final Throwable ex) {
        String _logFilePath = null;
        try {
            Log.d(TAG, "called for " + ex.getClass());
            // assume we would write each error in one file ...
            File f = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), ERROR_FILE);
            // log this exception ...
            if (!f.exists()) {
                f.createNewFile();
            }
            _logFilePath = f.getAbsolutePath();
            FileWriter fw = new FileWriter(_logFilePath, true);
            ByteArrayOutputStream boas = new ByteArrayOutputStream();
            PrintStream stream = new PrintStream(boas);
            ex.printStackTrace(stream);
            fw.write(new String(boas.toByteArray()));
            fw.flush();
        } catch (Exception e) {
            Log.e(TAG, "Exception Logger failed!", e);
        }
        rootHandler.uncaughtException(thread, ex);
    }
}
