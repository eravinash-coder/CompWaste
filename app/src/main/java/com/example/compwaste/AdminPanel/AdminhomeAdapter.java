package com.example.compwaste.AdminPanel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.compwaste.R;

import java.util.List;

public class AdminhomeAdapter extends RecyclerView.Adapter<AdminhomeAdapter.ViewHolder> {

   private Context mcont;
   private List<UpdateWasteModel> updateWasteModellist;

   public AdminhomeAdapter(Context context, List<UpdateWasteModel> updateWasteModellist)
   {
       this.updateWasteModellist = updateWasteModellist;
       this.mcont=context;
   }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(mcont).inflate(R.layout.chef_menu_update_delete,parent,false);
       return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       final UpdateWasteModel updateWasteModel = updateWasteModellist.get(position);
       holder.dishes.setText(updateWasteModel.getDishes());
       updateWasteModel.getRandomUID();
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(mcont, Update_Delete_Waste.class);
               intent.putExtra("updatedeletedish", updateWasteModel.getRandomUID());
               mcont.startActivity(intent);

           }
       });
    }


    @Override
    public int getItemCount() {
        return updateWasteModellist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

       TextView dishes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dishes=itemView.findViewById(R.id.dish_name);

        }
    }
}
