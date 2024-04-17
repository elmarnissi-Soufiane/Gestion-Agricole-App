package com.example.gst_agricolesvf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;

import com.example.gst_agricolesvf.vm.VmAgricoles;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public class MainActivity extends AppCompatActivity {

    Socket socket ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        VmAgricoles vmAgricoles = new VmAgricoles(this);


    }
}