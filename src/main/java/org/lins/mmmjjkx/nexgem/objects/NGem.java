package org.lins.mmmjjkx.nexgem.objects;

import io.github.linsminecraftstudio.polymer.utils.FileUtil;
import net.kyori.adventure.text.Component;
import org.bukkit.configuration.file.YamlConfiguration;
import org.lins.mmmjjkx.nexgem.NexGem;

import java.io.File;
import java.util.List;


public abstract class NGem {
    private int level;

    public static String BLUE_MATERIA = "http://textures.minecraft.net/texture/9115dc88e3214c38243d782d63edb0a6e06291eb6da8e600c7e2ea36e7f61b31";
    public static String GREEN_MATERIA = "http://textures.minecraft.net/texture/f757cfc7c11b1e6f1028b80462d1e4302dca5ab8592225ea8c8b7639c70e61f9";
    public static String PURPLE_MATERIA = "http://textures.minecraft.net/texture/db6975af70724d6a44fd5946e60b2717737dfdb545b4dab1893351a9c9dd183c";
    public static String RED_MATERIA = "http://textures.minecraft.net/texture/2b055c810bddfd16264ec8d439c43283e35bca71a50983e15e364cd8ab7c668f";
    public static String YELLOW_MATERIA = "http://textures.minecraft.net/texture/520716203da039cafca24bbd9f3e9bd5c6985c3c25527bcd506d388e99bb7afe";

    public NGem() {
        level = 1;
    }

    public NGem(int level) {
        setLevel(level);
    }

    public abstract Component name();
    public abstract String key();
    public abstract String headLink();
    public abstract List<Component> lore();

    public int level() {
        return level;
    }

    public void setLevel(int level) {
        if (level > maxLevel()) {
            this.level = maxLevel();
            return;
        }
        this.level = level;
    }

    /**
     * Set gem's max level.
     * Don't set it to zero or lower.
     * @return max level
     */
    public abstract int maxLevel();

    protected YamlConfiguration getGemConfiguration() {
        FileUtil.completeFile(NexGem.INSTANCE, "gems.yml");
        return YamlConfiguration.loadConfiguration(new File(NexGem.INSTANCE.getDataFolder(), "gems.yml"));
    }

    @Override
    public String toString() {
        return "NexGem/;*LVL:" + level + ";KEY:" + this.key();
    }
}
