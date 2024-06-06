package Remove;

import java.io.File;
import java.util.Scanner;

public class RemoveDay extends RemoveSca {

    public void remove(String identifier) {
    	
        // 파일 경로
        String filePath = basePath + identifier;
        File daySchedule = new File(filePath);

        try (Scanner scanner = new Scanner(System.in)) {
            // 최종 삭제 여부 입력
            System.out.println("선택한 날짜의 일정을 전부 제거하겠습니까? (Y|N)");
            String userInput = scanner.nextLine().toUpperCase();

            if (userInput.equals("Y")) {
                if (daySchedule.exists()) {
                    File[] files = daySchedule.listFiles();
                    if (files != null) {
                        for (File file : files) {
                            if (!deleteFile(file.getAbsolutePath())) {
                                System.out.println(file.getName() + " 파일 삭제에 실패했습니다.");
                            }
                        }
                        System.out.println("선택한 날짜의 일정이 모두 삭제되었습니다.");
                    } else {
                        System.out.println("삭제할 일정이 없습니다.");
                    }
                } else {
                    System.out.println("선택한 날짜에 일정이 존재하지 않습니다.");
                }
            } else if (userInput.equals("N")) {
                System.out.println("일정 삭제를 취소합니다.");
            } else {
                System.out.println("'Y' 또는 'N'을 입력하세요.");
            }
        } catch (SecurityException e) {
            System.out.println("파일에 접근할 수 없습니다: " + e.getMessage());
        }
    }
}
