package Remove;

import user.User;
import view.MainView;

import java.io.File;

public abstract class RemoveSca {
    protected static String userPath = "filepath/folderpath-";
    
    public abstract void remove(String identifier);

    public void initializePath() {
        this.userPath = User.getUserFolder() + "\\" + MainView.getCurrentYear() + "\\" + MainView.getCurrentMonth() + "\\" + MainView.getCurrentDay() + ".txt";
    }
}
