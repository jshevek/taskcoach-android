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

import android.net.Uri;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aspela
 */
@Root(name = "tasks", strict = false)
public class TaskFile {
    private static final String LOG_TAG = TaskFile.class.getSimpleName() + "::";

    @ElementList(name = "category", inline = true)
    public List<Category> categories = new ArrayList<Category>();
    public String filename = "";

    @Element(required = false)
    public String guid = "";

    @Element(name = "syncmlconfig", required = false)
    public SyncMLConfig syncmlconfig = null;

    @Attribute(name = "release", required = false)
    public String taskcoachRelease = "0";

    @ElementList(name = "task", inline = true)
    public List<Task> tasks = new ArrayList<Task>();

    @Attribute(name = "tskversion", required = false)
    public String tskVersion = "0";
    public Uri uri;

    public void addTask(final Task newTask) {
        tasks.add(newTask);
    }


    /**
     * @param string
     * @return
     */
    public Task getTask(final String taskId) {
        for (final Task t : tasks) {
            if (t.id.equals(taskId)) {
                return t;
            }
            if (t.tasks.size() > 0) {
                final Task tmpTask = t.getTask(taskId);
                if (tmpTask != null) {
                    return tmpTask;
                }
            }
        }
        return null;
    }

}
