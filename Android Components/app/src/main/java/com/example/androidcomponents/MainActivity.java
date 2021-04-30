package com.example.androidcomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.androidcomponents.ui.MapDialog;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.button.MaterialButton;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements MapDialog.LocationProvider{

    private MaterialButton mapDialogBtn,markLocBtn;
    private ImageButton getCurrentLoc;
    private MapView map;
    private GoogleMap mMap;
    private Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        mapDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapDialog mapDialog = new MapDialog();
                mapDialog.show(getSupportFragmentManager(),"Map Dialog Box");

            }
        });
    }

    private void initViews() {
        mapDialogBtn = findViewById(R.id.map_dialog_btn);
    }

    @Override
    public void sendLocation(String location) {
        Toast.makeText(this, location, Toast.LENGTH_SHORT).show();
    }
}