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
package uk.co.droidinactu.taskcoach.data;

import android.content.Context;
import android.database.SQLException;
import android.net.Uri;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import uk.co.droidinactu.taskcoach.MyApplication;

/**
 * @author aspela
 */
public class DataModel extends Observable {

    private static final String LOG_TAG = DataModel.class.getSimpleName() + "::";
    private static DataModel instance = new DataModel();
    public List<TaskFile> taskFiles = new ArrayList<TaskFile>();

    public static DataModel getInstance() {
        return DataModel.instance;
    }

    /**
     *
     */
    public void destroy() {
    }

    /**
     * @param i
     * @return
     */
    public TaskFile getTaskFile(final int i) {
        if (taskFiles.size() < i + 1) {
            return null;
        }
        return taskFiles.get(i);
    }

    public List<TaskFile> getTaskFiles() {
        return taskFiles;
    }

    public void initialise(final Context context) throws SQLException {
        MyApplication.d(LOG_TAG + "initialise()");
    }

    public boolean loadTaskFile(Context ctx, final Uri tskFilename) {
        taskFiles.clear();
        try {
            InputStream inputStream = ctx.getContentResolver().openInputStream(tskFilename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            inputStream.close();

            final Serializer serializer = new Persister();
            final TaskFile tmpTaskFile = serializer.read(TaskFile.class, stringBuilder.toString());
            tmpTaskFile.uri = tskFilename;
            taskFiles.add(tmpTaskFile);
        } catch (final Exception e) {
            MyApplication.e(DataModel.LOG_TAG + "loadTaskFileSimple() Exception parsing TaskCoach file [" + tskFilename + "]", e);
            return false;
        }
        return true;
    }

    public boolean loadTaskFile(Context ctx, final String tskFilename) {
        taskFiles.clear();
        MyApplication.d(LOG_TAG + "loadTaskFile(" + tskFilename + ")");
        if (tskFilename.startsWith("content://")) {
            return loadTaskFile(ctx, Uri.parse(tskFilename));
        } else {
            try {
                final Serializer serializer = new Persister();
                final File source = new File(tskFilename);

                final TaskFile tmpTaskFile = serializer.read(TaskFile.class, source);
                tmpTaskFile.filename = tskFilename;
                taskFiles.add(tmpTaskFile);
            } catch (final Exception e) {
                MyApplication.e(DataModel.LOG_TAG + "loadTaskFileSimple() Exception parsing TaskCoach file [" + tskFilename + "]", e);
                return false;
            }
            return true;
        }
    }

}
