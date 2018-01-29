package com.assignment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.toString();
    private ImageView mLogoImV;
    private Button mShowBtn;
    private final String BUTTON_SHOW = "Show Image";
    private final String BUTTON_HIDE = "Hide Image";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        // init layout file (.XML)
        setContentView(R.layout.activity_main);
        // init all views
        mShowBtn = (Button) findViewById(R.id.button_show_image);
        mLogoImV = (ImageView) findViewById(R.id.imageview_logo);
        mShowBtn.setText(BUTTON_HIDE); // set button title
        // set onclick listener on button
        mShowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Change Visibality")
                        .setMessage("Are you sure you want to " + getButtonStatus() + "?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {  // positiveButton
                            public void onClick(DialogInterface dialog, int which) {
                                // if user select positive button change status of button and imageview
                                changeStatus();
                            }
                        })

                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) { // negativeButton
                                dialog.dismiss();//hide the dialog UI
                            }
                        })
                        .setIcon(R.drawable.settings)
                        .show();
            }
        });
    }

    // this method will return button current status ( show/hide)
    private String getButtonStatus() {
        String status = mShowBtn.getText().toString();
        if (status.equalsIgnoreCase(BUTTON_HIDE)) {
            return BUTTON_HIDE;
        } else {
            return BUTTON_SHOW;
        }
    }

    // This method will change button and imageview status
    private void changeStatus() {
        if (getButtonStatus().equalsIgnoreCase(BUTTON_SHOW)) {
            mLogoImV.setVisibility(View.VISIBLE);
            mShowBtn.setText(BUTTON_HIDE);
        } else {
            mLogoImV.setVisibility(View.INVISIBLE);
            mShowBtn.setText(BUTTON_SHOW);
        }
    }
}
