package com.example.cprogramming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class item6 extends AppCompatActivity implements View.OnClickListener{

    BottomSheetDialog bottomSheetDialog;
    CardView solve_view, cancel;
    private WebView item6WebView;
    Toolbar toolbar;
    ImageView copy_img;

    private static final String web_view ="<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <style>\n" +
            "        body {\n" +
            "            font-family: Consolas, monospace;\n" +
            "            background-color: #282c34;\n" +
            "            color: #ffffff;\n" +
            "            font-size: 1.3em;\n" +
            "            padding: 20px;\n" +
            "        }\n" +
            "        .keyword { color: #66d9ef; }\n" +
            "        .type { color: #a6e22e; }\n" +
            "        .string { color: #e6db74; }\n" +
            "        .number { color: #ae81ff; }\n" +
            "        .function { color: #f92672; }\n" +
            "        .comment { color: #75715e; }\n" +
            "        .operator { color: #f92672; }\n" +
            "        .bracket { color: #f8f8f2; }\n" +
            "    </style>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <pre>\n" +
            "<span class=\"keyword\">#include</span> <span class=\"string\">&lt;stdio.h&gt;</span>\n" +
            "<span class=\"keyword\">#include</span> <span class=\"string\">&lt;stdbool.h&gt;</span>\n" +
            "<span class=\"keyword\">#include</span> <span class=\"string\">&lt;ctype.h&gt;</span>\n" +
            "<span class=\"keyword\">#include</span> <span class=\"string\">&lt;string.h&gt;</span>\n" +
            "\n" +
            "<span class=\"keyword\">#define</span> <span class=\"type\">MAX_SIZE</span> <span class=\"number\">100</span>\n" +
            "\n" +
            "<span class=\"type\">bool</span> <span class=\"function\">is_sorted</span>(<span class=\"type\">char</span> *str) {\n" +
            "    <span class=\"type\">int</span> len = <span class=\"function\">strlen</span>(str);\n" +
            "    <span class=\"keyword\">for</span> (<span class=\"type\">int</span> i = <span class=\"number\">0</span>; i < len - <span class=\"number\">1</span>; i++) {\n" +
            "        <span class=\"keyword\">if</span> (str[i] > str[i + <span class=\"number\">1</span>]) {\n" +
            "            <span class=\"keyword\">return</span> <span class=\"keyword\">false</span>;\n" +
            "        }\n" +
            "    }\n" +
            "    <span class=\"keyword\">return</span> <span class=\"keyword\">true</span>;\n" +
            "}\n" +
            "\n" +
            "<span class=\"keyword\">void</span> <span class=\"function\">sort_string</span>(<span class=\"type\">char</span> *str) {\n" +
            "    <span class=\"type\">int</span> len = <span class=\"function\">strlen</span>(str);\n" +
            "    <span class=\"keyword\">for</span> (<span class=\"type\">int</span> i = <span class=\"number\">0</span>; i < len - <span class=\"number\">1</span>; i++) {\n" +
            "        <span class=\"keyword\">for</span> (<span class=\"type\">int</span> j = i + <span class=\"number\">1</span>; j < len; j++) {\n" +
            "            <span class=\"keyword\">if</span> (str[i] > str[j]) {\n" +
            "                <span class=\"type\">char</span> temp = str[i];\n" +
            "                str[i] = str[j];\n" +
            "                str[j] = temp;\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "}\n" +
            "\n" +
            "<span class=\"type\">bool</span> <span class=\"function\">password</span>(<span class=\"type\">char</span> *str) {\n" +
            "    <span class=\"type\">char</span> digit[MAX_SIZE] = {<span class=\"number\">0</span>};\n" +
            "    <span class=\"type\">char</span> let[MAX_SIZE] = {<span class=\"number\">0</span>};\n" +
            "    <span class=\"type\">int</span> digit_index = <span class=\"number\">0</span>, let_index = <span class=\"number\">0</span>;\n" +
            "    <span class=\"type\">int</span> x = <span class=\"function\">strlen</span>(str);\n" +
            "    \n" +
            "    <span class=\"keyword\">for</span> (<span class=\"type\">int</span> i = <span class=\"number\">0</span>; i < x; i++) {\n" +
            "        <span class=\"keyword\">if</span> (str[i] >= <span class=\"string\">'A'</span> && str[i] <= <span class=\"string\">'Z'</span>) {\n" +
            "            <span class=\"keyword\">return</span> <span class=\"keyword\">false</span>;\n" +
            "        }\n" +
            "    }\n" +
            "    \n" +
            "    <span class=\"keyword\">for</span> (<span class=\"type\">int</span> i = <span class=\"number\">0</span>; i < x; i++) {\n" +
            "        <span class=\"keyword\">if</span> (<span class=\"function\">isdigit</span>(str[i])) {\n" +
            "            digit[digit_index++] = str[i];\n" +
            "        } <span class=\"keyword\">else</span> {\n" +
            "            let[let_index++] = str[i];\n" +
            "        }\n" +
            "    }\n" +
            "    \n" +
            "    digit[digit_index] = <span class=\"string\">'\\0'</span>;\n" +
            "    let[let_index] = <span class=\"string\">'\\0'</span>;\n" +
            "    \n" +
            "    <span class=\"keyword\">if</span> (!<span class=\"function\">is_sorted</span>(digit) || !<span class=\"function\">is_sorted</span>(let)) {\n" +
            "        <span class=\"keyword\">return</span> <span class=\"keyword\">false</span>;\n" +
            "    }\n" +
            "    \n" +
            "    <span class=\"keyword\">if</span> (str[<span class=\"number\">0</span>] == let[<span class=\"number\">0</span>] && digit_index != <span class=\"number\">0</span>) {\n" +
            "        <span class=\"keyword\">return</span> <span class=\"keyword\">false</span>;\n" +
            "    }\n" +
            "    \n" +
            "    <span class=\"type\">char</span> sorted_str[MAX_SIZE];\n" +
            "    <span class=\"function\">strcpy</span>(sorted_str, str);\n" +
            "    <span class=\"function\">sort_string</span>(sorted_str);\n" +
            "    \n" +
            "    <span class=\"keyword\">if</span> (<span class=\"function\">strcmp</span>(str, sorted_str) == <span class=\"number\">0</span>) {\n" +
            "        <span class=\"keyword\">return</span> <span class=\"keyword\">true</span>;\n" +
            "    }\n" +
            "    \n" +
            "    <span class=\"keyword\">return</span> <span class=\"keyword\">false</span>;\n" +
            "}\n" +
            "\n" +
            "<span class=\"type\">int</span> <span class=\"function\">main</span>() {\n" +
            "    <span class=\"type\">int</span> a;\n" +
            "    <span class=\"keyword\">scanf</span>(<span class=\"string\">\"%d\"</span>, &a);\n" +
            "    <span class=\"keyword\">while</span> (a--) {\n" +
            "        <span class=\"type\">int</span> x;\n" +
            "        <span class=\"type\">char</span> str[MAX_SIZE];\n" +
            "        <span class=\"keyword\">scanf</span>(<span class=\"string\">\"%d %s\"</span>, &x, str);\n" +
            "        \n" +
            "        <span class=\"type\">bool</span> result = <span class=\"function\">password</span>(str);\n" +
            "        <span class=\"keyword\">if</span> (result) {\n" +
            "            <span class=\"keyword\">printf</span>(<span class=\"string\">\"Yes\\\\n\"</span>);\n" +
            "        } <span class=\"keyword\">else</span> {\n" +
            "            <span class=\"keyword\">printf</span>(<span class=\"string\">\"No\\\\n\"</span>);\n" +
            "        }\n" +
            "    }\n" +
            "    <span class=\"keyword\">return</span> <span class=\"number\">0</span>;\n" +
            "}\n" +
            "    </pre>\n" +
            "</body>\n" +
            "</html>\n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item6);


        bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.item6_view);

        toolbar = findViewById(R.id.tabMode);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        View bottomSheetInternal = bottomSheetDialog.findViewById(com.google.android.material.R.id.design_bottom_sheet);
        BottomSheetBehavior<View> bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetInternal);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

        item6WebView = bottomSheetDialog.findViewById(R.id.aLegs);
        if (item6WebView != null) {
            item6WebView.loadDataWithBaseURL(null, web_view, "text/html", "utf-8", null);
            WebSettings webSettings = item6WebView.getSettings();
            webSettings.setJavaScriptEnabled(true);

            item6WebView.setNestedScrollingEnabled(true);
        }

        solve_view = findViewById(R.id.solve_qus);
        solve_view.setOnClickListener(this);

        cancel = bottomSheetDialog.findViewById(R.id.solve_qus);
        if (cancel != null) {
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bottomSheetDialog.dismiss();
                }
            });
        }

        copy_img = bottomSheetDialog.findViewById(R.id.img_view);
        if (copy_img != null) {
            copy_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (item6WebView != null) {
                        item6WebView.evaluateJavascript(
                                "(function() { return document.documentElement.innerText; })();",
                                value -> {
                                    value = value.replace("\\n", "\n").replace("\\\"", "\"");
                                    value = value.substring(1, value.length() - 1);

                                    ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                                    ClipData clipData = ClipData.newPlainText("Copy", value);
                                    clipboardManager.setPrimaryClip(clipData);

                                    Toast.makeText(item6WebView.getContext(), "Copied", Toast.LENGTH_SHORT).show(); // Corrected context usage
                                }
                        );
                    }
                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        bottomSheetDialog.show();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }

    }
}