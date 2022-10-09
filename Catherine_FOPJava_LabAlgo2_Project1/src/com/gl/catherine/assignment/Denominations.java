package com.gl.catherine.assignment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Denominations {
	public static void main(String[] args) {
		System.out.println("enter the size of currency denominations");
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		System.out.println("enter the currency denominations value");
		int[] denominations = new int[size];
		for (int i = 0; i < size; i++) {
			denominations[i] = in.nextInt();
		}
		System.out.println("enter the amount you want to pay");
		int requiredAmount = in.nextInt();

		List<Integer> denominationsList = Arrays.stream(denominations).boxed().sorted((s1, s2) -> s2 - s1)
				.collect(Collectors.toList());
		Map<Integer, Integer> map = new TreeMap<>((s1, s2) -> s2 - s1);
		for (int i = 0; i < size && requiredAmount > 0; i++) {
			int count = 0;
			while (requiredAmount >= denominationsList.get(i)) {
				requiredAmount = requiredAmount - denominationsList.get(i);
				count++;
			}
			if (count > 0) {
				map.put(denominationsList.get(i), count);
			}

		}
		if (requiredAmount > 0) {
			System.out.println("It is not possible to give the amount specified in the available denominations");
		} else {
			System.out.println("Your payment approach in order to give min no of notes will be");
			for (Entry<Integer, Integer> entry : map.entrySet()) {
				System.out.println(entry.getKey() + ":" + entry.getValue());
			}
		}
		in.close();
	}
}
