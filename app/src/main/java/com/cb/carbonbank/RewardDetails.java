package com.cb.carbonbank;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class RewardDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView rtdTitleTextView=findViewById(R.id.rtdTitleTextView);
        TextView rtdDescTextView=findViewById(R.id.rtdDescTextView);

        Bundle extras = getIntent().getExtras();
        String value;
        if (extras != null) {
            rtdTitleTextView.setText(extras.getString("title"));
            rtdDescTextView.setText(extras.getString("desc"));

        }


    }

}
