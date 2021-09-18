package com.manappuram.twowheeler.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class BaseActivity extends AppCompatActivity {


    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Activity mActivity;

    public String empCode = "";
    public String sessionId = "";
    public String empName = "";
    public String postId = "";
    public String brId = "";
    public String doorKey = "";
    public String areaId = "";
    public String regId = "";
    public String zoneId = "";
    public String departId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

//        StaticVariableInitializer.initConstants();
//        Fabric.with(this, new Crashlytics());
//        initAnalytics();

        sharedPreferences = getSharedPreferences("ess-app", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

        empCode = sharedPreferences.getString("empCode", "");
        sessionId = sharedPreferences.getString("sessionId", "");
        empName = sharedPreferences.getString("name", "");
        postId = sharedPreferences.getString("postId", "");
        brId = sharedPreferences.getString("brId", "");
        departId = sharedPreferences.getString("departId", "");
        areaId = sharedPreferences.getString("areaId", "");
        regId = sharedPreferences.getString("regionId", "");
        zoneId = sharedPreferences.getString("zoneId", "");

    }



    @Override
    protected void onResume() {
        super.onResume();
        doorKey = sharedPreferences.getString("doorKey", "");
        Log.d("doorKeyonResume", "-->" + doorKey);
    }

    //    /**
//     * Initialize google Analytics
//     */
//    private void initAnalytics() {
//        Tracker mTracker = ESSApplication.getAppInstance().getDefaultTracker();
//        mTracker.setScreenName(this.getClass().getName());
//        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
//    }
//
//    /**
//     * Get Application Instance
//     *
//     * @return
//     */
//    public ESSApplication getApp() {
//        return (ESSApplication) this.getApplication();
//    }
//
//    /**
//     * Update session time on user touch event
//     */
//    @Override
//    public void onUserInteraction() {
//        super.onUserInteraction();
//        getApp().touch();
//    }
//
//
//
//
////    @Override
////    protected void attachBaseContext(Context base) {
////        super.attachBaseContext(LocaleHelper.onAttach(base));
////    }
//
//    @Override
//    public void finish() {
//        super.finish();
//    }
//
//    /**
//     * Override Activity Transition
//     *
//     * @param intent
//     */
//    @Override
//    public void startActivity(Intent intent) {
//        super.startActivity(intent);
//        overridePendingTransitionEnter();
//    }
//
//    /**
//     * Overrides the pending Activity transition by performing the "Enter" animation.
//     */
//    protected void overridePendingTransitionEnter() {
//        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
//    }
//
//    /**
//     * Overrides the pending Activity transition by performing the "Exit" animation.
//     */
//    protected void overridePendingTransitionExit() {
//        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
//    }
//
//    public void showSessionDialog() {
//        new AlertDialog.Builder(this)
//                .setTitle(getString(R.string.session_expire))
//                .setMessage(getString(R.string.your_session_exp))
//                .setCancelable(false)
//                .setPositiveButton(getString(R.string.login), (dialog, id) -> {
//                    Intent intent = new Intent(this, LoginActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                    startActivity(intent);
//                    finish();
//                })
//                .show();
//    }
//
//
////    public void showBackPopup() {
////        new AlertDialog.Builder(this)
////                .setTitle(getString(R.string.session_expire))
////                .setMessage(getString(R.string.exit_msg))
////                .setCancelable(false)
////                .setPositiveButton(getString(R.string.ok), (dialog, id) -> {
////                })
////                .show();
////    }
//
////    @Override
////    public void onConfigurationChanged(Configuration newConfig) {
////        super.onConfigurationChanged(newConfig);
////        LocaleHelper.onAttach(BaseActivity.this);
////        // Checks whether a hardware keyboard is available
////        if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO) {
////            KeyboardVisibilityListenerHandler.getHandler().onKeyboardVisible();
////        } else if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_YES) {
////            KeyboardVisibilityListenerHandler.getHandler().onKeyboardHidden();
////        }
////    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//        LocaleHelper.onAttach(this);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        LocaleHelper.onAttach(this);
//    }
//
//    @Override
//    public void onSaveInstanceState(Bundle outState){
//        super.onSaveInstanceState(outState);
//        outState.putBoolean("restart",true);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState){
//        super.onRestoreInstanceState(savedInstanceState);
//        if(savedInstanceState.getBoolean("restart",false)){
//            showSessionDialog();
//        }
//    }

}