package com.example.contactapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ContactDetailsActivity extends AppCompatActivity {
    private ImageView profileIV;
    private TextView detailsNameTV, detailsPhoneTV;
    private String name, phone, photo;
    private int photolink;
    private LinearLayout calling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);


        inti();
        setdata();
        getdat();
        calling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+phone));
                startActivity(intent);
            }
        });

    }

    private void getdat() {

        name = getIntent().getStringExtra("Name");
        phone = getIntent().getStringExtra("Phone");
        photo = getIntent().getStringExtra("Photo");
        photolink = Integer.parseInt(photo);

    }

    private void setdata() {


        detailsNameTV.setText(name);
        detailsPhoneTV.setText(phone);
        profileIV.setImageResource(photolink);
        setTitle(name);
    }

    private void inti() {



        detailsNameTV = findViewById(R.id.detailsNmaeTV);
        detailsPhoneTV = findViewById(R.id.detailsPhoneTV);
        profileIV = findViewById(R.id.profileIV);
        calling= findViewById(R.id.calling);


    }
}
