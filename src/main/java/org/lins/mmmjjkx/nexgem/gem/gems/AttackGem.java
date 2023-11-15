package org.lins.mmmjjkx.nexgem.gem.gems;

import net.kyori.adventure.text.Component;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.lins.mmmjjkx.nexgem.NexGem;
import org.lins.mmmjjkx.nexgem.objects.subtypes.EquipmentGem;
import org.lins.mmmjjkx.nexgem.objects.MaterialTags;

import java.util.List;

public class AttackGem extends EquipmentGem {

    @Override
    public Component name() {
        return NexGem.INSTANCE.getMessageHandler().getColored(null, "Gem.Name.AttackGem");
    }

    @Override
    public String key() {
        return "ATTACK_GEM";
    }

    @Override
    public String headLink() {
        return RED_MATERIA;
    }


    public List<Component> lore() {
        return NexGem.INSTANCE.getMessageHandler().getColoredMessages(null, "Gem.Lore.AttackGem");
    }

    @Override
    public MaterialTags allowMaterials() {
        return MaterialTags.SWORD;
    }

    @Override
    public int maxLevel() {
        return getGemConfiguration().getInt("Gem.AttackGem.MaxLevel");
    }


    public void doUse(ItemStack itemStack, Event e, int level) {
        if (e instanceof EntityDamageByEntityEvent event) {
            double damage = event.getDamage();
            double multiplier = getGemConfiguration().getDouble("Gem.AttackGem.Multiplier");
            event.setDamage(damage + (level * multiplier));
        }
    }
}
