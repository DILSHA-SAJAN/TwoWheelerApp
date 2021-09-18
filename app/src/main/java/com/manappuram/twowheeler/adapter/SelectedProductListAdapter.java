package com.manappuram.twowheeler.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.manappuram.twowheeler.R;
import com.manappuram.twowheeler.activity.AddCustomerActivity;
import com.manappuram.twowheeler.databinding.ItemSelectedProductBinding;
import com.manappuram.twowheeler.response.ProductListResponse;

import java.util.ArrayList;

public class SelectedProductListAdapter extends RecyclerView.Adapter<SelectedProductListAdapter.ViewHolder> {

    Context context;
    ArrayList<ProductListResponse> prList;
    public AddCustomerActivity.OnSelectedProdClickListener prodClickListener;

    public SelectedProductListAdapter(Context context, ArrayList<ProductListResponse> prList) {
        this.context = context;
        this.prList = prList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSelectedProductBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_selected_product, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.name.setText(prList.get(position).getProductName());
        holder.binding.selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prodClickListener.ondeleteClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (prList != null)
            return prList.size();

        else
            return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ItemSelectedProductBinding binding;

        public ViewHolder(@NonNull ItemSelectedProductBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
