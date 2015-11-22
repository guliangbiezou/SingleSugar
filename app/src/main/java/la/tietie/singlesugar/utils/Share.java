package la.tietie.singlesugar.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2015/11/21 0021.
 */
public class Share {

    public static SharedPreferences preferences;
    public static SharedPreferences.Editor editor;
    public static void init(Context context) {
        preferences = context.getSharedPreferences("share_pres",context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public static void putString(String key,String value) {
        editor.putString(key,value);
        editor.commit();
    }

    public static String  getString(String key,String defaul) {
       return preferences.getString(key,defaul);
    }

    public static void putBoolean(String key,boolean value) {
        editor.putBoolean(key,value);
        editor.commit();
    }

    public static boolean getBoolean(String key,boolean defaul) {
        return preferences.getBoolean(key,defaul);
    }
}
