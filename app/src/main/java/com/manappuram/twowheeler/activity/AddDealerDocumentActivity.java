package com.manappuram.twowheeler.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.manappuram.twowheeler.R;
import com.manappuram.twowheeler.databinding.ActivityAddDealerBinding;
import com.manappuram.twowheeler.databinding.ActivityAddDealerDocumentBinding;
import com.manappuram.twowheeler.databinding.ActivityViewCustomerBinding;
import com.manappuram.twowheeler.databinding.ImageUploadpopupBinding;
import com.manappuram.twowheeler.request.AddDealerDocumentRequest;
import com.manappuram.twowheeler.request.DealerIDCreationRequest;
import com.manappuram.twowheeler.utils.Utility;
import com.manappuram.twowheeler.viewModel.LoginViewModel;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddDealerDocumentActivity extends AppCompatActivity {
    ActivityAddDealerDocumentBinding binding;
    ImageUploadpopupBinding imageUploadpopupBinding;
    LoginViewModel viewModel;
    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public String sessionId = "";
    public String empCode = "";
    private int SELECT_TYPE = 0;
    private static final int REQUEST_CAPTURE_IMAGE = 1;
    private static final int REQUEST_GALLERY = 2;
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 7;
    private static final int REQUEST_CAPTURE_IMAGE_QUESTION = 3;
    private static final int REQUEST_GALLERY_QUESTION = 4;
    private static final int PANSELECT = 11;
    private static final int AADHARSELECT = 12;
    private static final int QUESTION_SELECT = 22;
    private static final int BANK_SELECT = 33;
    private static final int AGREE_SELECT = 44;
    private static final int PLEDGE_SELECT = 55;

    String PANCOPY = "", AADHARCOPY = "", QUESTIONCOPY = "", BANKCOPY = "", AGREECOPY = "", PLEDGECOPY = "";
    String gold_backed = "yes";

    BottomSheetDialog bottomSheetDialog;
    byte[] imageInByte;

    String owner_name = "";
    String MOB = "";
    String doc_sequence = "";
    String id_no = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_dealer_document);


        sharedPreferences = getSharedPreferences("ess-app", Context.MODE_PRIVATE);

        owner_name = getIntent().getStringExtra("owner_name");
        MOB = getIntent().getStringExtra("MOB");
        doc_sequence = getIntent().getStringExtra("doc_sequence");
        id_no = getIntent().getStringExtra("id_no");

        editor = sharedPreferences.edit();
        sessionId = sharedPreferences.getString("sessionId", "");
        empCode = sharedPreferences.getString("empCode", "");
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.tvAddDocs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    addDocsRetrofit();
                }

            }
        });
        binding.tvAddAadhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Aadhar
                SELECT_TYPE = AADHARSELECT;
                createBottomSheetDialog();
                imageupload();
            }
        });
        binding.tvAddPan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //PAN card
                SELECT_TYPE = PANSELECT;
                createBottomSheetDialog();
                imageupload();
            }
        });
        binding.tvQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // Question card
                SELECT_TYPE = QUESTION_SELECT;
                createBottomSheetDialog();
                imageupload();
            }
        });
        binding.tvChooseBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SELECT_TYPE = BANK_SELECT;
                createBottomSheetDialog();
                imageupload();
            }
        });
        binding.tvChooseAgreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SELECT_TYPE = AGREE_SELECT;
                createBottomSheetDialog();
                imageupload();
            }
        });
        binding.tvChoosePledge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SELECT_TYPE = PLEDGE_SELECT;
                createBottomSheetDialog();
                imageupload();
            }
        });
        binding.tvGbYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gold_backed = "yes";
                binding.tvGbYes.setBackgroundResource(R.drawable.curved_black_button);
                binding.tvGbYes.setTextColor(Color.WHITE);
                binding.tvGbNo.setBackgroundResource(R.drawable.view_black_border);
                binding.tvGbNo.setTextColor(Color.parseColor("#2F3D4A"));

            }
        });
        binding.tvGbNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gold_backed = "no";
                binding.tvGbNo.setBackgroundResource(R.drawable.curved_black_button);
                binding.tvGbNo.setTextColor(Color.WHITE);
                binding.tvGbYes.setBackgroundResource(R.drawable.view_black_border);
                binding.tvGbYes.setTextColor(Color.parseColor("#2F3D4A"));
            }
        });

    }


    private boolean isValid() {
        if (PANCOPY.equals("") || AADHARCOPY.equals("") || QUESTIONCOPY.equals("") || BANKCOPY.equals("") || AGREECOPY.equals("") || PLEDGECOPY.equals("")) {

//            Toast.makeText(this, ""+PANCOPY+AADHARCOPY+, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Please upload all documents! ", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void addDocsRetrofit() {
        AddDealerDocumentRequest request = new AddDealerDocumentRequest();
        request.setDealer(owner_name);
        request.setDoc_seq(doc_sequence);
        request.setQuestioncopy(QUESTIONCOPY);
        request.setPan_card(PANCOPY);
        request.setAadhar(AADHARCOPY);
        request.setBank_statement(BANKCOPY);
        request.setPledge_form(PLEDGECOPY);
        request.setAgreement(AGREECOPY);
        request.setGold_backed(gold_backed);
        request.setUpload_by(empCode);
        request.setDeal_mob(MOB);
//        Log.v("AGREECOPY",request.getAgreement());
        request.setStatus("1");
        request.setSessionId(sessionId);
        viewModel.addDealerDocuments(request);
        Utility.setProgressbar(this);
        viewModel.getAddDealerDocumentResponseMutableLiveData().observe(this, addDealDocResponse -> {

            if (addDealDocResponse != null) {
                if (addDealDocResponse.getStatus().equals("111")) {
                    Utility.cancelProgressbar();
                    Toast.makeText(this, addDealDocResponse.getResult(), Toast.LENGTH_SHORT).show();
                    generateDealerIDRetrofit();

                } else {
                    Utility.cancelProgressbar();
                    Toast.makeText(this, addDealDocResponse.getResult(), Toast.LENGTH_SHORT).show();
                }
            }

            viewModel.getLoginRepository().getErrorsMutable().observe(this, error -> {
                Utility.cancelProgressbar();
                if (error.getContent() != null) {
                    Toast.makeText(this, error.getContent().getResult(), Toast.LENGTH_SHORT).show();
                }
            });

        });

    }

    private void generateDealerIDRetrofit() {
        DealerIDCreationRequest request = new DealerIDCreationRequest();
        request.setFlag("DEALID_CREATION");
        request.setId_no(id_no);
        request.setMob(MOB);
        request.setDoc_seq(doc_sequence);
        request.setSessionId(sessionId);
        viewModel.generateDealerID(request);
        viewModel.getDealerIDCreationResponseMutableLiveData().observe(this, dealerIDResponse -> {
            if (dealerIDResponse != null) {
                if (dealerIDResponse.getStatus().equals("111")) {
                    Toast.makeText(this, dealerIDResponse.getResult() + ":" + dealerIDResponse.getDealer_id(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, ViewDealerActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, dealerIDResponse.getStatus() + "" + dealerIDResponse.getResult() + "" + dealerIDResponse.getDealer_id(), Toast.LENGTH_SHORT).show();
                }
            }
            viewModel.getLoginRepository().getErrorsMutable().observe(this, error -> {
                if (error.getContent() != null) {
                    Toast.makeText(this, error.getContent().getResult(), Toast.LENGTH_SHORT).show();
                }
            });
        });

    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.PNG, 30, bytes); // change to 100
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public static String getFileNameString(String pathName) {
        try {
            String path = pathName;
            return path != null ? path.substring(path.lastIndexOf("/") + 1) : "unknown";

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "unknown";
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        Log.d("in fragment on request", "Permission callback called-------");
        switch (requestCode) {
            case REQUEST_ID_MULTIPLE_PERMISSIONS: {
                Map<String, Integer> perms = new HashMap<>();
                // Initialize the map with both permissions
                perms.put(Manifest.permission.WRITE_EXTERNAL_STORAGE, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.CAMERA, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.READ_EXTERNAL_STORAGE, PackageManager.PERMISSION_GRANTED);
                // Fill with actual results from user
                if (grantResults.length > 0) {
                    for (int i = 0; i < permissions.length; i++)
                        perms.put(permissions[i], grantResults[i]);
                    // Check for both permissions
                    if (perms.get(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                            && perms.get(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED && perms.get(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        Log.d("in fragment on request", "CAMERA & WRITE_EXTERNAL_STORAGE READ_EXTERNAL_STORAGE permission granted");
                        // process the normal flow
                        //else any one or both the permissions are not granted
                    } else {
                        //permission is denied (this is the first time, when "never ask again" is not checked) so ask again explaining the usage of permission
//                        // shouldShowRequestPermissionRationale will return true
                        //show the dialog or snackbar saying its necessary and try again otherwise proceed with setup.
                        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) || ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA) || ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                            showDialogOK("Camera and Storage Permission required for this app",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            switch (which) {
                                                case DialogInterface.BUTTON_POSITIVE:
                                                    checkAndRequestPermissions();
                                                    break;
                                                case DialogInterface.BUTTON_NEGATIVE:
                                                    // proceed with logic by disabling the related features or quit the app.
                                                    break;
                                            }
                                        }
                                    });
                        }
                        //permission is denied (and never ask again is  checked)
                        //shouldShowRequestPermissionRationale will return false
                        else {
                            Toast.makeText(this, "Go to settings and enable permissions", Toast.LENGTH_LONG)
                                    .show();
                            //                            //proceed with logic by disabling the related features or quit the app.
                        }
                    }
                }
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            int type = SELECT_TYPE;
            if (requestCode == REQUEST_CAPTURE_IMAGE) {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                Bundle extras = data.getExtras();
                Bitmap photo = extras.getParcelable("data");
                setID(photo, bitmap, type);

            } else if (requestCode == REQUEST_GALLERY) {
                Uri selectedImage = data.getData();
                setIDfile(selectedImage, type);
            }
        }
    }

    private void showDialogOK(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(getApplicationContext())
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", okListener)
                .create()
                .show();
    }

    public static int sizeOf(Bitmap data) {
        return data.getRowBytes() * data.getHeight();
    }

    private void createBottomSheetDialog() {
        if (bottomSheetDialog == null) {
            imageUploadpopupBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.image_uploadpopup, null, false);

//            View view = LayoutInflater.from(this.inflate(R.layout.image_uploadpopup, null));
//            takephoto = view.findViewById(R.id.takePhoto);
//            uploadphoto = view.findViewById(R.id.uploadPhoto);
//            cancel = view.findViewById(R.id.cancel);

            imageUploadpopupBinding.takePhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (pictureIntent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(pictureIntent, REQUEST_CAPTURE_IMAGE);
                    }
                    bottomSheetDialog.dismiss();
                }
            });
            imageUploadpopupBinding.uploadPhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, REQUEST_GALLERY);
                    bottomSheetDialog.dismiss();
                }
            });
            imageUploadpopupBinding.cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bottomSheetDialog.dismiss();
                }
            });

            bottomSheetDialog = new BottomSheetDialog(this, R.style.BottomSheetDialogTheme);
            bottomSheetDialog.setContentView(imageUploadpopupBinding.getRoot());

        }
    }

    private void imageupload() {
        if (checkAndRequestPermissions()) {
            bottomSheetDialog.show();
        }
    }

    private boolean checkAndRequestPermissions() {
        int camera = ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.CAMERA);
        int wtite = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int read = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE);
        List<String> listPermissionsNeeded = new ArrayList<>();
        if (wtite != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (camera != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CAMERA);
        }
        if (read != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }

    private void setIDfile(Uri selectedImage, int requestcode) {

        if (requestcode == PANSELECT) {
            String[] filePath = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePath[0]);
            String picturePath = c.getString(columnIndex);
            c.close();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
            String file = getFileNameString(picturePath);
            binding.panImage.setVisibility(View.VISIBLE);
            binding.panImageid.setVisibility(View.VISIBLE);
            binding.panImage.setImageBitmap(thumbnail);
            binding.panImageid.setText(file);
            ReduceImageSize(requestcode, thumbnail);
        } else if (requestcode == AADHARSELECT) {
            String[] filePath = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePath[0]);
            String picturePath = c.getString(columnIndex);
            c.close();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
            String file = getFileNameString(picturePath);
            binding.aadharImage.setVisibility(View.VISIBLE);
            binding.adharImageid.setVisibility(View.VISIBLE);
            binding.aadharImage.setImageBitmap(thumbnail);
            binding.adharImageid.setText(file);
            ReduceImageSize(requestcode, thumbnail);
        } else if (requestcode == QUESTION_SELECT) {
            String[] filePath = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePath[0]);
            String picturePath = c.getString(columnIndex);
            c.close();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
            String file = getFileNameString(picturePath);
            binding.questionImage.setVisibility(View.VISIBLE);
            binding.questionImageid.setVisibility(View.VISIBLE);
            binding.questionImage.setImageBitmap(thumbnail);
            binding.questionImageid.setText(file);
            ReduceImageSize(requestcode, thumbnail);
        } else if (requestcode == BANK_SELECT) {
            String[] filePath = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePath[0]);
            String picturePath = c.getString(columnIndex);
            c.close();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
            String file = getFileNameString(picturePath);
            Toast.makeText(this, "Bank Statement Selected", Toast.LENGTH_SHORT).show();
            binding.bankImage.setVisibility(View.VISIBLE);
            binding.bankImageid.setVisibility(View.VISIBLE);
            binding.bankImage.setImageBitmap(thumbnail);
            binding.bankImageid.setText(file);
            ReduceImageSize(requestcode, thumbnail);
        } else if (requestcode == AGREE_SELECT) {
            String[] filePath = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePath[0]);
            String picturePath = c.getString(columnIndex);
            c.close();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
            String file = getFileNameString(picturePath);

            binding.agreeImage.setVisibility(View.VISIBLE);
            binding.agreeImageid.setVisibility(View.VISIBLE);
            binding.agreeImage.setImageBitmap(thumbnail);
            binding.agreeImageid.setText(file);
            Toast.makeText(this, "Agreement Selected", Toast.LENGTH_SHORT).show();
            ReduceImageSize(requestcode, thumbnail);
        } else if (requestcode == PLEDGE_SELECT) {
            String[] filePath = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePath[0]);
            String picturePath = c.getString(columnIndex);
            c.close();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
            String file = getFileNameString(picturePath);
            binding.pledgeImage.setVisibility(View.VISIBLE);
            binding.pledgeImageid.setVisibility(View.VISIBLE);
            binding.pledgeImage.setImageBitmap(thumbnail);
            binding.pledgeImageid.setText(file);
            Toast.makeText(this, "Pledge Document Selected", Toast.LENGTH_SHORT).show();
            ReduceImageSize(requestcode, thumbnail);
        }
    }

    private void setID(Bitmap photo, Bitmap bitmap, int requestcode) {
        try {
            if (requestcode == PANSELECT) {
                binding.panImage.setImageBitmap(bitmap);
                binding.panImage.setVisibility(View.VISIBLE);
                Uri tempUri = getImageUri(getApplicationContext(), photo);
                String[] filePath = {MediaStore.Images.Media.DATA};
                Cursor c = getContentResolver().query(tempUri, filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                String picturePath = c.getString(columnIndex);
                c.close();
                String file = getFileNameString(picturePath);
                binding.panImageid.setText(file);
                binding.panImageid.setVisibility(View.VISIBLE);
                ReduceImageSize(requestcode, bitmap);
            } else if (requestcode == AADHARSELECT) {
                binding.aadharImage.setImageBitmap(bitmap);
                binding.aadharImage.setVisibility(View.VISIBLE);
                Uri tempUri = getImageUri(getApplicationContext(), photo);
                String[] filePath = {MediaStore.Images.Media.DATA};
                Cursor c = getContentResolver().query(tempUri, filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                String picturePath = c.getString(columnIndex);
                c.close();
                String file = getFileNameString(picturePath);
                binding.adharImageid.setText(file);
                binding.adharImageid.setVisibility(View.VISIBLE);
                ReduceImageSize(requestcode, bitmap);
            } else if (requestcode == QUESTION_SELECT) {
                binding.questionImage.setImageBitmap(bitmap);
                binding.questionImage.setVisibility(View.VISIBLE);
                Uri tempUri = getImageUri(getApplicationContext(), photo);
                String[] filePath = {MediaStore.Images.Media.DATA};
                Cursor c = getContentResolver().query(tempUri, filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                String picturePath = c.getString(columnIndex);
                c.close();
                String file = getFileNameString(picturePath);
                binding.questionImageid.setText(file);
                binding.questionImageid.setVisibility(View.VISIBLE);
                ReduceImageSize(requestcode, bitmap);
            } else if (requestcode == BANK_SELECT) {
                binding.bankImage.setImageBitmap(bitmap);
                binding.bankImageid.setVisibility(View.VISIBLE);
                Uri tempUri = getImageUri(getApplicationContext(), photo);
                String[] filePath = {MediaStore.Images.Media.DATA};
                Cursor c = getContentResolver().query(tempUri, filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                String picturePath = c.getString(columnIndex);
                c.close();
                String file = getFileNameString(picturePath);
                binding.bankImageid.setText(file);
                binding.bankImageid.setVisibility(View.VISIBLE);
                ReduceImageSize(requestcode, bitmap);
            } else if (requestcode == AGREE_SELECT) {
                binding.agreeImage.setImageBitmap(bitmap);
                binding.agreeImage.setVisibility(View.VISIBLE);
                Uri tempUri = getImageUri(getApplicationContext(), photo);
                String[] filePath = {MediaStore.Images.Media.DATA};
                Cursor c = getContentResolver().query(tempUri, filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                String picturePath = c.getString(columnIndex);
                c.close();
                String file = getFileNameString(picturePath);
                binding.agreeImageid.setText(file);
                binding.agreeImageid.setVisibility(View.VISIBLE);
                ReduceImageSize(requestcode, bitmap);
            } else if (requestcode == PLEDGE_SELECT) {
                binding.pledgeImage.setImageBitmap(bitmap);
                binding.pledgeImage.setVisibility(View.VISIBLE);
                Uri tempUri = getImageUri(getApplicationContext(), photo);
                String[] filePath = {MediaStore.Images.Media.DATA};
                Cursor c = getContentResolver().query(tempUri, filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                String picturePath = c.getString(columnIndex);
                c.close();
                String file = getFileNameString(picturePath);
                binding.pledgeImageid.setText(file);
                binding.pledgeImageid.setVisibility(View.VISIBLE);
                ReduceImageSize(requestcode, bitmap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ReduceImageSize(int requestcode, Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        // Log.v("bitmap_size",""+bitmap.getByteCount());
        if (sizeOf(bitmap) < 10000000) {
            imageInByte = baos.toByteArray();

            //   bitmap.recycle();
            if (requestcode == PANSELECT) {
                PANCOPY = Base64.encodeToString(imageInByte, Base64.DEFAULT);
                Log.v("PANCOPY", PANCOPY);
            } else if (requestcode == AADHARSELECT) {
                AADHARCOPY = Base64.encodeToString(imageInByte, Base64.DEFAULT);
                Log.v("AADHARCOPY", AADHARCOPY);
            } else if (requestcode == QUESTION_SELECT) {
                QUESTIONCOPY = Base64.encodeToString(imageInByte, Base64.DEFAULT);
                Log.v("QUESTIONCOPY", QUESTIONCOPY);
            } else if (requestcode == BANK_SELECT) {
                BANKCOPY = Base64.encodeToString(imageInByte, Base64.DEFAULT);
                Log.v("BANKCOPY", BANKCOPY);
            } else if (requestcode == AGREE_SELECT) {
                AGREECOPY = Base64.encodeToString(imageInByte, Base64.DEFAULT);
                Log.v("AGREECOPY", AGREECOPY);
            } else if (requestcode == PLEDGE_SELECT) {
                PLEDGECOPY = Base64.encodeToString(imageInByte, Base64.DEFAULT);
                Log.v("PLEDGECOPY", PLEDGECOPY);
            }
        } else {
            showsnackbar();
            if (requestcode == PANSELECT) {
                binding.panImageid.setVisibility(View.GONE);
                binding.panImage.setVisibility(View.GONE);
            } else if (requestcode == AADHARSELECT) {
                binding.adharImageid.setVisibility(View.GONE);
                binding.aadharImage.setVisibility(View.GONE);
            } else if (requestcode == QUESTION_SELECT) {
                binding.questionImageid.setVisibility(View.GONE);
                binding.questionImage.setVisibility(View.GONE);
            } else if (requestcode == BANK_SELECT) {
                binding.bankImageid.setVisibility(View.GONE);
                binding.bankImage.setVisibility(View.GONE);
            } else if (requestcode == PLEDGE_SELECT) {
                binding.pledgeImageid.setVisibility(View.GONE);
                binding.pledgeImage.setVisibility(View.GONE);
            } else if (requestcode == AGREE_SELECT) {
                binding.agreeImageid.setVisibility(View.GONE);
                binding.agreeImage.setVisibility(View.GONE);
            }
        }

    }

    private void showsnackbar() {
        Utility.showSnackbar(binding.getRoot(), "image size should not exceed 500kb");
    }
}