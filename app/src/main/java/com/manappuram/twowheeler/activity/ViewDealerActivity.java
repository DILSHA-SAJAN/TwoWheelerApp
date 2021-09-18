package com.manappuram.twowheeler.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.manappuram.twowheeler.R;
import com.manappuram.twowheeler.adapter.ViewDealerItemAdapter;
import com.manappuram.twowheeler.databinding.ActivityViewDealerBinding;
import com.manappuram.twowheeler.request.ViewDealerListRequest;
import com.manappuram.twowheeler.response.ViewDealerListResponse;
import com.manappuram.twowheeler.utils.Utility;
import com.manappuram.twowheeler.viewModel.LoginViewModel;

import java.util.ArrayList;

public class ViewDealerActivity extends AppCompatActivity {
    ActivityViewDealerBinding binding;
    LoginViewModel viewModel;
    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public String sessionId = "";
    public String empCode = "";
    ViewDealerItemAdapter adapter;



    ArrayList<ViewDealerListResponse.DealerList> dealer_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("ess-app", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        sessionId = sharedPreferences.getString("sessionId", "");
        empCode = sharedPreferences.getString("empCode", "");
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_dealer);
        adapter = new ViewDealerItemAdapter(ViewDealerActivity.this, dealer_list);
        binding.recycleDealer.setAdapter(adapter);
        getDealers();
        searchFunction();

        binding.tvAddDealer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddDealerActivity.class);
                startActivity(intent);
            }
        });
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getDealers() {
        ViewDealerListRequest request = new ViewDealerListRequest();
        request.setFlag("VIEW_DEALERS");
        request.setEmp_code(empCode);
        request.setSessionId(sessionId);

        viewModel.getDealerList(request);
        Utility.setProgressbar(this);

        viewModel.getViewDealerListResponseMutableLiveData().observe(this, dealerListResponse1 -> {
            Utility.cancelProgressbar();
            if (dealerListResponse1 != null) {
                if (dealerListResponse1.getStatus().equals("111")) {
                    if (dealerListResponse1.getDealerList().size() > 0) {
                        dealer_list.addAll(dealerListResponse1.getDealerList());
                        adapter.notifyDataSetChanged();
                    }
                } else {
                    Toast.makeText(this, dealerListResponse1.getResult(), Toast.LENGTH_SHORT).show();
                }


            }
        });

        viewModel.getLoginRepository().getErrorsMutable().observe(this, error -> {


            if (error.getContent() != null) {
                Utility.cancelProgressbar();
                Toast.makeText(this, error.getContent().getResult(), Toast.LENGTH_SHORT).show();
            }
        });

        adapter.listener = new DealerIDSelectListener() {
            @Override
            public void onitemClick(String dealer_id) {

                Intent intent = new Intent(getApplicationContext(), ViewIndividualDealerActivity.class);
                intent.putExtra("dealer_id", dealer_id);
                startActivity(intent);
                //  finish();
            }
        };

    }

    private void searchFunction() {
        // below line is to call set on query text listener method.
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                filter(newText);
                return false;
            }
        });

    }

    private void filter(String text) {
        // creating a new array list to filter our data.
        ArrayList<ViewDealerListResponse.DealerList> filteredlist = new ArrayList<>();

        // running a for loop to compare elements.
        for (ViewDealerListResponse.DealerList item : dealer_list) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.getOWNER_NAME().toLowerCase().contains(text.toLowerCase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item);
            }
        }
//        if (filteredlist.isEmpty()) {
//            // if no item is added in filtered list we are
//            // displaying a toast message as no data found.
////            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
//        } else {
//            // at last we are passing that filtered
//            // list to our adapter class.
            adapter.filterList(filteredlist);
//        }
    }

    public interface DealerIDSelectListener {

        void onitemClick(String dealer_id);
    }


}