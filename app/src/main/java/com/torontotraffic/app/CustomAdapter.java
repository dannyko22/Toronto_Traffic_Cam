package com.torontotraffic.app;

/**
 * Created by Danny on 18/02/14.
 */
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.support.v4.app.ActivityCompat.startActivity;

public class CustomAdapter extends BaseAdapter{
    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public CustomAdapter(MainActivity mainActivity, String[] prgmNameList, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=mainActivity;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        //ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.main_items, null);
        holder.tv=(TextView) rowView.findViewById(R.id.main_itemTextView);
        //holder.img=(ImageView) rowView.findViewById(R.id.imageView1);
        holder.tv.setText(result[position]);
        //holder.img.setImageResource(imageId[position]);
        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();

                switch (position)
                {
                    case 0:
                        context.startActivity(new Intent(context,mapview.class));
                        break;
                    case 1:
                        context.startActivity(new Intent(context,Four_O_One.class));
                        break;
                    case 2:
                        context.startActivity(new Intent(context,dvp.class));
                        break;
                    case 3:
                        context.startActivity(new Intent(context,Gardiner.class));
                        break;
                    case 4:
                        context.startActivity(new Intent(context,QEW.class));
                        break;
                    case 5:
                        context.startActivity(new Intent(context,fourhundred.class));
                        break;
                    case 6:
                        context.startActivity(new Intent(context,Four_O_Three.class));
                        break;
                    case 7:
                        context.startActivity(new Intent(context,Four_two_seven.class));
                        break;
                    case 8:
                        context.startActivity(new Intent(context,Allen.class));
                        break;
                    case 9:
                        context.startActivity(new Intent(context,HwySeven.class));
                        break;
                    case 10:
                        context.startActivity(new Intent(context,steeles.class));
                        break;
                    case 11:
                        context.startActivity(new Intent(context,finch.class));
                        break;
                    case 12:
                        context.startActivity(new Intent(context,sheppard.class));
                        break;
                    case 13:
                        context.startActivity(new Intent(context,eglinton.class));
                        break;
                    case 14:
                        context.startActivity(new Intent(context,bloor.class));
                        break;
                    case 15:
                        context.startActivity(new Intent(context,college.class));
                        break;
                    case 16:
                        context.startActivity(new Intent(context,dundas.class));
                        break;
                    case 17:
                        context.startActivity(new Intent(context,richmond.class));
                        break;
                    case 18:
                        context.startActivity(new Intent(context,adelaide.class));
                        break;
                    case 19:
                        context.startActivity(new Intent(context,front.class));
                        break;
                    case 20:
                        context.startActivity(new Intent(context,lakeshore.class));
                        break;
                    case 21:
                        context.startActivity(new Intent(context,aboutme.class));
                        break;
                    default:
                        break;
                }
            }
        });
        return rowView;
    }

}