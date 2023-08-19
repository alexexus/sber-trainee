package org.example.task2;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(Paths.get("C:\\Users\\tnt99\\IdeaProjects\\sber-trainee\\BC.csv"));
            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().split(";");
                if (split.length == 6) {
                    cities.add(new City(split[1], split[2], split[3], split[4], split[5]));
                } else {
                    cities.add(new City(split[1], split[2], split[3], split[4], null));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (City city : cities.stream()
                .sorted(Comparator.comparing(City::getName))
                .collect(Collectors.toList())) {
            System.out.println(city);
        }
        System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n");
        for (City city : cities.stream()
                .sorted(Comparator.comparing(City::getDistrict).thenComparing(City::getName))
                .collect(Collectors.toList())) {
            System.out.println(city);
        }
    }

    static class City {
        String name;
        String region;
        String district;
        String population;
        String foundation;

        public City(String name, String region, String district, String population, String foundation) {
            this.name = name;
            this.region = region;
            this.district = district;
            this.population = population;
            this.foundation = foundation;
        }

        @Override
        public String toString() {
            return "City{" +
                    "name='" + name + '\'' +
                    ", region='" + region + '\'' +
                    ", district='" + district + '\'' +
                    ", population=" + population +
                    ", foundation=" + foundation +
                    '}';
        }

        public String getName() {
            return name;
        }

        public String getDistrict() {
            return district;
        }
    }
}
