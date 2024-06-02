package add;

import java.time.LocalDate;
import java.util.Scanner;

class AddMonth extends Add {
    private ScheduleManager eventManager;

    public AddMonth(ScheduleManager eventManager) {
        this.eventManager = eventManager;
    }

    void addSchedule() {
        Scanner s = new Scanner(System.in);
        System.out.println("일정을 추가할 연도와 달을 입력하세요 (yyyy-MM)");

        String yearMonthStr = s.nextLine();
        LocalDate firstDayOfMonth = null;

        try {
            // 입력 받은 문자열을 연도와 달로 파싱
            String[] yearMonthArray = yearMonthStr.split("-");
            int year = Integer.parseInt(yearMonthArray[0]);
            int month = Integer.parseInt(yearMonthArray[1]);

            // 해당 연도와 달의 첫 번째 날짜를 구함
            firstDayOfMonth = LocalDate.of(year, month, 1);

            System.out.println("일정을 입력하세요");
            String description = s.nextLine();

            // 해당 연도와 달의 모든 날짜에 일정 추가
            for (int day = 1; day <= firstDayOfMonth.lengthOfMonth(); day++) {
                LocalDate date = firstDayOfMonth.withDayOfMonth(day);
                Event event = new Event(date, description);
                eventManager.addEvent(event);
            }
        } catch (Exception e) {
            System.out.println("잘못된 형식입니다. 다시 입력하세요.");
        }
        s.close();
    }
}