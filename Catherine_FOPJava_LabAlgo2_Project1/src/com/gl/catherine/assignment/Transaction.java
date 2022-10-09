package com.gl.catherine.assignment;

import java.util.Scanner;

public class Transaction {
	public static void main(String[] args) {
		System.out.println("enter the size of transaction array");
		Scanner in = new Scanner(System.in);
		int numberOfTransactions = in.nextInt();
		System.out.println("enter the values of array");
		int[] transactionArray = new int[numberOfTransactions];
		for (int i = 0; i < numberOfTransactions; i++) {
			transactionArray[i] = in.nextInt();
		}
		System.out.println("enter the total no of targets that needs to be achieved");
		int totaltargets = in.nextInt();

		int transactionCountPerTarget = 0;
		int achievedTarget = 0;

		boolean targetAchieved = false;
		for (int j = 0; j < totaltargets; j++) {
			System.out.println("enter the value of target");
			int target = in.nextInt();
			for (int i = 0; i < numberOfTransactions; i++) {
				achievedTarget += transactionArray[i];
				transactionCountPerTarget++;
				if (achievedTarget >= target) {
					targetAchieved = true;
					System.out.println("Target achieved after " + transactionCountPerTarget + " transactions");
					transactionCountPerTarget = 0;
					achievedTarget = 0;
					break;
				}
			}
			if (targetAchieved == false) {
				System.out.println("Given target is not achieved");
			}
		}
		in.close();
	}
}