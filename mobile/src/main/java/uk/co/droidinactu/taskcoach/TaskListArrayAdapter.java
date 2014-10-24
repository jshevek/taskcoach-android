package uk.co.droidinactu.taskcoach;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import uk.co.droidinactu.taskcoach.data.Task;
import uk.co.droidinactu.taskcoach.data.TaskIconFactory;

/**
 * Created by aspela on 15/09/14.
 */
public class TaskListArrayAdapter extends ArrayAdapter<Task> {
    private final Context context;
    private final Task[] values;

    public TaskListArrayAdapter(Context context, Task[] values) {
        super(context, R.layout.task_list_item, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Task getItem(int position) {
        return values[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.task_list_item, parent, false);

        Task currTask = values[position];

        TextView textNameView = (TextView) rowView.findViewById(R.id.task_list_item_name);
        textNameView.setText(currTask.subject);
        if (currTask.tasks.size() > 0) {
            //textNameView.setTextAppearance(context, android.R.style.TextAppearance_Large);
            rowView.setBackground(context.getResources().getDrawable(R.drawable.btn_default_normal));
        } else {
            //textNameView.setTextAppearance(context, android.R.style.TextAppearance_Small);
        }

        final TextView taskDescriptionView = (TextView) rowView.findViewById(R.id.task_list_item_description);
        if (currTask.description.length() == 0) {
            taskDescriptionView.setVisibility(View.GONE);
        } else {
            taskDescriptionView.setVisibility(View.VISIBLE);
            taskDescriptionView.setText(currTask.description);
        }

        ImageView taskImg = (ImageView) rowView.findViewById(R.id.task_list_item_image);
        final Bitmap bmp = TaskIconFactory.getIcon(context, currTask);
        if (bmp != null) {
            taskImg.setImageBitmap(bmp);
        }

        CheckBox chkTaskComplete = (CheckBox) rowView.findViewById(R.id.task_list_item_checkbox);
        chkTaskComplete.setTag(currTask.id);
        if (currTask.tasks.size() > 0) {
            chkTaskComplete.setVisibility(View.GONE);
        } else {
            chkTaskComplete.setVisibility(View.VISIBLE);
            chkTaskComplete.setChecked(currTask.percentageComplete.equalsIgnoreCase("100"));
        }
        chkTaskComplete.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                final String taskId = (String) buttonView.getTag();

                if (buttonView.isChecked()) {
                    Toast.makeText(context, "Button Checked", Toast.LENGTH_SHORT);
                } else {
                    Toast.makeText(context, "Button Unchecked", Toast.LENGTH_SHORT);
                }
            }
        });

        Button btnTaskDetails = (Button) rowView.findViewById(R.id.task_list_item_btn_details);
        btnTaskDetails.setTag(currTask.id);
        btnTaskDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //Debug.startMethodTracing();
                final Intent detailIntent = new Intent(MyApplication.getInstance().getApplicationContext(), TaskDetailsActivity.class);
                detailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                final String taskId = v.getTag().toString();
                detailIntent.putExtra(TaskDetailsActivity.ARG_TASK_ID, taskId);
                MyApplication.getInstance().getApplicationContext().startActivity(detailIntent);
            }
        });

        return rowView;
    }
}
