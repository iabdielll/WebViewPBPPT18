package com.example.webview28octubre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview = findViewById(R.id.wView);
        WebSettings wSettings = webview.getSettings();
        wSettings.setJavaScriptEnabled(true);
        webview.addJavascriptInterface(new JavaScriptInterface(), "appInterface");
    }

    public void loadURL(View v){
        EditText urlET = findViewById(R.id.etUrl);
        String url = urlET.getText().toString();
        if (url.isEmpty()){
            Toast.makeText(this, "Ingrese una URL valida", Toast.LENGTH_SHORT).show();
        }else {
            webview.loadUrl(url);
        }
    }

    private class JavaScriptInterface{
        @android.webkit.JavascriptInterface
        public void showToast(String message){

        }
    }
}