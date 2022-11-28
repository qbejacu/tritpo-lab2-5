package sample;

public class EventManager {
    public EventManager(event event) {
        Event = event;
    }

    public event getEvent() {
        return Event;
    }

    public void setEvent(event event) {
        Event = event;
    }

    event Event;

    public void add_event() {
    }
    public void edit_event(event event) {
    }
    public void delete_event(event event) {
    }
    public void sort_by_author() {
    }
    public void sort_by_date_growing() {
    }
    public void sort_by_date_lowing() {
    }
    public void sort_by_exact_date() {
    }
    public void search_by_name() {
    }
}
