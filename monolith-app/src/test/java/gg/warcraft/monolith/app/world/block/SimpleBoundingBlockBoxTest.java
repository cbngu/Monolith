package gg.warcraft.monolith.app.world.block;

import gg.warcraft.monolith.api.world.BlockLocation;
import gg.warcraft.monolith.api.world.block.Block;
import org.joml.Vector3i;
import org.junit.After;
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

    @Mock private Block mockBlock;
    @Mock private BlockLocation mockBlockLocation;

    @Before
    public void beforeEach() {
        Vector3i minimumCorner = new Vector3i(0, 0, 0);
        Vector3i maximumCorner = new Vector3i(10, 10, 10);
        simpleBoundingBlockBox = new SimpleBoundingBlockBox(minimumCorner, maximumCorner);
    }

    @After
    public void afterEach() {
        reset(mockBlock, mockBlockLocation);
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
}
