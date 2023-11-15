package org.lins.mmmjjkx.nexgem.objects.subtypes;

import de.tr7zw.changeme.nbtapi.NBTEntity;
import de.tr7zw.changeme.nbtapi.NBTList;
import org.bukkit.entity.Player;
import org.lins.mmmjjkx.nexgem.objects.NGem;

public abstract class AttributeGem extends NGem {
    public abstract void apply(Player p);

    public abstract void remove(Player p);

    protected void storeSelf(Player p) {
        NBTEntity entity = new NBTEntity(p);
        NBTList<String> strings = entity.getStringList("NexAttributeGems");
        strings.add(super.toString());
    }

    protected void removeSelf(Player p) {
        NBTEntity entity = new NBTEntity(p);
        NBTList<String> strings = entity.getStringList("NexAttributeGems");
        strings.remove(super.toString());
    }
}
