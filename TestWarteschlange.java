
import static org.junit.Assert.*;
import org.junit.*;
/**
 *
 * Eine Klasse zur Verwaltung eines Class
 *
 * @author (Mofadhal Al-Manari und Leen Alkhadraa)
 * @version (19.01.2021)
 */
public class TestWarteschlange {
    PatientenWarteschlange x;

    @Before
    public void setUp() {
        x = new PatientenWarteschlange(3);
    }

    @Test
    public void testDerNaechsteBitte() {
        x.neuerPatient(1, "almanari");
        x.neuerPatient(2, "moha");
        x.neuerPatient(3, "musleh");

        assertEquals(x.derNaechsteBitte(), new Patient(1, "almanari"));
        assertEquals(x.derNaechsteBitte(), new Patient(2, "moha"));
        assertEquals(x.derNaechsteBitte(), new Patient(3, "musleh"));
    }

    @Test(expected = RuntimeException.class)
    public void testMehrAlsDieSchlange() {
        x.neuerPatient(1, "almanari");
        x.neuerPatient(2, "moha");
        x.neuerPatient(3, "musleh");
        x.neuerPatient(4, "khaled, almanari");
    }

    @Test(expected = RuntimeException.class)
    public void testEntferneError() {
        x.neuerPatient(1, "almanari");
        x.neuerPatient(2, "moha");
        x.neuerPatient(3, "musleh");

        x.entfernePatient(5);
    }

    @Test
    public void testEntferne() {
        PatientenWarteschlange x1 = new PatientenWarteschlange(4);
        x1.neuerPatient(1, "almanari");
        x1.neuerPatient(2, "moha, almanari");
        x1.neuerPatient(3, "musleh");
        x1.neuerPatient(10, "mofa, hassan");


        x1.entfernePatient(1);
        x1.entfernePatient(3);
        assertEquals(x1.derNaechsteBitte(), new Patient(2, "moha, almanari"));
        assertEquals(x1.derNaechsteBitte(), new Patient(10, "mofa, hassan"));
    }

    @Test(expected = RuntimeException.class)
    public void testDerNaechsteLeereSchlange() {
        x.derNaechsteBitte();
    }

    @Test(expected = RuntimeException.class)
    public void testEntferneLeereSchlange() {
        x.entfernePatient(1);
    }

    @Test(expected = RuntimeException.class)
    public void testEntferneAlle() {
        x.neuerPatient(1, "almanari");
        x.neuerPatient(2, "moha");
        x.neuerPatient(3, "musleh");

        x.entfernePatient(1);
        x.entfernePatient(2);
        x.entfernePatient(3);
        x.derNaechsteBitte();
    }
}
