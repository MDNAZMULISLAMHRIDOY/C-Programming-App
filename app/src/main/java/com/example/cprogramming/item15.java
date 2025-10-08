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

public class item15 extends AppCompatActivity implements View.OnClickListener{

    BottomSheetDialog bottomSheetDialog;
    CardView solve_view, cancel;
    private WebView item15WebView;
    Toolbar toolbar;
    ImageView copy_img;

    private static final String web_view = "<!DOCTYPE html>\n" +
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
            "\n" +
            "<span class=\"type\">int</span> <span class=\"function\">fab</span>(<span class=\"type\">int</span> a)\n" +
            "{\n" +
            "    <span class=\"keyword\">if</span> (a == <span class=\"number\">0</span> || a == <span class=\"number\">1</span>)\n" +
            "    {\n" +
            "        <span class=\"keyword\">return</span> a;\n" +
            "    }\n" +
            "    <span class=\"keyword\">else</span>\n" +
            "    {\n" +
            "        <span class=\"keyword\">return</span> <span class=\"function\">fab</span>(a - <span class=\"number\">1</span>) + <span class=\"function\">fab</span>(a - <span class=\"number\">2</span>);\n" +
            "    }\n" +
            "}\n" +
            "\n" +
            "<span class=\"type\">int</span> <span class=\"function\">main</span>()\n" +
            "{\n" +
            "    <span class=\"type\">int</span> a, x;\n" +
            "    <span class=\"function\">scanf</span>(<span class=\"string\">\"%d\"</span>, &a);\n" +
            "    <span class=\"keyword\">for</span> (<span class=\"type\">int</span> i = <span class=\"number\">0</span>; i &lt;= a; i++)\n" +
            "    {\n" +
            "        x = <span class=\"function\">fab</span>(i);\n" +
            "    }\n" +
            "    <span class=\"function\">printf</span>(<span class=\"string\">\"%d\\n\"</span>, x);\n" +
            "    <span class=\"keyword\">return</span> <span class=\"number\">0</span>;\n" +
            "}\n" +
            "    </pre>\n" +
            "</body>\n" +
            "</html>\n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item15);

        bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.item15_view);

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

        item15WebView = bottomSheetDialog.findViewById(R.id.aLegs);
        if (item15WebView != null) {
            item15WebView.loadDataWithBaseURL(null, web_view, "text/html", "utf-8", null);
            WebSettings webSettings = item15WebView.getSettings();
            webSettings.setJavaScriptEnabled(true);

            item15WebView.setNestedScrollingEnabled(true);
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
                    if (item15WebView != null) {
                        item15WebView.evaluateJavascript(
                                "(function() { return document.documentElement.innerText; })();",
                                value -> {
                                    value = value.replace("\\n", "\n").replace("\\\"", "\"");
                                    value = value.substring(1, value.length() - 1);

                                    ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                                    ClipData clipData = ClipData.newPlainText("Copy", value);
                                    clipboardManager.setPrimaryClip(clipData);

                                    Toast.makeText(item15WebView.getContext(), "Copied", Toast.LENGTH_SHORT).show(); // Corrected context usage
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