package com.example.listview;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomAdapter extends ArrayAdapter<SmsEmail> {
    private Context context;
    private int resource;
    private List<SmsEmail> arrSms;

    public CustomAdapter(Context context, int resource, ArrayList<SmsEmail> arrSms) {
        super(context, resource, arrSms);
        this.context = context;
        this.resource = resource;
        this.arrSms = arrSms;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.tvSender = (TextView) convertView.findViewById(R.id.tvSender);
            viewHolder.tvContent = (TextView) convertView.findViewById(R.id.tvContent);
            viewHolder.tvDescription = (TextView) convertView.findViewById(R.id.tvDescription);
            viewHolder.tvAvatar = (TextView) convertView.findViewById(R.id.tvAvart);
            viewHolder.tvTime = (TextView) convertView.findViewById(R.id.tvTime);
            viewHolder.imgStar = (ImageView) convertView.findViewById(R.id.imgStar);
            viewHolder.linearLayout = (LinearLayout) convertView.findViewById(R.id.ll);

            convertView.setTag(viewHolder);
            Log.d("yy", "position"+(position+1));
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final SmsEmail smsEmail = arrSms.get(position);
        viewHolder.tvSender.setText(smsEmail.getSender());
        viewHolder.tvContent.setText(smsEmail.getContent());
        viewHolder.tvDescription.setText(smsEmail.getDescription());
        viewHolder.tvTime.setText(smsEmail.getTime());
        viewHolder.tvAvatar.setText(setAvatar(smsEmail.getSender()));
        viewHolder.linearLayout.setBackgroundColor(Color.WHITE);

        int color =  smsEmail.getColor();
        switch (color) {
            case 1:
                viewHolder.tvAvatar.setBackgroundTintList(context.getResources().getColorStateList(R.color.colorYellow));
                break;
            case 2:
                viewHolder.tvAvatar.setBackgroundTintList(context.getResources().getColorStateList(R.color.colorAccent));
                break;
            case 3:
                viewHolder.tvAvatar.setBackgroundTintList(context.getResources().getColorStateList(R.color.colorB));
                break;
            case 4:
                viewHolder.tvAvatar.setBackgroundTintList(context.getResources().getColorStateList(R.color.colorPrimary));
                notifyDataSetChanged();
                break;
            case 5:
                viewHolder.tvAvatar.setBackgroundTintList(context.getResources().getColorStateList(R.color.colorPrimaryDark));
                break;
            case 6:
                viewHolder.tvAvatar.setBackgroundTintList(context.getResources().getColorStateList(R.color.color1));
                break;
            case 7:
                viewHolder.tvAvatar.setBackgroundTintList(context.getResources().getColorStateList(R.color.color2));
                break;
            case 8:
                viewHolder.tvAvatar.setBackgroundTintList(context.getResources().getColorStateList(R.color.color3));
                break;
            case 9:
                viewHolder.tvAvatar.setBackgroundTintList(context.getResources().getColorStateList(R.color.color4));
                notifyDataSetChanged();
                break;
            case 10:
                viewHolder.tvAvatar.setBackgroundTintList(context.getResources().getColorStateList(R.color.color5));
                break;
            case 11:
                viewHolder.tvAvatar.setBackgroundTintList(context.getResources().getColorStateList(R.color.color6));
                notifyDataSetChanged();
                break;
            case 12:
                viewHolder.tvAvatar.setBackgroundTintList(context.getResources().getColorStateList(R.color.color7));
                break;
            case 13:
                viewHolder.tvAvatar.setBackgroundTintList(context.getResources().getColorStateList(R.color.color8));
                break;
            case 14:
                viewHolder.tvAvatar.setBackgroundTintList(context.getResources().getColorStateList(R.color.color9));
                break;
            case 15:
                viewHolder.tvAvatar.setBackgroundTintList(context.getResources().getColorStateList(R.color.color10));
                break;
             default:
                 break;
        }


       viewHolder.imgStar.setOnClickListener(new View.OnClickListener() {
            int state = smsEmail.getState();

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if (state == 0) {
                    viewHolder.imgStar.setBackgroundTintList(context.getResources().getColorStateList(R.color.colorYellow));
                    state = 1;
                    smsEmail.setState(state);
                    notifyDataSetChanged();
                } else {
                    viewHolder.imgStar.setBackgroundTintList(context.getResources().getColorStateList(R.color.colorB));
                    state = 0;
                    smsEmail.setState(state);
                    notifyDataSetChanged();
                }
            }
        });
        return convertView;
    }

    public class ViewHolder {
        TextView tvSender, tvContent, tvDescription, tvTime, tvAvatar;
        ImageView imgStar;
        LinearLayout linearLayout;
    }

    public String setAvatar(String name) {
        char x = name.charAt(0);
        return (x + "");
    }
}
