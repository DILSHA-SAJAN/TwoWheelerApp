package com.manappuram.twowheeler.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.manappuram.twowheeler.R;
import com.manappuram.twowheeler.activity.MisReportActivity;
import com.manappuram.twowheeler.activity.ViewDealerActivity;
import com.manappuram.twowheeler.databinding.ItemViewDealerDetailsBinding;
import com.manappuram.twowheeler.databinding.ItemprioritylistBinding;
import com.manappuram.twowheeler.response.MisReportResponse;
import com.manappuram.twowheeler.response.ViewDealerListResponse;

import java.util.ArrayList;
import java.util.List;

public class MisDataAdapter extends RecyclerView.Adapter<MisDataAdapter.ViewHolder> {

    Context context;
    ArrayList<MisReportResponse.MISReportList> dtlllist;
    public MisReportActivity.misSelectListener listener;

    public MisDataAdapter(Context context, ArrayList<MisReportResponse.MISReportList> dtlllist) {
        this.context = context;
        this.dtlllist = dtlllist;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemprioritylistBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.itemprioritylist, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.binding.name.setText((dtlllist.get(position)).getCust_name());
        holder.binding.totlead.setText((dtlllist.get(position)).getCust_id());
        holder.binding.hotitem.setText((dtlllist.get(position)).getUploaded_by());
        holder.binding.wormitem.setText((dtlllist.get(position)).getDealer_name());
        holder.binding.colditem.setText((dtlllist.get(position)).getState());
        holder.binding.notreachitem.setText((dtlllist.get(position)).getBRANCH_NAME());
        holder.binding.notinterestitem.setText((dtlllist.get(position)).getTot_int_score());
        holder.binding.laststatusitem.setText((dtlllist.get(position)).getRemarks());

    }

    @Override
    public int getItemCount() {
        if (dtlllist != null)
            return dtlllist.size();
        else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

       ItemprioritylistBinding binding;

        public ViewHolder(@NonNull ItemprioritylistBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;

        }
    }

}
