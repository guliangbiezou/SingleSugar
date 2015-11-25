package la.tietie.singlesugar.utils;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.List;

import la.tietie.singlesugar.bean.DanPingData;
import la.tietie.singlesugar.bean.DanPingItem;
import la.tietie.singlesugar.bean.FenLeiZhuanTi;
import la.tietie.singlesugar.bean.FenleiChannels;

/**
 * Created by Administrator on 2015/11/23 0023.
 */
public class JsonUtil {

    public static List<DanPingItem> JsonDanping(String jsonStr) {
        List<DanPingItem> datas;
        JSONObject all = JSONObject.parseObject(jsonStr);
        JSONObject data = all.getJSONObject("data");
        String result = data.getString("items");
        datas = JSON.parseArray(result,DanPingItem.class);
        return  datas;
    }

    public static List<FenLeiZhuanTi> JsonFenLeiZhuanTi (String jsonStr) {
        List<FenLeiZhuanTi> datas;
        JSONObject object = JSONObject.parseObject(jsonStr);
        object = object.getJSONObject("data");
        String result = object.getString("collections");
        datas = JSON.parseArray(result,FenLeiZhuanTi.class);
        Log.e("print",datas.toString());
        return  datas;
    }

    public static List<FenleiChannels>  JsonChannels(String jsonStr) {
        List<FenleiChannels> datas;
        JSONObject object = JSONObject.parseObject(jsonStr);
        object = object.getJSONObject("data");
        String result = object.getString("channel_groups");
        datas = JSON.parseArray(result,FenleiChannels.class);
        return  datas;
    }
}
