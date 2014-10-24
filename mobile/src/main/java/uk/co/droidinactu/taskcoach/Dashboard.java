package uk.co.droidinactu.taskcoach;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.ListFragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.List;
import java.util.Stack;

import uk.co.droidinactu.taskcoach.data.Task;
import uk.co.droidinactu.taskcoach.data.TaskFile;

public class Dashboard extends Activity {

    private static final String ADMOB_UNIT_ID = "a153283f76b65b0";
    private static final int FILE_CHOOSER_REQUEST_CODE = 8192;
    private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
    private static final String LOG_TAG = Dashboard.class.getSimpleName() + "::";
    private static final int RESOLVE_CONNECTION_REQUEST_CODE = 8191;
    private static final int SAF_FILE_CHOOSER_REQUEST_CODE = 8190;
    private static final int SETTINGS_ACTIVITY_REQUEST_CODE = 8193;
    private static final boolean DEBUG = false;
    private boolean fileChoosen = false;
    private TaskListFragment tlFrag;

    private void loadLastTaskFile() {
        MyApplication.d(Dashboard.LOG_TAG + "loadLastTaskFile()");
        if (fileChoosen) {
            return;
        }
        MyApplication.i(Dashboard.LOG_TAG + "loadLastTaskFile()");
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String lastFilename = sharedPref.getString("LAST_USED_TASKCOACH_FILE", "");

        if (lastFilename.length() == 0) {
            showFileChooser();
        } else {
            MyApplication.d(Dashboard.LOG_TAG + "onResume() attempting to loading last used file [" + lastFilename + "]");
            if (!MyApplication.getInstance().getDataModel().loadTaskFile(this, lastFilename)) {
                showFileChooser();
            } else {
//                if (taskLists.size() == 0) {
//                    final TaskListFragment tlf = TaskListFragment.newInstance();
//                    tlf.updateTaskList(MyApplication.getInstance().getDataModel().getTaskFile(0));
//                    taskLists.add(tlf);
//                }
//                updateNavigationSpinner();
//                changeToTaskList(0);
            }
            List<TaskFile> files = MyApplication.getInstance().getDataModel().getTaskFiles();
            tlFrag = new TaskListFragment(files.get(0));
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, tlFrag).commit();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {
        if (requestCode == SAF_FILE_CHOOSER_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // The document selected by the user won't be returned in the intent.
            // Instead, a URI to that document will be contained in the return intent
            // provided to this method as a parameter.
            // Pull that URI using resultData.getData().
            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData();
                MyApplication.i(Dashboard.LOG_TAG + "Uri: " + uri.toString());
                final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("LAST_USED_TASKCOACH_FILE", uri.toString());
                editor.commit();
                MyApplication.getInstance().getDataModel().loadTaskFile(this, uri);
            }
        }
    }

