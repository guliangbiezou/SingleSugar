package la.tietie.singlesugar.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/11/23 0023.
 */
public class DanPingItem implements Serializable{

    private DanPingData data;
    private String type;

    public DanPingData getData() {
        return data;
    }

    public void setData(DanPingData data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
