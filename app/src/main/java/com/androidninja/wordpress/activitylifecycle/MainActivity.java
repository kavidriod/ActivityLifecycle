package com.androidninja.wordpress.activitylifecycle;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String TAG = MainActivity.class.getSimpleName() + "-> ";
    Button activityButton,activitydialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"onCreate");

        activityButton = (Button) findViewById(R.id.activityButton);
        activitydialogButton = (Button) findViewById(R.id.activitydialogButton);

        activitydialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   showDialogs();
            }
        });


        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           startActivity(new Intent(getApplicationContext(),SecondActivity.class));
            }
        });
    }

    private void showDialogs() {
        AlertDialog.Builder builder ;

        Log.i(TAG,"Build.VERSION.SDK_INT ? "+Build.VERSION.SDK_INT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            builder = new AlertDialog.Builder(this,android.R.style.Theme_Material_Dialog_Alert);
        }
        else
        {
            builder = new AlertDialog.Builder(this);
        }

        builder.setMessage("Incoming Calls");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart");
    }


    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i(TAG,"onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG,"onRestoreInstanceState");
    }
}
