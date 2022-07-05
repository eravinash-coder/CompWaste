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

public class AdminOrderDishesAdapter extends RecyclerView.Adapter<AdminOrderDishesAdapter.ViewHolder> {


    private Context mcontext;
    private List<AdminPendingOrders> adminPendingOrderslist;

    public AdminOrderDishesAdapter(Context context, List<AdminPendingOrders> adminPendingOrderslist) {
        this.adminPendingOrderslist = adminPendingOrderslist;
        this.mcontext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.chef_order_dishes, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final AdminPendingOrders adminPendingOrders = adminPendingOrderslist.get(position);
        holder.dishname.setText(adminPendingOrders.getDishName());
        holder.price.setText("Reward: ₹ " + adminPendingOrders.getPrice());
        holder.quantity.setText("× " + adminPendingOrders.getDishQuantity());
        holder.totalprice.setText("Total Reward: ₹ " + adminPendingOrders.getTotalPrice());


    }

    @Override
    public int getItemCount() {
        return adminPendingOrderslist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView dishname, price, totalprice, quantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            dishname = itemView.findViewById(R.id.DN);
            price = itemView.findViewById(R.id.PR);
            totalprice = itemView.findViewById(R.id.TR);
            quantity = itemView.findViewById(R.id.QY);
        }
    }
}
