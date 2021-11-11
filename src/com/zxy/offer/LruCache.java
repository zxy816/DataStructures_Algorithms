package com.zxy.offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache {
    private Map<Integer, Integer> cache;

    public static void main(String[] args) {
        LruCache lruCache = new LruCache(2);
        lruCache.put(0, 2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 1);
        System.out.println(lruCache.get(0));
    }

    public LruCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity + 1, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };

    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    /**
     * 第二种方法...
     */
    public class Node {
        public Node pre;
        public Node next;
        public String key;
        public String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
