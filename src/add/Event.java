package add;

import java.time.LocalDate;

class Event {
    private LocalDate date;
    private String description;

    public Event(LocalDate date, String description) {
        this.date = date;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return date + ": " + description;
    }
}