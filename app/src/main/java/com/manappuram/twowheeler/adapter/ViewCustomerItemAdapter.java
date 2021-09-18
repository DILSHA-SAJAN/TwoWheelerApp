package com.manappuram.twowheeler.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.manappuram.twowheeler.R;

import com.manappuram.twowheeler.activity.ViewCustomerActivity;
import com.manappuram.twowheeler.databinding.ItemViewCustomerDetailsBinding;
import com.manappuram.twowheeler.response.ViewCustomerListResponse;

import java.util.ArrayList;

public class ViewCustomerItemAdapter extends RecyclerView.Adapter<ViewCustomerItemAdapter.ViewHolder> {

    Context context;
    public ArrayList<ViewCustomerListResponse.custList> prList;
    public ViewCustomerActivity.CustIDSelectListener listener;


    public ViewCustomerItemAdapter(Context context, ArrayList<ViewCustomerListResponse.custList> prList) {
        this.context = context;
        this.prList = prList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemViewCustomerDetailsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_view_customer_details, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.tvCustName.setText(prList.get(position).getCust_name());
        holder.binding.tvCustID.setText(prList.get(position).getCust_id());
        holder.binding.tvQuotAMount.setText(prList.get(position).getQuotation());
        switch (prList.get(position).getRemarks()) {
            case "Sent For Approval":
                holder.binding.tvStatus.setTextColor(Color.BLUE);
                holder.binding.tvStatus.setText(prList.get(position).getRemarks());
                break;
            case "Customer Approved":
                holder.binding.tvStatus.setTextColor(Color.parseColor("#25CE16"));
                holder.binding.tvStatus.setText(prList.get(position).getRemarks());
                break;
            default:
                holder.binding.tvStatus.setTextColor(Color.parseColor("#D60129"));
                holder.binding.tvStatus.setText("Rejected");
                holder.binding.tvStatus.setOnClickListener(v ->
                        Toast.makeText(context, prList.get(position).getRemarks(), Toast.LENGTH_LONG).show());
                break;
        }
        holder.binding.tvViewdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!prList.get(position).getCust_id().equals("")) {
                    listener.onitemClick(prList.get(position).getCust_id());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return prList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemViewCustomerDetailsBinding binding;

        public ViewHolder(ItemViewCustomerDetailsBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }

    // method for filtering our recyclerview items.
    public void filterList(ArrayList<ViewCustomerListResponse.custList> filterllist) {
        // below line is to add our filtered
        // list in our course array list.
        prList = filterllist;
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged();
    }
}
