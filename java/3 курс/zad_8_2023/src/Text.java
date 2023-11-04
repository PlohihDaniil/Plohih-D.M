import java.util.Date;

public class Text {
    private String text;
    private Date date;

    public void setTextAndDate(String text){
        this.text = text;
        this.date = new Date();
    }

    public Save save(){
        return new Save(text);
    }

    public void load(Save save){
        text = save.getText();
        date = save.getDate();
    }

    @Override
    public String toString() {
        return "Text{" +
                "text= " + text + '\n' +
                "date= " + date;
    }
}
