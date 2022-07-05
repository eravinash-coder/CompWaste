package com.example.compwaste.AdminPanel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.compwaste.R;

import java.util.List;

public class AdminOrdertobePrepareViewAdapter extends RecyclerView.Adapter<AdminOrdertobePrepareViewAdapter.ViewHolder> {

    private Context mcontext;
    private List<AdminWaitingOrders> adminWaitingOrderslist;

    public AdminOrdertobePrepareViewAdapter(Context context, List<AdminWaitingOrders> adminWaitingOrderslist) {
        this.adminWaitingOrderslist = adminWaitingOrderslist;
        this.mcontext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.chef_ordertobeprepared_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final AdminWaitingOrders adminWaitingOrders = adminWaitingOrderslist.get(position);
        holder.dishname.setText(adminWaitingOrders.getDishName());
        holder.price.setText("Reward: ₹ " + adminWaitingOrders.getDishPrice());
        holder.quantity.setText("× " + adminWaitingOrders.getDishQuantity());
        holder.totalprice.setText("Total Reward: ₹ " + adminWaitingOrders.getTotalPrice());
    }

    @Override
    public int getItemCount() {
        return adminWaitingOrderslist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView dishname, price, totalprice, quantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            dishname = itemView.findViewById(R.id.Dname);
            price = itemView.findViewById(R.id.Dprice);
            totalprice = itemView.findViewById(R.id.Tprice);
            quantity = itemView.findViewById(R.id.Dqty);
        }
    }
}
