package com.example.androidcomponents.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.androidcomponents.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class BottomSheet extends BottomSheetDialogFragment {

    public interface FilterProvider{
        void addFilters(Boolean veg,Boolean nonVeg,Boolean breakfast,Boolean lunch,Boolean dinner);
    }

    public FilterProvider mFilterProvider;
    View view;
    private CheckBox vg,nnvg,brkfst,lnch,dnnr;
    private MaterialButton filter_btn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bottom_sheet,container,false);
        filter_btn = view.findViewById(R.id.bottom_sheet_filter_btn);
        vg = view.findViewById(R.id.check_vegetarian);
        nnvg = view.findViewById(R.id.check_non_vegetarian);
        brkfst = view.findViewById(R.id.check_breakfast);
        lnch = view.findViewById(R.id.check_lunch);
        dnnr = view.findViewById(R.id.check_dinner);

        filter_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFilterProvider.addFilters(vg.isChecked(),nnvg.isChecked(),brkfst.isChecked(),lnch.isChecked(),dnnr.isChecked());
                Objects.requireNonNull(getDialog()).dismiss();
            }
        });




        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            mFilterProvider = (FilterProvider) getActivity();
        }catch (ClassCastException e){
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
