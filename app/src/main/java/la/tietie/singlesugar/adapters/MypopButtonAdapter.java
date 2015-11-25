package la.tietie.singlesugar.adapters;

import android.content.Context;
import android.media.Image;
import android.widget.Button;
import android.widget.ImageView;

import la.tietie.singlesugar.R;
import la.tietie.singlesugar.bean.TitleEntity;

/**
 * Created by steven on 2015/11/23.
 */
public class MypopButtonAdapter extends AbsRecyclerAdapter<TitleEntity>{
    public MypopButtonAdapter(Context context, int resId) {
        super(context, resId);
    }

    @Override
    public void bindDatas(MyViewHolder holder, TitleEntity data) {
        Button bt = (Button) holder.getView(R.id.button_title);
        ImageView iv = (ImageView) holder.getView(R.id.iv_delete);
        bt.setText(data.getTitle_name());
        iv.setImageResource(R.drawable.channel_cell_btn_delete);
    }
}
