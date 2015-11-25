package la.tietie.singlesugar.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import la.tietie.singlesugar.R;
import la.tietie.singlesugar.utils.Constants;
import la.tietie.singlesugar.utils.VolleyUtil;

/**
 * Created by steven on 2015/11/25.
 */
public class VpChildFragment extends Fragment {
    /**
     * 添加构造方法，以便创建对应的fragment
     */
    private String image_url;

    public VpChildFragment() {
    }

    public VpChildFragment(String image_url) {
        this.image_url = image_url;
    }

    private ImageView iv_childFragment;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vp_child_fragment,null);
        initView(view);
        loadImageView();
        return view;
    }

    private void loadImageView() {
        Bundle bundle = getArguments();
        image_url = bundle.getString(Constants.BUNDLE_KEY.VPCHILD_FRAGMENT_KEY);
        VolleyUtil.reqestImage(image_url,iv_childFragment,R.mipmap.ic_launcher,R.mipmap.ic_launcher);

    }

    private void initView(View view) {
        iv_childFragment = (ImageView) view.findViewById(R.id.iv_childFragment);
    }
}
