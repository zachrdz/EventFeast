package com.example.daddyz.turtleboys.newsfeed;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.example.daddyz.turtleboys.R;

import java.util.ArrayList;

/**
 * Created by snow on 7/11/2015.
 */
public class newsfeedFragment extends Fragment{

    public static final String REQUEST_TAG = "MainVolleyActivity";
    private Button mButton;

    private TextView mTextView;
    private RequestQueue mQueue;
    private View rootView;
    private ListView list;
    private newsfeedAdapter adapter;
    private ArrayList<newsfeedObject> newsfeedList;
    private  FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rootView = inflater.inflate(R.layout.newsfeedlistfragment, container, false);
        list = (ListView) rootView.findViewById(R.id.listView);

        mTextView = (TextView) rootView.findViewById(R.id.textView);
        mButton = (Button) rootView.findViewById(R.id.button);
        list.setClickable(true);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //get object at that position
                //this code is gonna get nocked out monday

                //start the fragment

                //this is where we are gonna

            }
        });

        fab = (FloatingActionButton) rootView.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(getActivity(), "User Wants to make a post", Toast.LENGTH_SHORT).show();
            }
        });
        newsfeedList = new ArrayList<newsfeedObject>();
        newsfeedObject obj = new newsfeedObject();
        newsfeedObject obj3 = new newsfeedObject();
        newsfeedObject obj4 = new newsfeedObject();
        newsfeedObject obj5 = new newsfeedObject();
        newsfeedObject obj6 = new newsfeedObject();
        newsfeedObject obj7 = new newsfeedObject();
        newsfeedObject obj8 = new newsfeedObject();
        newsfeedObject obj9 = new newsfeedObject();
        newsfeedObject obj10 = new newsfeedObject();
        newsfeedList.add(obj);
        newsfeedList.add(obj3);
        newsfeedList.add(obj4);
        newsfeedList.add(obj5);
        newsfeedList.add(obj6);
        newsfeedList.add(obj7);
        newsfeedList.add(obj8);
        newsfeedList.add(obj9);
        newsfeedList.add(obj10);
        adapter = new newsfeedAdapter(getActivity(), R.layout.eventfeedroweven, newsfeedList);
        list.setAdapter(adapter);
        Log.d("CustomAdapter", "Newsfeed Launched successfully");

        return rootView;
    }
}
