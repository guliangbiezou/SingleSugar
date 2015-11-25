package la.tietie.singlesugar.adapters;

import android.content.Context;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import la.tietie.singlesugar.R;
import la.tietie.singlesugar.bean.HomeEntity;
import la.tietie.singlesugar.utils.VolleyUtil;

/**
 * Created by steven on 2015/11/24.
 */
public class MyHomeEntityAdapter  extends AbsRecyclerAdapter<HomeEntity>{
    public MyHomeEntityAdapter(Context context, int resId) {
        super(context, resId);
    }
    @Override
    public void bindDatas(MyViewHolder holder, HomeEntity data) {
        ImageView iv = (ImageView) holder.getView(R.id.iv_homeItem);
        Button bt = (Button) holder.getView(R.id.bt_homeItem);
        TextView tv = (TextView) holder.getView(R.id.tv_homeItem);
        VolleyUtil.reqestImage(data.getCover_image_url(),iv,R.mipmap.ic_launcher,R.mipmap.ic_launcher);
        bt.setText(data.getLikes_count()+"");
        tv.setText(data.getTitle());
    }
}
