package com.example.androidcomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.androidcomponents.ui.BottomSheet;
import com.example.androidcomponents.ui.MapDialog;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements MapDialog.LocationProvider, BottomSheet.FilterProvider{

    private MaterialButton mapDialogBtn, bottomSheetBtn;


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

        bottomSheetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.show(getSupportFragmentManager(),"Bottom Sheet");
            }
        });
    }

    private void initViews() {
        mapDialogBtn = findViewById(R.id.map_dialog_btn);
        bottomSheetBtn = findViewById(R.id.bottom_sheet_btn);

    }

    @Override
    public void sendLocation(String location) {
        Toast.makeText(this, location, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addFilters(Boolean veg, Boolean nonVeg, Boolean breakfast, Boolean lunch, Boolean dinner) {
        Toast.makeText(this, "Vegetarian: "+veg.toString()+"\nNon-Vegetarian: "+nonVeg.toString()+"\nBreakfast: "+breakfast.toString()+"\nLunch: "+lunch.toString()+"\nDinner: "+dinner.toString(), Toast.LENGTH_SHORT).show();
    }
}