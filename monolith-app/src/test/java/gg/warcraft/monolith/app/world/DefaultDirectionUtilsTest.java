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

    @Test
    public void rotate_ShouldReturnCorrectRotation() {
        // When
        Direction northRotate0 = defaultDirectionUtils.rotate(Direction.NORTH, 0);
        Direction northRotate90 = defaultDirectionUtils.rotate(Direction.NORTH, 90);
        Direction northRotate180 = defaultDirectionUtils.rotate(Direction.NORTH, 180);
        Direction northRotate270 = defaultDirectionUtils.rotate(Direction.NORTH, 270);
        Direction northRotate360 = defaultDirectionUtils.rotate(Direction.NORTH, 360);
        Direction northRotate720 = defaultDirectionUtils.rotate(Direction.NORTH, 720);

        Direction eastRotate0 = defaultDirectionUtils.rotate(Direction.EAST, 0);
        Direction eastRotate90 = defaultDirectionUtils.rotate(Direction.EAST, 90);
        Direction eastRotate180 = defaultDirectionUtils.rotate(Direction.EAST, 180);
        Direction eastRotate270 = defaultDirectionUtils.rotate(Direction.EAST, 270);
        Direction eastRotate360 = defaultDirectionUtils.rotate(Direction.EAST, 360);
        Direction eastRotate720 = defaultDirectionUtils.rotate(Direction.EAST, 720);

        Direction southRotate0 = defaultDirectionUtils.rotate(Direction.SOUTH, 0);
        Direction southRotate90 = defaultDirectionUtils.rotate(Direction.SOUTH, 90);
        Direction southRotate180 = defaultDirectionUtils.rotate(Direction.SOUTH, 180);
        Direction southRotate270 = defaultDirectionUtils.rotate(Direction.SOUTH, 270);
        Direction southRotate360 = defaultDirectionUtils.rotate(Direction.SOUTH, 360);
        Direction southRotate720 = defaultDirectionUtils.rotate(Direction.SOUTH, 720);

        Direction westRotate0 = defaultDirectionUtils.rotate(Direction.WEST, 0);
        Direction westRotate90 = defaultDirectionUtils.rotate(Direction.WEST, 90);
        Direction westRotate180 = defaultDirectionUtils.rotate(Direction.WEST, 180);
        Direction westRotate270 = defaultDirectionUtils.rotate(Direction.WEST, 270);
        Direction westRotate360 = defaultDirectionUtils.rotate(Direction.WEST, 360);
        Direction westRotate720 = defaultDirectionUtils.rotate(Direction.WEST, 720);

        // Then
        Assert.assertEquals(northRotate0, Direction.NORTH);
        Assert.assertEquals(northRotate90, Direction.EAST);
        Assert.assertEquals(northRotate180, Direction.SOUTH);
        Assert.assertEquals(northRotate270, Direction.WEST);
        Assert.assertEquals(northRotate360, Direction.NORTH);
        Assert.assertEquals(northRotate720, Direction.NORTH);

        Assert.assertEquals(eastRotate0, Direction.EAST);
        Assert.assertEquals(eastRotate90, Direction.SOUTH);
        Assert.assertEquals(eastRotate180, Direction.WEST);
        Assert.assertEquals(eastRotate270, Direction.NORTH);
        Assert.assertEquals(eastRotate360, Direction.EAST);
        Assert.assertEquals(eastRotate720, Direction.EAST);

        Assert.assertEquals(southRotate0, Direction.SOUTH);
        Assert.assertEquals(southRotate90, Direction.WEST);
        Assert.assertEquals(southRotate180, Direction.NORTH);
        Assert.assertEquals(southRotate270, Direction.EAST);
        Assert.assertEquals(southRotate360, Direction.SOUTH);
        Assert.assertEquals(southRotate720, Direction.SOUTH);

        Assert.assertEquals(westRotate0, Direction.WEST);
        Assert.assertEquals(westRotate90, Direction.NORTH);
        Assert.assertEquals(westRotate180, Direction.EAST);
        Assert.assertEquals(westRotate270, Direction.SOUTH);
        Assert.assertEquals(westRotate360, Direction.WEST);
        Assert.assertEquals(westRotate720, Direction.WEST);
    }
}
