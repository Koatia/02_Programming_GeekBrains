//📌 Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями.
//📌 Вывести название каждой планеты и количество его повторений в списке.
//Задание состоит из двух блоков
//Задание №2.2 (если выполнено первое задание)
//📌 Пройти по списку из предыдущего задания и удалить повторяющиеся элементы.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolarSystem {
    public static void main(String[] args) {
        List<String> planets = getPlanetsList();
        System.out.println(planets);
        printCountPlanets(planets);
//        removeDoublePlanets2(planets);
        removeDoublePlanets2(planets);

        System.out.println(planets);
    }

    private static void removeDoublePlanets2(List<String> planets) {
        for (int i = 0; i < planets.size(); i++) {
            String currentPlanet = planets.get(i);
            for (int j = planets.size() - 1; j > i; j--) {
                if (planets.get(j).equals(currentPlanet)) {
                    planets.remove(j);
                }
            }
        }
    }

    private static void removeDoublePlanets(List<String> planets) {
        for (int i = 0; i < planets.size(); i++) {
            String currentPlanet = planets.get(i);
            for (int j = i + 1; j < planets.size(); j++) {
                if (planets.get(j).equals(currentPlanet)) {
                    planets.remove(j);
                    j--;
                }
            }
        }
    }

    private static void printCountPlanets(List<String> planets) {
        List<String> sortedPlanets = new ArrayList<>(planets);
        Collections.sort(sortedPlanets);
        System.out.println(sortedPlanets);

        int count = 1;

        for (int i = 1; i < sortedPlanets.size(); i++) {
            if (sortedPlanets.get(i).equals(sortedPlanets.get(i - 1))) {
                count++;
            } else {
                System.out.println(sortedPlanets.get(i - 1) + " -> " + count);
                count = 1;
            }
        }
        System.out.println(sortedPlanets.getLast() + " -> " + count);
    }


    private static List<String> getPlanetsList() {
        List<String> planets = new ArrayList<>();
        planets.add("Земля");
        planets.add("Уран");
        planets.add("Сатурн");
        planets.add("Юпитер");
        planets.add("Венера");
        planets.add("Марс");
        planets.add("Меркурий");
        planets.add("Нептун");
        planets.add("Венера");
        planets.add("Марс");
        planets.add("Земля");
        planets.add("Уран");
        planets.add("Сатурн");
        planets.add("Юпитер");
        planets.add("Венера");
        return planets;
    }
}