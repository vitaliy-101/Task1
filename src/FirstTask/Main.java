package FirstTask;

import FirstTask.Jobs.Developer;
import FirstTask.Jobs.Student;
import FirstTask.Jobs.Teacher;
import FirstTask.Jobs.User;

import java.io.File;
import java.io.IOException;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) throws IOException {
        //создание файла
        File myFile = new File("src\\FirstTask\\UserParser.txt");
        List<User> usersList = new ArrayList<>();
        Map<Long, UserGroup> groups = new HashMap<>();

        //чтение файла
        Scanner scanner = new Scanner(myFile);
        scanner.nextLine();
        while (scanner.hasNextLine()) {

            String[] userData = scanner.nextLine().toString().split("\t");
            if (userData[3].isEmpty()) {
                userData[3] = "0";
            }
            Long userGroupId = Long.valueOf(userData[3]);
            if (!groups.containsKey(userGroupId)) {
                UserGroup group = new UserGroup(userGroupId);
                groups.put(userGroupId, group);
            }
            Optional<User> optionalUser = createUser(userData, groups, userGroupId);
            if (optionalUser.isEmpty()){
                continue;
            }
            User user = optionalUser.get();
            UserGroup group = groups.get(userGroupId);
            group.addUser(user);
            groups.put(userGroupId, group);
            user.calculateSalary();
            usersList.add(user);

        }
        for (int i = 0; i < usersList.size(); i++) {
            System.out.println(usersList.get(i).getSalary() + " " + usersList.get(i).getYearSalary());
        }

        for (Long userGroupId : groups.keySet()) {
            UserGroup group = groups.get(userGroupId);
            List<User> users = group.getUsers();
            System.out.println(userGroupId);
            for (int i = 0; i < users.size(); i++) {
                System.out.print(users.get(i).getId() + " ");
            }
            System.out.println();
            System.out.println("---------------");
        }

    }

    private static Optional<User> createUser(String[] userData, Map<Long, UserGroup> groups, Long userGroupId) {
        if (userData[4].equals("Student")) {
            return Optional.of(new Student(userData[0], userData[1], userData[2], userData[4], userData[5], userData[6], userData[7], userData[8], groups.get(userGroupId)));

        } else if (userData[4].equals("Developer")) {
            return Optional.of(new Developer(userData[0], userData[1], userData[2], userData[4], userData[5], userData[6], userData[7], userData[8], groups.get(userGroupId)));

        } else if (userData[4].equals("Teacher")) {
            return Optional.of(new Teacher(userData[0], userData[1], userData[2], userData[4], userData[5], userData[6], userData[7], userData[8], groups.get(userGroupId)));
        }
        return Optional.empty();

    }


}