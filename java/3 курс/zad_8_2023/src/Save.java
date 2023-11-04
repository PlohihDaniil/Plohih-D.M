import java.util.Date;

public class Save {
    private final String text;
    private final Date date;

    public Save(String text) {
        this.text = text;
        this.date = new Date();
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }
}
