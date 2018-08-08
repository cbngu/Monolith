package gg.warcraft.monolith.app.world;

import gg.warcraft.monolith.api.world.OrientedLocation;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.junit.Assert;
import org.junit.Test;

public class SimpleOrientedLocationTest {
    private final float DELTA = 0.00001f;

    @Test
    public void constructor_shouldCalculateCorrectDirectionLookingUp() {
        // Given
        float pitch = -90;
        float yaw = 0;

        Vector3fc expectedDirection = new Vector3f(0, 1, 0);

        // When
        OrientedLocation location = new SimpleOrientedLocation(null, 0, 0, 0, pitch, yaw);
        Vector3fc direction = location.getDirection();

        // Then
        Assert.assertEquals(expectedDirection.x(), direction.x(), DELTA);
        Assert.assertEquals(expectedDirection.y(), direction.y(), DELTA);
        Assert.assertEquals(expectedDirection.z(), direction.z(), DELTA);
    }

    @Test
    public void constructor_shouldCalculateCorrectDirectionLookingDown() {
        // Given
        float pitch = 90;
        float yaw = 0;

        Vector3fc expectedDirection = new Vector3f(0, -1, 0);

        // When
        OrientedLocation location = new SimpleOrientedLocation(null, 0, 0, 0, pitch, yaw);
        Vector3fc direction = location.getDirection();

        // Then
        Assert.assertEquals(expectedDirection.x(), direction.x(), DELTA);
        Assert.assertEquals(expectedDirection.y(), direction.y(), DELTA);
        Assert.assertEquals(expectedDirection.z(), direction.z(), DELTA);
    }

    @Test
    public void constructor_shouldCalculateCorrectDirectionLookingNorth() {
        // Given
        float pitch = 0;
        float yaw = -180;

        Vector3fc expectedDirection = new Vector3f(0, 0, -1);

        // When
        OrientedLocation location = new SimpleOrientedLocation(null, 0, 0, 0, pitch, yaw);
        Vector3fc direction = location.getDirection();

        // Then
        Assert.assertEquals(expectedDirection.x(), direction.x(), DELTA);
        Assert.assertEquals(expectedDirection.y(), direction.y(), DELTA);
        Assert.assertEquals(expectedDirection.z(), direction.z(), DELTA);
    }

    @Test
    public void constructor_shouldCalculateCorrectDirectionLookingEast() {
        // Given
        float pitch = 0;
        float yaw = -90;

        Vector3fc expectedDirection = new Vector3f(1, 0, 0);

        // When
        OrientedLocation location = new SimpleOrientedLocation(null, 0, 0, 0, pitch, yaw);
        Vector3fc direction = location.getDirection();

        // Then
        Assert.assertEquals(expectedDirection.x(), direction.x(), DELTA);
        Assert.assertEquals(expectedDirection.y(), direction.y(), DELTA);
        Assert.assertEquals(expectedDirection.z(), direction.z(), DELTA);
    }

    @Test
    public void constructor_shouldCalculateCorrectDirectionLookingSouth() {
        // Given
        float pitch = 0;
        float yaw = 0;

        Vector3fc expectedDirection = new Vector3f(0, 0, 1);

        // When
        OrientedLocation location = new SimpleOrientedLocation(null, 0, 0, 0, pitch, yaw);
        Vector3fc direction = location.getDirection();

        // Then
        Assert.assertEquals(expectedDirection.x(), direction.x(), DELTA);
        Assert.assertEquals(expectedDirection.y(), direction.y(), DELTA);
        Assert.assertEquals(expectedDirection.z(), direction.z(), DELTA);
    }

    @Test
    public void constructor_shouldCalculateCorrectDirectionLookingWest() {
        // Given
        float pitch = 0;
        float yaw = 90;

        Vector3fc expectedDirection = new Vector3f(-1, 0, 0);

        // When
        OrientedLocation location = new SimpleOrientedLocation(null, 0, 0, 0, pitch, yaw);
        Vector3fc direction = location.getDirection();

        // Then
        Assert.assertEquals(expectedDirection.x(), direction.x(), DELTA);
        Assert.assertEquals(expectedDirection.y(), direction.y(), DELTA);
        Assert.assertEquals(expectedDirection.z(), direction.z(), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_shouldCRejectOutOfRangePositivePitch() {
        // Given
        float pitch = 90.1f;
        float yaw = 0;

        // When
        new SimpleOrientedLocation(null, 0, 0, 0, pitch, yaw);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_shouldCRejectOutOfRangeNegativePitch() {
        // Given
        float pitch = -90.1f;
        float yaw = 0;

        // When
        new SimpleOrientedLocation(null, 0, 0, 0, pitch, yaw);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_shouldCRejectOutOfRangePositiveYaw() {
        // Given
        float pitch = 0;
        float yaw = 180;

        // When
        new SimpleOrientedLocation(null, 0, 0, 0, pitch, yaw);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_shouldCRejectOutOfRangeNegativeYaw() {
        // Given
        float pitch = 0;
        float yaw = -180.1f;

        // When
        new SimpleOrientedLocation(null, 0, 0, 0, pitch, yaw);
    }
}
