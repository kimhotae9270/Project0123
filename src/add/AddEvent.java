package add;

import java.util.Calendar;

class AddEvent {
	    private String title;
	    private Calendar date;

	    public AddEvent(String title, Calendar date) {
	        this.title = title;
	        this.date = date;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public Calendar getDate() {
	        return date;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public void setDate(Calendar date) {
	        this.date = date;
	    }

	    @Override
	    public String toString() {
	        return "Title: " + title + ", Date: " + date.get(Calendar.YEAR) + "-" +
	                (date.get(Calendar.MONTH) + 1) + "-" + date.get(Calendar.DAY_OF_MONTH);
	    }

}
