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


public class rewardFoodAdapter extends PagerAdapter {
   private List<rewardModel> rewardModelList;
   private LayoutInflater layoutInflater;
   private Context context;

    public rewardFoodAdapter(List<rewardModel> rewardModelList, Context context) {
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
        View view=layoutInflater.inflate(R.layout.item2, container,false);

        ImageView rfImageView;
        final TextView rfTitle,rfDesc;
        rfImageView=view.findViewById(R.id.rfImageView);
        rfTitle=view.findViewById(R.id.rfTitle);
        rfDesc=view.findViewById(R.id.rfDesc);

        rfImageView.setImageResource(rewardModelList.get(position).getImage());
        rfTitle.setText(rewardModelList.get(position).getTitle());
        rfDesc.setText(rewardModelList.get(position).getDesc());

        view.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Bundle bundle = new Bundle();
                bundle.putString("title", rfTitle.getText().toString());
                bundle.putString("desc", rfDesc.getText().toString());
                Intent intent = new Intent(context, RewardDetails.class);
                for(int i=0;i<rewardModelList.size();i++)
                {
                    if(rewardModelList.get(i).getTitle().equals(rfTitle.getText().toString()))
                    {
                        bundle.putString("type", rewardModelList.get(i).getType());
                    }
                }
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        container.addView(view,0);
        return view;


    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
