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
        var currentTimeMillis = System.currentTimeMillis();

        var threeSecondsAgoTimestamp = currentTimeMillis - 3 * TimeUtils.MILLIS_PER_SECOND;
        var lessThanAMinute = defaultTimeUtils.getTimeElapsedSince(threeSecondsAgoTimestamp);
        assertEquals("less than a minute", lessThanAMinute);

        var sixtyFiveSecondsAgoTimestamp = currentTimeMillis - 65 * TimeUtils.MILLIS_PER_SECOND;
        var oneMinute = defaultTimeUtils.getTimeElapsedSince(sixtyFiveSecondsAgoTimestamp);
        assertEquals("1 minute", oneMinute);

        var oneHundredThirtySecondsAgoTimestamp = currentTimeMillis - 130 * TimeUtils.MILLIS_PER_SECOND;
        var twoMinutes = defaultTimeUtils.getTimeElapsedSince(oneHundredThirtySecondsAgoTimestamp);
        assertEquals("2 minutes", twoMinutes);

        var sixtyFiveMinutesAgoTimestamp = currentTimeMillis - 65 * TimeUtils.MILLIS_PER_MINUTE;
        var oneHour = defaultTimeUtils.getTimeElapsedSince(sixtyFiveMinutesAgoTimestamp);
        assertEquals("1 hour", oneHour);

        var oneHundredThirtyMinutesAgoTimestamp = currentTimeMillis - 130 * TimeUtils.MILLIS_PER_MINUTE;
        var twoHours = defaultTimeUtils.getTimeElapsedSince(oneHundredThirtyMinutesAgoTimestamp);
        assertEquals("2 hours", twoHours);

        var thirtyHoursAgoTimestamp = currentTimeMillis - 30 * TimeUtils.MILLIS_PER_HOUR;
        var oneDay = defaultTimeUtils.getTimeElapsedSince(thirtyHoursAgoTimestamp);
        assertEquals("1 day", oneDay);

        var oneHundredTwentyEightHoursAgoTimestamp = currentTimeMillis - 128 * TimeUtils.MILLIS_PER_HOUR;
        var fiveDays = defaultTimeUtils.getTimeElapsedSince(oneHundredTwentyEightHoursAgoTimestamp);
        assertEquals("5 days", fiveDays);
    }
}
