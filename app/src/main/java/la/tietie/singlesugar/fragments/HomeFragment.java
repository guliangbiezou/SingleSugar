package la.tietie.singlesugar.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.List;

import la.tietie.singlesugar.R;
import la.tietie.singlesugar.adapters.AbsRecyclerAdapter;
import la.tietie.singlesugar.adapters.MyFragmentAdapter;
import la.tietie.singlesugar.adapters.MyTitleAdapter;
import la.tietie.singlesugar.adapters.MypopButtonAdapter;
import la.tietie.singlesugar.bean.TitleEntity;
import la.tietie.singlesugar.utils.Constants;
import la.tietie.singlesugar.utils.VolleyUtil;
import la.tietie.singlesugar.utils.Xll_JsonUtils;

/**
 * Created by steven on 2015/11/22.
 */
public class HomeFragment extends Fragment implements View.OnClickListener, VolleyUtil.OnRequest,AbsRecyclerAdapter.OnItemClickListener, ViewPager.OnPageChangeListener {
    private ViewPager vp_home;
    private MyFragmentAdapter myFragmentAdapter;
    private List<Fragment> fragments = new ArrayList<>();
    private static final String TAG = "print";
    private RecyclerView rv_title;
    private RecyclerView rv_pop;
    private ImageView iv_search;
    private ImageView iv_more;
    private RelativeLayout rl_more1;
    private LinearLayout ll_more;
    private TextView tv_order;
    private ImageView iv_more1;
    private ImageView iv_delete;
    private MyTitleAdapter titleAdapter;
    private MypopButtonAdapter popAdapter;
    private PopupWindow popWindow;
    private TextView tv_hint;
    private List<TitleEntity>datas = new ArrayList<TitleEntity>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View  view = inflater.inflate(R.layout.home_fragment,null);
        initView(view);
        loadData();


        return view;
    }

    /**
     * 初始化ViewPager
     */
    private void initViewPager() {
        for(int i = 0; i < datas.size();i++){
            Bundle bundle = new Bundle();
            bundle.putInt(Constants.BUNDLE_KEY.HOMEFRAGMENT_TO_CHILDFRAGMENT,datas.get(i).getId());
            Fragment fragment = new ChildFragment();
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        myFragmentAdapter = new MyFragmentAdapter(getChildFragmentManager(),fragments);
        vp_home.setAdapter(myFragmentAdapter);
    }

    /**
     * 绑定数据
     */
    private void loadData() {

        VolleyUtil.requestString(Constants.URL.HOME_TITLE,this);
        titleAdapter = new MyTitleAdapter(getActivity(),R.layout.item_title);
        titleAdapter.setOnItemClickListener(new AbsRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                vp_home.setCurrentItem(position);
                Toast.makeText(getActivity(),"点击了"+position,Toast.LENGTH_SHORT).show();
            }
        });
        popAdapter = new MypopButtonAdapter(getActivity(),R.layout.item_popwindow_button);
        popAdapter.setOnItemClickListener(this);
        rv_title.setAdapter(titleAdapter);
        //rv_title.getChildAt(0).setBackgroundResource(R.drawable.abc_ab_transparent_dark_holo);
        rv_pop.setAdapter(popAdapter);

    }

    /**
     * 初始化homeFragment中的控件
     */
    private void initView(View view) {
        vp_home = (ViewPager) view.findViewById(R.id.vp_home);
        vp_home.addOnPageChangeListener(this);
        ll_more = (LinearLayout) view.findViewById(R.id.ll_more);
        rl_more1 = (RelativeLayout) view.findViewById(R.id.rl_more1);
        tv_order = (TextView) view.findViewById(R.id.tv_order);
        tv_hint = (TextView) view.findViewById(R.id.tv_hint);
        iv_more1 = (ImageView) view.findViewById(R.id.iv_more1);
        popWindow = new PopupWindow(getResources().getDisplayMetrics().widthPixels,getResources().getDisplayMetrics().heightPixels);
        View popWindowView = LayoutInflater.from(getActivity()).inflate(R.layout.popwindow,null);
        popWindow.setContentView(popWindowView);
        popWindow.setAnimationStyle(R.style.popWindowanim);
        iv_delete = (ImageView) popWindowView.findViewById(R.id.iv_delete);
        rv_title = (RecyclerView) view.findViewById(R.id.rv_home);
        rv_pop = (RecyclerView) popWindowView.findViewById(R.id.rv_pop);
        rv_pop.setLayoutManager(new StaggeredGridLayoutManager(4, 1));
        rv_title.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayout.HORIZONTAL,false));
        iv_search = (ImageView) view.findViewById(R.id.iv_search);
        iv_more = (ImageView) view.findViewById(R.id.iv_more);
        iv_more.setOnClickListener(this);
        iv_more1.setOnClickListener(this);
        tv_order.setOnClickListener(this);


    }

    /**
     * iv_
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.iv_more:
                popWindow.showAsDropDown(v);
                ll_more.setVisibility(View.GONE);
                rl_more1.setVisibility(View.VISIBLE);
                break;
            case R.id.iv_more1:
                popWindow.dismiss();
                rl_more1.setVisibility(View.GONE);
                ll_more.setVisibility(View.VISIBLE);
            case R.id.tv_order:
                tv_order.setText("完成");
                tv_hint.setText("拖动排序");


                break;
        }



    }

    /**
     * 数据下载成功
     * @param url
     * @param response
     */
    @Override
    public void response(String url, String response) {
        Log.i(TAG,response);
        datas = Xll_JsonUtils.getTitle(response);
        Log.i(TAG,datas.toString());
        titleAdapter.setDatas(datas);
        popAdapter.setDatas(datas);
        initViewPager();
    }

    /**
     * 数据下载失败
     * @param url
     * @param error
     */
    @Override
    public void errorResponse(String url, VolleyError error) {

    }

    /**
     * 实现Abs的监听方法
     * @param v
     * @param position
     */
    @Override
    public void onItemClick(View v, int position) {
        Toast.makeText(getActivity(),"点击了下标"+position,Toast.LENGTH_SHORT).show();
    }

    /**
     * ViewPager的监听回调方法
     * @param position
     * @param positionOffset
     * @param positionOffsetPixels
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for(int i = 0; i < rv_title.getChildCount();i++){
            rv_title.getChildAt(i).setBackgroundColor(Color.WHITE);
        }
        rv_title.getChildAt(position).setBackgroundResource(R.drawable.abc_ab_transparent_dark_holo);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
