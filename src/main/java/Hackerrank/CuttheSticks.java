package Hackerrank;


import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 You are given N sticks, where the length of each stick is a positive integer. A cut operation is performed on the sticks such that all of them are reduced by the length of the smallest stick.

 Suppose we have six sticks of the following lengths:
 5 4 4 2 2 8

 Then, in one cut operation we make a cut of length 2 from each of the six sticks. For the next cut operation four sticks are left (of non-zero length), whose lengths are the following: 
 3 2 2 6

 The above step is repeated until no sticks are left.

 Given the length of N sticks, print the number of sticks that are left before each subsequent cut operations.

 Note: For each cut operation, you have to recalcuate the length of smallest sticks (excluding zero-length sticks).

 Input Format 
 The first line contains a single integer N. 
 The next line contains N integers: a0, a1,...aN-1 separated by space, where ai represents the length of ith stick.

 Output Format 
 For each operation, print the number of sticks that are cut, on separate lines.

 Constraints 
 1 ≤ N ≤ 1000 
 1 ≤ ai ≤ 1000

 Sample Input #00

 6
 5 4 4 2 2 8
 Sample Output #00

 6
 4
 2
 1
 Sample Input #01

 8
 1 2 3 4 3 3 2 1
 Sample Output #01

 8
 6
 4
 1
 Explanation

 Sample Case #00 :

 sticks-length        length-of-cut   sticks-cut
 5 4 4 2 2 8             2               6
 3 2 2 _ _ 6             2               4
 1 _ _ _ _ 4             1               2
 _ _ _ _ _ 3             3               1
 _ _ _ _ _ _           DONE            DONE
 Sample Case #01

 sticks-length         length-of-cut   sticks-cut
 1 2 3 4 3 3 2 1         1               8
 _ 1 2 3 2 2 1 _         1               6
 _ _ 1 2 1 1 _ _         1               4
 _ _ _ 1 _ _ _ _         1               1
 _ _ _ _ _ _ _ _       DONE            DONE
 */
/**
 *
 * @author pulsefire
 */
public class CuttheSticks {

    //Approach number 2 by pipebombguy
    public static void approach2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        for (int i = 0; i < n;) {   //Logic
            int j = i;
            while (j < n && a[j] == a[i]) {
                j++;
            }
            out.println(n - i);
            i = j;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            arr.add(a);
        }
        Collections.sort(arr);
        for (int i = 0; i < arr.size(); i++) { //remove elements after reducing to zero
            if (arr.get(0) == 0) {
                arr.remove(0);
                i = -1; //so that after increment,it resets to 0
                continue;
            }
            System.out.println(arr.size());
            int min = arr.get(0);
            for (int j = 0; j < arr.size(); j++) {
                arr.set(j, arr.get(j) - min);
            }
        }

    }

}
