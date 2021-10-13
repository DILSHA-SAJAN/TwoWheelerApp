package com.manappuram.twowheeler.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;

import com.manappuram.twowheeler.R;
import com.manappuram.twowheeler.databinding.ActivityDocWebViewBinding;
import com.manappuram.twowheeler.utils.Utility;

public class DocWebViewActivity extends AppCompatActivity {

    ActivityDocWebViewBinding binding;
    String docUrl = "https://onpay.online.manappuram.com/TwowheelerService/Images/"; // UAT
   // String docUrl = "https://online.manappuram.com/TwowheelerService/Images/"; // Production
    String doc_name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_doc_web_view);
        doc_name = getIntent().getStringExtra("doc_name");



        binding.webViewDocument.getSettings().setLoadsImagesAutomatically(true);
        binding.webViewDocument.getSettings().setJavaScriptEnabled(true);
//        binding.webViewDocument.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        binding.webViewDocument.getSettings().setLoadWithOverviewMode(true);
        binding.webViewDocument.getSettings().setUseWideViewPort(true);
        binding.webViewDocument.getSettings().setBuiltInZoomControls(true);
        Utility.setProgressbar(this);
        binding.webViewDocument.setWebViewClient(new WebViewClient());
        binding.webViewDocument.loadUrl(docUrl+doc_name);
    }

    public class WebViewClient extends android.webkit.WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Utility.cancelProgressbar();
        }
    }

    @Override
    public void onBackPressed(){
        doc_name="";
        finish();
//        if(binding.webViewDocument.canGoBack()){
//            binding.webViewDocument.goBack();
//        } else {
//            super.onBackPressed();
//        }
    }
}