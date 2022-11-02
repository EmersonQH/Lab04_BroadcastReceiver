package com.example.lab4_broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText texto;
    Button enviar;
    MyBroadcastReceiver escucharMensaje;
    IntentFilter filter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = findViewById(R.id.id_texto);
        enviar = findViewById(R.id.id_MensajeInterno);

        escucharMensaje = new MyBroadcastReceiver();
        filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        this.registerReceiver(escucharMensaje, filter);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensajeData;
                mensajeData = texto.getText().toString();

                Intent intent = new Intent();
                intent.setAction("com.example.lab4_broadcastreceiver.actionButton");
                intent.putExtra("mensaje",mensajeData);
                sendBroadcast(intent);

            }
        });

    }
}