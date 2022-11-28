package sample;

import javafx.beans.property.SimpleStringProperty;

public class event {
    private final SimpleStringProperty date;
    private final SimpleStringProperty text;
    private final SimpleStringProperty author;
    private final SimpleStringProperty event_name;

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getText() {
        return text.get();
    }

    public SimpleStringProperty textProperty() {
        return text;
    }

    public void setText(String text) {
        this.text.set(text);
    }

    public String getAuthor() {
        return author.get();
    }

    public SimpleStringProperty authorProperty() {
        return author;
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public String getEvent_name() {
        return event_name.get();
    }

    public SimpleStringProperty event_nameProperty() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name.set(event_name);
    }

    public event(String eventName, String dateIn, String authorIn, String textIn) {
        this.event_name=new SimpleStringProperty(eventName);
        this.date=new SimpleStringProperty(dateIn);
        this.author=new SimpleStringProperty(authorIn);
        this.text=new SimpleStringProperty(textIn);
    }


}
