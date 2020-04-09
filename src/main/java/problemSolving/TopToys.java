package problemSolving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * input
 */
public class TopToys {

    /**
     * O(NlogN)
     * TODO: complete the program. Comparator is throwing runtime error
     * @param topToys: top N toys which occurred the most in quotes
     * @param toys: list of toys names
     * @param quotes: list of quotes with toy names
     * @return list of toy names which occurred the most in quotes
     */
    public static ArrayList<String> populateNToysHashMap(int topToys, List<String> toys, List<String> quotes) {
        ArrayList<String> names = new ArrayList();
        TreeMap<String,Integer> sortedtoys = new TreeMap(new ValueComparator());
        initializeMap(toys, sortedtoys);

        for(String quote : quotes) {
           String[] words = quote.split(" ");
            updateMapWithToyOccurrence(words, sortedtoys);
        }

        return names;
    }
    /**
     *
     * @param words
     * @param sortedtoys
     */
    static void updateMapWithToyOccurrence(String[] words, TreeMap<String,Integer> sortedtoys) {
        int count = 0;
        //this will store initial count of toys before reading quote
        Map<String, Integer> copyMap = new TreeMap<>(sortedtoys);
        for(String word : words) {
            if(sortedtoys.containsKey(word) && copyMap.get(word) == sortedtoys.get(word)) {
                sortedtoys.put(word, sortedtoys.get(word) + 1);
            }
        }
    }

    /**
     *
     * @param toys
     */
    private static void initializeMap(List<String> toys, TreeMap<String,Integer> sortedtoys) {
        for(String toy : toys) {
            sortedtoys.put(toy,0);
        }
    }

    /**
     * O(NxN) - List
     * @param topToys: top N toys which occurred the most in quotes
     * @param toys: list of toys names
     * @param quotes: list of quotes with toy names
     * @return list of toy names which occurred the most in quotes
     */
     public static ArrayList<String> populateNToys(int topToys, List<String> toys, List<String> quotes) {
        //HashMap<String, Integer> toyOccurrence = new HashMap<String, Integer>();
        List<Toy> toyOccurrence = new ArrayList<>();
        for(String toy : toys) {
            int toyCount = 0;
            for(String quote : quotes) {
                toyCount += getOccurrence(toy, quote);
            }
            toyOccurrence.add(new Toy(toy, toyCount));
        }

        //sort by count
        Collections.sort(toyOccurrence, new ToyComparator());
        return getTopNToys(topToys, toyOccurrence);
    }

    /**
     * Returns occurrence of given name in sentence
     * @param toy
     * @param sentence
     * @return
     */
    static int getOccurrence(String toy, String sentence) {
        int count = 0;
        if(sentence == null || toy == null) {
            return 0;
        }
        String[] words = sentence.split(" ");
        for(String word : words) {
            //do not consider more than 1 count in a quote
            if(count == 1) {
                break;
            }
            if(toy.equals(word)) {
                count++;
            }
        }
        return count;
    }

    static ArrayList<String> getTopNToys(int topN, List<Toy> toyOccurrence) {
        ArrayList<String> toys = new ArrayList<>();
        int count = 0;
        for(Toy toy : toyOccurrence) {
            if(count == topN) {
                break;
            }
            count++;
            if(toy.count > 0) {
                toys.add(toy.name);
            }
        }
        return toys;
    }
}

class Toy {
    String name;
    int count;
    public Toy(String name, int count) {
        this.name = name;
        this.count = count;
    }
}

class ToyComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
        if(o1.count == o2.count) {
            return o1.name.compareTo(o2.name);
        }
        return o2.count - o1.count;
    }
}

class ValueComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        if(o1.getValue() == o2.getValue()) {
            return o1.getKey().compareTo(o2.getKey());
        }
        return o2.getValue() - o1.getValue();
    }
}


