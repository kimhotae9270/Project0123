package user;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CheckInfo {
    private boolean isIDtrue = false;
    private boolean Allclear = false;
    private String folderPath = "C:\\schedule_system\\User";
    private String filePath = folderPath + "\\user.txt";
    private File folder = new File(folderPath);
    public void checkInfo(String ID,String PassWord){


        if(!folder.exists()) {
            folder.mkdirs();
        }else {
            // 파일 읽기
            try (BufferedReader id = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = id.readLine()) != null) {
                    String[] user = line.split(";");
                    if(ID.equals(user[0])) {
                        isIDtrue = true;
                        if(PassWord.equals(user[1])){
                            Allclear = true;
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("파일이 아직 생성되지 않았습니다");
            }}
    }
    public void checkInfo(String ID){
        if(!folder.exists()) {
            folder.mkdirs();
        }else {
            // 파일 읽기
            try (BufferedReader id = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = id.readLine()) != null) {
                    String[] user = line.split(";");
                    if(ID.equals(user[0])) {
                        isIDtrue = true;
                    }
                }
            } catch (IOException e) {
                System.out.println("파일이 아직 생성되지 않았습니다");
            }}
    }
    public boolean getAllclear() {
        return Allclear;
    }
    public boolean getIsIDtrue() {
        return isIDtrue;
    }
}
