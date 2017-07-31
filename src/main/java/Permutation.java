import java.util.*;

/**
 * Created by mseidel on 14/06/2017.
 */
public class Permutation {
    public static void main(String... args) {

        int[] hunderArray = new int[100];

        for (int i = 0 ; i < hunderArray.length ; i++) {
            hunderArray[i] = new Random().nextInt(1000);
        }

        int[] tousandArray = new int[1000];
        for (int i = 0 ; i < tousandArray.length ; i++) {
            tousandArray[i] = new Random().nextInt(1000);
        }

        int[] milionArray = new int[1000000];
        for (int i = 0 ; i < milionArray.length ; i++) {
            milionArray[i] = new Random().nextInt(100000);
        }

        Permutation permutation = new Permutation();
        System.out.println(Arrays.toString(permutation.permutationRecursion("ba")));
        System.out.println(Arrays.toString(permutation.permutationRecursion("abc")));
        System.out.println(Arrays.toString(permutation.permutationRecursion("abcd")));
        System.out.println(Arrays.toString(permutation.permutationRecursion("abcde")));
        long time = System.nanoTime();
        System.out.println(Arrays.toString(getPair(new int[]{4,2,3,8,5}, 10)));
        long newTime = System.nanoTime();
        System.out.println("time took is " + Long.toString(newTime - time));

        time = System.nanoTime();
        System.out.println(Arrays.toString(getPair(new int[]{2,43,43,12,54,213,54,234,32,213,33,11,2,3,4,7,8,5}, 44)));
        newTime = System.nanoTime();
        System.out.println("time took is " + Long.toString(newTime - time));

        time = System.nanoTime();
        System.out.println(Arrays.toString(getPair(hunderArray, 244)));
        newTime = System.nanoTime();
        System.out.println("time took is " + Long.toString(newTime - time));

        time = System.nanoTime();
        System.out.println(Arrays.toString(getPair(tousandArray, 444)));
        newTime = System.nanoTime();
        System.out.println("time took is " + Long.toString(newTime - time));

        time = System.nanoTime();
        System.out.println(Arrays.toString(getPair(milionArray, 444)));
        newTime = System.nanoTime();
        System.out.println("time took is " + Long.toString(newTime - time));
    }

    public String[] permutationRecursion(String str) {

        if (str.length() == 2) {
            return new String[]{str, new StringBuilder(str).reverse().toString()};
        } else {
            Set<String> storedPermutation = new HashSet<String>();
            for (int i = 0; i < str.length(); i++) {
                List<String> permutatedStrings = Arrays.asList(permutationRecursion(new StringBuilder().append(str.substring(0, i)).append(str.substring(i + 1, str.length())).toString()));
                for (String s : permutatedStrings) {
                    storedPermutation.add(new StringBuilder().append(str.charAt(i)).append(s).toString());
                }
            }
            return storedPermutation.toArray(new String[0]);
        }
    }

    public static int[] getPair(int [] array, int sum) {
        Arrays.sort(array);
        int offset = findOffset(array, sum);

        for (int i = 0 ; i < offset ; i ++) {
            if (array[i] + array[offset] == sum) {
                return new int[]{i, offset};
            } else if (array[i] + array[offset] > sum) {
                offset--;
            }
        }
        return null;
    }

    private static int findOffset(int[] array, int sum) {
        int searchedValue = sum - array[0];

        for (int i = array.length - 2 ; i > 0 ; i-- ) {
            if (array[i] < searchedValue) {
                return i + 1;
            }
        }
        return 0;
    }

}
