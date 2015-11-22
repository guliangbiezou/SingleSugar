package la.tietie.singlesugar.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import la.tietie.singlesugar.R;
import la.tietie.singlesugar.utils.VolleyUtil;

public class MainActivity extends AppCompatActivity implements VolleyUtil.OnRequest {
    private ImageView imageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) this.findViewById(R.id.iv_main);
        textView = (TextView) this.findViewById(R.id.tv_main);
        VolleyUtil.reqestImage("http://img4.duitang.com/uploads/item/201308/21/20130821091748_MHfPU.thumb.600_0.jpeg",imageView,R.mipmap.ic_launcher,R.mipmap.ic_launcher);
    }

    @Override
    public void response(String url, String response) {
    }

    @Override
    public void errorResponse(String url, VolleyError error) {

    }
}
