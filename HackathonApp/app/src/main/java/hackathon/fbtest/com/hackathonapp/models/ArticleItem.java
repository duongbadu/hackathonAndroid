package hackathon.fbtest.com.hackathonapp.models;

/**
 * Created by mr.icetea on 7/30/16.
 */
public class ArticleItem {
    private String teacherName;
    private String degree;
    private String price;
    private String subject;
    private String avatarUrl;

    public ArticleItem(String teacherName, String degree, String price, String subject) {
        this.teacherName = teacherName;
        this.degree = degree;
        this.price = price;
        this.subject = subject;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getDegree() {
        return degree;
    }

    public String getPrice() {
        return price;
    }

    public String getSubject() {
        return subject;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
