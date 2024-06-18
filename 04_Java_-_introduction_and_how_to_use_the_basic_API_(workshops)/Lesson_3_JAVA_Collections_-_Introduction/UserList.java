//📌 Создать список типа ArrayList<String>.
//📌 Поместить в него как строки, так и целые числа.
//📌 Пройти по списку, найти и удалить целые числа.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class UserList {
    public static void main(String[] args) {
        ArrayList<String> list = spawnList();

        System.out.println(list);
        deleteInteger2(list);
        System.out.println(list);
    }

    public static ArrayList<String> spawnList() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("2", "3", "список", "2", "3", "список", "2", "3", "список", "2", "3", "список"));
        return list;
    }

    public static void deleteInteger(ArrayList<String> arrList) {
        for (int i = 0; i < arrList.size(); i++) {
            if (checkInt(arrList.get(i))) {
                arrList.remove(i);
                i--;
            }
        }
    }

    public static void deleteInteger2(ArrayList<String> arrList) {
        Iterator<String> iterator = arrList.iterator();
        while (iterator.hasNext()) {
            String elem = iterator.next();
            if (checkInt(elem)) {
                iterator.remove();
            }
        }
    }

    public static boolean checkInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}