package org.lins.mmmjjkx.nexgem.gem;

import com.google.common.base.Preconditions;
import de.tr7zw.changeme.nbtapi.NBTEntity;
import de.tr7zw.changeme.nbtapi.NBTList;
import io.github.linsminecraftstudio.polymer.itemstack.ItemStackBuilder;
import io.github.linsminecraftstudio.polymer.libs.nbtapi.NBTItem;
import io.github.linsminecraftstudio.polymer.utils.OtherUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.lins.mmmjjkx.nexgem.NexGem;
import org.lins.mmmjjkx.nexgem.gem.gems.AttackGem;
import org.lins.mmmjjkx.nexgem.gem.gems.special.UselessGem;
import org.lins.mmmjjkx.nexgem.objects.NGem;
import org.lins.mmmjjkx.nexgem.objects.subtypes.AttributeGem;

import java.util.HashMap;
import java.util.Map;

public class GemManager {
    private final Map<String, NGem> gems = new HashMap<>();

    public static UselessGem USELESS;
    public static AttackGem ATTACK;

    public GemManager() {
        Preconditions.checkState(!OtherUtils.findCallingPlugin().equals(NexGem.INSTANCE),
                "GemManager should be constructed by NexGem");
        setup();
    }

    public void setup() {
        USELESS = new UselessGem();
        ATTACK = new AttackGem();

        gems.put(USELESS.key(), USELESS);
        gems.put(ATTACK.key(), ATTACK);
    }

    public NGem getGem(String key) {
        return gems.get(key);
    }

    public void register(NGem gem) {
        if (gems.containsKey(gem.key())) {
            throw new IllegalStateException("Gem with key " + gem.key() + " is already registered");
        }
        gems.put(gem.key(), gem);
    }

    public boolean attributeGemExists(Player p, AttributeGem gem) {
        NBTEntity entity = new NBTEntity(p);
        NBTList<String> strings = entity.getStringList("NexAttributeGems");
        return strings.contains(gem.toString());
    }

    public static ItemStack createItemStack(NGem gem, int amount) {
        ItemStack stack = new ItemStackBuilder(Material.PLAYER_HEAD, amount).head(gem.headLink()).name(gem.name()).lore(gem.lore()).build();
        NBTItem item = new NBTItem(stack);
        item.setBoolean("FromNexGem", true);
        item.setString("NexGemKey", gem.key());
        item.setInteger("NexGemLevel", gem.level());
        return item.getItem();
    }
}
