package view;

import user.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleView extends Frame{
    private Frame checklistFrame = new Frame("Schedule List");
    private Panel checklistPanel = new Panel();

    private Button addButton = new Button("추가");
    private Button removeButton = new Button("일정 지우기");

    List<Checkbox> checkboxes = new ArrayList<>();
    void scheduleView(){
        checklistPanel.setLayout(new GridLayout(0, 1, 10, 10)); // 세로로 배치, 수직 및 수평 간격 추가
        //String path = CheckInfo.getFolderPath() + "/" + NowLoginUser.getID() + "/schedule"; // 사용
        /*File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdirs();
        }*/
        String filePath = User.getUserFolder() +"\\"+ MainView.getCurrentYear() + "\\" + MainView.getCurrentMonth() + "\\" + MainView.getCurrentDay() + ".txt";



        Panel buttonPanel = new Panel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        checklistFrame.setLayout(new BorderLayout());
        checklistFrame.add(checklistPanel, BorderLayout.CENTER);
        checklistFrame.add(buttonPanel, BorderLayout.SOUTH);
        checklistFrame.setSize(400, 400);
        checklistFrame.setLocationRelativeTo(null);

        try (BufferedReader lst = new BufferedReader(new FileReader(filePath))) {
            String line;
            File file = new File(filePath);
            if(file.length() == 0){
                Label l = new Label("할일이 없습니다!");
                checklistPanel.add(l);
            } else {
                while ((line = lst.readLine()) != null) {

                    String[] parts = line.split(";", 2);
                    boolean isChecked = Boolean.parseBoolean(parts[0]);
                    String label = parts[1];
                    Checkbox ch = new Checkbox(label, isChecked);
                    ch.setFont(new Font("Arial", Font.PLAIN, 18)); // 체크박스 텍스트 크기 조정
                    checkboxes.add(ch);
                    checklistPanel.add(ch);
                }
            }
        } catch (IOException e) {
            Label l = new Label("할일이 없습니다!");
            checklistPanel.add(l);
        }


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddScheduleView addSchedule = new AddScheduleView();
                addSchedule.scheduleAddView(new Runnable() {
                    @Override
                    public void run() {

                        refreshChecklist(filePath);
                    }
                });
                

            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        checklistFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                saveChecklist(filePath); // 프로그램 종료 시 체크리스트 상태 저장
                checklistFrame.dispose();
            }
        });

        //사용 고민


        checklistFrame.setVisible(true);
    }
    private void loadChecklist(String filePath){
        checklistPanel.removeAll(); // 기존 체크리스트 항목을 제거

        try (BufferedReader lst = new BufferedReader(new FileReader(filePath))) {
            String line;
            File file = new File(filePath);
            if(file.length() == 0){
                Label l = new Label("할일이 없습니다!");
                checklistPanel.add(l);
            } else {
                while ((line = lst.readLine()) != null) {

                    String[] parts = line.split(";", 2);
                    boolean isChecked = Boolean.parseBoolean(parts[0]);
                    String label = parts[1];
                    Checkbox ch = new Checkbox(label, isChecked);
                    ch.setFont(new Font("Arial", Font.PLAIN, 18)); // 체크박스 텍스트 크기 조정
                    checkboxes.add(ch);
                    checklistPanel.add(ch);
                }
            }
        } catch (IOException e) {
            Label l = new Label("할일이 없습니다!");
            checklistPanel.add(l);
        }

        checklistPanel.revalidate();
        checklistPanel.repaint();
    }

    //추가 할 경우 창을 다시 로드해서 보여주는 기능
    private void refreshChecklist(String filePath) {

        checkboxes.clear();
        loadChecklist(filePath); // 체크리스트를 다시 로드하여 새로고침
    }
    private void saveChecklist(String filePath) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Checkbox checkbox : checkboxes) {
                writer.write(checkbox.getState() + ";" + checkbox.getLabel());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("할일이 없습니다");
        }
    }
}
