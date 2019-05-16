package com.example.rpisecure;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ProgressDialog dialog;
    WebView videoView;
    ImageButton btnPlay;
    BackendlessUser currentUser = Backendless.UserService.CurrentUser();
    String ip = currentUser.getProperty("ip").toString();


    String videoURL = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        videoURL = "http://" + ip + "/";
        setContentView(R.layout.activity_main);
        videoView = (WebView) findViewById(R.id.videoView);
        btnPlay = (ImageButton) findViewById(R.id.btn_play);
        btnPlay.setOnClickListener(this);
        dialog = new ProgressDialog(MainActivity.this);
        dialog.setMessage("Please wait....");
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
        WebView videoView = (WebView) findViewById(R.id.videoView);
        videoView.loadUrl(videoURL);
        dialog.dismiss();

    }

    @Override
    public void onClick(View v) {

    }
}


