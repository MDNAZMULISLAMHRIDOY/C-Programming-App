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

public class item7 extends AppCompatActivity implements View.OnClickListener {
    BottomSheetDialog bottomSheetDialog;
    CardView solve_view, cancel;
    private WebView item7WebView;
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
            "            font-size: 1.1em;\n" +
            "            padding: 20px;\n" +
            "        }\n" +
            "        .keyword { color: #66d9ef; }\n" +
            "        .type { color: #a6e22e; }\n" +
            "        .string { color: #e6db74; }\n" +
            "        .number { color: #ae81ff; }\n" +
            "        .function { color: #f92672; }\n" +
            "    </style>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <pre>\n" +
            "<span class=\"keyword\">#include</span> <span class=\"string\">&lt;stdio.h&gt;</span>\n" +
            "<span class=\"keyword\">#include</span> <span class=\"string\">&lt;stdlib.h&gt;</span>\n" +
            "\n" +
            "\n" +
            "<span class=\"type\">int</span> <span class=\"function\">compare</span>(<span class=\"keyword\">const void</span> *a, <span class=\"keyword\">const void</span> *b) {\n" +
            "    <span class=\"keyword\">return</span> (*( <span class=\"type\">int</span> *)a - *( <span class=\"type\">int</span> *)b);\n" +
            "}\n" +
            "\n" +
            "<span class=\"type\">int</span> <span class=\"function\">main</span>() {\n" +
            "    <span class=\"type\">int</span> a, value, n;\n" +
            "\n" +
            "    <span class=\"keyword\">scanf</span>(<span class=\"string\">\"%d\"</span>, &n);\n" +
            "    <span class=\"keyword\">for</span> (<span class=\"type\">int</span> i = <span class=\"number\">0</span>; i &lt; n; i++) {\n" +
            "        <span class=\"type\">int</span> sum = <span class=\"number\">0</span>;\n" +
            "        <span class=\"keyword\">scanf</span>(<span class=\"string\">\"%d\"</span>, &a);\n" +
            "\n" +
            "        <span class=\"comment\"></span>\n" +
            "        <span class=\"type\">int</span> *v = ( <span class=\"type\">int</span> *)<span class=\"function\">malloc</span>(a * <span class=\"keyword\">sizeof</span>( <span class=\"type\">int</span> ));\n" +
            "        <span class=\"keyword\">if</span> (v == <span class=\"keyword\">NULL</span>) {\n" +
            "            <span class=\"function\">fprintf</span>(stderr, <span class=\"string\">\"Memory allocation failed\\n\"</span>);\n" +
            "            <span class=\"keyword\">return</span> <span class=\"number\">1</span>;\n" +
            "        }\n" +
            "\n" +
            "        <span class=\"keyword\">for</span> (<span class=\"type\">int</span> j = <span class=\"number\">0</span>; j &lt; a; j++) {\n" +
            "            <span class=\"keyword\">scanf</span>(<span class=\"string\">\"%d\"</span>, &v[j]);\n" +
            "        }\n" +
            "\n" +
            "        <span class=\"comment\"></span>\n" +
            "        <span class=\"function\">qsort</span>(v, a, <span class=\"keyword\">sizeof</span>( <span class=\"type\">int</span> ), compare);\n" +
            "\n" +
            "        <span class=\"keyword\">for</span> (<span class=\"type\">int</span> j = <span class=\"number\">0</span>; j &lt; a - <span class=\"number\">1</span>; j++) {\n" +
            "            sum += v[j + <span class=\"number\">1</span>] - v[j];\n" +
            "        }\n" +
            "\n" +
            "        <span class=\"function\">printf</span>(<span class=\"string\">\"%d\\n\"</span>, sum);\n" +
            "        \n" +
            "        <span class=\"comment\"></span>\n" +
            "        <span class=\"function\">free</span>(v);\n" +
            "    }\n" +
            "    <span class=\"keyword\">return</span> <span class=\"number\">0</span>;\n" +
            "}\n" +
            "    </pre>\n" +
            "</body>\n" +
            "</html>\n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item7);


        bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.item7_view);

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

        item7WebView = bottomSheetDialog.findViewById(R.id.aLegs);
        if (item7WebView != null) {
            item7WebView.loadDataWithBaseURL(null, web_view, "text/html", "utf-8", null);
            WebSettings webSettings = item7WebView.getSettings();
            webSettings.setJavaScriptEnabled(true);

            item7WebView.setNestedScrollingEnabled(true);
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
                    if (item7WebView != null) {
                        item7WebView.evaluateJavascript(
                                "(function() { return document.documentElement.innerText; })();",
                                value -> {
                                    value = value.replace("\\n", "\n").replace("\\\"", "\"");
                                    value = value.substring(1, value.length() - 1);

                                    ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                                    ClipData clipData = ClipData.newPlainText("Copy", value);
                                    clipboardManager.setPrimaryClip(clipData);

                                    Toast.makeText(item7WebView.getContext(), "Copied", Toast.LENGTH_SHORT).show(); // Corrected context usage
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