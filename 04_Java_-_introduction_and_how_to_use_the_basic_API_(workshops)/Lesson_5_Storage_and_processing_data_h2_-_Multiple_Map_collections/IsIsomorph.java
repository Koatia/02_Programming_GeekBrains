import java.util.HashMap;

//Даны 2 строки, написать метод, который вернет true, если эти строки являются изоморфными
//и false, если нет. Строки изоморфны, если одну букву в первом слове можно заменить на
//некоторую букву во втором слове, при этом
//1. повторяющиеся буквы одного слова меняются на одну и ту же букву с сохранением
//порядка следования. (Например, add - egg изоморфны)
//2. буква может не меняться, а остаться такой же. (Например, note - code)
//Пример 1: Input: s = "foo", t = "bar"
//Output: false
//Пример 2: Input: s = "paper", t = "title"
//Output: true
public class IsIsomorph {
    public static void main(String[] args) {
        String st1 = "paper";
        String st2 = "title";
        System.out.println(isIsomorphic(st1, st2));
    }

    public static boolean isIsomorphic(String st1, String st2) {
        if (st1.length() != st2.length())
            return false;
        if (st1.equals(st2))
            return true;

        HashMap<Character, Character> stringHashMap = new HashMap<>();

        for (int i = 0; i < st1.length(); i++) {
            char c1 = st1.charAt(i);
            char c2 = st2.charAt(i);
            if (stringHashMap.containsKey(c1)) {
                if (stringHashMap.get(c1) != c2) {
                    return false;
                }
            } else {
                stringHashMap.put(c1, c2);
            }
        }
        return true;
    }
}