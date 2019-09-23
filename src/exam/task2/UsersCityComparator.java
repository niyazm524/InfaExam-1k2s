package exam.task2;

import exam.task1.User;

import java.util.Comparator;

public class UsersCityComparator implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        if (u1 == null) return 1;
        if (u2 == null) return -1;
        int birthCompare = u1.birthCity.compareToIgnoreCase(u2.birthCity);
        if (birthCompare == 0) {
            return u1.username.compareTo(u2.username);
        } else {
            return birthCompare;
        }
    }
}
