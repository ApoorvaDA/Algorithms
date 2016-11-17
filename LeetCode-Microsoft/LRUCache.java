/*
How to implement LRU caching scheme? What data structures should be used?

We are given total possible page numbers that can be referred. 
We are also given cache (or memory) size (Number of page frames that cache can hold at a time).
The LRU caching scheme is to remove the least recently used frame when the cache is full and
a new page is referenced which is not there in cache.

Problem Statement :

Design and implement a data structure for Least Recently Used (LRU) cache. 
It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. 
When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/

public class LRUCache{

	Map<Integer,Integer> map;
	int capacity;

	public LRUCache(int capacity){
		this.map = new LinkedHashMap<Integer,Integer>();
		this.capacity = capacity;
	}

	public int get(int key){
		if (!map.containsKey(key)) {
			return -1;
		}
		int value = map.get(key);
		if (map.size()>1) {
			map.remove(key);
			map.put(key,value);
		}
		return value;
	}

	public void set(int key, int value){
		if (!map.containsKey(key)) {
			if (map.size() == capacity) {
				int firstKey =map.keySet().iterator().next();
				map.remove(firstKey);
			} else {
				map.remove(key);
				map.put(key,value);
			}
		}
	}


}