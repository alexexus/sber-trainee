package org.example.task1;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(Paths.get("C:\\Users\\tnt99\\IdeaProjects\\sber-trainee\\BC.csv"));
            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().split(";");
                if (split.length == 6) {
                    System.out.println(new City(split[1], split[2], split[3], split[4], split[5]));
                } else {
                    System.out.println(new City(split[1], split[2], split[3], split[4], null));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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
    }
}
