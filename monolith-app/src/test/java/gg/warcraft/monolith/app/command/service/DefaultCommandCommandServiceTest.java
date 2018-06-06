package gg.warcraft.monolith.app.command.service;

import gg.warcraft.monolith.api.command.Command;
import gg.warcraft.monolith.api.command.CommandHandler;
import gg.warcraft.monolith.api.command.service.CommandQueryService;
import gg.warcraft.monolith.api.command.service.CommandRepository;
import gg.warcraft.monolith.api.command.service.CommandServerAdapter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static gg.warcraft.monolith.app.command.CommandTestUtils.randomAliases;
import static gg.warcraft.monolith.app.command.CommandTestUtils.randomArgument;
import static gg.warcraft.monolith.app.command.CommandTestUtils.randomName;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultCommandCommandServiceTest {
    private DefaultCommandCommandService defaultCommandCommandService;

    @Mock private CommandQueryService mockCommandQueryService;
    @Mock private CommandRepository mockCommandRepository;
    @Mock private CommandServerAdapter mockCommandServerAdapter;
    @Mock private Command mockCommand;
    @Mock private CommandHandler mockCommandHandler;

    @Before
    public void beforeEach() {
        defaultCommandCommandService = new DefaultCommandCommandService(mockCommandQueryService, mockCommandRepository,
                mockCommandServerAdapter);
    }

    @After
    public void afterEach() {
        reset(mockCommandQueryService, mockCommandRepository, mockCommandServerAdapter, mockCommand,
                mockCommandHandler);
    }

    @Test
    public void createCommand_shouldRegisterAndSave() {
        // Given
        var name = randomName();
        var aliases = randomAliases();

        when(mockCommandQueryService.getCommand(name)).thenReturn(null);
        when(mockCommandServerAdapter.isCommandAvailable(name)).thenReturn(true);
        aliases.forEach(alias -> when(mockCommandQueryService.getCommand(alias)).thenReturn(null));
        aliases.forEach(alias -> when(mockCommandServerAdapter.isCommandAvailable(alias)).thenReturn(true));

        // When
        defaultCommandCommandService.createCommand(name, aliases, mockCommandHandler);

        // Then
        verify(mockCommandServerAdapter).registerCommand(any());
        verify(mockCommandRepository).save(any());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createCommand_shouldThrowOnNullName() {
        // Given
        var aliases = randomAliases();

        // When
        defaultCommandCommandService.createCommand(null, aliases, mockCommandHandler);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createCommand_shouldThrowOnEmptyName() {
        // Given
        var name = "";
        var aliases = randomAliases();

        // When
        defaultCommandCommandService.createCommand(name, aliases, mockCommandHandler);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createCommand_shouldThrowOnUnavailableName() {
        // Given
        var name = randomName();
        var aliases = randomAliases();

        when(mockCommandQueryService.getCommand(name)).thenReturn(mockCommand);

        // When
        defaultCommandCommandService.createCommand(name, aliases, mockCommandHandler);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createCommand_shouldThrowOnUnavailableNameCommand() {
        // Given
        var name = randomName();
        var aliases = randomAliases();

        when(mockCommandQueryService.getCommand(name)).thenReturn(null);
        when(mockCommandServerAdapter.isCommandAvailable(name)).thenReturn(false);

        // When
        defaultCommandCommandService.createCommand(name, aliases, mockCommandHandler);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createCommand_shouldThrowOnNullAlias() {
        // Given
        var name = randomName();
        var aliases = randomAliases();
        aliases.add(null);

        // When
        defaultCommandCommandService.createCommand(name, aliases, mockCommandHandler);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createCommand_shouldThrowOnUnavailableAlias() {
        // Given
        var name = randomName();
        var aliases = randomAliases();

        when(mockCommandQueryService.getCommand(name)).thenReturn(null);
        when(mockCommandServerAdapter.isCommandAvailable(name)).thenReturn(true);
        when(mockCommandQueryService.getCommand(aliases.get(0))).thenReturn(mockCommand);

        // When
        defaultCommandCommandService.createCommand(name, aliases, mockCommandHandler);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createCommand_shouldThrowOnUnavailableAliasCommand() {
        // Given
        var name = randomName();
        var aliases = randomAliases();

        when(mockCommandQueryService.getCommand(name)).thenReturn(null);
        when(mockCommandServerAdapter.isCommandAvailable(name)).thenReturn(true);
        when(mockCommandQueryService.getCommand(aliases.get(0))).thenReturn(null);
        when(mockCommandServerAdapter.isCommandAvailable(aliases.get(0))).thenReturn(false);

        // When
        defaultCommandCommandService.createCommand(name, aliases, mockCommandHandler);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createCommand_shouldThrowOnNullHandler() {
        // Given
        var name = randomName();
        var aliases = randomAliases();

        // When
        defaultCommandCommandService.createCommand(name, aliases, null);
    }

    @Test
    public void formatCommand_shouldJoinArguments() {
        // Given
        var name = randomName();
        var argument1 = randomArgument();
        var argument2 = randomArgument();

        when(mockCommand.getName()).thenReturn(name);

        // When
        String formattedCommand = defaultCommandCommandService.formatCommand(mockCommand, argument1, argument2);

        // Then
        assertEquals(name + " " + argument1 + " " + argument2, formattedCommand);
    }
}
