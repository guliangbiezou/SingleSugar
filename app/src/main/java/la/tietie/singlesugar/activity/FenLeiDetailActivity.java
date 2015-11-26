package la.tietie.singlesugar.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.List;

import la.tietie.singlesugar.R;
import la.tietie.singlesugar.adapters.AbsBaseAdapter;
import la.tietie.singlesugar.bean.FenLeiZhuanTi;
import la.tietie.singlesugar.bean.FenleiChannels;
import la.tietie.singlesugar.bean.HomeEntity;
import la.tietie.singlesugar.utils.Constants;
import la.tietie.singlesugar.utils.JsonUtil;
import la.tietie.singlesugar.utils.VolleyUtil;
import la.tietie.singlesugar.view.XCRoundRectImageView;

public class FenLeiDetailActivity extends AppCompatActivity {

    ListView list;
    TextView title;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fen_lei_detail);
        initView();

    }

    private void initView() {
        Intent intent = getIntent();
        Object object = intent.getSerializableExtra("data");
        list = (ListView) findViewById(R.id.lv_detail_list);
        title = (TextView) findViewById(R.id.tv_detail_title);
        back = (ImageView) findViewById(R.id.iv_detail_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if (object instanceof FenLeiZhuanTi) {
            FenLeiZhuanTi data = (FenLeiZhuanTi) object;
            title.setText(data.getTitle());
            String url = String.format(Constants.URL.ZHUANGTI_DETAIL, data.getId());
            VolleyUtil.requestString(url, new VolleyUtil.OnRequest() {
                @Override
                public void response(String url, String response) {
                    List<HomeEntity> datas;
                    datas = JsonUtil.JsonHomeEntity(response);
                    FenLeiAdapter adapter = new FenLeiAdapter(FenLeiDetailActivity.this,
                            R.layout.item_homeentity);
                    list.setAdapter(adapter);
                    adapter.addDatas(datas);

                }

                @Override
                public void errorResponse(String url, VolleyError error) {

                }
            });

        } else if (object instanceof FenleiChannels.Channel) {
            FenleiChannels.Channel channel = (FenleiChannels.Channel) object;
            title.setText(channel.getName());
            String url = String.format(Constants.URL.SORT,channel.getId());
            VolleyUtil.requestString(url, new VolleyUtil.OnRequest() {
                @Override
                public void response(String url, String response) {
                    List<HomeEntity> datas;
                    datas = JsonUtil.JsonFenLeiCY(response);
                    FenLeiAdapter adapter = new FenLeiAdapter(FenLeiDetailActivity.this,
                            R.layout.item_homeentity);
                    list.setAdapter(adapter);
                    adapter.addDatas(datas);
                }

                @Override
                public void errorResponse(String url, VolleyError error) {

                }
            });
        }
    }

    class FenLeiAdapter extends AbsBaseAdapter<HomeEntity> {


        public FenLeiAdapter(Context context, int resid) {
            super(context, resid);
        }

        @Override
        public void bindDatas(ViewHolder viewHolder, HomeEntity data) {
            XCRoundRectImageView iv = (XCRoundRectImageView) viewHolder.getView(R.id.iv_homeItem);
            TextView tv = (TextView) viewHolder.getView(R.id.tv_homeItem);
            Button bt = (Button) viewHolder.getView(R.id.bt_homeItem);
            tv.setText(data.getTitle());
            bt.setText(data.getLikes_count()+"");
            VolleyUtil.reqestImage(data.getCover_image_url(),iv,R.drawable.ig_holder_image,R.drawable.ig_holder_image);

        }
    }
}