package com.example.mina.minatask.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.example.mina.minatask.R;
import com.example.mina.minatask.activity.MainActivity;
import com.example.mina.minatask.activity.imageViewerActivity;
import com.example.mina.minatask.model.productObject;
import com.squareup.picasso.Picasso;

public class productsAdapter extends RecyclerView.Adapter<productsAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<productObject> data;

    public productsAdapter(Context mContext, ArrayList<productObject> data) {
        this.data = data;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.products_design, parent, false);
        final MyViewHolder mViewHolder = new MyViewHolder(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  mListener.onItemClick(v, mViewHolder.getPosition());
                //  mListener.onClick(v,mViewHolder.getPosition());
            }
        });
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, imageViewerActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("image", data);
                bundle.putInt("postion", position);
                intent.putExtra("bundle", bundle);
                mContext.startActivity(intent);
            }
        });
        holder.price.setText(String.valueOf(data.get(position).getPrice()));
        holder.descripton.setText(String.valueOf(data.get(position).getProductDescription()));
        holder.imageView.getLayoutParams().height=data.get(position).getImage().getHeight();
        holder.imageView.getLayoutParams().width=data.get(position).getImage().getWidth();

        Picasso.with(mContext)
                .load(data.get(position).getImage().getUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView price;
        public TextView descripton;
        public ImageView imageView;
        public CardView card_view;


        public MyViewHolder(View view) {

            super(view);
            price = (TextView) itemView.findViewById(R.id.price);
            descripton = (TextView) itemView.findViewById(R.id.desc);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            card_view = (CardView) itemView.findViewById(R.id.card_view);
        }
    }
}
