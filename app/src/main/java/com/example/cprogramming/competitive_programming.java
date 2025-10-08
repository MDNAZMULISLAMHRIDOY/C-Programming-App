package com.example.cprogramming;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class competitive_programming extends Fragment implements View.OnClickListener {
    CardView item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16;
    TextView codeforces,beecrowd,toph,leetcode,codechaf;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_competitive_programming, container, false);

        item1 = view.findViewById(R.id.list1);
        item2=view.findViewById(R.id.list2);
        item3=view.findViewById(R.id.list3);
        item4=view.findViewById(R.id.list4);
        item5=view.findViewById(R.id.list5);
        item6=view.findViewById(R.id.list6);
        item7=view.findViewById(R.id.list7);
        item8=view.findViewById(R.id.list8);
        item9=view.findViewById(R.id.list9);
        item10=view.findViewById(R.id.list10);
        item11=view.findViewById(R.id.list11);
        item12=view.findViewById(R.id.list12);
        item13=view.findViewById(R.id.list13);
        item14=view.findViewById(R.id.list14);
        item15=view.findViewById(R.id.list15);
        item16=view.findViewById(R.id.list16);

        codeforces = view.findViewById(R.id.codeForse);
        codeforces.setText(Html.fromHtml("<a href='https://codeforces.com/'>->Codeforces Competitive programming Sides</a>"));
        beecrowd = view.findViewById(R.id.beecrowd);
        beecrowd.setText(Html.fromHtml("<a href='https://judge.beecrowd.com/en/login'>->Beecrowd Competitive programming Sides</a>"));
        toph = view.findViewById(R.id.toph);
        toph.setText(Html.fromHtml("<a href='https://toph.co/problems'>->Toph Competitive programming Sides</a>"));
        leetcode = view.findViewById(R.id.leetcode);
        leetcode.setText(Html.fromHtml("<a href='https://leetcode.com/'>->Leetcode Competitive programming Sides</a>"));
        codechaf = view.findViewById(R.id.codechaf);
        codechaf.setText(Html.fromHtml("<a href='https://www.codechef.com/'>->Codechef Competitive programming Sides</a>"));

        if (!isInternetAvailable()) {
            Toast.makeText(getContext(), "Internet is not available", Toast.LENGTH_SHORT).show();
        }


        codeforces.setMovementMethod(LinkMovementMethod.getInstance());
        if (!isInternetAvailable()) {
            Toast.makeText(getContext(), "Internet is not available", Toast.LENGTH_SHORT).show();
        }

        toph.setMovementMethod(LinkMovementMethod.getInstance());
        leetcode.setMovementMethod(LinkMovementMethod.getInstance());
        codechaf.setMovementMethod(LinkMovementMethod.getInstance());

        item1.setOnClickListener(this);
        item2.setOnClickListener(this);
        item3.setOnClickListener(this);
        item4.setOnClickListener(this);
        item5.setOnClickListener(this);
        item6.setOnClickListener(this);
        item7.setOnClickListener(this);
        item8.setOnClickListener(this);
        item9.setOnClickListener(this);
        item10.setOnClickListener(this);
        item11.setOnClickListener(this);
        item12.setOnClickListener(this);
        item13.setOnClickListener(this);
        item14.setOnClickListener(this);
        item15.setOnClickListener(this);
        item16.setOnClickListener(this);

        return view;
    }

    private boolean isInternetAvailable() {
        ConnectivityManager connectivityManager =(ConnectivityManager) requireContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {
            Network network = connectivityManager.getActiveNetwork();
            if (network != null) {
                NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(network);
                if (capabilities != null) {

                    return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET);
                }
            }
        }
        return false;

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.codeForse){
            if (!isInternetAvailable()) {
                Toast.makeText(getContext(), "Internet is not available", Toast.LENGTH_SHORT).show();
            }
            else{
                codeforces.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
       else if(v.getId()==R.id.beecrowd){
            if (!isInternetAvailable()) {
                Toast.makeText(getContext(), "Internet is not available", Toast.LENGTH_SHORT).show();
            }
            else{
                beecrowd.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        else if(v.getId()==R.id.toph){
            if (!isInternetAvailable()) {
                Toast.makeText(getContext(), "Internet is not available", Toast.LENGTH_SHORT).show();
            }
            else{
                toph.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        else if(v.getId()==R.id.leetcode){
            if (!isInternetAvailable()) {
                Toast.makeText(getContext(), "Internet is not available", Toast.LENGTH_SHORT).show();
            }
            else{
               leetcode.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        else if(v.getId()==R.id.codechaf){
            if (!isInternetAvailable()) {
                Toast.makeText(getContext(), "Internet is not available", Toast.LENGTH_SHORT).show();
            }
            else{
                codechaf.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
       else if (v.getId() == R.id.list1) {
            Intent intent = new Intent(getActivity(), item1.class);
            startActivity(intent);

        }
        else if(v.getId()==R.id.list2){
            Intent intent=new Intent(getActivity(), item2.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.list3){
            Intent intent=new Intent(getActivity(), item3.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.list4){
            Intent intent=new Intent(getActivity(), item4.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.list5){
            Intent intent=new Intent(getActivity(), item5.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.list6){
            Intent intent=new Intent(getActivity(), item6.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.list7){
            Intent intent=new Intent(getActivity(), item7.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.list8){
            Intent intent=new Intent(getActivity(), item8.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.list9){
            Intent intent=new Intent(getActivity(), item9.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.list10){
            Intent intent=new Intent(getActivity(), item10.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.list11){
            Intent intent=new Intent(getActivity(), item11.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.list12){
            Intent intent=new Intent(getActivity(), item12.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.list13){
            Intent intent=new Intent(getActivity(), item13.class);
            startActivity(intent);
        } else if(v.getId()==R.id.list14){
            Intent intent=new Intent(getActivity(), item14.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.list15){
            Intent intent=new Intent(getActivity(), item15.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.list16){
            Intent intent=new Intent(getActivity(), item16.class);
            startActivity(intent);
        }
    }
}
