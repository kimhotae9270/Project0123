package add;

import user.User;
import view.MainView;

public abstract class Add {
    private String userPath;

    public abstract void addDay(String newItem);

    public void initializePath() {
        this.userPath = User.getUserFolder() + "\\" + MainView.getCurrentYear() + "\\" + MainView.getCurrentMonth() + "\\" + MainView.getCurrentDay() + ".txt";
    }

    public String getUserPath() {
        return userPath;
    }
}