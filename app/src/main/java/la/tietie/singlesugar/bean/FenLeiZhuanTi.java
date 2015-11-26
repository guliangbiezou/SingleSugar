package la.tietie.singlesugar.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/11/23 0023.
 */
public class FenLeiZhuanTi implements Serializable{

    private String banner_image_url;
    private String cover_image_url;
    private String created_at;
    private String id;
    private String posts_count;
    private String status;
    private String subtitle;
    private String title;
    private String updated_at;

    @Override
    public String toString() {
        return "FenLeiZhuanTi{" +
                "banner_image_url='" + banner_image_url + '\'' +
                ", cover_image_url='" + cover_image_url + '\'' +
                ", created_at='" + created_at + '\'' +
                ", id='" + id + '\'' +
                ", posts_count='" + posts_count + '\'' +
                ", status='" + status + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", title='" + title + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }

    public String getBanner_image_url() {
        return banner_image_url;
    }

    public void setBanner_image_url(String banner_image_url) {
        this.banner_image_url = banner_image_url;
    }

    public String getCover_image_url() {
        return cover_image_url;
    }

    public void setCover_image_url(String cover_image_url) {
        this.cover_image_url = cover_image_url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosts_count() {
        return posts_count;
    }

    public void setPosts_count(String posts_count) {
        this.posts_count = posts_count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
