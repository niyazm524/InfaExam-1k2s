package exam.task1;

public class User {
    public int ID;
    public String username;
    public String birthCity;

    public User(int ID, String username, String birthCity) {
        this.ID = ID;
        this.username = username;
        this.birthCity = birthCity;
    }

    @Override
    public String toString() {
        return ID + " " + username + " " + birthCity;
    }
}
