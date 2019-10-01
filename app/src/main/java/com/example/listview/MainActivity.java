package com.example.listview;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity  {
    ListView listView;
    ArrayList<SmsEmail> smsEmails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        smsEmails = new ArrayList<>();
        Random random = new Random();
        int i = 1 + random.nextInt(14);

        SmsEmail smsEmails1 = new SmsEmail("Tiki", "Xác Nhận email của bạn tren Shopee","Bạn đã nhập địa chỉ là xxxxxxxxxx", "19:00PM",0,1 + random.nextInt(14));
        SmsEmail smsEmails2 = new SmsEmail("Shopee", "Xác Nhận email của bạn tren Shopee","Bạn đã nhập địa chỉ là xxxxxxxxxx", "18:04PM",0,1 + random.nextInt(14));
        SmsEmail smsEmails3 = new SmsEmail("Dropbox", "Xác Nhận email của bạn tren Shopee","Bạn đã nhập địa chỉ là xxxxxxxxxx", "12:04AM",0,1 + random.nextInt(14));
        SmsEmail smsEmails4 = new SmsEmail("Admin", "Xác Nhận email của bạn tren Shopee","Bạn đã nhập địa chỉ là xxxxxxxxxx", "12:04AM",0,1 + random.nextInt(14));
        SmsEmail smsEmails5 = new SmsEmail("Facebook", "Xác Nhận email của bạn tren Shopee","Bạn đã nhập địa chỉ là xxxxxxxxxx", "12:04AM",0,1 + random.nextInt(14));
        SmsEmail smsEmails6 = new SmsEmail("Alibaba", "Xác Nhận email của bạn tren Shopee","Bạn đã nhập địa chỉ là xxxxxxxxxx", "12:04AM",0,1 + random.nextInt(14));
        SmsEmail smsEmails7 = new SmsEmail("Google", "Xác Nhận email của bạn tren Shopee","Bạn đã nhập địa chỉ là xxxxxxxxxx", "12:04AM",0,1 + random.nextInt(14));
        SmsEmail smsEmails8 = new SmsEmail("Apple", "Xác Nhận email của bạn tren Shopee","Bạn đã nhập địa chỉ là xxxxxxxxxx", "12:04AM",0,1 + random.nextInt(14));
        SmsEmail smsEmails9 = new SmsEmail("Lazada", "Xác Nhận email của bạn tren Shopee","Bạn đã nhập địa chỉ là xxxxxxxxxx", "12:04AM",0,1 + random.nextInt(14));
        SmsEmail smsEmails10 = new SmsEmail("Email", "Xác Nhận email của bạn tren Shopee","Bạn đã nhập địa chỉ là xxxxxxxxxx", "12:04AM",0,1 + random.nextInt(14));

         smsEmails.add(smsEmails1);
         smsEmails.add(smsEmails2);
         smsEmails.add(smsEmails3);
         smsEmails.add(smsEmails4);
         smsEmails.add(smsEmails5);
         smsEmails.add(smsEmails6);
         smsEmails.add(smsEmails7);
         smsEmails.add(smsEmails8);
         smsEmails.add(smsEmails9);
         smsEmails.add(smsEmails10);

        final CustomAdapter customAdapter = new CustomAdapter(this, R.layout.row_item,smsEmails);
        listView.setAdapter(customAdapter);
        
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                int k = smsEmails.get(position).getState();
                if(k == 0) {
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll);
                    linearLayout.setBackgroundResource(R.drawable.background_item);
                    TextView tv = (TextView) view.findViewById(R.id.tvAvart);
                    tv.setText("✓");
                    tv.setBackgroundTintList(MainActivity.this.getResources().getColorStateList(R.color.color7));
                    k =1;
                    smsEmails.get(position).setState(k);
                }else{
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll);
                    linearLayout.setBackgroundColor(Color.WHITE);
                    TextView tv = (TextView) view.findViewById(R.id.tvAvart);
                    tv.setText( ""+smsEmails.get(position).getSender().charAt(0));
                    tv.setBackgroundTintList(MainActivity.this.getResources().getColorStateList(R.color.color5));
                    k =0;
                    smsEmails.get(position).setState(k);
                }
                return true;
            }
        });


    }
}