    /**
     * Override the back button so that we can use it to go back up the task tree
     */
    @Override
    public void onBackPressed() {
        if (tlFrag.isAtRoot()) {
            super.onBackPressed();
        } else {
            tlFrag.goUpTask();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MyApplication.d(Dashboard.LOG_TAG + "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            final Intent settings = new Intent(this, SettingsActivity.class);
            this.startActivityForResult(settings, Dashboard.SETTINGS_ACTIVITY_REQUEST_CODE);
            return true;
        } else if (item.getItemId() == R.id.action_open_file) {
            Toast.makeText(this, "Open File.", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
     * (non-Javadoc)
     *
     * @see android.app.Activity#onPause()
     */
    @Override
    protected void onPause() {
        super.onPause();
        MyApplication.d(Dashboard.LOG_TAG + "onPause()");
    }

    @Override
    public void onRestoreInstanceState(final Bundle savedInstanceState) {
        MyApplication.d(Dashboard.LOG_TAG + "onRestoreInstanceState()");
        // Restore the previously serialized current dropdown position.
        if (savedInstanceState.containsKey(Dashboard.STATE_SELECTED_NAVIGATION_ITEM)) {
            // getActionBar().setSelectedNavigationItem(savedInstanceState.getInt(Dashboard.STATE_SELECTED_NAVIGATION_ITEM));
        }
    }

    /**
     * (non-Javadoc)
     *
     * @see android.app.Activity#onResume()
     */
    @Override
    protected void onResume() {
        super.onResume();
        MyApplication.d(Dashboard.LOG_TAG + "onResume()");


        // changeToTaskList(0);
    }


    @Override
    public void onSaveInstanceState(final Bundle outState) {
        MyApplication.d(Dashboard.LOG_TAG + "onSaveInstanceState()");
        // Serialize the current dropdown position.
        outState.putInt(Dashboard.STATE_SELECTED_NAVIGATION_ITEM, getActionBar().getSelectedNavigationIndex());
    }

    @Override
    protected void onStart() {
        super.onStart();
        MyApplication.d(Dashboard.LOG_TAG + "onStart()");
        loadLastTaskFile();
    }

    @Override
    protected void onStop() {
        MyApplication.d(Dashboard.LOG_TAG + "onStop()");
        super.onStop();
    }

    /**
     * Fires an intent to spin up the "file chooser" UI and select a task file.
     */
    private void showFileChooser() {
        MyApplication.i(LOG_TAG + "showChooserLocal()");

        // ACTION_OPEN_DOCUMENT is the intent to choose a file via the system's file browser.
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        //intent = new Intent(Intent.ACTION_GET_CONTENT);

        // Filter to only show results that can be "opened", such as a
        // file (as opposed to a list of contacts or timezones)
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        // Filter to show only images, using the image MIME data type.
        // If one wanted to search for ogg vorbis files, the type would be
        // "audio/ogg".
        // To search for all documents available via installed storage
        // providers, it would be "*/*".
        // FIXME add XML mime type:
        // intent.setType("text/xml");
        intent.setType("*/*");

        try {
            startActivityForResult(intent, SAF_FILE_CHOOSER_REQUEST_CODE);
        } catch (final ActivityNotFoundException e) {
            // The reason for the existence of aFileChooser
        }
    }

    private void showToast(final String msg) {
        final Toast error = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        error.show();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    @SuppressLint("ValidFragment")
    public class TaskListFragment extends ListFragment {
        private static final int BREADCRUMB_START_ID = 32768;
        private TaskFile taskfile = null;
        private Task[] taskArray = null;
        private AdView mAdView;
        private Stack<Task> breadcrumbTasks = new Stack<Task>();
        private LinearLayout mBreadcrumbLayout;
        private int mBreadcrumbId = BREADCRUMB_START_ID;

        public TaskListFragment(TaskFile pTaskfile) {
            taskfile = pTaskfile;
        }

        @Override
        public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);

            mAdView = (AdView) rootView.findViewById(R.id.adView);
            mBreadcrumbLayout = (LinearLayout) rootView.findViewById(R.id.breadcrumbs);

            return rootView;
        }

        @Override
        public void onViewCreated(View view, Bundle bundle) {
            if (mAdView != null) {
                // Create an ad request. Check logcat output for the hashed device ID to
                // get test ads on a physical device. e.g.
                // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
                AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice("7B665A2DEE9D2AB9B933F4809B53044F") //N4
                        .build();

                // Start loading the ad in the background.
                mAdView.loadAd(adRequest);
            }
            getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    TaskListArrayAdapter taskAdaptr = (TaskListArrayAdapter) getListView().getAdapter();
                    Task tmpTask = taskAdaptr.getItem(position);
                    if (tmpTask.tasks.size() == 0) {
                        final Intent detailIntent = new Intent(Dashboard.this, TaskDetailsActivity.class);
                        detailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        final String taskId = tmpTask.id;
                        detailIntent.putExtra(TaskDetailsActivity.ARG_TASK_ID, taskId);
                        Dashboard.this.startActivity(detailIntent);
                    } else {
                        breadcrumbTasks.push(tmpTask);

                        TextView valueTV = new TextView(Dashboard.this);
                        if (mBreadcrumbLayout.getChildCount() == 0) {
                            valueTV.setText(tmpTask.subject);
                        } else {
                            valueTV.setText(" >> " + tmpTask.subject);
                        }
                        valueTV.setId(++mBreadcrumbId);
                        valueTV.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                        mBreadcrumbLayout.addView(valueTV);
                        updateList();
                    }
                }
            });
            updateList();
        }

        private void updateList() {
            if (getListView() != null) {
                if (taskfile == null) {
                } else {
                    if (breadcrumbTasks.isEmpty()) {
                        taskArray = new Task[taskfile.tasks.size()];
                        taskArray = taskfile.tasks.toArray(taskArray);
                    } else {
                        taskArray = new Task[breadcrumbTasks.get(breadcrumbTasks.size() - 1).tasks.size()];
                        taskArray = breadcrumbTasks.get(breadcrumbTasks.size() - 1).tasks.toArray(taskArray);
                    }
                }
                if (taskArray == null) {
                    //FIXME: what now???
                } else {
                    getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                    TaskListArrayAdapter adapter = new TaskListArrayAdapter(getActivity(), taskArray);
                    getListView().setAdapter(adapter);
                }
            }
        }

        public boolean isAtRoot() {
            return (breadcrumbTasks.isEmpty());
        }

        public void goUpTask() {
            breadcrumbTasks.pop();
            mBreadcrumbLayout.removeViewAt(mBreadcrumbLayout.getChildCount() - 1);
            updateList();
        }
    }
}
