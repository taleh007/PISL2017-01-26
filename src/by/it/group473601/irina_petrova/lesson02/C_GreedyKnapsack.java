package by.it.group473601.irina_petrova.lesson02;
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
import java.util.Scanner;

public class C_GreedyKnapsack {
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
            //тут может быть ваш компаратор


            return 0;
        }
    }

    double calc(File source) throws FileNotFoundException {
        Scanner input = new Scanner(source);
        int n = input.nextInt();      //сколько предметов в файле
        int W = input.nextInt();      //какой вес у рюкзака
        Item[] items = new Item[n];   //получим список предметов
        for (int i = 0; i < n; i++) { //создавая каждый конструктором
            items[i] = new Item(input.nextInt(), input.nextInt());
        }
        //покажем предметы
        for (Item item:items) {
            System.out.println(item);
        }
        System.out.printf("Всего предметов: %d. Рюкзак вмещает %d кг.\n",n,W);
        Item[] items2 = new Item[n];
        for(int i = 0; i < items.length; i++){
            items2[i] = new Item(items[i].cost/items[i].weight,i);
        }
            for (int j = 0; j < items2.length - 1; j++) {
            for (int k = j + 1; k < items2.length; k++) {
                if (items2[j].cost < items2[k].cost) {
                    Item item_my = items2[k];
                    items2[k] = items2[j];
                    items2[j] = item_my;
                }
            }
        }
        double result = 0;
        int all = W;
        while (all > 0){
            for(int i = 0; i < items2.length; i++){
                if(items[items2[i].weight].weight <= all) {
                    all -= items[items2[i].weight].weight;
                    System.out.println("item " + items2[i].weight + " call " + items[items2[i].weight].weight + " cost " + items[items2[i].weight].cost);
                    result += items[items2[i].weight].cost;
                }
                else {
                    result += items2[i].cost * all;
                    System.out.println("item " + items2[i].weight + " call " +  all + " cost " + items2[i].cost * all);
                    all = 0;
                    return result;
                }
            }
        }
        //тут необходимо реализовать решение задачи
        //итогом является максимально воможная стоимость вещей в рюкзаке
        //вещи можно резать на кусочки (непрерывный рюкзак)

        //тут реализуйте алгоритм сбора рюкзака
        //будет особенно хорошо, если с собственной сортировкой
        //кроме того, можете описать свой компаратор в классе Item
        //ваше решение.

        System.out.printf("Удалось собрать рюкзак на сумму %f\n",result);
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        String root=System.getProperty("user.dir")+"/src/";
        File f=new File(root+"by/it/group473601/irina_petrova/lesson02/greedyKnapsack.txt");
        double costFinal=new C_GreedyKnapsack().calc(f);
        long finishTime = System.currentTimeMillis();
        System.out.printf("Общая стоимость %f (время %d)",costFinal,finishTime - startTime);
    }
}