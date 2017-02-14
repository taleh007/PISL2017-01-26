package by.it.group473602.matys.lesson2;

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
    private class Item implements Comparable<Item> {
	int cost;
	int weight;

	Item(int cost, int weight) {
	    this.cost = cost;
	    this.weight = weight;
	}

	@Override
	public String toString() {
	    return "Item{" + "cost=" + cost + ", weight=" + weight + '}';
	}

	@Override
	public int compareTo(Item compare) {
	    double currentCostDelWeight = this.cost / this.weight;
	    double compareCostDelWeight = compare.cost / compare.weight;
	    if (compareCostDelWeight > currentCostDelWeight)
		return 1;
	    else if (compareCostDelWeight < currentCostDelWeight)
		return -1;
	    else
		return 0;
	}
    }

    double calc(File source) throws FileNotFoundException {
	Scanner input = new Scanner(source);
	int n = input.nextInt(); // сколько предметов в файле
	int W = input.nextInt(); // какой вес у рюкзака
	Item[] items = new Item[n]; // получим список предметов
	for (int i = 0; i < n; i++) { // создавая каждый конструктором
	    items[i] = new Item(input.nextInt(), input.nextInt());
	}

	input.close();

	
	// покажем предметы
	for (Item item : items) {
	    System.out.println(item);
	}
	System.out.printf("Всего предметов: %d. Рюкзак вмещает %d кг.\n", n, W);

	//Sort our items
	Arrays.sort(items);
	double result = 0;

	for (int i = 0; i < items.length; i++) {
	    Item item = items[i];
	    if (W >= item.weight) {
		result += item.cost;
		W -= item.weight;
	    } else {
		result += (double) W / item.weight * item.cost;
		break;
	    }
	}

	System.out.printf("Удалось собрать рюкзак на сумму %f\n", result);
	return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
	long startTime = System.currentTimeMillis();
	String root = System.getProperty("user.dir") + "/src/";
	File f = new File(root + "by/it/group473602/matys/lesson2/greedyKnapsack.txt");
	double costFinal = new C_GreedyKnapsack().calc(f);
	long finishTime = System.currentTimeMillis();
	System.out.printf("Общая стоимость %f (время %d)", costFinal, finishTime - startTime);
    }
}