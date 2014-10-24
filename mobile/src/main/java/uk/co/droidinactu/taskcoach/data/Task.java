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

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aspela
 */
@Root(strict = false)
public class Task {
    public static final String DATE_FORMAT_DISPLAY = "dd/MM/yy HH:mm";
    public static final String DATETIME_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";
    public static final String DATETIME_FORMAT_STRING_WITHMICRO = "yyyy-MM-dd HH:mm:ss.SSSSSS";
    public static final int REC_DAILY = 0;
    public static final int REC_MONTHLY = 2;
    public static final int REC_WEEKLY = 1;
    public static final int REC_YEARLY = 3;
    public static final int TASKSTATUS_COMPLETED = 5;
    public static final int TASKSTATUS_DUESOON = 2;
    public static final int TASKSTATUS_NOTSTARTED = 4;
    public static final int TASKSTATUS_OVERDUE = 1;
    public static final int TASKSTATUS_STARTED = 3;
    public static final int TASKSTATUS_UNDEFINED = 0;
    private static final String LOG_TAG = Task.class.getSimpleName();
    @Attribute(required = false)
    public String actualstartdate = "";
    public String actualStartDateTime = "";
    @Element(required = false)
    public Attachment attachment;
    @Attribute(required = false)
    public String budget = "";
    public List<Category> categories = new ArrayList<Category>();
    @Attribute(name = "completiondate", required = false)
    public String completionDateTime = "";
    @Attribute(required = false)
    public String creationDateTime = "";
    @Attribute(required = false)
    public String dependencies = "";
    // @Element(required = false)
    // public TaskDescription description = new TaskDescription();
    @Element(required = false)
    public String description = "";
    @Attribute(name = "duedate", required = false)
    public String dueDateTime = "";
    @Element(required = false)
    public Effort effort = null;
    @Attribute(required = false)
    public String expandedContexts = "";
    @Attribute(required = false)
    public String fgColor;
    @Attribute(required = false)
    public String fixedFee = "";
    @Attribute(required = false)
    public String font = "";
    @Attribute(required = false)
    public String hourlyFee = "";
    @Attribute(required = false)
    public String icon = "";
    @Attribute(required = false)
    public String id = "";
    @Attribute(required = false)
    public String modificationDateTime = "";
    @ElementList(name = "note", inline = true, required = false)
    public List<Note> notes = new ArrayList<Note>();
    @Attribute(required = false)
    public String percentageComplete = "0";
    @Attribute(name = "plannedstartdate", required = false)
    public String plannedStartDate = "";
    @Attribute(required = false)
    public String plannedStartDateTime = "";
    @Attribute(required = false)
    public String prerequisites = "";
    @Attribute(required = false)
    public String priority = "";
    @Attribute(required = false)
    public String recurrence = "";
    @Attribute(required = false)
    public String reminder = "";
    @Attribute(required = false)
    public String reminderBeforeSnooze = "";
    @Attribute(required = false)
    public String selectedIcon = "";
    public String shouldMarkCompletedWhenAllChildrenCompleted = "";
    @Attribute(required = false)
    public String status = "";
    @Attribute(required = false)
    public String subject = "";
    @ElementList(name = "task", inline = true, required = false)
    public List<Task> tasks = new ArrayList<Task>();

    public static String dateForDisplay(final String dateStr) {
        if (dateStr.length() == 0) {
            return "";
        }
        final DateTime date = dateFromString(dateStr);
        return date.toString(DATE_FORMAT_DISPLAY);
    }

    public static DateTime dateFromString(final String dateStr) {
        DateTime date = null;
        if (dateStr.contains(".")) {
            date = DateTime.parse(dateStr, DateTimeFormat.forPattern(Task.DATETIME_FORMAT_STRING_WITHMICRO));
        } else {
            date = DateTime.parse(dateStr, DateTimeFormat.forPattern(Task.DATETIME_FORMAT_STRING));
        }
        return date;
    }

    public void addTask(final Task subTsk) {
        tasks.add(subTsk);
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Task)) {
            return false;
        }

        final Task rhs = (Task) obj;
        return new EqualsBuilder().appendSuper(super.equals(obj)).append(actualstartdate, rhs.actualstartdate).append(creationDateTime, rhs.creationDateTime).append(id, rhs.id).append(modificationDateTime, rhs.modificationDateTime).append(priority, rhs.priority).append(status, rhs.status).append(subject, rhs.subject).isEquals();
    }

    /**
     * @param taskId
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

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31). // two randomly chosen prime numbers
                appendSuper(super.hashCode()).append(id).append(subject).append(creationDateTime).toHashCode();
    }

    @Override
    public String toString() {
        return subject;
    }

}
