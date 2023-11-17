package org.lins.mmmjjkx.nexgem.gem;

import com.google.common.base.Preconditions;
import com.google.common.reflect.ClassPath;
import de.tr7zw.changeme.nbtapi.NBTEntity;
import de.tr7zw.changeme.nbtapi.NBTList;
import io.github.linsminecraftstudio.polymer.itemstack.ItemStackBuilder;
import io.github.linsminecraftstudio.polymer.libs.nbtapi.NBTItem;
import io.github.linsminecraftstudio.polymer.utils.OtherUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.lins.mmmjjkx.nexgem.NexGem;
import org.lins.mmmjjkx.nexgem.gem.gems.AttackGem;
import org.lins.mmmjjkx.nexgem.gem.gems.FlyGem;
import org.lins.mmmjjkx.nexgem.gem.gems.special.ErrorGem;
import org.lins.mmmjjkx.nexgem.gem.gems.special.UselessGem;
import org.lins.mmmjjkx.nexgem.objects.NGem;
import org.lins.mmmjjkx.nexgem.objects.subtypes.AttributeGem;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GemManager {
    private static final Map<String, NGem> gems = new HashMap<>();

    public GemManager() {
        Preconditions.checkState(!OtherUtils.findCallingPlugin().equals(NexGem.INSTANCE),
                "GemManager should be constructed by NexGem");
        setup();
    }

    @SuppressWarnings("deprecation")
    void setup() {
        try {
            List<? extends Class<?>> classes = ClassPath.from(ClassLoader.getSystemClassLoader())
                    .getAllClasses()
                    .stream()
                    .filter(clazz -> clazz.getPackageName()
                            .equalsIgnoreCase("org.lins.mmmjjkx.nexgem.gem.gems"))
                    .map(ClassPath.ClassInfo::load)
                    .toList();

            for (Class<?> clazz : classes) {
                if (clazz.getSuperclass() == NGem.class) {
                    NGem gem = (NGem) clazz.newInstance();
                    gems.put(gem.key(), gem);
                }
            }
        } catch (IOException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        gems.put(new UselessGem().key(), new UselessGem());
        gems.put(new AttackGem().key(), new AttackGem());
        gems.put(new FlyGem().key(), new FlyGem());
    }

    /**
     * Get gem by key.<br>
     * If you just want to check the gem has registered, please use {@link #hasRegistered(String)}.
     * @param key the key of gem
     * @return the gem (if it's null, it will return a new {@link ErrorGem})
     */
    @NotNull
    public static NGem getGem(String key) {
        return gems.get(key.toUpperCase()) == null ? new ErrorGem(key,1) : gems.get(key.toUpperCase());
    }

    /**
     * Check the gem has registered
     * @param key the key of gem
     * @return the gem has registered or not
     */
    public static boolean hasRegistered(String key) {
        return gems.containsKey(key.toUpperCase());
    }

    /**
     * Register your gems
     * @param gem the gem
     * @throws IllegalStateException if the gem is already registered
     */
    public static void register(NGem gem) {
        if (gems.containsKey(gem.key())) {
            throw new IllegalStateException("Gem with key " + gem.key() + " is already registered");
        }
        gems.put(gem.key(), gem);
    }

    public static boolean attributeGemExists(Player p, AttributeGem gem) {
        NBTEntity entity = new NBTEntity(p);
        NBTList<String> strings = entity.getStringList("NexAttributeGems");
        return strings.contains(gem.toString());
    }

    /**
     * Create an item stack of the gem
     * @param key the key of gem
     * @param amount the amount of gem
     * @return the item stack of gem (THE GEM CAN BE ERROR_GEM)
     */
    public static ItemStack createItemStack(String key, int amount, int level) {
        NGem gem = getGem(key);
        gem.setLevel(level);
        ItemStack stack = new ItemStackBuilder(Material.PLAYER_HEAD, amount).head(gem.headLink()).name(gem.name()).lore(gem.lore()).build();
        NBTItem item = new NBTItem(stack);
        item.setBoolean("FromNexGem", true);
        item.setString("NexGemKey", gem.key());
        item.setInteger("NexGemLevel", gem.level());
        return item.getItem();
    }
}
