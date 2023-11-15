package org.lins.mmmjjkx.nexgem.gem.gems.special;

import com.google.common.base.Preconditions;
import io.github.linsminecraftstudio.polymer.objects.array.ObjectArray;
import net.kyori.adventure.text.Component;
import org.lins.mmmjjkx.nexgem.NexGem;
import org.lins.mmmjjkx.nexgem.objects.NGem;

import java.util.List;

public class ErrorGem extends NGem {
    private final String errorGem;

    public ErrorGem (String errorGemKey, int level) {
        Preconditions.checkNotNull(NexGem.gemManager.getGem(errorGemKey), "Gem already exist.(Are you kidding me?)");
        Preconditions.checkState(level > 1, "Gem level must be greater than 1");
        this.errorGem = errorGemKey;
    }


    @Override
    public Component name() {
        return NexGem.INSTANCE.getMessageHandler().getColored(null, "Gem.Name.Error");
    }

    @Override
    public String key() {
        return "ERROR_GEM";
    }

    @Override
    public String headLink() {
        return "http://textures.minecraft.net/texture/27548362a24c0fa8453e4d93e68c5969ddbde57bf6666c0319c1ed1e84d89065";
    }

    @Override
    public List<Component> lore() {
        return NexGem.INSTANCE.getMessageHandler().getColoredMessages(null, "Gem.Lore.Error", new ObjectArray(), new ObjectArray(errorGem));
    }

    @Override
    public int maxLevel() {
        return 1;
    }
}
