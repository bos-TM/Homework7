package Task2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Worker {
    String fullName;
    String position;
    int yearOfEmployment;

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return  fullName + ", " + position +  ", працює з " + yearOfEmployment + " року.";
    }

    public static void main(String[] args) {
        Worker[] workers = new Worker[5];
        for (int i = 0; i < workers.length; i++) {
            Scanner input = new Scanner(System.in);
            workers[i] = new Worker();
            System.out.print("Введіть прізвище і ініціали: ");
            workers[i].fullName = input.nextLine();
            System.out.print("Введіть назву посади: ");
            workers[i].position = input.nextLine();
            System.out.print("Введіть рік влаштування на роботу: ");
            try {
                workers[i].yearOfEmployment = input.nextInt();
            } catch (Exception e) {
                System.out.println("Ви ввели рік неправильно.");
                System.out.println(e.getMessage());
            }
        }

//        Сортуємо масив - прізвища за абеткою
        Arrays.sort(workers, Comparator.comparing(Worker::getFullName));

        for (Worker element:
             workers) {
            System.out.println(element);
        }

//        Визначаємо людину з найбільшим стажем роботи
        { Worker longerWorker = workers[workers.length - 1];
            for (int i = 0; i < workers.length - 1; i++) {
                if(longerWorker.yearOfEmployment > workers[i].yearOfEmployment)
                    longerWorker = workers[i];
            }
            System.out.println(longerWorker.fullName + " - має найбільший стаж роботи");
        }
    }
}



