package gg.warcraft.monolith.app.command.service;

import gg.warcraft.monolith.api.command.Command;
import gg.warcraft.monolith.api.command.CommandHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static gg.warcraft.monolith.app.command.CommandTestUtils.randomAliases;
import static gg.warcraft.monolith.app.command.CommandTestUtils.randomName;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultCommandRepositoryTest {
    private DefaultCommandRepository defaultCommandRepository;

    @Mock private Command mockCommand;
    @Mock private CommandHandler mockCommandHandler;

    @Before
    public void beforeEach() {
        defaultCommandRepository = new DefaultCommandRepository();
    }

    @After
    public void afterEach() {
        reset(mockCommand, mockCommandHandler);
    }

    @Test
    public void save_shouldPutCommandInMap() {
        // Given
        String name = randomName();
        List<String> aliases = randomAliases();

        when(mockCommand.getName()).thenReturn(name);
        when(mockCommand.getAliases()).thenReturn(aliases);
        when(mockCommand.getHandler()).thenReturn(mockCommandHandler);

        // When
        defaultCommandRepository.save(mockCommand);

        // Then
        assertEquals(mockCommand, defaultCommandRepository.commands.get(name));
        aliases.forEach(alias -> assertEquals(mockCommand, defaultCommandRepository.commands.get(alias)));
    }

    @Test
    public void save_shouldSilentlyIgnoreNull() {
        // Given
        String name = randomName();
        List<String> aliases = randomAliases();
        aliases.add(null);

        when(mockCommand.getName()).thenReturn(name);
        when(mockCommand.getAliases()).thenReturn(aliases);
        when(mockCommand.getHandler()).thenReturn(mockCommandHandler);

        // When
        defaultCommandRepository.save(mockCommand);

        // Then
        assertEquals(mockCommand, defaultCommandRepository.commands.get(name));
        assertFalse(defaultCommandRepository.commands.containsKey(null));
    }

    @Test
    public void save_shouldSilentlyIgnoreEmpty() {
        // Given
        String name = "";
        List<String> aliases = randomAliases();

        when(mockCommand.getName()).thenReturn(name);
        when(mockCommand.getAliases()).thenReturn(aliases);
        when(mockCommand.getHandler()).thenReturn(mockCommandHandler);

        // When
        defaultCommandRepository.save(mockCommand);

        // Then
        assertFalse(defaultCommandRepository.commands.containsKey(""));
        aliases.forEach(alias -> assertEquals(mockCommand, defaultCommandRepository.commands.get(alias)));
    }
}
