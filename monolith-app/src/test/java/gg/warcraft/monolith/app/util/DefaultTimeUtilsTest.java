package gg.warcraft.monolith.app.util;

import gg.warcraft.monolith.api.util.TimeUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DefaultTimeUtilsTest {
    private DefaultTimeUtils defaultTimeUtils;

    @Before
    public void beforeEach() {
        defaultTimeUtils = new DefaultTimeUtils();
    }

    @Test
    public void shouldCalculateElapsedTime() {
        long currentTimeMillis = System.currentTimeMillis();

        long threeSecondsAgoTimestamp = currentTimeMillis - 3 * TimeUtils.MILLIS_PER_SECOND;
        String lessThanAMinute = defaultTimeUtils.getTimeElapsedSince(threeSecondsAgoTimestamp);
        assertEquals("less than a minute", lessThanAMinute);

        long sixtyFiveSecondsAgoTimestamp = currentTimeMillis - 65 * TimeUtils.MILLIS_PER_SECOND;
        String oneMinute = defaultTimeUtils.getTimeElapsedSince(sixtyFiveSecondsAgoTimestamp);
        assertEquals("1 minute", oneMinute);

        long oneHundredThirtySecondsAgoTimestamp = currentTimeMillis - 130 * TimeUtils.MILLIS_PER_SECOND;
        String twoMinutes = defaultTimeUtils.getTimeElapsedSince(oneHundredThirtySecondsAgoTimestamp);
        assertEquals("2 minutes", twoMinutes);

        long sixtyFiveMinutesAgoTimestamp = currentTimeMillis - 65 * TimeUtils.MILLIS_PER_MINUTE;
        String oneHour = defaultTimeUtils.getTimeElapsedSince(sixtyFiveMinutesAgoTimestamp);
        assertEquals("1 hour", oneHour);

        long oneHundredThirtyMinutesAgoTimestamp = currentTimeMillis - 130 * TimeUtils.MILLIS_PER_MINUTE;
        String twoHours = defaultTimeUtils.getTimeElapsedSince(oneHundredThirtyMinutesAgoTimestamp);
        assertEquals("2 hours", twoHours);

        long thirtyHoursAgoTimestamp = currentTimeMillis - 30 * TimeUtils.MILLIS_PER_HOUR;
        String oneDay = defaultTimeUtils.getTimeElapsedSince(thirtyHoursAgoTimestamp);
        assertEquals("1 day", oneDay);

        long oneHundredTwentyEightHoursAgoTimestamp = currentTimeMillis - 128 * TimeUtils.MILLIS_PER_HOUR;
        String fiveDays = defaultTimeUtils.getTimeElapsedSince(oneHundredTwentyEightHoursAgoTimestamp);
        assertEquals("5 days", fiveDays);
    }
}
