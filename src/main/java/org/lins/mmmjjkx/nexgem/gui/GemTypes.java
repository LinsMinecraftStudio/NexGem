package org.lins.mmmjjkx.nexgem.gui;

import io.github.linsminecraftstudio.polymer.gui.MultiPageInventoryHandler;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.lins.mmmjjkx.nexgem.objects.NGem;

import java.util.List;

public class GemTypes extends MultiPageInventoryHandler<NGem> {
    public GemTypes(List<NGem> data) {
        super(data);
    }

    @Override
    public Component title(Player p) {
        return null;
    }

    @Override
    public Component search(Player p) {
        return null;
    }

    @Override
    public void buttonHandle(Player p, int slot, NGem data) {

    }

    @Override
    public ItemStack getItemStackButton(Player p, int slot, NGem data) {
        return null;
    }

    @Override
    public String toSearchableText(NGem data) {
        return null;
    }
}
