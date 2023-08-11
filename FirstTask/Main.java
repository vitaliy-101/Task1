package FirstTask;

import FirstTask.User;

import java.io.File;
import java.io.IOException;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) throws IOException {
        //создание файла
        File myFile = new File("src\\FirstTask\\UserParser.txt");
        ArrayList<User> usersList = new ArrayList<>();
        //чтение файла
        Scanner scanner = new Scanner(myFile);
        scanner.nextLine();
        while (scanner.hasNextLine()){
             String[] userData = scanner.nextLine().toString().split("\t");
             User user = new User(userData);
             user.setYearSalary();
             usersList.add(user);
        }
        //Распределяем юзеров по группам
        //ПОСЛЕДНЕЕ ЗАДАНИЕ СНАЧАЛА НЕПРАВИЛЬНО ПОНЯЛ
        //ПОЭТОМУ ОТСОРТИРОВАЛ ID ЮЗЕРОВ В ГРУППАХ ТОЖЕ
        Map<String, ArrayList<User>> dictionary = new HashMap<String,ArrayList<User>>();
        for (int i = 0; i < usersList.size(); i ++){
            User user = usersList.get(i);
            if (dictionary.containsKey(user.getUserGroup())){
                ArrayList<User> now = dictionary.get(user.getUserGroup());
                now.add(user);
                dictionary.put(user.getUserGroup(), now);
            }
            else{
                ArrayList<User> now = new ArrayList<>();
                now.add(user);
                dictionary.put(user.getUserGroup(), now);
            }
        }
        //вывод и счет среднего значения
        for (String name: dictionary.keySet()){
            ArrayList<User> now = dictionary.get(name);
            Comparator sortUsers = new sortUsers();
            Collections.sort(now, sortUsers);
            dictionary.put(name, now);
            Float mean = (float) 0; //среднее значение
            for (int i = 0; i < now.size(); i ++){
                mean += Float.valueOf(now.get(i).getYearSalary());
            }
            //вывод
            System.out.println("UserGroupId: " + name);
            System.out.println("UserId : ");
            for (int i = 0; i < now.size(); i ++){
                System.out.print(now.get(i).getUserId() + "; ");
            }
            System.out.println();
            System.out.println("MeanSalary: " + (mean / now.size()));
            System.out.println("-----------------------------------------------");

        }
    }

}