package la.tietie.singlesugar.app;

import android.app.Application;


import la.tietie.singlesugar.utils.Share;
import la.tietie.singlesugar.utils.VolleyUtil;

/**
 * Created by Administrator on 2015/11/21 0021.
 */
public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        VolleyUtil.initVolley(this);
        Share.init(this);
    }
}
