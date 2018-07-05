package gg.warcraft.monolith.app.world.block;

import gg.warcraft.monolith.api.world.BlockLocation;
import gg.warcraft.monolith.api.world.World;
import gg.warcraft.monolith.api.world.WorldType;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BoundingBlockBox;
import gg.warcraft.monolith.api.world.service.WorldQueryService;
import org.joml.Vector3i;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SimpleBoundingBlockBoxTest {
    private SimpleBoundingBlockBox simpleBoundingBlockBox;

    @Mock private WorldQueryService mockWorldQueryService;
    @Mock private World mockWorld;
    @Mock private Block mockBlock;
    @Mock private BlockLocation mockBlockLocation;

    @Before
    public void beforeEach() {
        WorldType world = WorldType.OVERWORLD;
        when(mockWorldQueryService.getWorld(world)).thenReturn(mockWorld);

        Vector3i minimumCorner = new Vector3i(0, 0, 0);
        Vector3i maximumCorner = new Vector3i(9, 9, 9);
        simpleBoundingBlockBox = new SimpleBoundingBlockBox(mockWorldQueryService, world, minimumCorner, maximumCorner);
    }

    @After
    public void afterEach() {
        reset(mockWorldQueryService, mockWorld, mockBlock, mockBlockLocation);
    }

    @Test
    public void test_shouldAcceptBlockInsideBoundary() {
        // Given
        when(mockBlockLocation.getX()).thenReturn(1);
        when(mockBlockLocation.getY()).thenReturn(1);
        when(mockBlockLocation.getZ()).thenReturn(1);
        when(mockBlock.getLocation()).thenReturn(mockBlockLocation);

        // When
        boolean result = simpleBoundingBlockBox.test(mockBlock);

        // Then
        assertTrue(result);
    }

    @Test
    public void test_shouldAcceptBlockOnBoundary() {
        // Given
        when(mockBlockLocation.getX()).thenReturn(0);
        when(mockBlockLocation.getY()).thenReturn(0);
        when(mockBlockLocation.getZ()).thenReturn(0);
        when(mockBlock.getLocation()).thenReturn(mockBlockLocation);

        // When
        boolean result = simpleBoundingBlockBox.test(mockBlock);

        // Then
        assertTrue(result);
    }

    @Test
    public void test_shouldRejectBlockOutsideBoundary() {
        // Given
        when(mockBlockLocation.getX()).thenReturn(20);
        when(mockBlockLocation.getY()).thenReturn(20);
        when(mockBlockLocation.getZ()).thenReturn(20);
        when(mockBlock.getLocation()).thenReturn(mockBlockLocation);

        // When
        boolean result = simpleBoundingBlockBox.test(mockBlock);

        // Then
        assertFalse(result);
    }

    @Test
    public void rotate_shouldCorrectlyRotate0DegreesAroundPivot() {
        // Given
        when(mockBlockLocation.getX()).thenReturn(1);
        when(mockBlockLocation.getY()).thenReturn(1);
        when(mockBlockLocation.getZ()).thenReturn(1);
        when(mockBlock.getLocation()).thenReturn(mockBlockLocation);

        // When
        BoundingBlockBox result = simpleBoundingBlockBox.rotateY(mockBlock, 0);

        // Then
        Assert.assertEquals(0, result.getNorthBoundary());
        Assert.assertEquals(9, result.getEastBoundary());
        Assert.assertEquals(9, result.getSouthBoundary());
        Assert.assertEquals(0, result.getWestBoundary());
        Assert.assertEquals(0, result.getLowerBoundary());
        Assert.assertEquals(9, result.getUpperBoundary());
    }

    @Test
    public void rotate_shouldCorrectlyRotate90DegreesAroundPivot() {
        // Given
        when(mockBlockLocation.getX()).thenReturn(1);
        when(mockBlockLocation.getY()).thenReturn(1);
        when(mockBlockLocation.getZ()).thenReturn(1);
        when(mockBlock.getLocation()).thenReturn(mockBlockLocation);

        // When
        BoundingBlockBox result = simpleBoundingBlockBox.rotateY(mockBlock, 90);

        // Then
        Assert.assertEquals(0, result.getNorthBoundary());
        Assert.assertEquals(2, result.getEastBoundary());
        Assert.assertEquals(9, result.getSouthBoundary());
        Assert.assertEquals(-7, result.getWestBoundary());
        Assert.assertEquals(0, result.getLowerBoundary());
        Assert.assertEquals(9, result.getUpperBoundary());
    }

    @Test
    public void rotate_shouldCorrectlyRotate180DegreesAroundPivot() {
        // Given
        when(mockBlockLocation.getX()).thenReturn(1);
        when(mockBlockLocation.getY()).thenReturn(1);
        when(mockBlockLocation.getZ()).thenReturn(1);
        when(mockBlock.getLocation()).thenReturn(mockBlockLocation);

        // When
        BoundingBlockBox result = simpleBoundingBlockBox.rotateY(mockBlock, 180);

        // Then
        Assert.assertEquals(-7, result.getNorthBoundary());
        Assert.assertEquals(2, result.getEastBoundary());
        Assert.assertEquals(2, result.getSouthBoundary());
        Assert.assertEquals(-7, result.getWestBoundary());
        Assert.assertEquals(0, result.getLowerBoundary());
        Assert.assertEquals(9, result.getUpperBoundary());
    }

    @Test
    public void rotate_shouldCorrectlyRotate270DegreesAroundPivot() {
        // Given
        when(mockBlockLocation.getX()).thenReturn(1);
        when(mockBlockLocation.getY()).thenReturn(1);
        when(mockBlockLocation.getZ()).thenReturn(1);
        when(mockBlock.getLocation()).thenReturn(mockBlockLocation);

        // When
        BoundingBlockBox result = simpleBoundingBlockBox.rotateY(mockBlock, 270);

        // Then
        Assert.assertEquals(-7, result.getNorthBoundary());
        Assert.assertEquals(9, result.getEastBoundary());
        Assert.assertEquals(2, result.getSouthBoundary());
        Assert.assertEquals(0, result.getWestBoundary());
        Assert.assertEquals(0, result.getLowerBoundary());
        Assert.assertEquals(9, result.getUpperBoundary());
    }

    @Test
    public void rotate_shouldCorrectlyRotateLargeRotation() {
        // Given
        when(mockBlockLocation.getX()).thenReturn(1);
        when(mockBlockLocation.getY()).thenReturn(1);
        when(mockBlockLocation.getZ()).thenReturn(1);
        when(mockBlock.getLocation()).thenReturn(mockBlockLocation);

        // When
        BoundingBlockBox result = simpleBoundingBlockBox.rotateY(mockBlock, 2700);

        // Then
        Assert.assertEquals(-7, result.getNorthBoundary());
        Assert.assertEquals(2, result.getEastBoundary());
        Assert.assertEquals(2, result.getSouthBoundary());
        Assert.assertEquals(-7, result.getWestBoundary());
        Assert.assertEquals(0, result.getLowerBoundary());
        Assert.assertEquals(9, result.getUpperBoundary());
    }

    @Test
    public void rotate_shouldCorrectlyRotateNegativeRotation() {
        // Given
        when(mockBlockLocation.getX()).thenReturn(1);
        when(mockBlockLocation.getY()).thenReturn(1);
        when(mockBlockLocation.getZ()).thenReturn(1);
        when(mockBlock.getLocation()).thenReturn(mockBlockLocation);

        // When
        BoundingBlockBox result = simpleBoundingBlockBox.rotateY(mockBlock, -90);

        // Then
        Assert.assertEquals(-7, result.getNorthBoundary());
        Assert.assertEquals(9, result.getEastBoundary());
        Assert.assertEquals(2, result.getSouthBoundary());
        Assert.assertEquals(0, result.getWestBoundary());
        Assert.assertEquals(0, result.getLowerBoundary());
        Assert.assertEquals(9, result.getUpperBoundary());
    }

    @Test
    public void rotate_shouldCorrectlyRotateLargeNegativeRotation() {
        // Given
        when(mockBlockLocation.getX()).thenReturn(1);
        when(mockBlockLocation.getY()).thenReturn(1);
        when(mockBlockLocation.getZ()).thenReturn(1);
        when(mockBlock.getLocation()).thenReturn(mockBlockLocation);

        // When
        BoundingBlockBox result = simpleBoundingBlockBox.rotateY(mockBlock, -2070);

        // Then
        Assert.assertEquals(0, result.getNorthBoundary());
        Assert.assertEquals(2, result.getEastBoundary());
        Assert.assertEquals(9, result.getSouthBoundary());
        Assert.assertEquals(-7, result.getWestBoundary());
        Assert.assertEquals(0, result.getLowerBoundary());
        Assert.assertEquals(9, result.getUpperBoundary());
    }

    @Test(expected = IllegalArgumentException.class)
    public void rotate_shouldThrowOnOddRotation() {
        // Given
        when(mockBlockLocation.getX()).thenReturn(1);
        when(mockBlockLocation.getY()).thenReturn(1);
        when(mockBlockLocation.getZ()).thenReturn(1);
        when(mockBlock.getLocation()).thenReturn(mockBlockLocation);

        // When
        simpleBoundingBlockBox.rotateY(mockBlock, 60);
    }
}
