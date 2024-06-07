package Remove;

import user.User;
import view.MainView;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RemoveSelect extends Remove{

    private String filePath = getFilePath()+MainView.getCurrentDay()+".txt";
    @Override
    public void remove(List<Checkbox> cb) {

        try(BufferedWriter w = new BufferedWriter(new FileWriter(filePath))) {
            for(Checkbox checkbox : cb){
                if(!checkbox.getState()){

                    w.write(checkbox.getState()+";"+checkbox.getLabel()+"\n");
                }
            }

        }catch (IOException err){
            System.out.println("삭제 실패");
        }
    }

}
