package concepts;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Questions: Make a MAP immutable.
 */
public class ImmutableMap<K,V> extends HashMap<K, V> {
    Map<K, V> map;

    public ImmutableMap(Map<K, V> map) {
        this.map = map;
    }

    @Override
    public V put(K key, V value) {
        //you can also throw exception if you want
        System.out.println("put operation is not allowed");
        return null;
    }

    @Override
    public V remove(Object key) {
        //you can also throw exception if you want
        System.out.println("remove operation is not allowed");
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        //you can also throw exception if you want
        System.out.println("putAll operation is not allowed");
    }

    @Override
    public V replace(K key, V value) {
        //you can also throw exception if you want
        System.out.println("replace operation is not allowed");
        return null;
    }


    public static void main(String[] args) {
        /**
         * Make the following map immutable.
         */
        Map<Integer, Integer> mutableMap = new HashMap<>();
        mutableMap.put(1,2);
        mutableMap.put(4,5);

        /**
         * Note that in order to benefit immutability, you should use
         * ImmutableMap<Integer, Integer> immutableMap object only.
         *
         * Wrapper for immutable map
         */
        ImmutableMap<Integer, Integer> immutableMap = new ImmutableMap<>(mutableMap);
        immutableMap.put(70,100); // not allowed
        immutableMap.replace(70,100); // not allowed

        Assert.assertEquals("map is not modified",immutableMap.map, mutableMap);

    }
}
