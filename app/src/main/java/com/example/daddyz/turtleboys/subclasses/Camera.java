package com.example.daddyz.turtleboys.subclasses;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Gregory Hooks Jr on 6/16/2015.
 */
public class Camera extends Activity {
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    //private static final int CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE = 200;
    private Uri fileUri;
    public static final int MEDIA_TYPE_IMAGE = 1;
    //public static final int MEDIA_TYPE_VIDEO = 2;
    private static Context context;
    private static String sub_directory;

    public Camera (Context context, String sub_dir){
        this.sub_directory = sub_dir;
        this.context = context;
    }

    public Uri startCamera() {
        if(context == null){
            return null;
        }
        // create Intent to take a picture and return control to the calling application
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE); // create a file to save the image
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name

        // start the image capture Intent
        ((AppCompatActivity) context).startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
        return fileUri;
    }



    /** Create a file Uri for saving an image or video */
    private static Uri getOutputMediaFileUri(int type){
        return Uri.fromFile(getOutputMediaFile(type));
    }

    /** Create a File for saving an image or video */
    private static File getOutputMediaFile(int type){
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "GigIT/" + sub_directory);
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE){
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_"+ timeStamp + ".jpg");
        } /*else if(type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "VID_"+ timeStamp + ".mp4");
        }*/ else {
            Log.d("MyCameraApp", "type returned was " + type);
            return null;
        }

        return mediaFile;
    }
}
