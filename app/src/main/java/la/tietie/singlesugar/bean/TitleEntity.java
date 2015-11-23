package la.tietie.singlesugar.bean;

/**
 * Created by steven on 2015/11/23.
 */
public class TitleEntity {
    private int id;
    private String name;

    public TitleEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TitleEntity{" +
                "id=" + id +
                ", title_name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle_name() {
        return name;
    }

    public void setTitle_name(String title_name) {
        this.name = title_name;
    }
}
