package la.tietie.singlesugar.adapters;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;
import android.widget.TextView;

import la.tietie.singlesugar.R;
import la.tietie.singlesugar.bean.TitleEntity;

/**
 * Created by steven on 2015/11/23.
 */
public class MyTitleAdapter extends AbsRecyclerAdapter<TitleEntity>{


    public MyTitleAdapter(Context context, int resId) {
        super(context, resId);
    }

    @Override
    public void bindDatas(MyViewHolder holder, TitleEntity data) {
        Button bt = (Button) holder.getView(R.id.button_title);
        bt.setText(data.getTitle_name());
    }
}
