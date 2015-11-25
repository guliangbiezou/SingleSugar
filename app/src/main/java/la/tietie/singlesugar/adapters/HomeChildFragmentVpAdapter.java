package la.tietie.singlesugar.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by steven on 2015/11/25.
 */
public class HomeChildFragmentVpAdapter  extends FragmentPagerAdapter{
    private List<Fragment>vp_childFragments;
    public HomeChildFragmentVpAdapter(FragmentManager fm, List<Fragment> vp_childFragments) {
        super(fm);
        this.vp_childFragments = vp_childFragments;
    }


    @Override
    public Fragment getItem(int position) {
        return vp_childFragments.get(position);
    }

    @Override
    public int getCount() {
        return vp_childFragments.size();
    }


}
