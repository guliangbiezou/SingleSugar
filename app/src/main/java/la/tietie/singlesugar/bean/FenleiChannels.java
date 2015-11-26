package la.tietie.singlesugar.bean;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Administrator on 2015/11/24 0024.
 */
public class FenleiChannels implements Serializable{

    private  Channel[] channels;
    private  String id;
    private  String name;
    private  String order;
    private  String status;

    public FenleiChannels() {
    }

    public Channel[] getChannels() {
        return channels;
    }

    public void setChannels(Channel[] channels) {
        this.channels = channels;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FenleiChannels{" +
                "channels=" + Arrays.toString(channels) +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", order='" + order + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

   public static class Channel implements Serializable{
        private  String group_id;
        private  String icon_url;
        private  String id;
        private  String items_count;
        private  String name;
        private  String order;
        private  String status;

        public Channel() {
        }

        @Override
        public String toString() {
            return "Channel{" +
                    "group_id='" + group_id + '\'' +
                    ", icon_url='" + icon_url + '\'' +
                    ", id='" + id + '\'' +
                    ", items_count='" + items_count + '\'' +
                    ", name='" + name + '\'' +
                    ", order='" + order + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }

        public String getGroup_id() {
            return group_id;
        }

        public void setGroup_id(String group_id) {
            this.group_id = group_id;
        }

        public String getIcon_url() {
            return icon_url;
        }

        public void setIcon_url(String icon_url) {
            this.icon_url = icon_url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getItems_count() {
            return items_count;
        }

        public void setItems_count(String items_count) {
            this.items_count = items_count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
