package app.mapl.util.methods.collect;

import java.util.*;

public class HashMapping {
    public static void main(String[] args) {
       hashmap();
       immutableKeys();
       lruCacheTest();

        // creating HashMap object of type <String, String>
        LinkedHashMap<String, String> lhm
                = new LinkedHashMap<String, String>();

        System.out.println("Staff DataBase");

        // adding key-value pairs to HashMap object
        lhm.put("CSE", "Subba Rao");
        lhm.put("IT", "Maruti");
        lhm.put("Civil", "Sundari Devi");

        // Insertion Order iterating
        System.out.println(
                "Insertion Order of LinkedHashMap:"
                        + " iterating \n");

        // getting keySet() into Set
        Set<String> set = lhm.keySet();

        // get Iterator from key set
        Iterator<String> itr = set.iterator();

        // iterating as per Insertion Order
        while (itr.hasNext()) {
            String key = itr.next();
            System.out.println("Key : " + key + "\t\t"
                    + "Value : " + lhm.get(key));
        }

        // Reverse of Insertion Order iterating
        System.out.println("\n\nReverse of Insertion Order:"
                + " iterating \n");

        // convert to ArrayList of key set
        List<String> alKeys
                = new ArrayList<String>(lhm.keySet());

        // reverse order of keys
        Collections.reverse(alKeys);

        // iterate LHM using reverse order of keys
        for (String strKey : alKeys) {
            System.out.println("Key : " + strKey + "\t\t"
                    + "Value : "
                    + lhm.get(strKey));
        }
    }



    private static void hashmap() {
        System.out.println("\n\nInside hashMapDemo ...");
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("John", 25);
        map1.put("Raj", 29);
        map1.put("Anita", null);

        System.out.println(map1);

        map1.put("Anita", 23);
        System.out.println(map1);

        System.out.println("Contains John? " + map1.containsKey("John"));
        System.out.println("John's age: " + map1.get("John"));

        System.out.println("Iterating using keySet ...");
        Set<String> names = map1.keySet();
        for (String name : names) {
            System.out.println("Name: " + name + ", Age: " + map1.get(name));
        }

        System.out.println("Iterating using entrySet ...");
        Set<Map.Entry<String, Integer>> mappings = map1.entrySet();
        for (Map.Entry<String, Integer> mapping : mappings) {
            System.out.println("Name: " + mapping.getKey() + ", Age: " + mapping.getValue());
        }

        names.remove("Anita");
        System.out.println(map1);

        Map<String, Map<String, Object>> userProfile = new HashMap<>();

        Map<String, Object> profile = new HashMap<>();
        profile.put("age", 25);
        profile.put("dept", "CS");
        profile.put("city", "New York");

        userProfile.put("John", profile);

        profile = new HashMap<>();
        profile.put("age", 29);
        profile.put("dept", "CS");
        profile.put("city", "New York");

        userProfile.put("Raj", profile);

        System.out.println("userProfile: " + userProfile);

        Map<String, Object> profile1 = userProfile.get("John");
        int age = (Integer) profile1.get("age");
        System.out.println("Age: " + age);
        // Exercise: Try using second constructor, putAll, clear, values, and other methods
    }

    private static void immutableKeys() {
        System.out.println("\n\nInside immutableKeys  ...");
        List<Integer> list = new ArrayList<>();
        list.add(1);

        Map<List<Integer>, Integer> map = new HashMap<>();
        map.put(list, 1);

        list.add(2);
        System.out.println(map.get(list));

        Student s = new Student(1, null);
        Map<Student, Integer> map2 = new HashMap<>();
        map2.put(s, 1);

        s.setName("John");
        System.out.println(map2.get(s));
    }

    private static void lruCacheTest() {
        System.out.println("\n\nInside lruCacheTest ...");
        Map<String, String> lruCache = new LRUCache<>(16, 0.75f, true);
        lruCache.put("a", "A");
        lruCache.put("b", "B");
        lruCache.put("c", "C");
        System.out.println(lruCache);

        lruCache.get("a"); // multiple gets to "a" will not make a difference
        lruCache.get("a");
        lruCache.get("a");
        System.out.println(lruCache);
        lruCache.get("b");
        System.out.println(lruCache);

        lruCache.put("d", "D");
        System.out.println(lruCache);
        lruCache.put("e", "E");
        System.out.println(lruCache);
    }

}

class LRUCache<K,V> extends LinkedHashMap<K,V> {
    //private static final long serialVersionUID = 6464155743798737431L;
    private static final int MAX_ENTRIES = 3;

    public LRUCache(int initialCapacity,
                    float loadFactor,
                    boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    // Invoked by put and putAll after inserting a new entry into the map
    public boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
        // return false; // same as normal linked hash map
    }
}

class Student {
    private int id;
    private String name;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Student(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
