package la.tietie.singlesugar.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.List;

import la.tietie.singlesugar.bean.DanPingData;
import la.tietie.singlesugar.bean.DanPingItem;

/**
 * Created by Administrator on 2015/11/23 0023.
 */
public class JsonUtil {

    public static List<DanPingItem> JsonDanping(String jsonStr) {
        List<DanPingItem> datas = new ArrayList<>();
        JSONObject all = JSONObject.parseObject(jsonStr);
        JSONObject data = all.getJSONObject("data");
        String result = data.getString("items");
        datas = JSON.parseArray(result,DanPingItem.class);
        return  datas;
    }
}
