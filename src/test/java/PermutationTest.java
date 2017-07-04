import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mseidel on 14/06/2017.
 */
public class PermutationTest {

    Permutation objUnderTest;

    @Before
    public void setUp() {
        objUnderTest = new Permutation();
    }

    @Test
    public void permutationTest() {
        Assertions.assertThat(objUnderTest.permutationRecursion("ba")).isEqualTo(new String[] {"ba", "ab"});
    }

}
