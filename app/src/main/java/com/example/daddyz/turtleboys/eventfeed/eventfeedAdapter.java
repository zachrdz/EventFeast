package com.example.daddyz.turtleboys.eventfeed;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.daddyz.turtleboys.R;

import java.util.ArrayList;

/**
 * Created by snow on 6/17/2015.
 */
public class eventfeedAdapter extends ArrayAdapter<eventfeedObject> {

    private Context context;
    private int resource;
    private ArrayList<eventfeedObject> objects;

    private int[] colors = new int[] { 0x30FF0000, 0x300000FF };
    public eventfeedAdapter(Context context, int resource, ArrayList<eventfeedObject> objects) {
        super(context, resource,objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }
    //return even or odd row
    public int getItemViewType(int position) {
        // return a value between 0 and (getViewTypeCount - 1)
        //return position % 2;
        return position % 1;
    }
    //total type of rows that are shown if we add more we need to change this to a 3
    public int getViewTypeCount() {
        // return the total number of view types. this value should never change at runtime
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get inflator so it will strech the view to fill the row data
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();

        //change row layout depending on row number
        int rowType = getItemViewType(position);

        int layoutResource = 0; // determined by view type
        int viewType = getItemViewType(position);
        Log.d("test", viewType + "");
        switch(viewType) {
            case 0:
                layoutResource = R.layout.eventfeedroweven; break;
            case 1:
                layoutResource = R.layout.eventfeedrowodd; break;
        }
        //set the view to the odd or even row view
        View row=inflater.inflate(layoutResource,parent,false);

        //TextView source = (TextView) row.findViewById(R.id.sourceLine);
        TextView description = (TextView) row.findViewById(R.id.descLine);
        TextView citystate = (TextView) row.findViewById(R.id.citystateLine);
        TextView date = (TextView)row.findViewById(R.id.dateLine);
        TextView time = (TextView) row.findViewById(R.id.timeLine);
        TextView venue = (TextView) row.findViewById(R.id.venueLine);
        //TextView urlpath = (TextView) row.findViewById(R.id.urlpathLine);

        //source.setText(objects.get(position).getEventSource());
        description.setText(objects.get(position).getEventDesc());
        citystate.setText(objects.get(position).getEventCity() + "," + objects.get(position).getEventState());
        date.setText(objects.get(position).getEventDate());
        time.setText(objects.get(position).getEventTime());
        venue.setText(objects.get(position).getEventVenue());
        //urlpath.setText(objects.get(position).getEventURL());


        return row;
    }
}