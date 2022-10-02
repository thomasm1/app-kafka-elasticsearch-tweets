package service;

import java.util.List;
import util.HashtableChain;
import util.HashtableProbe;
import util.Tree;
import models.Car;

public class DataService {
	
	public static int[] hashNums(int[] arr) {
		int[] nums = new int[10];
		int[] numsToAdd = arr;
		
		for (int i = 0; i< numsToAdd.length;i++) {
			nums[hash(nums.length, numsToAdd[i])] = numsToAdd[i];
		}
		return nums; // returns array of ints8
	}

	public static int hash(int size, int value) {
		return Math.abs(value  %  size);	}

}
