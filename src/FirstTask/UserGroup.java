package FirstTask;

import FirstTask.Jobs.User;

import java.util.ArrayList;
import java.util.List;

public class UserGroup {
    private Long id;
    private List<User> users;


    public UserGroup(Long id) {
        this.id = id;
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        this.users.add(user);
        user.setGroup(this);
    }
}
