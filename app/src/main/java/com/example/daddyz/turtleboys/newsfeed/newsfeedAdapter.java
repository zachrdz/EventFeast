package com.example.daddyz.turtleboys.newsfeed;

import android.content.Context;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daddyz.turtleboys.R;

import java.util.ArrayList;

/**
 * Created by snow on 7/11/2015.
 */
public class newsfeedAdapter extends ArrayAdapter<newsfeedObject> {

    private Context context;
    private int resource;
    private ArrayList<newsfeedObject> newsfeedObjects;
    private Boolean AnimationFlag;
    private int lastPosition = -1;

    public newsfeedAdapter(Context context, int resource, ArrayList<newsfeedObject> newsfeedObjects) {
        super(context, resource,newsfeedObjects);
        this.context = context;
        this.resource = resource;
        this.newsfeedObjects = newsfeedObjects;
        this.AnimationFlag = PreferenceManager.getDefaultSharedPreferences(context).getBoolean("animation_preference", false);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.newsfeedrow, parent, false);
        TextView messageBox1 = (TextView) rowView.findViewById(R.id.example);
        TextView description = (TextView) rowView.findViewById(R.id.description);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        ImageView likeButton;
        ImageView reportButton;

        likeButton = (ImageView) rowView.findViewById(R.id.likeimage);
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "User LIKES THIS POST", Toast.LENGTH_SHORT).show();
            }
        });
        reportButton = (ImageView) rowView.findViewById(R.id.report);
        reportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(getContext(), "User REPORTS THIS POST", Toast.LENGTH_SHORT).show();
            }
        });

        messageBox1.setText("This is the Test example message");
        description.setText("The description of the post will go here");
        //slide up animation
        if (AnimationFlag) {
            Animation animation = AnimationUtils.loadAnimation(getContext(), (position > lastPosition) ? R.anim.up_from_bottom : R.anim.bottom_from_up);
            rowView.startAnimation(animation);
            lastPosition = position;
        }
        return rowView;
    }
}


