package com.manappuram.twowheeler.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.snackbar.Snackbar;
import com.manappuram.twowheeler.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Utility {
    private static SharedPreferences.Editor sp_editor;
    public static final String auth_key = "AUTH_KEY";
    public static final String user_emp_code = "user_emp_code";
    public static final String user_name = "user_name";
    private static SharedPreferences sp;
    private static Dialog progressDialog;
    private static AlertDialog.Builder builder;
    private static AlertDialog alertDialog;


    public static String encodeString(String text) {
        try {
            String CIPHER_KEY = "8080808080808080";
            String CIPHER_IV = "8080808080808080";
            return Encrypt(text, CIPHER_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String Encrypt(String text, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] keyBytes = new byte[16];
        byte[] b = key.getBytes("UTF-8");
        int len = b.length;
        if (len > keyBytes.length)
            len = keyBytes.length;
        System.arraycopy(b, 0, keyBytes, 0, len);
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

        byte[] results = cipher.doFinal(text.getBytes("UTF-8"));

        String Base64encodeString = android.util.Base64.encodeToString(results, android.util.Base64.DEFAULT);

        return Base64encodeString.substring(0, Base64encodeString.length() - 2);
    }

    /**
     * Saves key value pair in shared preference
     *
     * @param key   key to save data
     * @param value the value to be saved against the key
     */
    public static void save_data(String key, String value) {
        try {

            String encrypted = AESUtils.encrypt(value);
            sp_editor.putString(key, encrypted);
            sp_editor.apply();
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

    /**
     * Fetches value by passing the key from shared preference
     *
     * @param key to retrieve the value of the key
     * @throws NullPointerException if the instance of the Shared Preference is null
     */
    public static String get_saved_data(String key) throws NullPointerException {
        String decrypted = "";
        try {
            decrypted = AESUtils.decrypt(sp.getString(key, ""));

        } catch (Exception e) {
//            e.printStackTrace();
        }
        return decrypted;
    }

    public static String getDate(int dayOfMonth, int month, int year) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        calendar1.set(Calendar.MONTH, month);
        calendar1.set(Calendar.YEAR, year);

        return getDate(calendar1);
    }
    public static String getDate(Calendar calendar) {
        try {
            String outPattern = "dd-MMM-yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(outPattern);
            String dateOut = simpleDateFormat.format(calendar.getTime());
            return dateOut;
        } catch (Exception e) {
            return "";
        }
    }
    public static String getCIBILDate(int dayOfMonth, int month, int year) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        calendar1.set(Calendar.MONTH, month);
        calendar1.set(Calendar.YEAR, year);

        return getCIBILDate(calendar1);
    }

    public static String getCIBILDate(Calendar calendar) {
        try {
            String outPattern = "ddMMyyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(outPattern);
            String dateOut = simpleDateFormat.format(calendar.getTime());
            return dateOut;
        } catch (Exception e) {
            return "";
        }
    }



    public static void  setProgressbar(Context context) {


        progressDialog = new Dialog(context, R.style.AlertDialogCustom);
        progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        progressDialog.setContentView(R.layout.custom_progressbar);
        progressDialog.setCancelable(false);

        progressDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        progressDialog.getWindow().getAttributes().windowAnimations = R.style.AlertDialogCustom;
        progressDialog.getWindow().setGravity(Gravity.CENTER);

        if (!((Activity) context).isFinishing()) {
            progressDialog.show();
        }

    }

    public static void cancelProgressbar() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    public static void showSnackbar(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show();
    }

    public static void showSnackbar(View view, int msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show();
    }

    public static void showAlertDialog(Context context, String msg, DialogInterface.OnClickListener listener) {

        builder = new AlertDialog.Builder(context);
        builder.setMessage(msg);
        builder.setCancelable(false);

        builder.setPositiveButton("OK", listener);
        alertDialog = builder.create();
        alertDialog.show();


    }

    public static void dismissAlertDialog() {

        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }

    }

    public static boolean isOnline(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        //should check null because in airplane mode it will be null
        return (netInfo != null && netInfo.isConnected());
    }

}
