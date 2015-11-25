package la.tietie.singlesugar.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/24 0024.
 */
public class ProfilePagerAdapter extends PagerAdapter {

    List<View> datas = new ArrayList<>();



    public void setDatas(List<View> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(datas.get(position));
        return  datas.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(datas.get(position));
    }
}
