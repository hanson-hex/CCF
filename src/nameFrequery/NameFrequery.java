package nameFrequery;

import java.util.*;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
import java.util.Map.Entry;
//import java.util.Scanner;

public class NameFrequery {
	public static void start() {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = input.nextInt();
		}
		int count = 0; // 记录出现次数最多的数字出现次数
		int min = 0; // 记录出现最多数字
		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			if (numMap.containsKey(array[i])) {
				int temp = numMap.get(array[i]);
				temp += 1;
				numMap.put(array[i], temp);
			} else {
				numMap.put(array[i], 1);
			}
		}
		Iterator<Map.Entry<Integer, Integer>> iter = numMap.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<Integer, Integer> entry = iter.next();
			if (entry.getValue() > count || (entry.getValue() == count && entry.getKey() < min)) {
				count = entry.getValue();
				min = entry.getKey();
			}
			
		}
		System.out.println(min);
	}
	public static void start1() {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = input.nextInt();
		}
		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			if (numMap.containsKey(array[i])) {
				int temp = numMap.get(array[i]);
				temp += 1;
				numMap.put(array[i], temp);
			} else {
				numMap.put(array[i], 1);
			}
		}
		List<Map.Entry<Integer, Integer>> listData = new ArrayList<Map.Entry<Integer, Integer>>(numMap.entrySet());
//		List<Map.Entry<Integer, Integer>> list_Data = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(listData, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				if (o2.getValue() - o1.getValue() > 0) {
					return 1;
				} else if (o2.getValue() - o1.getValue() == 0) {
					if (o1.getKey() - o2.getKey() > 0) {
						return 1;
					} else {
						return -1;
					}
				} else {
					return -1;
				}
			}
		});
		System.out.println(listData.get(0).getKey());
	}
}
