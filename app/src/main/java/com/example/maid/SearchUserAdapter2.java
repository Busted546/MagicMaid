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

public class SearchUserAdapter2 extends RecyclerView.Adapter<SearchUserAdapter2.ViewHolder>  {

    List<SearchUserData2> dataList;
    Context context;


    public SearchUserAdapter2(List<SearchUserData2> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;

    }

    @NonNull
    @Override
    public SearchUserAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_name_layout_2, parent, false);

        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull final SearchUserAdapter2.ViewHolder holder, int position) {

        final SearchUserData2 data = dataList.get(position);
        holder.ttxt.setText(data.getUsername());

        holder.ttxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x= (String) holder.ttxt.getText();

                Intent i=new Intent(context,MaidFeatures.class);
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
