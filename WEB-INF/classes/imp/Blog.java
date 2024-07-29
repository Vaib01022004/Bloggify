package imp;
import java.util.Date;

public class Blog {
    private int bid;
    private String email;
    private String title;
    private String bdesc;
    private String category;
    private String body;
    private Date cdate;

    // Constructors
    public Blog() {
    }

    public Blog(String email, String title, String bdesc, String category, String body, Date cdate) {
        this.email = email;
        this.title = title;
        this.bdesc = bdesc;
        this.category = category;
        this.body = body;
        this.cdate = cdate;
    }

    public Blog(int bid,String email, String title, String bdesc, String category, String body, Date cdate) {
        this.email = email;
        this.title = title;
        this.bdesc = bdesc;
        this.category = category;
        this.body = body;
        this.cdate = cdate;
        this.bid = bid;
    }

    // Getters and setters
    public int getBid() {
        return bid;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBdesc() {
        return bdesc;
    }

    public void setBdesc(String bdesc) {
        this.bdesc = bdesc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }
}
