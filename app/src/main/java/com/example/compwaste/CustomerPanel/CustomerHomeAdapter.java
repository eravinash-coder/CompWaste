package com.example.compwaste.CustomerPanel;

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
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.compwaste.AdminPanel.UpdateWasteModel;
import com.example.compwaste.R;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class CustomerHomeAdapter extends RecyclerView.Adapter<CustomerHomeAdapter.ViewHolder> {


    private Context mcontext;
    private List<UpdateWasteModel> updateWasteModellist;
    DatabaseReference databaseReference;

    public CustomerHomeAdapter(Context context,List<UpdateWasteModel> updateWasteModellist)
    {
        this.updateWasteModellist = updateWasteModellist;
        this.mcontext=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.customer_menudish,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        final UpdateWasteModel updateWasteModel = updateWasteModellist.get(position);
        Glide.with(mcontext).load(updateWasteModel.getImageURL()).into(holder.imageView);
        holder.Dishname.setText(updateWasteModel.getDishes());
        updateWasteModel.getRandomUID();
        updateWasteModel.getChefId();
        holder.price.setText("Price: ₹ " + updateWasteModel.getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(mcontext, OrderWaste.class);
                intent.putExtra("FoodMenu", updateWasteModel.getRandomUID());
                intent.putExtra("ChefId", updateWasteModel.getChefId());


                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return updateWasteModellist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView Dishname,price;
        ElegantNumberButton additem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.menu_image);
            Dishname=itemView.findViewById(R.id.dishname);
            price=itemView.findViewById(R.id.dishprice);
            additem=itemView.findViewById(R.id.number_btn);


        }
    }
}
