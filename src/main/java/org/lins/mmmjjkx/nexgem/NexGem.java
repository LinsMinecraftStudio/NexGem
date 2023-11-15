package org.lins.mmmjjkx.nexgem;

import io.github.linsminecraftstudio.polymer.command.PolymerCommand;
import io.github.linsminecraftstudio.polymer.objects.plugin.PolymerPlugin;
import org.lins.mmmjjkx.nexgem.gem.GemManager;

import java.util.List;

public final class NexGem extends PolymerPlugin {
    public static NexGem INSTANCE;
    public static GemManager gemManager;

    @Override
    public void onPlEnable() {
        INSTANCE = this;
        gemManager = new GemManager();
    }

    @Override
    public void onPlDisable() {

    }

    @Override
    public List<PolymerCommand> registerCommands() {
        return null;
    }

    @Override
    public String requireVersion() {
        return "1.4.0";
    }

    @Override
    public int requireApiVersion() {
        return 2;
    }
}