package Task3;

import java.util.LinkedList;
import java.util.Queue;


public class FileQueue {
    Queue<File> queue = new LinkedList<>();


    public synchronized File get() {
        while (queue.size()<1) {
            try{
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        notify();
        return queue.peek();
    }


    public synchronized File cut() { //delete head of queue
        while (queue.size()<1) {
            try{
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        notify();
        System.out.println("FileQueue: Файл " + queue.peek().name + " удален из очереди");
        return queue.poll();
    }
    public synchronized void put(File file) {
        while (queue.size()>=5) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        System.out.println("FileQueue: Файл "
                + file.name +
                " добавлен в очередь");
        notify();
        queue.add(file);
    }
}
