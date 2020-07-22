package com.example.evarkadasim.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.evarkadasim.Model.User;
import com.example.evarkadasim.R;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    ArrayList<User> users;
    LayoutInflater layoutInflater;
    Context context;


    public GridAdapter(Activity activity,ArrayList<User>users){
        this.users=users;
        this.context=activity;
        this.layoutInflater=
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.gridview_gorunumu,null);

        TextView tvAd=(TextView)view.findViewById(R.id.tvAd);
        TextView tvYas=(TextView)view.findViewById(R.id.tvYas);
        TextView tvSehir=(TextView)view.findViewById(R.id.tvSehir);
        TextView tvTel=(TextView)view.findViewById(R.id.tvTel);

        tvAd.setText(users.get(position).getAd());
        tvYas.setText(users.get(position).getBolum());
        tvSehir.setText(users.get(position).getSehir());
        tvTel.setText(users.get(position).getTel());

        return view;
    }

}
