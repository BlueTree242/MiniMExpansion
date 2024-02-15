package dev.bluetree242.minim;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mockStatic;

@ExtendWith(MockitoExtension.class)
public class MiniMExpansionTest {
    private final Player player;
    private final MiniMExpansion expansion = new MiniMExpansion();

    private MiniMExpansionTest(@Mock Player player) {
        this.player = player;
    }

    @Test
    public void colorsTest() {
        test("&c&lTest", "<bold><red>Test", false);
    }

    @Test
    public void resetTest() {
        test("&r", "<reset>", false);
    }

    @Test
    public void sectionColorsTest() {
        test("§c§lTest", "<bold><red>Test", true);
    }

    @Test
    public void resetSectionTest() {
        test("§r", "<reset>", true);
    }

    private void test(String request, String expected, boolean section) {
        try (MockedStatic<PlaceholderAPI> mockedStatic = mockStatic(PlaceholderAPI.class)) {
            String placeholder = "%vault_prefix%";
            String placeholderExact = "vault_prefix";
            mockedStatic.when(() -> PlaceholderAPI.setPlaceholders((OfflinePlayer) any(), eq(placeholder))).thenReturn(request);
            String result = expansion.onPlaceholderRequest(player, (section ? "section_" : "")  + placeholderExact);
            assertEquals(result, expected);
        }
    }
}
