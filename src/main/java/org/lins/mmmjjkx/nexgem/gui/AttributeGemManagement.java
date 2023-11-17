package org.lins.mmmjjkx.nexgem.gui;

import io.github.linsminecraftstudio.polymer.gui.InventoryActionType;
import io.github.linsminecraftstudio.polymer.gui.SimpleInventoryHandler;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.lins.mmmjjkx.nexgem.NexGem;

public class AttributeGemManagement extends SimpleInventoryHandler {
    @Override
    public void placeButtons(Player p, Inventory inv) {

    }

    @Override
    public Component title(Player p) {
        return NexGem.INSTANCE.getMessageHandler().getColored(p, "GUI.AttributeGemManagementTitle");
    }

    @Override
    public void doListen(InventoryActionType type, Player p, int slot, Inventory inventory) {

    }
}
