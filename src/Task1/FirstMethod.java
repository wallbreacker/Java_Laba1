package Task1;
import java.util.Random;

public class FirstMethod {
    public static void main(String[] args) throws InterruptedException {

        int[] arr = new int[10000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000);
        }
        // Измеряем время выполнения
        long startTime = System.nanoTime();
        // Находим максимальный элемент в массиве
        int maxElement = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxElement) {
                maxElement = arr[i];
                Thread.sleep(1);
            }
        }
        float endTime = System.nanoTime();
        float executionTime = endTime - startTime;

        // Измеряем объем памяти
        long memoryUsage = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();

        System.out.println("Время выполнения: " + executionTime/1000000 + " миллисекунд");
        System.out.println("Объем памяти: " + memoryUsage / (1024 * 1024) + " МБ");
        System.out.println("Максимальный элемент: " + maxElement);
    }
}
