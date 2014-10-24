package uk.co.droidinactu.taskcoach.data;

import org.simpleframework.xml.Text;
import org.simpleframework.xml.core.Commit;

import uk.co.droidinactu.taskcoach.MyApplication;

public class TaskDescription {

    private static final String LOG_TAG = TaskDescription.class.getSimpleName() + "::";

    @Text(required = false, data = false, empty = "")
    public String description = "";

    @Commit
    public void build() {
        MyApplication.d(LOG_TAG + "build() description [" + description + "]");
    }

    public int length() {
        return description.length();
    }

    @Override
    public String toString() {
        return description;
    }
}