abstract class User {

    protected int userId;
    protected String userName;

    public User(int userId, String userName){
        this.userId = userId;
        this.userName = userName;
    }

    public abstract void viewDetails();

    public String getUserName(){
        return userName;
    }

    public int getUserId(){
        return userId;
    }
}
