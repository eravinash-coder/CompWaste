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

public class AdminPreparedOrderAdapter extends RecyclerView.Adapter<AdminPreparedOrderAdapter.ViewHolder> {

    private Context context;
    private List<AdminFinalOrders1> adminFinalOrders1List;

    public AdminPreparedOrderAdapter(Context context, List<AdminFinalOrders1> adminFinalOrders1List) {
        this.adminFinalOrders1List = adminFinalOrders1List;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.chef_preparedorder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final AdminFinalOrders1 adminFinalOrders1 = adminFinalOrders1List.get(position);
        holder.Address.setText(adminFinalOrders1.getAddress());
        holder.grandtotalprice.setText("Total Reward: ₹ " + adminFinalOrders1.getGrandTotalPrice());
        final String random = adminFinalOrders1.getRandomUID();
        holder.Vieworder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AdminPreparedOrderView.class);
                intent.putExtra("RandomUID", random);
                context.startActivity(intent);
                ((AdminPreparedOrder) context).finish();
            }
        });

    }

    @Override
    public int getItemCount() {
        return adminFinalOrders1List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Address, grandtotalprice;
        Button Vieworder;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Address = itemView.findViewById(R.id.customer_address);
            grandtotalprice = itemView.findViewById(R.id.customer_totalprice);
            Vieworder = itemView.findViewById(R.id.View);
        }
    }
}
