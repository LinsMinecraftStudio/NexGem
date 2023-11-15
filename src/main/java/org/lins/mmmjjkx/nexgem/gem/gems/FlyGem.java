package org.lins.mmmjjkx.nexgem.gem.gems;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.lins.mmmjjkx.nexgem.NexGem;
import org.lins.mmmjjkx.nexgem.objects.subtypes.AttributeGem;

import java.util.List;

public class FlyGem extends AttributeGem {
    @Override
    public Component name() {
        return NexGem.INSTANCE.getMessageHandler().getColored(null, "Gem.Name.Flying");
    }

    @Override
    public String key() {
        return "FLYING_GEM";
    }

    @Override
    public String headLink() {
        return BLUE_MATERIA;
    }

    @Override
    public List<Component> lore() {
        return NexGem.INSTANCE.getMessageHandler().getColoredMessages(null, "Gem.Lore.Flying");
    }

    @Override
    public int maxLevel() {
        return 1;
    }

    @Override
    public void apply(Player p) {
        storeSelf(p);
        p.setAllowFlight(true);
    }

    @Override
    public void remove(Player p) {
        removeSelf(p);
        p.setAllowFlight(false);
    }
}
