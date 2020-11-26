package nl.lensmedia.verkeersborden;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.firebase.messaging.FirebaseMessaging;

import nl.lensmedia.verkeersborden.Service.MyFirebaseInstanceService;

public class SecondActivity extends AppCompatActivity{

    private WebView mWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_second);

        mWebView = (WebView) findViewById(R.id.WebView);

        // Get web settings object
        WebSettings webSettings = mWebView.getSettings();

        // Enable javascript
        webSettings.setJavaScriptEnabled(true);

        // Enable local storage
        //webSettings.setDomStorageEnabled(true);

        //webSettings.setLoadWithOverviewMode(true);
        //webSettings.setUseWideViewPort(true);
        FirebaseMessaging.getInstance().subscribeToTopic("nieuws");

        // Accept cookies
        //CookieManager.getInstance().setAcceptThirdPartyCookies(mWebView, true);


        // Load local URL
//        mWebView.loadUrl("https://examencentrum.nl/");
        mWebView.loadUrl("file:///android_asset/index.html");



        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());
    }
}