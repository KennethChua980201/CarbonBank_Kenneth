package com.cb.carbonbank;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class rewardTransportAdapter extends PagerAdapter {
   private List<rewardModel> rewardModelList;
   private LayoutInflater layoutInflater;
   private Context context;


    public rewardTransportAdapter(List<rewardModel> rewardModelList, Context context) {
        this.rewardModelList = rewardModelList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return rewardModelList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.item, container,false);

        final ImageView rtImageView;
        final TextView rtTitle,rtDesc;

        rtImageView=view.findViewById(R.id.rdImageView);
        rtTitle=view.findViewById(R.id.rtTitleTextView);
        rtDesc=view.findViewById(R.id.rtDescTextView);

        rtImageView.setImageResource(rewardModelList.get(position).getImage());
        view.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Bundle bundle = new Bundle();
                bundle.putString("title", rtTitle.getText().toString());
                bundle.putString("desc", rtDesc.getText().toString());

                for(int i=0;i<rewardModelList.size();i++)
                {
                    if(rewardModelList.get(i).getTitle().equals(rtTitle.getText().toString()))
                    {
                        bundle.putString("type", rewardModelList.get(i).getType());
                    }
                }
                Intent intent = new Intent(context, RewardDetails.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });




        rtTitle.setText(rewardModelList.get(position).getTitle());
        rtDesc.setText(rewardModelList.get(position).getDesc());
        container.addView(view,0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
