package co.edu.unal.tutorial9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class web extends AppCompatActivity {

    public WebView wv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        wv1 = (WebView)findViewById(R.id.webView1);

        String url = getIntent().getStringExtra("direccion");
        wv1.setWebViewClient(new WebViewClient());
        wv1.loadUrl("http://"+url);
    }

    public void Cerra(View v){
        finish();
    }
}
