package com.example.kursach.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.kursach.Domain.OrderDomain;
import com.example.kursach.R;
import com.example.kursach.activites.DetailActivity;
import com.example.kursach.activites.IntroActivity;
import java.util.ArrayList;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.ViewHolder>{
    ArrayList<OrderDomain> orderDomains;
    Context context;
    public RecommendedAdapter(ArrayList<OrderDomain> orderDomains) {
        this.orderDomains = orderDomains;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viewholder,parent,false);
        return new ViewHolder(inflate);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        holder.title.setText(orderDomains.get(position).getTitle());
        holder.fee.setText(String.valueOf(orderDomains.get(position).getPrice()));
        holder.addressTxt.setText(orderDomains.get(position).getAddress());
        int drawableReourceId =holder.itemView.getContext().getResources()
                .getIdentifier(orderDomains.get(position).getPic(),"drawable",holder.itemView.getContext()
                        .getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableReourceId).into(holder.pic);
        holder.pic.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
            intent.putExtra("object", orderDomains.get(position));
            holder.itemView.getContext().startActivity(intent);
        });
    }
    @Override
    public int getItemCount(){return orderDomains.size() ;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,fee;
        ImageView pic;
        TextView addressTxt;
        ImageView addBtn;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
           addressTxt = itemView.findViewById(R.id.addressTxt);
            title = itemView.findViewById(R.id.titleTxt);
            pic= itemView.findViewById(R.id.pic);
            fee = itemView.findViewById(R.id.priceTxt);
        }
    }
}
