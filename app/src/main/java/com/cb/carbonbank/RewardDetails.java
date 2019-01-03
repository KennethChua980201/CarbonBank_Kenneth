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

        TextView rtdTitleTextView=findViewById(R.id.rdTitleTextView);
        TextView rtdDescTextView=findViewById(R.id.rdDescTextView);
        ImageView imageViewRD= findViewById(R.id.rdImageView);

        Bundle extras = getIntent().getExtras();
        String value;
        if (extras != null) {
            rtdTitleTextView.setText(extras.getString("title"));
            rtdDescTextView.setText(extras.getString("desc"));
            String rewardtype= extras.getString("type");

            if(rewardtype.equals("rt1"))
            imageViewRD.setImageResource(R.drawable.rewardtransport1);
            else if(rewardtype.equals("rt2"))
            imageViewRD.setImageResource(R.drawable.rewardtransport2);
            else if(rewardtype.equals("rt3"))
            imageViewRD.setImageResource(R.drawable.rewardtransport3);
            else if (rewardtype.equals("rf1"))
                imageViewRD.setImageResource(R.drawable.rewardfood1);
            else if (rewardtype.equals("rf2"))
                imageViewRD.setImageResource(R.drawable.rewardfood2);
            else if (rewardtype.equals("rf3"))
                imageViewRD.setImageResource(R.drawable.rewardfood3);

        }


    }

}
