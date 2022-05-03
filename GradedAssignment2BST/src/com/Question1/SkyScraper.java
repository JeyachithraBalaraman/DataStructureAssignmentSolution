package com.Question1;
//Jeyachithra Balaraman - Constructing SkyScraper with different floor sizes
// arriving in different days

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class SkyScraper {
	public static void main(String[] args) {
		HashMap<Integer, Integer> daySize = new HashMap<>();
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> tempStack = new Stack<Integer>();
		Scanner sc = new Scanner(System.in);
		int n;
		int i, j, max;
		int size;
		System.out.println("Enter the total number of floors in the building");
		n = sc.nextInt();
        // storing input in a hashMap
		for (i = 1; i <= n; i++) {
			System.out.println("Enter size of floor arriving on day :" + i);
			daySize.put(i, sc.nextInt());
		}
		System.out.println("The day=floor sizes given are");
		System.out.println(daySize);
		// wait for max floor size to arrive
		max = 0;
		for (j = 1; j <= n; j++) {
			if (max < daySize.get(j))
				max = daySize.get(j);
		}
		System.out.println("The order of construction is as follows ");
		for (i = 1; i <= n; i++) {
			System.out.println();
			System.out.println("Day :" + i);
			size = daySize.get(i);
			// if size is less than max size, push in a stack
			if (size < max)
				stack.push(size);
			// if size = max , print size and all sizes lower than next max size
			if (size == max) {
				System.out.print(size);
				// getting next max size
				max = 0;
				for (j = (i + 1); j <= n; j++) {
					if (max < daySize.get(j))
						max = daySize.get(j);
				} 
                // emptying stack of sizes greater than next max size and moving rest to temp stack
				while (!stack.isEmpty()) {
					size = stack.pop();
					if (size > max)
						System.out.print(" " + size);
					else
						tempStack.push(size);
				} /* while*/
				// moving from temp Stack to main stack
				while (!tempStack.isEmpty()) {
					stack.push(tempStack.pop());
				}
			} /* if size==max*/
		} /* for i*/
		sc.close();
	} // main
}// class
