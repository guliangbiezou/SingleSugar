package la.tietie.singlesugar.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.List;

import la.tietie.singlesugar.R;
import la.tietie.singlesugar.activity.DanPinDetailActivity;
import la.tietie.singlesugar.bean.DanPingData;
import la.tietie.singlesugar.bean.DanPingItem;
import la.tietie.singlesugar.utils.Constants;
import la.tietie.singlesugar.utils.JsonUtil;
import la.tietie.singlesugar.utils.VolleyUtil;

/**
 * Created by steven on 2015/11/22.
 */
public class DanPingFragment extends Fragment{

    private GridView gridView;
    private List<DanPingItem> datas;
    private GvAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.danping_fragment,null);
        initView(view);
        loadDatas();
        return view;
    }

    private void loadDatas() {
        VolleyUtil.requestString(Constants.URL.DANGPING, new VolleyUtil.OnRequest() {
            @Override
            public void response(String url, String response) {
                Log.e("print",response);
                datas = JsonUtil.JsonDanping(response);
                Log.e("print","datas------"+datas.toString());
                adapter.setData(datas);
            }

            @Override
            public void errorResponse(String url, VolleyError error) {

            }
        });
    }

    private void initView(View view) {
        gridView = (GridView) view.findViewById(R.id.gv_danping);
        adapter = new GvAdapter();
        gridView.setAdapter(adapter);
    }

    class GvAdapter extends BaseAdapter {

        List<DanPingItem> data = new ArrayList<>();

        public void setData(List<DanPingItem> data) {
            this.data = data;
            notifyDataSetChanged();
        }
        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if(convertView == null) {
                holder = new ViewHolder();
                View view = LayoutInflater.from(getContext()).inflate(R.layout.item_danping,null);
                convertView = view;
                holder.iv = (ImageView) convertView.findViewById(R.id.iv_item_dp);
                holder.name = (TextView) convertView.findViewById(R.id.tv_item_name);
                holder.price = (TextView) convertView.findViewById(R.id.tv_item_price);
                holder.favorcount = (TextView) convertView.findViewById(R.id.tv_item_favorcount);
                convertView.setTag(holder);
            } else  {
                holder = (ViewHolder) convertView.getTag();
            }
            VolleyUtil.reqestImage(data.get(position).getData().getCover_image_url(),
                    holder.iv,R.drawable.ig_holder_image,R.drawable.ig_holder_image);
            Log.e("print", "------" + data.get(position).getData().getCover_image_url());
            holder.name.setText(data.get(position).getData().getName());
            holder.price.setText(data.get(position).getData().getPrice());
            holder.favorcount.setText(data.get(position).getData().getFavorites_count());
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), DanPinDetailActivity.class);
                    intent.putExtra("data",data.get(position));
                    startActivityForResult(intent, 0);
                }
            });
            return convertView;
        }

        class ViewHolder {
            ImageView iv;
            TextView name,price,favorcount;
        }
    }
}
