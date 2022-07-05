package com.example.compwaste.AdminPanel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.compwaste.R;

import java.util.List;

public class AdminOrderTobePreparedAdapter extends RecyclerView.Adapter<AdminOrderTobePreparedAdapter.ViewHolder> {

    private Context context;
    private List<AdminWaitingOrders1> adminWaitingOrders1List;

    public AdminOrderTobePreparedAdapter(Context context, List<AdminWaitingOrders1> adminWaitingOrders1List) {
        this.adminWaitingOrders1List = adminWaitingOrders1List;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.chef_ordertobeprepared, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        AdminWaitingOrders1 adminWaitingOrders1 = adminWaitingOrders1List.get(position);
        holder.Address.setText(adminWaitingOrders1.getAddress());
        holder.grandtotalprice.setText("Total Reward: ₹ " + adminWaitingOrders1.getGrandTotalPrice());
        final String random = adminWaitingOrders1.getRandomUID();
        holder.Vieworder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AdminOrdertobePrepareView.class);
                intent.putExtra("RandomUID", random);
                context.startActivity(intent);
                ((AdminOrderTobePrepared) context).finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return adminWaitingOrders1List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Address, grandtotalprice;
        Button Vieworder;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Address = itemView.findViewById(R.id.cust_address);
            grandtotalprice = itemView.findViewById(R.id.Grandtotalprice);
            Vieworder = itemView.findViewById(R.id.View_order);
        }
    }
}
