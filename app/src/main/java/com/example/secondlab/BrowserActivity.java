package com.example.secondlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class BrowserActivity extends AppCompatActivity implements View.OnClickListener {

    Button BackToMenu;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        BackToMenu = findViewById(R.id.backToMenu);
        BackToMenu.setOnClickListener(this);

        webView = findViewById(R.id.web);
        // включаем поддержку JavaScript
        webView.getSettings().setJavaScriptEnabled(true);
        // указываем страницу загрузки
        webView.loadUrl("https://www.google.com");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backToMenu:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
