package la.tietie.singlesugar.fragments;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import la.tietie.singlesugar.R;
import la.tietie.singlesugar.adapters.ProfilePagerAdapter;
import la.tietie.singlesugar.view.CustomViewPager;
import la.tietie.singlesugar.view.ScrollView_CanStop;

/**
 * Created by steven on 2015/11/22.
 */
public class ProfileFragment extends Fragment  {

    private ScrollView_CanStop sv;
    private LinearLayout center1;
    private Button left1,right1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        sv = (ScrollView_CanStop) view.findViewById(R.id.sv_profile);
        left1 = (Button) view.findViewById(R.id.bt_scroll_left1);
        right1 = (Button) view.findViewById(R.id.bt_scroll_right1);
        View head = LayoutInflater.from(getContext()).inflate(R.layout.profile_scroll_head,null);
        sv.addHead(head);
        center1 = (LinearLayout) view.findViewById(R.id.ll_scroll_center1);
        sv.setCenter1(center1);
        sv.setLeftBt("喜欢的商品");
        left1.setText("喜欢的商品");
        sv.setRightBt("喜欢的专题");
        right1.setText("喜欢的专题");
        initSVFoot();
    }


    public void initSVFoot() {
        View view1 = LayoutInflater.from(getContext()).inflate(R.layout.layout_scroll_foot_hei, null);
        View view2 = LayoutInflater.from(getContext()).inflate(R.layout.layout_scroll_foot_hei,null);
        List<View> datas = new ArrayList<>();
        datas.add(view1);
        datas.add(view2);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        view1.setLayoutParams(params);
        view2.setLayoutParams(params);
        CustomViewPager pager = new CustomViewPager(getContext());
        ProfilePagerAdapter adapter = new ProfilePagerAdapter();
        pager.setAdapter(adapter);
        params.height = 800;
        pager.setLayoutParams(params);
        adapter.setDatas(datas);
        sv.addFoot(pager);
    }



}
