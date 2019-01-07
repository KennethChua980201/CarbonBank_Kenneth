package com.cb.carbonbank;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarbonTrade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carbon_trade);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnBuy=findViewById(R.id.btnBuy);
        Button btnSell=findViewById(R.id.btnSell);
        final ListView listView=findViewById(R.id.listTradeRecords);
        final EditText buyEditText=findViewById(R.id.buyAmountText);
        final EditText sellEditText=findViewById(R.id.sellAmountText);
        final List<TradeRecord> tradeRecordList = new ArrayList<TradeRecord>();

        btnBuy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    if((Double.parseDouble(buyEditText.getText().toString())== 0))
                    {
                        Toast.makeText(getBaseContext(),"Please enter a valid buy amount", Toast.LENGTH_SHORT).show(); }
                    else
                    {
                        String buysuccess=buyEditText.getText()+" Carbon Credits has been bought";
                        Long tsLong = System.currentTimeMillis()/1000;
                        String ts = tsLong.toString();
                        Toast.makeText(getBaseContext(),buysuccess, Toast.LENGTH_SHORT).show();
                        tradeRecordList.add(new TradeRecord(ts,"Buy", Double.parseDouble(buyEditText.getText().toString())));
                    }

                }catch (Exception ex)
                {Toast.makeText(getBaseContext(),"Please enter a valid buy amount", Toast.LENGTH_SHORT).show();} }
        });

        btnSell.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    if((Double.parseDouble(sellEditText.getText().toString())== 0))
                    {
                        Toast.makeText(getBaseContext(),"Please enter a valid buy amount", Toast.LENGTH_SHORT).show(); }
                    else
                    {
                        String sellsuccess=sellEditText.getText()+" Carbon Credits has been sold";
                        Toast.makeText(getBaseContext(),sellsuccess, Toast.LENGTH_SHORT).show();
                    }

                }catch (Exception ex)
                {Toast.makeText(getBaseContext(),"Please enter a valid buy amount", Toast.LENGTH_SHORT).show();} }


        });

    }

}
