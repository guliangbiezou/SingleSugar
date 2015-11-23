package la.tietie.singlesugar.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import la.tietie.singlesugar.bean.TitleEntity;

/**
 * Created by steven on 2015/11/23.
 */
public class Xll_JsonUtils {
    public static List<TitleEntity> getTitle(String jsonStr){
        List<TitleEntity> data = null;
        try {
            JSONObject object = new JSONObject(jsonStr);
            JSONObject object1 = object.getJSONObject("data");
            JSONArray array = object1.getJSONArray("channels");
            TypeToken<List<TitleEntity>> tt = new TypeToken<List<TitleEntity>>(){};
            data = new Gson().fromJson(array.toString(),tt.getType());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }
}
