package la.tietie.singlesugar.bean;

/**
 * Created by steven on 2015/11/25.
 * {
 "channel": "all",
 "id": 4,
 "image_url": "http://7fvaoh.com3.z0.glb.qiniucdn.com/image/150806/kzp5acor6.jpg-w720",
 "order": 1,
 "status": 0,
 "target": {
 "banner_image_url": "http://7fvaoh.com3.z0.glb.qiniucdn.com/image/150806/cb3ee6gg8.jpg-w300",
 "cover_image_url": "http://7fvaoh.com3.z0.glb.qiniucdn.com/image/150806/8jrebu9ol.jpg-w720",
 "created_at": 1438826204,
 "id": 3,
 "posts_count": 3,
 "status": 0,
 "subtitle": "零食控的最爱",
 "title": "你不能错过的高颜值零食",
 "updated_at": 1438826204
 },
 "target_id": 3,
 "target_url": "",
 "type": "collection"
 },
 */
public class JingXuanVpEntity {
    private int id;
    private String image_url;

    public JingXuanVpEntity(int id, String image_url) {
        this.id = id;
        this.image_url = image_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "JingXuanVpEntity{" +
                "id=" + id +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
