package com.example.cprogramming;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class home extends Fragment{

    private WebView itemWebView;
    Toolbar toolbar;
    TextView[] item = new TextView[18];
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
            "<span class=\"keyword\">#include</span> <span class=\"string\">&lt;stdio.h&gt;</span> <span class=\"comment\">// Include standard input-output library</span>\n" +
            "<span class=\"type\">int</span> <span class=\"function\">main</span>()          <span class=\"comment\">// Main function</span>\n" +
            "{\n" +
            "    <span class=\"function\">printf</span>(<span class=\"string\">\"Hello, C Programming app\\n\"</span>);  <span class=\"comment\">// Print \"Hello, C Programming app\" to the console</span>\n" +
            "    <span class=\"keyword\">return</span> <span class=\"number\">0</span>;       <span class=\"comment\">// Return 0 to indicate successful execution</span>\n" +
            "}\n" +
            "    </pre>\n" +
            "</body>\n" +
            "</html>\n";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        item[0] = view.findViewById(R.id.item1);
        item[0].setText(Html.fromHtml("<a href='https://codeforces.com/'>->Profile Activity page</a>"));
        item[1] = view.findViewById(R.id.item2);
        item[1].setText(Html.fromHtml("<a href='https://codeforces.com/'>->History and Evolution Activity page</a>"));
        item[2] = view.findViewById(R.id.item3);
        item[2].setText(Html.fromHtml("<a href='https://codeforces.com/'>->Importance and Application Activity page</a>"));
        item[3] = view.findViewById(R.id.item4);
        item[3].setText(Html.fromHtml("<a href='https://codeforces.com/'>->Hello World Program Activity page</a>"));
        item[4] = view.findViewById(R.id.item5);
        item[4].setText(Html.fromHtml("<a href='https://codeforces.com/'>->#include Directives Activity page</a>"));
        item[5] = view.findViewById(R.id.item6);
        item[5].setText(Html.fromHtml("<a href='https://codeforces.com/'>->main() Function Activity page</a>"));
        item[6] = view.findViewById(R.id.item7);
        item[6].setText(Html.fromHtml("<a href='https://codeforces.com/'>->return Types Activity page</a>"));
        item[7] = view.findViewById(R.id.item8);
        item[7].setText(Html.fromHtml("<a href='https://codeforces.com/'>->Comments and Formatting Activity page</a>"));
        item[8] = view.findViewById(R.id.item9);
        item[8].setText(Html.fromHtml("<a href='https://codeforces.com/'>->C Tokens Activity page</a>"));
        item[9] = view.findViewById(R.id.item10);
        item[9].setText(Html.fromHtml("<a href='https://codeforces.com/'>->Keyword and Identifiers Activity page</a>"));
        item[10] = view.findViewById(R.id.item11);
        item[10].setText(Html.fromHtml("<a href='https://codeforces.com/'>->Constants and Variables Activity page</a>"));
        item[11] = view.findViewById(R.id.item12);
        item[11].setText(Html.fromHtml("<a href='https://codeforces.com/'>->Data Type Activity page</a>"));
        item[12] = view.findViewById(R.id.item13);
        item[12].setText(Html.fromHtml("<a href='https://codeforces.com/'>->Quiz Activity page</a>"));
        item[13] = view.findViewById(R.id.item14);
        item[13].setText(Html.fromHtml("<a href='https://codeforces.com/'>->Competitive Activity page</a>"));
        item[14] = view.findViewById(R.id.item15);
        item[14].setText(Html.fromHtml("<a href='https://codeforces.com/'>->Finding Output Activity page</a>"));
        item[15] = view.findViewById(R.id.item16);
        item[15].setText(Html.fromHtml("<a href='https://codeforces.com/'>->Simple Input Output Activity page</a>"));


        itemWebView=view.findViewById(R.id.aLegs);
        if (itemWebView != null) {
            itemWebView.loadDataWithBaseURL(null, web_view, "text/html", "utf-8", null);
            WebSettings webSettings = itemWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);

            itemWebView.setNestedScrollingEnabled(true);
        }

        copy_img=view.findViewById(R.id.img_view);
        copy_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemWebView != null) {
                    itemWebView.evaluateJavascript(
                            "(function() { return document.documentElement.innerText; })();",
                            value -> {
                                value = value.replace("\\n", "\n").replace("\\\"", "\"");
                                value = value.substring(1, value.length() - 1);

                                ClipboardManager clipboardManager = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                                ClipData clipData = ClipData.newPlainText("Copy", value);
                                clipboardManager.setPrimaryClip(clipData);

                                Toast.makeText(itemWebView.getContext(), "Copied", Toast.LENGTH_SHORT).show(); // Corrected context usage
                            }
                    );
                }
            }
        });
        return view;
    }
}
