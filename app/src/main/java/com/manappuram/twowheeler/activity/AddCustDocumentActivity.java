package com.manappuram.twowheeler.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.ceylonlabs.imageviewpopup.ImagePopup;
import com.manappuram.twowheeler.R;
import com.manappuram.twowheeler.databinding.ActivityAddCustDocumentBinding;
import com.manappuram.twowheeler.request.AddCustDocumentRequest;
import com.manappuram.twowheeler.request.CustIDCreationRequest;
import com.manappuram.twowheeler.utils.ImageUtils;
import com.manappuram.twowheeler.utils.Utility;
import com.manappuram.twowheeler.viewModel.LoginViewModel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class AddCustDocumentActivity extends AppCompatActivity {

    ActivityAddCustDocumentBinding binding;
    LoginViewModel viewModel;
    String name = "", dob = "", age = "", profession = "", loan_amount = "", state_id = "", quot_amount = "", district_id = "", branch_id = "";
    String cust_name = "";
    String doc_seq = "";
    String cust_mob = "";
    String pancardNo = "";
    String cibil_score = "";

    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    private static final int PANSELECT = 11;
    private static final int QUESTION_SELECT = 22;
    private static final int BANK_SELECT = 33;

    private int SELECT_TYPE = 0;
    String PANCOPY, QUESCOPY, BANKCOPY;
    public String sessionId = "", empCode = "";

    private static final int REQUEST_CAPTURE_IMAGE = 1;
    private static final int REQUEST_GALLERY = 2;


    Uri picUri;

    private ArrayList<String> permissionsToRequest;
    private ArrayList<String> permissionsRejected = new ArrayList<>();
    private ArrayList<String> permissions = new ArrayList<>();

    private final static int ALL_PERMISSIONS_RESULT = 107;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_cust_document);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        sharedPreferences = getSharedPreferences("ess-app", Context.MODE_PRIVATE);

        editor = sharedPreferences.edit();
        sessionId = sharedPreferences.getString("sessionId", "");
        empCode = sharedPreferences.getString("empCode", "");


        cust_name = getIntent().getStringExtra("cust_name");
        doc_seq = getIntent().getStringExtra("doc_seq");
        cust_mob = getIntent().getStringExtra("cust_mob");
        pancardNo = getIntent().getStringExtra("pancardNo");
        cibil_score= getIntent().getStringExtra("cibil_score");
        profession= getIntent().getStringExtra("profession");
        loan_amount = getIntent().getStringExtra("loan_amount");
        state_id = getIntent().getStringExtra("state_id");
        district_id = getIntent().getStringExtra("district_id");
        branch_id = getIntent().getStringExtra("branch_id");
        dob = getIntent().getStringExtra("dob");



        final ImagePopup imagePopup = new ImagePopup(this);

        imagePopup.setBackgroundColor(Color.BLACK);  // Optional
        imagePopup.setFullScreen(true); // Optional
        imagePopup.setHideCloseIcon(true);  // Optional
        imagePopup.setImageOnClickClose(true);

        binding.etPanCard.setText(pancardNo);
        binding.panImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** Initiate Popup view **/
                imagePopup.initiatePopup(binding.panImage.getDrawable());
                imagePopup.viewPopup();
            }
        });
        binding.questionImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** Initiate Popup view **/
                imagePopup.initiatePopup(binding.questionImage.getDrawable());
                imagePopup.viewPopup();
            }
        });
        binding.bankImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** Initiate Popup view **/
                imagePopup.initiatePopup(binding.bankImage.getDrawable());
                imagePopup.viewPopup();
            }
        });

        binding.tvContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isValidPanCardNo(binding.etPanCard.getText().toString())) {
                    if (PANCOPY != null && QUESCOPY != null && BANKCOPY != null) {
                        sendDocumentRetrofit();

                    } else
                        Toast.makeText(AddCustDocumentActivity.this, "Please upload all documents", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddCustDocumentActivity.this, "Please enter Valid PAN number", Toast.LENGTH_SHORT).show();
                }

            }
        });
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.tvUploadPhoto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SELECT_TYPE = PANSELECT;
                startActivityForResult(getPickImageChooserIntent(), SELECT_TYPE);
            }
        });
        binding.tvUploadPhoto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SELECT_TYPE = QUESTION_SELECT;
                startActivityForResult(getPickImageChooserIntent(), SELECT_TYPE);
            }
        });
        binding.tvUploadBankStatement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SELECT_TYPE = BANK_SELECT;
                startActivityForResult(getPickImageChooserIntent(), SELECT_TYPE);

            }
        });


        permissions.add(CAMERA);
        permissions.add(WRITE_EXTERNAL_STORAGE);
        permissions.add(READ_EXTERNAL_STORAGE);
        permissionsToRequest = findUnAskedPermissions(permissions);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (permissionsToRequest.size() > 0)
                requestPermissions(permissionsToRequest.toArray(new String[permissionsToRequest.size()]), ALL_PERMISSIONS_RESULT);
        }
    }

    @Override
    public void onBackPressed(){

    }
    // Function to validate the PAN Card number.
    public static boolean isValidPanCardNo(String panCardNo) {
        String regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
        Pattern p = Pattern.compile(regex);
        // If the PAN Card number is empty return false
        if (panCardNo == null) {
            return false;
        }
        Matcher m = p.matcher(panCardNo);
        return m.matches();
    }

    public Intent getPickImageChooserIntent() {

        Uri outputFileUri = getCaptureImageOutputUri();

        List<Intent> allIntents = new ArrayList<>();
        PackageManager packageManager = getPackageManager();

        Intent captureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        List<ResolveInfo> listCam = packageManager.queryIntentActivities(captureIntent, 0);
        for (ResolveInfo res : listCam) {
            Intent intent = new Intent(captureIntent);
            intent.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
            intent.setPackage(res.activityInfo.packageName);
            if (outputFileUri != null) {
                intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
            }
            allIntents.add(intent);
        }

        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        List<ResolveInfo> listGallery = packageManager.queryIntentActivities(galleryIntent, 0);
        for (ResolveInfo res : listGallery) {
            Intent intent = new Intent(galleryIntent);
            intent.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
            intent.setPackage(res.activityInfo.packageName);
            allIntents.add(intent);
        }

        Intent mainIntent = allIntents.get(allIntents.size() - 1);
        for (Intent intent : allIntents) {
            if (intent.getComponent().getClassName().equals("com.android.documentsui.DocumentsActivity")) {
                mainIntent = intent;
                break;
            }
        }
        allIntents.remove(mainIntent);

        Intent chooserIntent = Intent.createChooser(mainIntent, "Select source");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, allIntents.toArray(new Parcelable[allIntents.size()]));

        return chooserIntent;
    }

    private Uri getCaptureImageOutputUri() {
        Uri outputFileUri = null;
        File getImage = getExternalFilesDir("");
        if (getImage != null) {
            outputFileUri = Uri.fromFile(new File(getImage.getPath(), "temp.png"));
        }
        return outputFileUri;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //****
        super.onActivityResult(requestCode, resultCode, data);
        //****
        Log.e("Request code", String.valueOf(requestCode));
        if (resultCode == Activity.RESULT_OK) {


            String filePath = getImageFilePath(data);
            if (filePath != null) {

                long fileSize = ImageUtils.checkImageSize(filePath);

                if (fileSize < 5000000) {
                    Bitmap selectedImage = BitmapFactory.decodeFile(filePath);

                    try {
                        selectedImage = ImageUtils.rotateImageIfRequired(this, selectedImage, Uri.fromFile(new File(filePath)));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    //Compress Image
                    byte[] bitmapdata = ImageUtils.compressToBitmap(selectedImage);
                    selectedImage.recycle();


                    if (requestCode == PANSELECT) {
                        binding.panImage.setVisibility(View.VISIBLE);
                        binding.panImage.setImageBitmap(BitmapFactory.decodeByteArray(bitmapdata, 0, bitmapdata.length));
                        binding.panImageid.setVisibility(View.VISIBLE);
                        binding.panImageid.setText(filePath.substring(filePath.lastIndexOf("/") + 1));
                        PANCOPY = Base64.encodeToString(bitmapdata, Base64.DEFAULT);
                    } else if (requestCode == QUESTION_SELECT) {
                        binding.questionImage.setVisibility(View.VISIBLE);
                        binding.questionImage.setImageBitmap(BitmapFactory.decodeByteArray(bitmapdata, 0, bitmapdata.length));
                        binding.questionImageid.setVisibility(View.VISIBLE);
                        binding.questionImageid.setText(filePath.substring(filePath.lastIndexOf("/") + 1));
                        QUESCOPY = Base64.encodeToString(bitmapdata, Base64.DEFAULT);
                    } else if (requestCode == BANK_SELECT) {
                        binding.bankImage.setVisibility(View.VISIBLE);
                        binding.bankImage.setImageBitmap(BitmapFactory.decodeByteArray(bitmapdata, 0, bitmapdata.length));
                        binding.bankImageid.setVisibility(View.VISIBLE);
                        binding.bankImageid.setText(filePath.substring(filePath.lastIndexOf("/") + 1));
                        BANKCOPY = Base64.encodeToString(bitmapdata, Base64.DEFAULT);
                    }

                } else
                    showsnackbar("Image size should not exceed 5 MB");
            }


        }


    }


    private String getImageFromFilePath(Intent data) {
        boolean isCamera = data == null || data.getData() == null;

        if (isCamera) return getCaptureImageOutputUri().getPath();
        else return getPathFromURI(data.getData());

    }

    public String getImageFilePath(Intent data) {
        return getImageFromFilePath(data);
    }

    private String getPathFromURI(Uri contentUri) {
        String[] proj = {MediaStore.Audio.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelable("pic_uri", picUri);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // get the file url
        picUri = savedInstanceState.getParcelable("pic_uri");
    }

    private ArrayList<String> findUnAskedPermissions(ArrayList<String> wanted) {
        ArrayList<String> result = new ArrayList<String>();

        for (String perm : wanted) {
            if (!hasPermission(perm)) {
                result.add(perm);
            }
        }

        return result;
    }

    private boolean hasPermission(String permission) {
        if (canMakeSmores()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return (checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED);
            }
        }
        return true;
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    private boolean canMakeSmores() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        switch (requestCode) {

            case ALL_PERMISSIONS_RESULT:
                for (String perms : permissionsToRequest) {
                    if (!hasPermission(perms)) {
                        permissionsRejected.add(perms);
                    }
                }

                if (permissionsRejected.size() > 0) {


                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (shouldShowRequestPermissionRationale(permissionsRejected.get(0))) {
                            showMessageOKCancel("These permissions are mandatory for the application. Please allow access.",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                requestPermissions(permissionsRejected.toArray(new String[permissionsRejected.size()]), ALL_PERMISSIONS_RESULT);
                                            }
                                        }
                                    });
                            return;
                        }
                    }

                }

                break;
        }

    }

    private void sendDocumentRetrofit() {
        AddCustDocumentRequest request = new AddCustDocumentRequest();


        request.setCust_name(cust_name);
        request.setDoc_seq(doc_seq);
        request.setQuestioncopy(QUESCOPY);
        request.setPan_no(pancardNo);
        request.setPanCopy(PANCOPY);
        request.setBank_statement(BANKCOPY);
        request.setStatus("1");
        request.setUpload_by(empCode);
        request.setCust_mob(cust_mob);
        request.setSessionId(sessionId);
        viewModel.addCustDocuments(request);
        Utility.setProgressbar(AddCustDocumentActivity.this);
        viewModel.getAddCustDocumentResponseMutableLiveData().observe(this, addCustomerResponse -> {

            if (addCustomerResponse != null) {
                if (addCustomerResponse.getStatus().equals("111")) { // remember to change back
                    Utility.cancelProgressbar();
                    Toast.makeText(this, addCustomerResponse.getResult(), Toast.LENGTH_SHORT).show();
                    generateCustIDRetrofit();
//                    Intent intent = new Intent(this, InternalScoreCardActivity.class);
//                    startActivity(intent);

                } else {
                    Utility.cancelProgressbar();
                    Toast.makeText(this, addCustomerResponse.getResult(), Toast.LENGTH_SHORT).show();
                }
            }

            viewModel.getLoginRepository().getErrorsMutable().observe(this, error -> {
                Utility.cancelProgressbar();

                if (error.getContent() != null) {
                    //    Utility.cancelProgressbar();
                    Toast.makeText(AddCustDocumentActivity.this, error.getContent().getResult(), Toast.LENGTH_SHORT).show();
                }
            });

        });
    }

    private void generateCustIDRetrofit() {
        CustIDCreationRequest request = new CustIDCreationRequest();
        request.setFlag("CUSTID_CREATION");
        request.setCust_name(cust_name);
        request.setCust_mob(cust_mob);
        request.setDoc_seq(doc_seq);
        request.setState_id(state_id); // 06 Oct
        request.setDistrict_id(district_id);
        request.setLoan_amt(loan_amount);
        request.setProfession(profession);
        request.setUpdated_by(empCode);
        request.setBranch_id(branch_id);
        request.setDob(dob);
        request.setSessionId(sessionId);
        viewModel.generateCustID(request);
        viewModel.getCustIDCreationResponseMutableLiveData().observe(this, custIDResponse -> {

            if (custIDResponse != null) {
                if (custIDResponse.getStatus().equals("111")) {
                    Toast.makeText(this, "Cust id is: " + custIDResponse.getCust_id(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, InternalScoreCardActivity.class);
                    intent.putExtra("cust_id", custIDResponse.getCust_id());
                    intent.putExtra("cibil_score", cibil_score);
                    startActivity(intent);
                    finish();

                } else {

                    Toast.makeText(this, custIDResponse.getStatus() + "" + custIDResponse.getResult() + "" + custIDResponse.getCust_id(), Toast.LENGTH_SHORT).show();
                }
            }

            viewModel.getLoginRepository().getErrorsMutable().observe(this, error -> {
                if (error.getContent() != null) {
                    Toast.makeText(this, error.getContent().getResult(), Toast.LENGTH_SHORT).show();
                }
            });

        });

    }

    private void showsnackbar(String msg) {
        Utility.showSnackbar(binding.getRoot(), msg);
    }
}