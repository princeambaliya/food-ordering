package com.photostudio.albumgallery.demoapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

@SuppressWarnings("all")

public class MainActivity extends AppCompatActivity {
//
//    private static final int PICK_IMAGE_REQUEST = 1;
//    private static final int READ


    TextView txt;
    EditText editText;
    Button btn;
    private String READ_EXTERNAL_STORAGE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//

//        txt=findViewById(R.id.txt);
//        editText=findViewById(R.id.edittext);
//        btn=findViewById(R.id.btn);

//        SharedPreferences.........................
//        SharedPreferences sp = getSharedPreferences("name",MODE_PRIVATE);
//        String editval=sp.getString("name","no data right now");
//        txt.setText(editval);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String val=editText.getText().toString();
//                SharedPreferences sp = getSharedPreferences("name",MODE_PRIVATE);
//                SharedPreferences.Editor editor = sp.edit();
//                editor.putString("name", val);
//                editor.apply();
//                txt.setText(val);
//
//            }
//        });

        Dexter.withContext(this)
                .withPermission(READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        Toast.makeText(MainActivity.this, "permission allow", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                        permissionToken.continuePermissionRequest();
                    }
                })
                .check();


    }

}


//
//    private void openGallery() {
//        Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        startActivityForResult(intent,PICK_IMAGE_REQUEST);
//
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data!=null && data.getData()!=null);{
//            Uri uri=data.getData();
//        }
//    }