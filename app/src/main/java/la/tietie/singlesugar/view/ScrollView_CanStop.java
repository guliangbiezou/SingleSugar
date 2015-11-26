package la.tietie.singlesugar.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import la.tietie.singlesugar.R;



public class ScrollView_CanStop extends ScrollView{

    LinearLayout head,foot,center,center1;
    int currentY;
    public Button left,right;
    private TextView leftb,rightb,left1_b,right1_b;

    public void setCenter1(LinearLayout center1) {
        this.center1 = center1;
        left1_b = (TextView) center1.findViewById(R.id.bt_scroll_left_b);
        right1_b = (TextView) center1.findViewById(R.id.bt_scroll_right_b);
    }

    public ScrollView_CanStop(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.view_scroll,null);
        left = (Button) view.findViewById(R.id.bt_scroll_left);
        right = (Button) view.findViewById(R.id.bt_scroll_right);
        leftb = (TextView) view.findViewById(R.id.bt_scroll_left_b);
        rightb = (TextView) view.findViewById(R.id.bt_scroll_right_b);
        setVerticalScrollBarEnabled(false);
        addView(view);
        initView(view);
    }

    public void clickcenter(int index) {
        if(index == 0) {
            leftb.setBackgroundColor(Color.parseColor("#EC5252"));
            left1_b.setBackgroundColor(Color.parseColor("#EC5252"));
        } else {
            leftb.setBackgroundColor(Color.WHITE);
            left1_b.setBackgroundColor(Color.WHITE);
        }
        if(index == 1) {
            rightb.setBackgroundColor(Color.parseColor("#EC5252"));
            right1_b.setBackgroundColor(Color.parseColor("#EC5252"));
        }else  {

            rightb.setBackgroundColor(Color.WHITE);
            right1_b.setBackgroundColor(Color.WHITE);
        }
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

    public void setLeftBt(String str) {
        left.setText(str);
    }

    public void setRightBt(String str) {
        right.setText(str);
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
