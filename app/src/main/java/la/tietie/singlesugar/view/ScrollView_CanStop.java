package la.tietie.singlesugar.view;

import android.app.usage.UsageEvents;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.text.LoginFilter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import la.tietie.singlesugar.R;

import static la.tietie.singlesugar.R.layout.view_scroll;

/**
 * Created by Administrator on 2015/11/24 0024.
 */
public class ScrollView_CanStop extends ScrollView{

    LinearLayout head,foot,center,center1;
    int currentY,goneY;

    public void setCenter1(LinearLayout center1) {
        this.center1 = center1;
    }

    public ScrollView_CanStop(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.view_scroll,null);
        addView(view);
        initView(view);
    }

    private void initView(View view) {
        head = (LinearLayout) view.findViewById(R.id.ll_scroll_head);
        center = (LinearLayout) view.findViewById(R.id.ll_scroll_center);
        foot = (LinearLayout) view.findViewById(R.id.ll_scroll_foot);
    }

    public void addHead(View view) {
        head.addView(view);
    }

    public void addFoot(View view) {
        foot.addView(view);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        currentY = (int)(t - center.getY());
            if(currentY<=0) {
                center1.setVisibility(GONE);
            }  else {
                center1.setVisibility(VISIBLE);
            }

    }




}
