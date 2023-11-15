package org.lins.mmmjjkx.nexgem.gem.gems.special;

import net.kyori.adventure.text.Component;
import org.lins.mmmjjkx.nexgem.NexGem;
import org.lins.mmmjjkx.nexgem.objects.NGem;

import java.util.List;

public class UselessGem extends NGem {
    @Override
    public Component name() {
        return NexGem.INSTANCE.getMessageHandler().getColored(null, "Gem.Name.Useless");
    }

    @Override
    public String key() {
        return "USELESS";
    }

    @Override
    public String headLink() {
        //Onyx in minecraft-heads
        return "http://textures.minecraft.net/texture/f5db564300f9cd66785200799bef89894dc3c36b972722b782cda7d9c928b191";
    }

    @Override
    public List<Component> lore() {
        return NexGem.INSTANCE.getMessageHandler().getColoredMessages(null, "Gem.Lore.Useless");
    }

    @Override
    public int maxLevel() {
        return 1;
    }
}
