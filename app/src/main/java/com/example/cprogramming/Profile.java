package com.example.cprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Profile extends AppCompatActivity implements View.OnClickListener{
ImageView whats_app,linkin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        whats_app.findViewById(R.id.whatsapp);
        linkin=findViewById(R.id.linkedin);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.whatsapp){
            String phoneNumber = "+8801994491893";


            String url = "https://web.whatsapp.com/" + phoneNumber;


            try {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                intent.setPackage("com.whatsapp");
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if(v.getId()==R.id.linkedin){
            String linkedInProfileUrl = "https://www.linkedin.com/in/yourprofile";

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkedInProfileUrl));
            intent.setPackage("com.linkedin.android");

            try {
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(linkedInProfileUrl)));
            }
        }

    }
    }