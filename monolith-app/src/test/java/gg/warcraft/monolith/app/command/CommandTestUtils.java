package gg.warcraft.monolith.app.command;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandTestUtils {

    private static String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public static String randomName() {
        return randomString();
    }

    public static List<String> randomAliases() {
        List<String> aliases = new ArrayList<>();
        int count = RandomUtils.nextInt(1, 5);
        for (int i = 0; i <= count; i += 1) {
            String alias = randomString();
            aliases.add(alias);
        }
        return aliases;
    }

    public static String randomArgument() {
        return randomString();
    }
}
