package step0;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * En esta etapa no hay pruebas ni de Movie ni de Rental
 * porque son meros Value Objects y no merece la pena.
 *
 */
@RunWith(Suite.class)
@SuiteClasses({CustomerTest.class})
public class TestAll {

}
