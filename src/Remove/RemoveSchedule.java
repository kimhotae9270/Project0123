package Remove;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class RemoveSchedule extends RemoveSca {
	
	//Date 형식은 20240401의 형태
	public void remove(int startDate, int endDate) {
		
    	try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("선택한 일정들을 제거하겠습니까? (Y|N)");
            String userInput = scanner.nextLine().toUpperCase();

            if (userInput.equals("Y")) {
                boolean anyDeleted = false;
                
                // 시작 날짜 분리
                int startYear = startDate / 10000;
                int startMonth = (startDate % 10000) / 100;
                int startDay = startDate % 100;

                // 끝 날짜 분리
                int endYear = endDate / 10000;
                int endMonth = (endDate % 10000) / 100;
                int endDay = endDate % 100;

                // 시작 날짜부터 끝 날짜까지 반복
                for (int year = startYear; year <= endYear; year++) {
                    for (int month = startMonth; month <= endMonth; month++) {
                        for (int day = startDay; day <= endDay; day++) {
                            String filePath = basePath + "/" + year + "-" + month + "-" + day;
                            try {
                                File eventToDelete = new File(filePath);
                                if (eventToDelete.exists()) {
                                    if (deleteFile(eventToDelete.getPath())) {
                                        System.out.println("일정 " + filePath + "이 삭제되었습니다");
                                        anyDeleted = true;
                                    } else {
                                        System.out.println("일정 " + filePath + " 삭제에 실패했습니다");
                                    }
                                } else {
                                    System.out.println("일정 " + filePath + "이 존재하지 않습니다");
                                }
                            } catch (SecurityException e) {
                                System.out.println("일정 " + filePath + " 파일에 접근할 수 없습니다: " + e.getMessage());
                            }
                        }
                    }
                }
                if (!anyDeleted) {
                    System.out.println("삭제할 일정이 없습니다");
                }
            } else if (userInput.equals("N")) {
                System.out.println("일정 삭제를 취소합니다");
            } else {
                System.out.println("'Y' 또는 'N'을 입력하세요");
            }
        } catch (SecurityException e) {
            System.out.println("파일에 접근할 수 없습니다: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("알 수 없는 오류가 발생했습니다: " + e.getMessage());
        }
	}

}
