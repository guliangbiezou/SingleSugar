package la.tietie.singlesugar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import la.tietie.singlesugar.R;

/**
 * Created by steven on 2015/11/25.
 */
public class MarkView extends LinearLayout {
    public MarkView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.mark_view, this, true);
        initView();
    }

    private void initView() {

    }
}
