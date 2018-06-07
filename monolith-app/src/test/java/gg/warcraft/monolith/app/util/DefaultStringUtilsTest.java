package gg.warcraft.monolith.app.util;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class DefaultStringUtilsTest {
    private DefaultStringUtils defaultStringUtils;

    @Before
    public void beforeEach() {
        defaultStringUtils = new DefaultStringUtils();
    }

    @Test
    public void shouldCheckVowel() {
        boolean aIsVowel = defaultStringUtils.isVowel('a');
        assertTrue(aIsVowel);

        boolean bIsNoVowel = defaultStringUtils.isVowel('b');
        assertFalse(bIsNoVowel);

        boolean specialIsNoVowel = defaultStringUtils.isVowel('"');
        assertFalse(specialIsNoVowel);
    }
}
