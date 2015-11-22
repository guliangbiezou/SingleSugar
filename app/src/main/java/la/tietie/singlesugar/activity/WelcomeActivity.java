package la.tietie.singlesugar.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import la.tietie.singlesugar.R;
import la.tietie.singlesugar.view.Dots_View;

public class WelcomeActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private  Dots_View dots_view;
    private ViewPager pager;
    private List<View> datas;
    private int imgs[];
    private WelPagerAdapter adapter;
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        intiView();

    }

    private void intiView() {
        dots_view = (Dots_View) findViewById(R.id.dots);
        pager = (ViewPager) findViewById(R.id.vp_welcome);
        bt = (Button) findViewById(R.id.bt_welcome);
        imgs = new int[]{R.drawable.walkthrough_1,R.drawable.walkthrough_2,
        R.drawable.walkthrough_3,R.drawable.walkthrough_4};
        datas = new ArrayList<>();
        dots_view.setCount(imgs.length);
        for (int i=0; i<imgs.length;i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.view_welcome_page,null);
            ImageView iv = (ImageView) view.findViewById(R.id.iv_wel_img);
            iv.setImageResource(imgs[i]);
            datas.add(view);
        }
        adapter = new WelPagerAdapter();
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        dots_view.setOffset(position+positionOffset);
    }

    @Override
    public void onPageSelected(int position) {
        if(position == imgs.length-1) {
            bt.setVisibility(View.VISIBLE);
        }else {
            bt.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class WelPagerAdapter extends PagerAdapter {


        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
           container.removeView(datas.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(datas.get(position));
            return datas.get(position);
        }
    }

    public void click(View view) {
        Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
