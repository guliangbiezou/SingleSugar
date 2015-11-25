package la.tietie.singlesugar.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.List;

import la.tietie.singlesugar.R;
import la.tietie.singlesugar.adapters.HomeChildFragmentVpAdapter;
import la.tietie.singlesugar.adapters.MyHomeEntityAdapter;
import la.tietie.singlesugar.bean.HomeEntity;
import la.tietie.singlesugar.bean.JingXuanVpEntity;
import la.tietie.singlesugar.utils.Constants;
import la.tietie.singlesugar.utils.VolleyUtil;
import la.tietie.singlesugar.utils.Xll_JsonUtils;
import la.tietie.singlesugar.view.Dots_View;
import la.tietie.singlesugar.view.MyViewPager;

/**
 * Created by steven on 2015/11/24.
 */
public class ChildFragment extends Fragment implements VolleyUtil.OnRequest {

    public static final String TAG = "printl";
    private int framentID;
    private MyViewPager vp_childFragment;
    private List<HomeEntity>data = new ArrayList<>();
    private List<Fragment>vp_childFragments = new ArrayList<>();
    private List<JingXuanVpEntity> vpDatas = new ArrayList<>();
    private MyHomeEntityAdapter myHomeEntityAdapter;
    private RecyclerView rv_childFragment;
    private Dots_View dots_view;
    public ChildFragment(){}

    public ChildFragment(int framentID) {

        this.framentID = framentID;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vp_fragment,null);
        initView(view);
        loadData();
        return view;
    }

    /**
     * 初始化控件的数据
     */
    private void loadData() {
        Bundle bundle = getArguments();
        framentID = bundle.getInt(Constants.BUNDLE_KEY.HOMEFRAGMENT_TO_CHILDFRAGMENT);
        if(framentID == 6){
            vp_childFragment.setVisibility(View.VISIBLE);
            dots_view.setVisibility(View.VISIBLE);
        }
        String url = String.format(Constants.URL.HOME_LISTVIEW, framentID);
        VolleyUtil.requestString(url, this);
        VolleyUtil.requestString(Constants.URL.HOME_VIEWPAGER, this);
    }

    /**
     * 初始子fragment中的控件
     */
    private void initView(View view) {
        vp_childFragment = (MyViewPager) view.findViewById(R.id.vp_childFragment);
        rv_childFragment = (RecyclerView) view.findViewById(R.id.rv_chilFragment);
        rv_childFragment.setLayoutManager(new LinearLayoutManager(getActivity()));
        myHomeEntityAdapter = new MyHomeEntityAdapter(getActivity(),R.layout.item_homeentity);
        rv_childFragment.setAdapter(myHomeEntityAdapter);
        dots_view = (Dots_View) view.findViewById(R.id.dv_childFragment);
        dots_view.setCount(3);
        vp_childFragment.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                dots_view.setOffset(position+positionOffset);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    /**
     * 数据下载成功
     * @param url
     * @param response
     */
    @Override
    public void response(String url, String response) {
        if(url.equals(String.format(Constants.URL.HOME_LISTVIEW,framentID))){
            data = Xll_JsonUtils.getHomeEntity(response);
            Log.e(TAG, response);
            myHomeEntityAdapter.setDatas(data);
        }else{
            vpDatas =Xll_JsonUtils.getHomeViewPagerEntity(response);
            initViewPager();
            vp_childFragment.setAdapter(new HomeChildFragmentVpAdapter(getFragmentManager(),vp_childFragments));
        }

        /**
         * 下面是viewPager的数据
         */

    }

    /**
     * 初始化viewPager
     */
    private void initViewPager() {
        for(int i = 0;i < vpDatas.size();i++){
            Bundle bundle = new Bundle();
            bundle.putString(Constants.BUNDLE_KEY.VPCHILD_FRAGMENT_KEY,vpDatas.get(i).getImage_url());
            Fragment fragment = new VpChildFragment();
            fragment.setArguments(bundle);
            vp_childFragments.add(fragment);

        }
    }

    /**
     * 数据下载失败
     * @param url
     * @param error
     */
    @Override
    public void errorResponse(String url, VolleyError error) {

    }
}
