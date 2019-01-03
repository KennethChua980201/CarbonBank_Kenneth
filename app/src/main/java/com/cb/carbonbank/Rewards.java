package com.cb.carbonbank;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class Rewards extends AppCompatActivity {
ViewPager viewPager1;
ViewPager viewPager2;
List<rewardModel> rtModelList;
List<rewardModel> rfModelList;
rewardTransportAdapter rtAdapter;
rewardFoodAdapter rfAdapter;
ArgbEvaluator argbEvaluator= new ArgbEvaluator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rtModelList= new ArrayList<>();
        rfModelList= new ArrayList<>();
        rtModelList.add(new rewardModel(R.drawable.rewardtransport1, "RM10 Worth of LRT Rides","Exchange with 1000 Carbon Credits","rt1"));
        rtModelList.add(new rewardModel(R.drawable.rewardtransport2, "RM10 Worth of Rapid Bus Rides","Exchange with 1000 Carbon Credits","rt2"));
        rtModelList.add(new rewardModel(R.drawable.rewardtransport3, "RM50 Discount from every RM150 AirAsia Flight","Exchange with 5000 Carbon Credits","rt3"));

        rfModelList.add(new rewardModel(R.drawable.rewardfood1, "RM2.50 for every RM12.50 or below Beverages","Exchange with 1000 Carbon Credits","rf1"));
        rfModelList.add(new rewardModel(R.drawable.rewardfood2, "RM30 Worth of Eat Until Full Buffet","Exchange with 3000 Carbon Credits","rf2"));
        rfModelList.add(new rewardModel(R.drawable.rewardfood3, "RM5 Worth of YY Canteen Dishes","Exchange with 500 Carbon Credits","rf3"));

        rtAdapter=new rewardTransportAdapter(rtModelList,this);
        rfAdapter=new rewardFoodAdapter(rfModelList,this);

        viewPager1=findViewById(R.id.viewPager1);
        viewPager1.setAdapter(rtAdapter);
        viewPager1.setPadding(130,0,130,0);

        viewPager2=findViewById(R.id.viewPager2);
        viewPager2.setAdapter(rfAdapter);
        viewPager2.setPadding(130,0,130,0);


    }


}
