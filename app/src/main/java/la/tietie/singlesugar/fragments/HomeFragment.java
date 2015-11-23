package la.tietie.singlesugar.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.List;

import la.tietie.singlesugar.R;
import la.tietie.singlesugar.adapters.MyTitleAdapter;
import la.tietie.singlesugar.bean.TitleEntity;
import la.tietie.singlesugar.utils.Constants;
import la.tietie.singlesugar.utils.VolleyUtil;
import la.tietie.singlesugar.utils.Xll_JsonUtils;

/**
 * Created by steven on 2015/11/22.
 */
public class HomeFragment extends Fragment implements View.OnClickListener, VolleyUtil.OnRequest {
    private static final String TAG = "print";
    private RecyclerView rv_title;
    private ImageView iv_search;
    private ImageView iv_more;
    private MyTitleAdapter titleAdapter;
    private PopupWindow popWindow;
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
     * 绑定数据
     */
    private void loadData() {

        VolleyUtil.requestString(Constants.URL.HOME_TITLE,this);
        titleAdapter = new MyTitleAdapter(getActivity(),R.layout.item_title);

        rv_title.setAdapter(titleAdapter);

    }

    /**
     * 初始化homeFragment中的控件
     */
    private void initView(View view) {
        popWindow = new PopupWindow(getResources().getDisplayMetrics().widthPixels,getResources().getDisplayMetrics().heightPixels);
        View popWindowView = LayoutInflater.from(getActivity()).inflate(R.layout.popwindow,null);
        popWindow.setContentView(popWindowView);
        rv_title = (RecyclerView) view.findViewById(R.id.rv_home);
        rv_title.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayout.HORIZONTAL,false));
        iv_search = (ImageView) view.findViewById(R.id.iv_search);
        iv_more = (ImageView) view.findViewById(R.id.iv_more);
        iv_more.setOnClickListener(this);
    }

    /**
     * iv_
     * @param v
     */
    @Override
    public void onClick(View v) {
        if(popWindow.isShowing()){
            popWindow.dismiss();
        }else{
            popWindow.showAsDropDown(v);
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
