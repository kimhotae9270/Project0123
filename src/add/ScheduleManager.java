package add;

import java.util.ArrayList;



class ScheduleManager {
    // events == 스케쥴
    private ArrayList<Event> events = new ArrayList<>();

    public void addEvent(Event event) {
        events.add(event);
    }

    public void displayEvents() {
        for (Event event : events) {
            System.out.println(event);
        }
    }
}