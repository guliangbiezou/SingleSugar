package la.tietie.singlesugar.utils;

/**
 * Created by Administrator on 2015/11/21 0021.
 */
public interface Constants {
    interface  URL{
        String HOME_TITLE = "http://api.dantangapp.com/v2/channels/preset?gender=1&generation=2";
        String HOME_VIEWPAGER = "http://api.dantangapp.com/v2/banners";
        String HOME_LISTVIEW = "http://api.dantangapp.com/v2/channels/%d/items?limit=20&offset=0&gender=1&generation=2";
        String DANGPING = "http://api.dantangapp.com/v2/items?limit=20&offset=0&gender=1&generation=2";
        String SORT_ZHUANTI_IMAGES = "http://api.dantangapp.com/v2/collections?limit=10&offset=0";
        String ZHUANGTI_DETAIL = "http://api.dantangapp.com/v2/collections/%d/posts?limit=20&offset=0";


        String SHANGPING_DETAIL_V2 = "http://api.dantangapp.com/v2/items/%d";
        String SHANGPING_PINGLUN_V2 = "http://api.dantangapp.com/v2/items/%d/comments?offset=0&limit=20";

        String SHANGPING_DETAIL_V1 = "http://api.dantangapp.com/v1/posts/%d";
        String SHANGPING_PINGLUN_V1 = "http://api.dantangapp.com/v1/posts/%d/comments?offset=0&limit=20";

        String SEARCH_SHANGPING = "http://api.dantangapp.com/v2/search/item?keyword=%s&sort=&offset=0&limit=20";
        String SEARCH_ZHUANTI = "http://api.dantangapp.com/v2/search/post?keyword=%s&sort=&offset=0&limit=20";

        String SORT_MAIN = "http://api.dantangapp.com/v2/channel_groups/all";
        String SORT = "http://api.dantangapp.com/v2/channels/%d/items?limit=20&offset=0&gender=1&generation=3";

    }
}
