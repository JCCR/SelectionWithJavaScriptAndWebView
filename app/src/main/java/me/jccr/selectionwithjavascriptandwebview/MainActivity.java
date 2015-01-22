package me.jccr.selectionwithjavascriptandwebview;

import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;


public class MainActivity extends ActionBarActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.addJavascriptInterface(this, "ActivityInterface");
        mWebView.loadUrl("file:///android_asset/main.html");
        mWebView.getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

    @JavascriptInterface
    public void selectionChange(String infoJson){
        Log.d(TAG, infoJson);
        /*
        Example output:
            {
              "boundingRect": {
                "height": 40,
                "width": 235,
                "left": 8,
                "bottom": 48,
                "right": 243,
                "top": 8
              },
              "rectList": [
                {
                  "height": 19,
                  "width": 190,
                  "left": 53,
                  "bottom": 27,
                  "right": 243,
                  "top": 8
                },
                {
                  "height": 21,
                  "width": 234,
                  "left": 8,
                  "bottom": 48,
                  "right": 242,
                  "top": 27
                },
                {
                  "height": 19,
                  "width": 200,
                  "left": 9,
                  "bottom": 47,
                  "right": 209,
                  "top": 28
                }
              ],
              "selectionText": "random text and elements Some random text and elem",
              "isEmpty": false
            }
         */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
