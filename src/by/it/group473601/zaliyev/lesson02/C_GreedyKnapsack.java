package by.it.group473601.zaliyev.lesson02;
/*
Даны
1) объем рюкзака 4
2) число возможных предметов 60
3) сам набор предметов
    100 50
    120 30
    100 50
Все это указано в файле (by/it/a_khmelov/lesson02/greedyKnapsack.txt)

Необходимо собрать наиболее дорогой вариант рюкзака для этого объема
Предметы можно резать на кусочки (т.е. алгоритм будет жадным)
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class C_GreedyKnapsack {
    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        String root = System.getProperty("user.dir") + "/src/";
        File f = new File(root + "by/it/group473601/zaliyev/lesson02/greedyKnapsack.txt");
        double costFinal = new C_GreedyKnapsack().calc(f);
        long finishTime = System.currentTimeMillis();
        System.out.printf("Общая стоимость %f (время %d)", costFinal, finishTime - startTime);
    }

    double calc(File source) throws FileNotFoundException {
        Scanner input = new Scanner(source);
        int itemsCount = input.nextInt();
        int weight = input.nextInt();
        Item[] items = new Item[itemsCount];
        for (int i = 0; i < itemsCount; i++) {
            items[i] = new Item(input.nextInt(), input.nextInt());
        }
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.printf("Всего предметов: %d. Рюкзак вмещает %d кг.\n", itemsCount, weight);
        double result = 0;
        Arrays.sort(items);
        Item item;
        for (int i = 0; i < items.length && weight > 0; i++) {
            item = items[i];
            if (item.weight <= weight) {
                weight -= item.weight;
                result += item.cost;
            } else {
                result += (weight * 1.0) * item.cost / item.weight;
                weight = 0;
            }
        }
        System.out.printf("Удалось собрать рюкзак на сумму %f\n", result);
        return result;
    }

    private class Item implements Comparable<Item> {
        int cost;
        int weight;

        Item(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "cost=" + cost +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Item o) {
            double valueA = this.cost * 1.0 / this.weight;
            double valueB = o.cost * 1.0 / o.weight;
            if (valueA < valueB)
                return 1;
            if (valueA > valueB)
                return -1;
            return 0;
        }
    }
}