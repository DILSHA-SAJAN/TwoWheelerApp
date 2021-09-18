package com.manappuram.twowheeler.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.manappuram.twowheeler.R;
import com.manappuram.twowheeler.activity.ViewDealerActivity;
import com.manappuram.twowheeler.databinding.ItemViewDealerDetailsBinding;
import com.manappuram.twowheeler.response.ViewDealerListResponse;

import java.util.ArrayList;

public class ViewDealerItemAdapter extends RecyclerView.Adapter<ViewDealerItemAdapter.ViewHolder>  {

    Context context;
    public ArrayList<ViewDealerListResponse.DealerList> prList;
    public ViewDealerActivity.DealerIDSelectListener listener;
    //

    public ViewDealerItemAdapter(Context context, ArrayList<ViewDealerListResponse.DealerList> prList) {
        this.context = context;
        this.prList = prList;
    }



    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        ItemViewDealerDetailsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_view_dealer_details, parent, false);
        return new ViewDealerItemAdapter.ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.tvCustName.setText(prList.get(position).getOWNER_NAME());
        holder.binding.tvCustID.setText(prList.get(position).getDEALER_ID());
        holder.binding.tvQuotAMount.setText(prList.get(position).getMOB());

        holder.binding.tvViewdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!prList.get(position).getDEALER_ID().equals("")) {
                    listener.onitemClick(prList.get(position).getDEALER_ID());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return prList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemViewDealerDetailsBinding binding;

        public ViewHolder( ItemViewDealerDetailsBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }

    // method for filtering our recyclerview items.
    public void filterList(ArrayList<ViewDealerListResponse.DealerList> filterllist) {
        // below line is to add our filtered
        // list in our course array list.
        prList = filterllist;
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged();
    }
}
