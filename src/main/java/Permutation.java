import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mseidel on 14/06/2017.
 */
public class Permutation {
    public static void main(String ... args) {

        Permutation permutation = new Permutation();
        System.out.println(Arrays.toString(permutation.permutationRecursion("ba")));
        System.out.println(Arrays.toString(permutation.permutationRecursion("abc")));
        System.out.println(Arrays.toString(permutation.permutationRecursion("abcd")));
        System.out.println(Arrays.toString(permutation.permutationRecursion("abcde")));
    }

    public String[] permutationRecursion(String str) {

        if (str.length() == 2) {
            return new String[] {str, new StringBuilder(str).reverse().toString()};
        } else {
            Set<String> storedPermutation = new HashSet<String>();
            for (int i = 0 ; i < str.length() ; i++) {
                List<String> permutatedStrings = Arrays.asList(permutationRecursion(new StringBuilder().append(str.substring(0,i)).append(str.substring(i + 1, str.length())).toString()));
                for (String s : permutatedStrings) {
                    storedPermutation.add(new StringBuilder().append(str.charAt(i)).append(s).toString());
                }
            }
            return storedPermutation.toArray(new String[0]);
        }
    }

}
