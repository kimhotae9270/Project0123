package Remove;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class RemoveEvent extends RemoveSca {

    public void remove(List<Integer> identifiers) {
    	
    	// 파일 경로
        //String filePath = basePath;
        //File event = new File(filePath);

    	try (Scanner scanner = new Scanner(System.in)) {
            // 최종 삭제 여부 입력
            System.out.println("선택한 일정들을 제거하겠습니까? (Y|N)");
            String userInput = scanner.nextLine().toUpperCase();

            if (userInput.equals("Y")) {
                boolean anyDeleted = false;
                for (int i = 0; i < identifiers.size(); i++) {
                    int identifier = identifiers.get(i);
                    if (identifier == 1) {
                        // 파일 경로를 동적으로 생성
                        try {
                            File eventToDelete = new File(basePath + "Year+Month+Day" + i);
                            if (eventToDelete.exists()) {
                                if (deleteFile(eventToDelete.getPath())) {
                                    System.out.println("일정 " + i + "이 삭제되었습니다");
                                    anyDeleted = true;
                                } else {
                                    System.out.println("일정 " + i + " 삭제에 실패했습니다");
                                }
                            } else {
                                System.out.println("일정 " + i + "이 존재하지 않습니다");
                            }
                        } catch (SecurityException e) {
                            System.out.println("일정 " + i + " 파일에 접근할 수 없습니다: " + e.getMessage());
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
