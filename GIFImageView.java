Create a custom class by extending Webview class & add constructor for it...

public class GifWebView extends WebView {
       public GifWebView(Context context, String path) {
              super(context);
              loadUrl(path);
       }

}

Use this custom class in your Activity as follows


public class MainActivity extends Activity {
       @Override
       protected void onCreate(Bundle savedInstanceState) {
              super.onCreate(savedInstanceState);
                           
              GifWebView view = new GifWebView(this, "file:///android_asset/image.gif");
              setContentView(view);
       }

}
