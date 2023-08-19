package org.example.task3;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(Paths.get("C:\\Users\\tnt99\\IdeaProjects\\sber-trainee\\BC.csv"));
            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().split(";");
                if (split.length == 6) {
                    cities.add(new City(split[0], split[1], split[2], split[3], Integer.parseInt(split[4]), split[5]));
                } else {
                    cities.add(new City(split[0], split[1], split[2], split[3], Integer.parseInt(split[4]), null));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        City city = cities.stream().max(Comparator.comparing(City::getPopulation)).get();
        System.out.println("[" + city.getId() + "] = " + city.getPopulation());
    }

    static class City {
        String id;
        String name;
        String region;
        String district;
        long population;
        String foundation;

        public City(String id, String name, String region, String district, long population, String foundation) {
            this.id = id;
            this.name = name;
            this.region = region;
            this.district = district;
            this.population = population;
            this.foundation = foundation;
        }

        @Override
        public String toString() {
            return "City{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", region='" + region + '\'' +
                    ", district='" + district + '\'' +
                    ", population=" + population +
                    ", foundation='" + foundation + '\'' +
                    '}';
        }

        public String getId() {
            return id;
        }

        public long getPopulation() {
            return population;
        }
    }
}
