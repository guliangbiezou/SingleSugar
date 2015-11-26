package la.tietie.singlesugar.activity;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import la.tietie.singlesugar.R;
import la.tietie.singlesugar.adapters.ProfilePagerAdapter;
import la.tietie.singlesugar.bean.DanPingData;
import la.tietie.singlesugar.bean.DanPingItem;
import la.tietie.singlesugar.utils.VolleyUtil;
import la.tietie.singlesugar.view.Dots_View;
import la.tietie.singlesugar.view.ScrollView_CanStop;

public class DanPinDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout center1;
    private ScrollView_CanStop sv;
    private Button left1,right1;
    private ImageView back;
    private Intent data;
    private DanPingItem danPingItem;
    private DanPingData danPingData;
    private ViewPager pager;
    private Dots_View dots_view;
    private TextView name,price,description;
    private ViewPager footpager;
    String[] urls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dan_pin_detail);
        data = getIntent();
        danPingItem = (DanPingItem) data.getSerializableExtra("data");
        danPingData = danPingItem.getData();
        initView();
    }

    private void initView() {
        center1 = (LinearLayout) findViewById(R.id.ll_detail_center1);
        sv = (ScrollView_CanStop) findViewById(R.id.sv_dp_detail);
        left1 = (Button) findViewById(R.id.bt_detail_left1);
        right1 = (Button) findViewById(R.id.bt_detail_right1);
        sv.setCenter1(center1);
        sv.setLeftBt("图文介绍");
        sv.left.setOnClickListener(this);
        sv.setRightBt("评论(0)");
        sv.right.setOnClickListener(this);
        left1.setText("图文介绍");
        left1.setOnClickListener(this);
        right1.setText("评论(0)");
        right1.setOnClickListener(this);
        back = (ImageView)findViewById(R.id.iv_detail_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DanPinDetailActivity.this, MainActivity.class);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        initHead();
        initFoot();
    }


    private void initHead() {

        View head = LayoutInflater.from(this).inflate(R.layout.danping_detail_head,null);
        pager = (ViewPager) head.findViewById(R.id.vp_dp_detail);
        dots_view = (Dots_View) head.findViewById(R.id.dv_dp_detail);
        name = (TextView) head.findViewById(R.id.tv_detail_name);
        price = (TextView) head.findViewById(R.id.tv_detail_price);
        description = (TextView) head.findViewById(R.id.tv_detail_description);
        name.setText(danPingData.getName());
        price.setText("¥"+danPingData.getPrice());
        description.setText(danPingData.getDescription());
        List<View> imgs = new ArrayList<>();
        urls = danPingData.getImage_urls();
        for (int i=0;i<urls.length;i++) {
            ImageView iv = new ImageView(this);
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            VolleyUtil.reqestImage(urls[i],iv,R.drawable.ig_holder_image,R.drawable.ig_holder_image);
            imgs.add(iv);
        }
        ProfilePagerAdapter adapter = new ProfilePagerAdapter();
        dots_view.setCount(imgs.size());
        pager.setAdapter(adapter);
        adapter.setDatas(imgs);
        sv.addHead(head);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                dots_view.setOffset(position + positionOffset);
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void initFoot() {
        View foot = LayoutInflater.from(this).inflate(R.layout.danping_detail_foot,null);
        ViewPager pager = (ViewPager) foot.findViewById(R.id.vp_dp_foot);
        List<View> datas = new ArrayList<>();
        View detail = LayoutInflater.from(this).inflate(R.layout.danping_detail_web,null);
        WebView web = (WebView) detail;
        web.loadUrl(danPingData.getUrl());
        datas.add(web);
        View pl = LayoutInflater.from(this).inflate(R.layout.danping_detail_pl,null);
        datas.add(pl);
        ProfilePagerAdapter adapter = new ProfilePagerAdapter();
        pager.setAdapter(adapter);
        adapter.setDatas(datas);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        params.height = 30000;
        foot.setLayoutParams(params);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                sv.clickcenter(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        footpager = pager;
        sv.addFoot(foot);

    }


    @Override
    public void onClick(View v) {
        if(v == sv.left || v == left1) {
            footpager.setCurrentItem(0);
        }
        if(v == sv.right|| v == right1) {
            footpager.setCurrentItem(1);
        }
    }
}
