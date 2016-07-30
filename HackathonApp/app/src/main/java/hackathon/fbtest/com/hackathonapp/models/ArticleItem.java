package hackathon.fbtest.com.hackathonapp.models;

/**
 * Created by mr.icetea on 7/30/16.
 */
public class ArticleItem {
    public String teacherName;
    public String degree;
    public String price;
    public String subject;
    public String avatarUrl;

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
