package la.tietie.singlesugar.bean;

/**
 * Created by steven on 2015/11/24.
 * {
 "content_url": "http://dantang.liwushuo.com/posts/2457/content",
 "cover_image_url": "http://7fvaoh.com3.z0.glb.qiniucdn.com/image/150831/13soouqwo.jpg-w720",
 "created_at": 1445385600,
 "id": 2457,
 "labels": [ ],
 "liked": false,
 "likes_count": 2534,
 "published_at": 1445385600,
 "share_msg": "秋天来了，同学们是不是明显感到脸上紧绷绷，从中午就开始出油了？没错，秋季补水保湿护肤季来啦~护肤先从洗脸开始吧~洁面产品有洁面乳、洁面液、洁面皂等形式，而洁面皂这种更为原始，可以手工制作的洗脸产品则越来越讲究成分天然，很多人也更喜欢使用洁面皂来进行脸部清洁，洗完脸后皮肤棒棒哒，来看看有什么好用的皂吧~",
 "short_title": "手工洁面皂",
 "status": 0,
 "title": "你皂吗？用它洗脸棒棒哒",
 "type": "post",
 "updated_at": 1441009893,
 "url": "http://dantang.liwushuo.com/posts/2457"

 },
 */
public class HomeEntity {
    private String content_url;
    private String cover_image_url;
    private int id;
    private int likes_count;
    private String title;
    private String url;

    public HomeEntity(String content_url, String cover_image_url, int id, int likes_count, String title, String url) {
        this.content_url = content_url;
        this.cover_image_url = cover_image_url;
        this.id = id;
        this.likes_count = likes_count;
        this.title = title;
        this.url = url;
    }

    public String getContent_url() {
        return content_url;
    }

    public void setContent_url(String content_url) {
        this.content_url = content_url;
    }

    public String getCover_image_url() {
        return cover_image_url;
    }

    public void setCover_image_url(String cover_image_url) {
        this.cover_image_url = cover_image_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "HomeEntity{" +
                "content_url='" + content_url + '\'' +
                ", cover_image_url='" + cover_image_url + '\'' +
                ", id=" + id +
                ", likes_count=" + likes_count +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
