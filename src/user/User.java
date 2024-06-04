package user;



public class User extends Person {
    private static String id;

    @Override
    public void setUserId(String id) {

        User.id = id;

        setUserFolder(id);
    }

    @Override
    public String getUserId() {
        return id;
    }
}
