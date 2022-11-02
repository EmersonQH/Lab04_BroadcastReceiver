package com.example.lab4_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle b = intent.getExtras();
        if (intent.getAction().equalsIgnoreCase("com.example.lab4_broadcastreceiver.actionButton")){
            String mensaje =b.getString("mensaje");
            Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
            Log.i("Broadcast","El mensaje resibido es: " +mensaje);
        }
    }

   /* private static final String TAG = "MyBroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append("Action: " + intent.getAction() + "\n");
        String log = sb.toString();
        Log.d(TAG, log);
        Toast.makeText(context, log, Toast.LENGTH_LONG).show();
    }*/
/*
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String mensaje = intent.getStringExtra("mensaje").toString();
        Log.i("Broadcast","El mensaje resivido es: " +mensaje);
        //Log.i("Broadcast","Ingresamos al escuchador");
        //throw new UnsupportedOperationException("Not yet implemented");
    }*/
}