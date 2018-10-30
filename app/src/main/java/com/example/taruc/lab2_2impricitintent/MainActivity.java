package com.example.taruc.lab2_2impricitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.*;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Main Activity","onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Main Activity","onResume");
    }

    public void visitTARUC(View view){
        String uri = "http://www.tarc.edu.my";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(uri));
        if(intent.resolveActivity(getPackageManager())!= null){
            startActivity(intent);
        }else{
            Log.d("ImplicitIntents","Can't handle this intent!");
        }
    }

    public void showMain(View view){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        startActivity(intent);
    }

    public void showDial(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + "0123456789"));
        startActivity(intent);
    }

    public void showSendTo(View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto: " + "hewsanlee@gmail.com"));
        if(intent.resolveActivity(getPackageManager())!= null){
            startActivity(intent);
        }else{
            //Log.d = debug message
            Log.d("ImplicitIntents","Can't handle this intent!");
        }
    }
}
