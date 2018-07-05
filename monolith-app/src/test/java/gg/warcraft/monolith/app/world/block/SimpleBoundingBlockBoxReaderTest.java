package gg.warcraft.monolith.app.world.block;

import gg.warcraft.monolith.api.world.Direction;
import gg.warcraft.monolith.api.world.World;
import gg.warcraft.monolith.api.world.WorldType;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BlockType;
import gg.warcraft.monolith.api.world.block.BoundingBlockBox;
import gg.warcraft.monolith.api.world.service.WorldQueryService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SimpleBoundingBlockBoxReaderTest {
    private SimpleBoundingBlockBoxReader northSimpleBoundingBlockBoxReader;
    private SimpleBoundingBlockBoxReader eastSimpleBoundingBlockBoxReader;
    private SimpleBoundingBlockBoxReader southSimpleBoundingBlockBoxReader;
    private SimpleBoundingBlockBoxReader westSimpleBoundingBlockBoxReader;

    @Mock private WorldQueryService mockWorldQueryService;
    @Mock private BoundingBlockBox mockBoundingBlockBox;
    @Mock private World mockWorld;

    @Before
    public void beforeEach() {
        when(mockWorld.getType()).thenReturn(WorldType.OVERWORLD);
        when(mockBoundingBlockBox.getWorld()).thenReturn(mockWorld);
        northSimpleBoundingBlockBoxReader = new SimpleBoundingBlockBoxReader(mockWorldQueryService, mockBoundingBlockBox, Direction.NORTH);
        eastSimpleBoundingBlockBoxReader = new SimpleBoundingBlockBoxReader(mockWorldQueryService, mockBoundingBlockBox, Direction.EAST);
        southSimpleBoundingBlockBoxReader = new SimpleBoundingBlockBoxReader(mockWorldQueryService, mockBoundingBlockBox, Direction.SOUTH);
        westSimpleBoundingBlockBoxReader = new SimpleBoundingBlockBoxReader(mockWorldQueryService, mockBoundingBlockBox, Direction.WEST);
    }

    @After
    public void afterEach() {
        reset(mockWorldQueryService, mockBoundingBlockBox);
    }

    @Test
    public void getBlockAt_shouldReturnCorrectBlock() {
        // Given
        when(mockBoundingBlockBox.getNorthBoundary()).thenReturn(1);
        when(mockBoundingBlockBox.getEastBoundary()).thenReturn(3);
        when(mockBoundingBlockBox.getSouthBoundary()).thenReturn(3);
        when(mockBoundingBlockBox.getWestBoundary()).thenReturn(1);
        when(mockBoundingBlockBox.getLowerBoundary()).thenReturn(0);
        when(mockBoundingBlockBox.getUpperBoundary()).thenReturn(0);

        Block mockBlock11 = mock(Block.class);
        when(mockBlock11.getType()).thenReturn(BlockType.AIR);
        Block mockBlock12 = mock(Block.class);
        when(mockBlock12.getType()).thenReturn(BlockType.GRASS);
        Block mockBlock13 = mock(Block.class);
        when(mockBlock13.getType()).thenReturn(BlockType.DIRT);
        Block mockBlock21 = mock(Block.class);
        when(mockBlock21.getType()).thenReturn(BlockType.STONE);
        Block mockBlock22 = mock(Block.class);
        when(mockBlock22.getType()).thenReturn(BlockType.GLASS);
        Block mockBlock23 = mock(Block.class);
        when(mockBlock23.getType()).thenReturn(BlockType.STILL_WATER);
        Block mockBlock31 = mock(Block.class);
        when(mockBlock31.getType()).thenReturn(BlockType.STILL_LAVA);
        Block mockBlock32 = mock(Block.class);
        when(mockBlock32.getType()).thenReturn(BlockType.FLOWER_POT);
        Block mockBlock33 = mock(Block.class);
        when(mockBlock33.getType()).thenReturn(BlockType.VINES);

        when(mockWorldQueryService.getBlockAt(mockWorld.getType(), 1, 0, 1)).thenReturn(mockBlock11);
        when(mockWorldQueryService.getBlockAt(mockWorld.getType(), 1, 0, 2)).thenReturn(mockBlock12);
        when(mockWorldQueryService.getBlockAt(mockWorld.getType(), 1, 0, 3)).thenReturn(mockBlock13);
        when(mockWorldQueryService.getBlockAt(mockWorld.getType(), 2, 0, 1)).thenReturn(mockBlock21);
        when(mockWorldQueryService.getBlockAt(mockWorld.getType(), 2, 0, 2)).thenReturn(mockBlock22);
        when(mockWorldQueryService.getBlockAt(mockWorld.getType(), 2, 0, 3)).thenReturn(mockBlock23);
        when(mockWorldQueryService.getBlockAt(mockWorld.getType(), 3, 0, 1)).thenReturn(mockBlock31);
        when(mockWorldQueryService.getBlockAt(mockWorld.getType(), 3, 0, 2)).thenReturn(mockBlock32);
        when(mockWorldQueryService.getBlockAt(mockWorld.getType(), 3, 0, 3)).thenReturn(mockBlock33);

        // When
        Block northFrontLeftBlock = northSimpleBoundingBlockBoxReader.getBlockAt(0, 0, 2);
        Block eastFrontLeftBlock = eastSimpleBoundingBlockBoxReader.getBlockAt(0, 0, 2);
        Block southFrontLeftBlock = southSimpleBoundingBlockBoxReader.getBlockAt(0, 0, 2);
        Block westFrontLeftBlock = westSimpleBoundingBlockBoxReader.getBlockAt(0, 0, 2);

        // Then
        Assert.assertEquals(mockBlock11.getType(), northFrontLeftBlock.getType());
        Assert.assertEquals(mockBlock31.getType(), eastFrontLeftBlock.getType());
        Assert.assertEquals(mockBlock33.getType(), southFrontLeftBlock.getType());
        Assert.assertEquals(mockBlock13.getType(), westFrontLeftBlock.getType());
    }
}
