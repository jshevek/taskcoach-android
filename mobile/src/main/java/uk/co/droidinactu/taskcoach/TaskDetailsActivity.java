package uk.co.droidinactu.taskcoach;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import uk.co.droidinactu.taskcoach.data.Task;


public class TaskDetailsActivity extends Activity implements ActionBar.OnNavigationListener {

    public static final String ARG_TASK_ID = "task_id";
    private static final String LOG_TAG = TaskDetailsActivity.class.getSimpleName() + "::";
    private Task task = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        final Intent intent = getIntent();
        final Bundle extras = intent.getExtras();
        final String taskId = extras.get(ARG_TASK_ID).toString();
        task = MyApplication.getInstance().getDataModel().getTaskFile(0).getTask(taskId);

        // Set up the action bar to show a dropdown list.
        final ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        // Set up the dropdown list navigation in the action bar.
        actionBar.setListNavigationCallbacks(
                // Specify a SpinnerAdapter to populate the dropdown list.
                new ArrayAdapter<String>(actionBar.getThemedContext(), android.R.layout.simple_list_item_1, android.R.id.text1, new String[]{getString(R.string.title_details_desc), getString(R.string.title_details_dates), getString(R.string.title_details_prereq), getString(R.string.title_details_progress), getString(R.string.title_details_categories), getString(R.string.title_details_budget), getString(R.string.title_details_effort), getString(R.string.title_details_notes), getString(R.string.title_details_attachments), getString(R.string.title_details_appearence),}), this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.task_details, menu);
        return true;
    }

    private DescriptionFragment descFrag=null;
    private DatesFragment datesFrag=null;
    private PreReqFragment preReqFrag=null;
    private ProgressFragment progressFrag=null;
    private CategoriesFragment catgFrag=null;
    private BudgetFragment budgetFrag=null;
    private EffortFragment effortFrag=null;
    private NotesFragment notesFrag=null;
    private AttachmentsFragment attachFrag=null;
    private AppearenceFragment appearFrag=null;

    @Override
    public boolean onNavigationItemSelected(final int position, final long id) {
        // When the given dropdown item is selected, show its contents in the
        // container view.
    Bundle taskBundle = new Bundle();
        taskBundle.putString("TaskId",task.id);
        switch (position) {
            case 0:{
                if (descFrag==null){
                    descFrag=new DescriptionFragment();
                    descFrag.setArguments(taskBundle);
                }
                getFragmentManager().beginTransaction().replace(R.id.container, descFrag).commit();
                break;}
            case 1:{
                if (datesFrag==null){
                    datesFrag=new DatesFragment();
                    datesFrag.setArguments(taskBundle);
                }
                getFragmentManager().beginTransaction().replace(R.id.container,datesFrag).commit();
                break;}
            case 2:{
                if (preReqFrag==null){
                    preReqFrag=new PreReqFragment();
                    descFrag.setArguments(taskBundle);
                }
                getFragmentManager().beginTransaction().replace(R.id.container, preReqFrag).commit();
                break;}
            case 3:{
                if (progressFrag==null){
                    progressFrag=new ProgressFragment();
                    descFrag.setArguments(taskBundle);
                }
                getFragmentManager().beginTransaction().replace(R.id.container,progressFrag).commit();
                break;}
            case 4:{
                if (catgFrag==null){
                    catgFrag=new CategoriesFragment();
                    descFrag.setArguments(taskBundle);
                }
                getFragmentManager().beginTransaction().replace(R.id.container, catgFrag).commit();
                break;}
            case 5:{
                if (budgetFrag==null){
                    budgetFrag=new BudgetFragment();
                    descFrag.setArguments(taskBundle);
                }
                getFragmentManager().beginTransaction().replace(R.id.container, budgetFrag).commit();
                break;}
            case 6:{
                if (effortFrag==null){
                    effortFrag=new EffortFragment();
                    descFrag.setArguments(taskBundle);
                }
                getFragmentManager().beginTransaction().replace(R.id.container,effortFrag).commit();
                break;}
            case 7:{
                if (notesFrag==null){
                    notesFrag=new NotesFragment();
                    descFrag.setArguments(taskBundle);
                }
                getFragmentManager().beginTransaction().replace(R.id.container, notesFrag).commit();
                break;}
            case 8:{
                if (attachFrag==null){
                    attachFrag=new AttachmentsFragment();
                    descFrag.setArguments(taskBundle);
                }
                getFragmentManager().beginTransaction().replace(R.id.container, attachFrag).commit();
                break;}
            case 9:{
                if (appearFrag==null){
                    appearFrag=new AppearenceFragment();
                    descFrag.setArguments(taskBundle);
                }
                getFragmentManager().beginTransaction().replace(R.id.container, appearFrag).commit();
                break;}
        }
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Debug.stopMethodTracing();
    }

    public static class AppearenceFragment extends Fragment {
        private final String LOG_TAG = ProgressFragment.class.getSimpleName() + "::";
        private Task task = null;

        public AppearenceFragment() {
        }

        @Override
        public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_task_details_appear, container, false);

            Bundle taskIdBundle=getArguments();
            task = MyApplication.getInstance().getDataModel().getTaskFile(0).getTask(taskIdBundle.getString("TaskId"));

            updateTaskDetails();
            return rootView;
        }

        public void updateTaskDetails() {
            MyApplication.v(LOG_TAG + "updateTaskDetails()");
            if (task != null) {
            }
        }
    }

    public static  class AttachmentsFragment extends Fragment {
        private final String LOG_TAG = ProgressFragment.class.getSimpleName() + "::";
        private Task task = null;

        public AttachmentsFragment() {
        }

        @Override
        public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_task_details_attch, container, false);

            Bundle taskIdBundle=getArguments();
            task = MyApplication.getInstance().getDataModel().getTaskFile(0).getTask(taskIdBundle.getString("TaskId"));

            updateTaskDetails();
            return rootView;
        }

        public void updateTaskDetails() {
            MyApplication.v(LOG_TAG + "updateTaskDetails()");
            if (task != null) {
            }
        }
    }

    public static  class BudgetFragment extends Fragment {
        private final String LOG_TAG = ProgressFragment.class.getSimpleName() + "::";
        private Task task = null;
        private EditText tabBudget_budget;

        public BudgetFragment() {
        }

        @Override
        public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_task_details_budget, container, false);

            tabBudget_budget = (EditText) rootView.findViewById(R.id.tabBudget_budget);

            Bundle taskIdBundle=getArguments();
            task = MyApplication.getInstance().getDataModel().getTaskFile(0).getTask(taskIdBundle.getString("TaskId"));

            updateTaskDetails();
            return rootView;
        }

        public void updateTaskDetails() {
            MyApplication.v(LOG_TAG + "updateTaskDetails()");
            if (task != null) {
                tabBudget_budget.setText(task.budget);
            }
        }
    }

    public static  class CategoriesFragment extends Fragment {
        private final String LOG_TAG = ProgressFragment.class.getSimpleName() + "::";
        private Task task = null;

        public CategoriesFragment() {
        }

        @Override
        public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_task_details_categories, container, false);

            Bundle taskIdBundle=getArguments();
            task = MyApplication.getInstance().getDataModel().getTaskFile(0).getTask(taskIdBundle.getString("TaskId"));

            updateTaskDetails();
            return rootView;
        }

        public void updateTaskDetails() {
            MyApplication.v(LOG_TAG + "updateTaskDetails()");
            if (task != null) {
            }
        }
    }

    public static  class DatesFragment extends Fragment {
        private final String LOG_TAG = DatesFragment.class.getSimpleName() + "::";
        private Task task = null;

        private EditText tabDates_actualstart;
        private EditText tabDates_completion;
        private EditText tabDates_due;
        private EditText tabDates_plannedstart;
        private EditText tabDates_recurrence;
        private EditText tabDates_reminder;

        public DatesFragment() {
        }

        @Override
        public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_task_details_dates, container, false);

            tabDates_plannedstart = (EditText) rootView.findViewById(R.id.tabDates_plannedstart);
            tabDates_due = (EditText) rootView.findViewById(R.id.tabDates_due);
            tabDates_actualstart = (EditText) rootView.findViewById(R.id.tabDates_actualstart);
            tabDates_completion = (EditText) rootView.findViewById(R.id.tabDates_completion);
            tabDates_reminder = (EditText) rootView.findViewById(R.id.tabDates_reminder);
            tabDates_recurrence = (EditText) rootView.findViewById(R.id.tabDates_recurrence);

            Bundle taskIdBundle=getArguments();
            task = MyApplication.getInstance().getDataModel().getTaskFile(0).getTask(taskIdBundle.getString("TaskId"));

            updateTaskDetails();
            return rootView;
        }

        public void updateTaskDetails() {
            MyApplication.v(LOG_TAG + "updateTaskDetails()");
            if (task != null) {
                tabDates_plannedstart.setText(Task.dateForDisplay(task.plannedStartDate));
                tabDates_due.setText(Task.dateForDisplay(task.dueDateTime));
                tabDates_actualstart.setText(Task.dateForDisplay(task.actualstartdate));
            }
        }
    }

    public static  class DescriptionFragment extends Fragment {
        private final String LOG_TAG = DescriptionFragment.class.getSimpleName() + "::";
        private Task task = null;

        private EditText tabDescription_creationDate;
        private EditText tabDescription_description;
        private EditText tabDescription_modificationDate;
        private EditText tabDescription_subject;

        public DescriptionFragment() {
        }

        @Override
        public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_task_details_desc, container, false);

            tabDescription_subject = (EditText) rootView.findViewById(R.id.tabDescription_subject);
            tabDescription_description = (EditText) rootView.findViewById(R.id.tabDescription_description);
            tabDescription_creationDate = (EditText) rootView.findViewById(R.id.tabDescription_creationDate);
            tabDescription_modificationDate = (EditText) rootView.findViewById(R.id.tabDescription_modificationDate);

         Bundle taskIdBundle=getArguments();
            task = MyApplication.getInstance().getDataModel().getTaskFile(0).getTask(taskIdBundle.getString("TaskId"));

            updateTaskDetails();
            return rootView;
        }

        public void updateTaskDetails() {
            MyApplication.v(LOG_TAG + "updateTaskDetails()");
            if (task != null) {
                tabDescription_subject.setText(task.subject);
                tabDescription_description.setText(task.description);
                tabDescription_creationDate.setText(Task.dateForDisplay(task.creationDateTime));
                tabDescription_modificationDate.setText(Task.dateForDisplay(task.modificationDateTime));
            }
        }
    }

    public static  class EffortFragment extends Fragment {
        private final String LOG_TAG = ProgressFragment.class.getSimpleName() + "::";
        private Task task = null;

        public EffortFragment() {
        }

        @Override
        public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_task_details_effort, container, false);

            Bundle taskIdBundle=getArguments();
            task = MyApplication.getInstance().getDataModel().getTaskFile(0).getTask(taskIdBundle.getString("TaskId"));

            updateTaskDetails();
            return rootView;
        }

        public void updateTaskDetails() {
            MyApplication.v(LOG_TAG + "updateTaskDetails()");
            if (task != null) {
            }
        }
    }

    public static  class NotesFragment extends Fragment {
        private final String LOG_TAG = ProgressFragment.class.getSimpleName() + "::";
        private Task task = null;

        public NotesFragment() {
        }

        @Override
        public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_task_details_notes, container, false);

            Bundle taskIdBundle=getArguments();
            task = MyApplication.getInstance().getDataModel().getTaskFile(0).getTask(taskIdBundle.getString("TaskId"));

            updateTaskDetails();
            return rootView;
        }

        public void updateTaskDetails() {
            MyApplication.v(LOG_TAG + "updateTaskDetails()");
            if (task != null) {
            }
        }
    }

    public static  class PreReqFragment extends Fragment {
        private final String LOG_TAG = PreReqFragment.class.getSimpleName() + "::";
        private Task task = null;

        public PreReqFragment() {
        }

        @Override
        public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_task_details_prereq, container, false);

            updateTaskDetails();
            return rootView;
        }

        public void updateTaskDetails() {
            MyApplication.v(LOG_TAG + "updateTaskDetails()");
            if (task != null) {
            }
        }
    }

    public static  class ProgressFragment extends Fragment {
        private final String LOG_TAG = ProgressFragment.class.getSimpleName() + "::";
        private Task task = null;
        private EditText tabProgress_percent;

        public ProgressFragment() {
        }

        @Override
        public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_task_details_progress, container, false);

            tabProgress_percent = (EditText) rootView.findViewById(R.id.tabProgress_percent);

            Bundle taskIdBundle=getArguments();
            task = MyApplication.getInstance().getDataModel().getTaskFile(0).getTask(taskIdBundle.getString("TaskId"));

            updateTaskDetails();
            return rootView;
        }

        public void updateTaskDetails() {
            MyApplication.v(LOG_TAG + "updateTaskDetails()");
            if (task != null) {
                tabProgress_percent.setText(task.percentageComplete);
            }
        }
    }
}
