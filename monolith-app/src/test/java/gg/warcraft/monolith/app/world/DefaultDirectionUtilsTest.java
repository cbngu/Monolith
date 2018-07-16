package gg.warcraft.monolith.app.world;

import gg.warcraft.monolith.api.world.Direction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefaultDirectionUtilsTest {
    private DefaultDirectionUtils defaultDirectionUtils;

    @Before
    public void beforeEach() {
        defaultDirectionUtils = new DefaultDirectionUtils();
    }

    @Test
    public void getRotation_shouldReturnCorrectValues() {
        // When
        int northEastRotation = defaultDirectionUtils.getRotation(Direction.NORTH, Direction.EAST);
        int northSouthRotation = defaultDirectionUtils.getRotation(Direction.NORTH, Direction.SOUTH);
        int northWestRotation = defaultDirectionUtils.getRotation(Direction.NORTH, Direction.WEST);
        int northNorthRotation = defaultDirectionUtils.getRotation(Direction.NORTH, Direction.NORTH);

        int eastSouthRotation = defaultDirectionUtils.getRotation(Direction.EAST, Direction.SOUTH);
        int eastWestRotation = defaultDirectionUtils.getRotation(Direction.EAST, Direction.WEST);
        int eastNorthRotation = defaultDirectionUtils.getRotation(Direction.EAST, Direction.NORTH);
        int eastEastRotation = defaultDirectionUtils.getRotation(Direction.EAST, Direction.EAST);

        int southWestRotation = defaultDirectionUtils.getRotation(Direction.SOUTH, Direction.WEST);
        int southNorthRotation = defaultDirectionUtils.getRotation(Direction.SOUTH, Direction.NORTH);
        int southEastRotation = defaultDirectionUtils.getRotation(Direction.SOUTH, Direction.EAST);
        int southSouthRotation = defaultDirectionUtils.getRotation(Direction.SOUTH, Direction.SOUTH);

        int westNorthRotation = defaultDirectionUtils.getRotation(Direction.WEST, Direction.NORTH);
        int westEastRotation = defaultDirectionUtils.getRotation(Direction.WEST, Direction.EAST);
        int westSouthRotation = defaultDirectionUtils.getRotation(Direction.WEST, Direction.SOUTH);
        int westWestRotation = defaultDirectionUtils.getRotation(Direction.WEST, Direction.WEST);

        // Then
        Assert.assertEquals(90, northEastRotation);
        Assert.assertEquals(180, northSouthRotation);
        Assert.assertEquals(270, northWestRotation);
        Assert.assertEquals(0, northNorthRotation);

        Assert.assertEquals(90, eastSouthRotation);
        Assert.assertEquals(180, eastWestRotation);
        Assert.assertEquals(270, eastNorthRotation);
        Assert.assertEquals(0, eastEastRotation);

        Assert.assertEquals(90, southWestRotation);
        Assert.assertEquals(180, southNorthRotation);
        Assert.assertEquals(270, southEastRotation);
        Assert.assertEquals(0, southSouthRotation);

        Assert.assertEquals(90, westNorthRotation);
        Assert.assertEquals(180, westEastRotation);
        Assert.assertEquals(270, westSouthRotation);
        Assert.assertEquals(0, westWestRotation);
    }
}
