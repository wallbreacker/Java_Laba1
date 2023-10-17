package Task2;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SecondTask {
    public static void main(String[] args) {
        System.out.print("Введите числа через строку для подсчета квадрата (0 для выхода):\n");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> processRequest(number));
            try {
                int result = future.get();
                System.out.println("Результат для числа " + number + ": " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
}
    public static int processRequest(int number) {
        try {
           int time = (1 + (int)(Math.random() * 5)) * 1000;
            System.out.println("Время задержки: " + number + ": " + time + " миллисекунд");
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number * number;
    }
}