package gg.warcraft.monolith.app.combat.value;

import com.google.common.collect.Lists;
import gg.warcraft.monolith.api.combat.CombatSource;
import gg.warcraft.monolith.api.combat.value.CombatValueModifier;
import gg.warcraft.monolith.api.combat.value.CombatValueModifierType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.reset;

@RunWith(MockitoJUnitRunner.class)
public class LazyCombatValueTest {
    private static final float DELTA = 1E-10f;

    @Mock private CombatSource mockSource;

    @After
    public void afterEach() {
        reset(mockSource);
    }

    @Test
    public void computeModifiedValue_shouldReturnBaseValueWithoutModifiers() {
        // Given
        float baseValue = 5f;
        List<CombatValueModifier> modifiers = new ArrayList<>();

        LazyCombatValue lazyCombatValue = new LazyCombatValue(baseValue, modifiers, mockSource);
        float expectedValue = 5f;

        // When
        float modifiedValue = lazyCombatValue.computeModifiedValue();

        // Then
        Assert.assertEquals(expectedValue, modifiedValue, DELTA);
    }

    @Test
    public void computeModifiedValue_shouldCorrectlyAddPercentModifiers() {
        // Given
        float baseValue = 5f;
        CombatValueModifier modifier = new SimpleCombatValueModifier(CombatValueModifierType.PERCENT, 0.1f, mockSource);
        List<CombatValueModifier> modifiers = Lists.newArrayList(modifier);

        LazyCombatValue lazyCombatValue = new LazyCombatValue(baseValue, modifiers, mockSource);
        float expectedValue = 5.5f;

        // When
        float modifiedValue = lazyCombatValue.computeModifiedValue();

        // Then
        Assert.assertEquals(expectedValue, modifiedValue, DELTA);
    }

    @Test
    public void computeModifiedValue_shouldCorrectlyAddFlatModifiers() {
        // Given
        float baseValue = 5f;
        CombatValueModifier modifier = new SimpleCombatValueModifier(CombatValueModifierType.FLAT, 0.1f, mockSource);
        List<CombatValueModifier> modifiers = Lists.newArrayList(modifier);

        LazyCombatValue lazyCombatValue = new LazyCombatValue(baseValue, modifiers, mockSource);
        float expectedValue = 5.1f;

        // When
        float modifiedValue = lazyCombatValue.computeModifiedValue();

        // Then
        Assert.assertEquals(expectedValue, modifiedValue, DELTA);
    }

    @Test
    public void computeModifiedValue_shouldCorrectlyAddPercentBeforeFlatModifiers() {
        // Given
        float baseValue = 5f;
        CombatValueModifier flatModifier =
                new SimpleCombatValueModifier(CombatValueModifierType.FLAT, 1, mockSource);
        CombatValueModifier percentModifier =
                new SimpleCombatValueModifier(CombatValueModifierType.PERCENT, 0.1f, mockSource);
        List<CombatValueModifier> modifiers = Lists.newArrayList(flatModifier, percentModifier);

        LazyCombatValue lazyCombatValue = new LazyCombatValue(baseValue, modifiers, mockSource);
        float expectedValue = 6.5f;

        // When
        float modifiedValue = lazyCombatValue.computeModifiedValue();

        // Then
        Assert.assertEquals(expectedValue, modifiedValue, DELTA);
    }

    @Test
    public void computeModifiedValue_shouldOverrideAboveAllOtherModifiers() {
        // Given
        float baseValue = 5f;
        CombatValueModifier overrideModifier =
                new SimpleCombatValueModifier(CombatValueModifierType.OVERRIDE, 2, mockSource);
        CombatValueModifier flatModifier =
                new SimpleCombatValueModifier(CombatValueModifierType.FLAT, 1, mockSource);
        CombatValueModifier percentModifier =
                new SimpleCombatValueModifier(CombatValueModifierType.PERCENT, 0.1f, mockSource);
        List<CombatValueModifier> modifiers = Lists.newArrayList(overrideModifier, flatModifier, percentModifier);

        LazyCombatValue lazyCombatValue = new LazyCombatValue(baseValue, modifiers, mockSource);
        float expectedValue = 2;

        // When
        float modifiedValue = lazyCombatValue.computeModifiedValue();

        // Then
        Assert.assertEquals(expectedValue, modifiedValue, DELTA);
    }
}
