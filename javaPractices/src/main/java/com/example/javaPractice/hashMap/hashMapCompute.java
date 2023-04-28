package com.example.javaPractice.hashMap;

import com.example.javaPractice.JavaPracticeApplication;
import com.example.javaPractice.hashMap.entity.BulkProductOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class hashMapCompute {

    public void main(String[] args) {
        SpringApplication.run(JavaPracticeApplication.class, args);
        this.hashMap();
        this.computeIfAbsent();
        List<BulkProductOffer> bulkProductOffers = new ArrayList<BulkProductOffer>();
        Map<String, Map<String, List<BulkProductOffer>>> groupedMap = createGroupedMap(bulkProductOffers);
        System.out.println(groupedMap);
    }

    private void computeIfAbsent(){
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);

        // Retrieve the value for the key "one", or compute a new value if the key is not present
        int value = map.computeIfAbsent("one", key -> key.length());

        // Retrieve the value for the key "two", or compute a new value if the key is not present
        int newValue = map.computeIfAbsent("two", key -> key.length());

        System.out.println(value); // Output: 1
        System.out.println(newValue); // Output: 3
    }

    private static Map<String, Map<String, List<BulkProductOffer>>> createGroupedMap(List<BulkProductOffer> bulkProductOffers) {
        Map<String, List<BulkProductOffer>> map = new HashMap<>();
        Map<String, Map<String, List<BulkProductOffer>>> groupedMap = new HashMap<>();
        for (BulkProductOffer item : bulkProductOffers) {
            String key = "definitionProduct"; //you can generate this item for present map.
            /* computeIfAbsent : The computeIfAbsent method first checks
            if the specified key is already present in the map. If it is,
            then the associated value is returned. If the key is not present,
            then the mapping function is called with the key as its argument to compute the new value.
            The new value is then associated with the key in the map and returned. */
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(item);

            Map<String, List<BulkProductOffer>> productMap = groupedMap.computeIfAbsent(item.getProductName(), k -> new HashMap<>());
            productMap.put(key, map.get(key));
        }
        return map;
    }

    private void hashMap() {
        // Create a new HashMap
        Map<String, Integer> map = new HashMap<>();

        // Add some key-value pairs to the map
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("orange", 3);

        // Retrieve the value for a key
        int value = map.get("banana");
        System.out.println(value); // Output: 2

        // Check if a key exists in the map
        boolean containsKey = map.containsKey("apple");
        System.out.println(containsKey); // Output: true

        // Update the value for a key
        map.put("banana", 5);

        // Iterate over the keys in the map and print the key-value pairs
        for (String key : map.keySet()) {
            int val = map.get(key);
            System.out.println(key + " -> " + val);
        }
        // Output:
        // apple -> 1
        // banana -> 5
        // orange -> 3
    }
}
