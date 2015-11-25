package la.tietie.singlesugar.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2015/11/21 0021.
 */
public class VolleyUtil {
    public static RequestQueue queue;
    public static LruCache<String ,Bitmap>  lruCache;
    public static void initVolley(Context context) {
        if(queue == null) {
            queue = Volley.newRequestQueue(context);
        }
        lruCache = new LruCache<String,Bitmap>((int)(Runtime.getRuntime().maxMemory()/8)){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight();
            }
        };
    }

    public static void requestString(final  String url,final OnRequest onRequest) {
        final StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                onRequest.response(url,response);
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onRequest.errorResponse(url,error);
            }
        });

        queue.add(request);

    }

    public static void reqestImage(String url,ImageView iv,int resid,int errorid) {
        ImageLoader loader = new ImageLoader(queue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {
                return lruCache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                lruCache.put(url,bitmap);
            }
        });

        loader.get(url, ImageLoader.getImageListener(iv, resid, errorid));

    }

    public interface OnRequest{
        void response(String url, String response);
        void errorResponse(String url, VolleyError error);
    }
}
