package org.lins.mmmjjkx.nexgem.objects;

import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ArmorMeta;

import java.util.function.Function;

public enum MaterialTags {
    @SuppressWarnings("unused")
    ARMOR((m) -> {
        ItemStack test = new ItemStack(m);
        try {
            var meta = (ArmorMeta) test.getItemMeta();
            return true;
        } catch (Exception e) {
            return false;
        }
    }),

    SWORD(Tag.ITEMS_SWORDS::isTagged);

    private final Function<Material, Boolean> function;

    MaterialTags(Function<Material, Boolean> checkAllow) {
        this.function = checkAllow;
    }

    public boolean checkAllow(Material material) {
        return function.apply(material);
    }
}
