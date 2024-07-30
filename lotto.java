package bpjs;

import java.util.*;
import java.text.*;

public class lotto {

	static final int MAXNUM = 47;
	static final int NUMNUMS = 6;
	static final int RUNS = 100;

	DecimalFormat formatter = new DecimalFormat();

	public void run(Collection<Integer> arg1) {
		int winCount = 0;
		long totalRolls = 0;
		SortedSet<Integer> result = new TreeSet<Integer>();
		SortedSet<Integer> testNums = new TreeSet<Integer>();
		testNums.addAll(arg1);
		System.out.println("Testing: " + testNums);

		do {
			long counter = 0;

			do {
				result.clear();
				counter++;
				while (result.size() < NUMNUMS) {
					Random rand = new Random();
					result.add(rand.nextInt(MAXNUM) + 1);
				}
			} while (!result.containsAll(testNums));
			System.out.println(result + " took " + formatter.format(counter) + " rolls.");
			totalRolls += counter;
		} while (++winCount < RUNS);
		System.out.println("Average Rolls: " + formatter.format(totalRolls / RUNS) + " rolls.");
	}
}
