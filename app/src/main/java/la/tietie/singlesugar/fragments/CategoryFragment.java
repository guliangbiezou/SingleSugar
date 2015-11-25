package la.tietie.singlesugar.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;

import java.util.Arrays;
import java.util.List;

import la.tietie.singlesugar.R;
import la.tietie.singlesugar.adapters.AbsRecyclerAdapter;
import la.tietie.singlesugar.bean.FenLeiZhuanTi;
import la.tietie.singlesugar.bean.FenleiChannels;
import la.tietie.singlesugar.utils.Constants;
import la.tietie.singlesugar.utils.JsonUtil;
import la.tietie.singlesugar.utils.VolleyUtil;

/**
 * Created by steven on 2015/11/22.
 */
public class CategoryFragment extends Fragment {

    RecyclerView zhuanti,fengge,pinglei;
    List<FenLeiZhuanTi> datas_zt;
    List<FenleiChannels> datas;
    List<FenleiChannels.Channel> datas_fg,datas_pl;
    ZhuanTiAdapter adapter_zt;
    ZhuanTiAdapter_FGPL adapter_fg,adapter_pl;
    TextView tv_fg,tv_pl;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.category_fragment,null);
        initView(view);
        loadDatas();
        return view;
    }

    private void loadDatas() {
        VolleyUtil.requestString(Constants.URL.SORT_ZHUANTI_IMAGES, new VolleyUtil.OnRequest() {
            @Override
            public void response(String url, String response) {
                datas_zt = JsonUtil.JsonFenLeiZhuanTi(response);
                adapter_zt.setDatas(datas_zt);
            }

            @Override
            public void errorResponse(String url, VolleyError error) {

            }
        });

        VolleyUtil.requestString(Constants.URL.SORT_MAIN, new VolleyUtil.OnRequest() {
            @Override
            public void response(String url, String response) {
                datas = JsonUtil.JsonChannels(response);
                datas_fg = Arrays.asList(datas.get(0).getChannels());
                datas_pl = Arrays.asList(datas.get(1).getChannels());
                tv_fg.setText(datas.get(0).getName());
                tv_pl.setText(datas.get(1).getName());
                adapter_fg.setDatas(datas_fg);
                adapter_pl.setDatas(datas_pl);

            }

            @Override
            public void errorResponse(String url, VolleyError error) {

            }
        });

    }

    private void initView(View view) {
        tv_fg = (TextView) view.findViewById(R.id.tv_fgtitle);
        tv_pl = (TextView) view.findViewById(R.id.tv_pltitle);
        zhuanti = (RecyclerView) view.findViewById(R.id.rv_fenlei);
        fengge = (RecyclerView) view.findViewById(R.id.rv_fenlei_fg);
        pinglei = (RecyclerView) view.findViewById(R.id.rv_fenlei_pl);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL,false);
        zhuanti.setLayoutManager(manager);
        adapter_zt = new ZhuanTiAdapter(getContext(),R.layout.item_fenlei_zhuanti);
        zhuanti.setAdapter(adapter_zt);
        GridLayoutManager manager_fg = new GridLayoutManager(getContext(),4);
        fengge.setLayoutManager(manager_fg);
        adapter_fg = new ZhuanTiAdapter_FGPL(getContext(),R.layout.item_fenlei_fgpl);
        fengge.setAdapter(adapter_fg);
        GridLayoutManager manager_pl = new GridLayoutManager(getContext(),4);
        pinglei.setLayoutManager(manager_pl);
        adapter_pl = new ZhuanTiAdapter_FGPL(getContext(),R.layout.item_fenlei_fgpl);
        pinglei.setAdapter(adapter_pl);

    }

    class ZhuanTiAdapter extends AbsRecyclerAdapter<FenLeiZhuanTi> {

        public ZhuanTiAdapter(Context context, int resId) {
            super(context, resId);
        }

        @Override
        public void bindDatas(MyViewHolder holder, FenLeiZhuanTi data) {
              ImageView iv = (ImageView) holder.getView(R.id.iv_fl_zhuanti);
              VolleyUtil.reqestImage(data.getBanner_image_url(),iv,R.drawable.ig_holder_image,R.drawable.ig_holder_image);
        }
    }

    class ZhuanTiAdapter_FGPL extends  AbsRecyclerAdapter<FenleiChannels.Channel> {

        public ZhuanTiAdapter_FGPL(Context context, int resId) {
            super(context, resId);
        }

        @Override
        public void bindDatas(MyViewHolder holder, FenleiChannels.Channel data) {
            ImageView iv = (ImageView) holder.getView(R.id.iv_item_fgpl);
            TextView tv = (TextView) holder.getView(R.id.tv_item_fgpl);
            VolleyUtil.reqestImage(data.getIcon_url(),iv,R.drawable.ig_holder_image,R.drawable.ig_holder_image);
            tv.setText(data.getName());
        }
    }
}
