package add;

import java.time.LocalDate;
import java.util.Scanner;

class AddDay extends Add {
    private ScheduleManager scheduleManager;

    public AddDay(ScheduleManager eventManager) {
        this.scheduleManager = eventManager;
    }

    void addSchedule() {
    		Scanner s = new Scanner(System.in);
    		
    	try {
    		System.out.println("일정을 추가할 날짜를 입력하세요 yyyy-mm-dd");

    		String dateStr = s.nextLine();
    		LocalDate date = LocalDate.parse(dateStr);

    		System.out.println("일정을 입력하세요");

    		String description = s.nextLine();
    		SplitAdd.splitText(description);

    		Event event = new Event(date, description);
    		scheduleManager.addEvent(event);
    	} catch (Exception e) {
    		System.out.println("잘못된 형식입니다. 다시 입력하세요.");
		}
    	s.close();
    }
}