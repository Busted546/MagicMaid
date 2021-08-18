package com.example.maid;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SearchUserAdapter extends RecyclerView.Adapter<SearchUserAdapter.ViewHolder>  {

    List<SearchUserData> dataList;
    Context context;


    public SearchUserAdapter(List<SearchUserData> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;

    }

    @NonNull
    @Override
    public SearchUserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_name_layout, parent, false);

        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull final SearchUserAdapter.ViewHolder holder, int position) {

        final SearchUserData data = dataList.get(position);
        holder.ttxt.setText(data.getShopname());

        holder.ttxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x= (String) holder.ttxt.getText();

                Intent i=new Intent(context, adminMain.class);
                i.putExtra("data",x);
                context.startActivity(i);



            }
        });

    }




    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView ttxt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ttxt = itemView.findViewById(R.id.ttxt);
        }

    }

}
