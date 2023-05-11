package com.example.kursach.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.example.kursach.Domain.ItemsDomain;
import com.example.kursach.Domain.OrderDomain;
import com.example.kursach.R;

import java.text.DecimalFormat;

public class DetailActivity extends AppCompatActivity {
    private TextView titleTxt, addressTxt, bedTxt, bathTxt, wifiTxt, descriptionTxt, priceTxt;
    private ItemsDomain item;
    private ImageView pic;
    private OrderDomain object;
    DecimalFormat formatter=new DecimalFormat("###,###,###.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();
        getBundle();
    }

    private void getBundle() {
        object = (OrderDomain)getIntent().getSerializableExtra("object");

        int drawableResourceId = this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this).load(drawableResourceId).into(pic);
        titleTxt.setText(object.getTitle());
        addressTxt.setText(object.getAddress());
        descriptionTxt.setText(object.getDescription());
        priceTxt.setText("₽"+formatter.format(object.getPrice()));

        Glide.with(this)
                .load(drawableResourceId)
                .into(pic);
    }

    private void initView() {
        titleTxt = findViewById(R.id.titleTxt);
        addressTxt = findViewById(R.id.addressTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        pic = findViewById(R.id.pic);
        priceTxt=findViewById(R.id.priceTxt);
    }
}