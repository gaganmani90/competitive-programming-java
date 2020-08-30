package concepts;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    /**
     * ConcurrentHashMap is thread safe but does not use locking on complete map.
     * It is fast and has better performance in comparison to Hashtable in concurrent environment
     *
     * Unlike Hastable or synchronizedMap which locks the entire map exclusively to gain thread-safety feature,
     * ConcurrentHashMap allows concurrent writer and reader threads.
     * That means it allows some threads to modify the map and other threads to read values from the map at the same time,
     * while Hashtable or synchronizedMap allows only one thread to work on the map at a time. More specifically,
     * ConcurrentHashMap allows any number of concurrent reader threads and a limited number of concurrent writer threads,
     * and both reader and writer threads can operate on the map simultaneously.
     */

    public static void main(String[] args) {
        new ConcurrentHashMapDemo().concurrentMapDemo();
        new ConcurrentHashMapDemo().mapDemo();
    }

    private void concurrentMapDemo() {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        new WriterThread(map, "Writer-1", 1).start();
        new WriterThread(map, "Writer-2", 2).start();

        for (int i = 1; i <= 5; i++) {
            new ReaderThread(map, "Reader-" + i).start();
        }
    }

    private void mapDemo() {
        HashMap<Integer, String> map = new HashMap<>();

        new WriterThread(map, "Writer-1", 1).start();
        new WriterThread(map, "Writer-2", 2).start();

        for (int i = 1; i <= 5; i++) {
            new ReaderThread(map, "Reader-" + i).start();
        }
    }

}
class WriterThread extends Thread {
    private Map<Integer, String> map;
    private Random random;
    private String name;

    public WriterThread(Map<Integer, String> map,
                        String threadName, long randomSeed) {
        this.map = map;
        this.random = new Random(randomSeed);
        this.name = threadName;
    }

    public void run() {
        while (true) {
            Integer key = random.nextInt(10);
            String value = name;

            if(map.putIfAbsent(key, value) == null) {
                long time = System.currentTimeMillis();
                String output = String.format("%d: %s has put [%d => %s]",
                        time, name, key, value);
                System.out.println(output);
            }


            Integer keyToRemove = random.nextInt(10);

            if (map.remove(keyToRemove, value)) {
                long time = System.currentTimeMillis();
                String output = String.format("%d: %s has removed [%d => %s]",
                        time, name, keyToRemove, value);
                System.out.println(output);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}

class ReaderThread extends Thread {
    private Map<Integer, String> map;
    private String name;

    public ReaderThread(Map<Integer, String> map, String threadName) {
        this.map = map;
        this.name = threadName;
    }

    public void run() {
        while (true) {
            Iterator<Integer> iterator = map.keySet().iterator();

            long time = System.currentTimeMillis();
            String output = time + ": " + name + ": ";

            while (iterator.hasNext()) {
                Integer key = iterator.next();
                String value = map.get(key);
                output += key + "=>" + value + "; ";
            }

            System.out.println(output);

            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}


