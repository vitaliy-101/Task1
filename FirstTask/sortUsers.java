package FirstTask;

import FirstTask.User;

import java.util.Comparator;

public class sortUsers implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return Integer.valueOf(o1.getUserId()) - Integer.valueOf(o2.getUserId());
    }
}
