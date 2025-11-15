package dev.akatriggered;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        logEnable();
    }

    @Override
    public void onDisable() {
        logDisable();
    }

    @EventHandler
    public void onTNTPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType() == Material.TNT) {
            TNTPrimed tnt = (TNTPrimed) event.getBlock().getWorld().spawnEntity(
                event.getBlock().getLocation().add(0.5, 0, 0.5), EntityType.PRIMED_TNT);
            event.getBlock().setType(Material.AIR);
            tnt.setFuseTicks(20);
        }
    }

    @EventHandler
    public void onCreeperSpawn(CreatureSpawnEvent event) {
        if (event.getEntity() instanceof Creeper && event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER_EGG) {
            Creeper creeper = (Creeper) event.getEntity();
            creeper.setPowered(true);
            creeper.ignite();
        }
    }

    private void logEnable() {
        String[] lines = {
            "§f╔══════════════════════════════════════════════════════════════╗",
            "§f║                                                              ║",
            "§f║  §b ██████╗ ██╗ █████╗ ██╗  ██╗    ████████╗███╗   ██╗████████╗ §f║",
            "§f║  §b██╔════╝███║██╔══██╗╚██╗██╔╝    ╚══██╔══╝████╗  ██║╚══██╔══╝ §f║",
            "§f║  §b██║  ███╗╚██║███████║ ╚███╔╝        ██║   ██╔██╗ ██║   ██║    §f║",
            "§f║  §b██║   ██║ ██║██╔══██║ ██╔██╗        ██║   ██║╚██╗██║   ██║    §f║",
            "§f║  §b╚██████╔╝ ██║██║  ██║██╔╝ ██╗       ██║   ██║ ╚████║   ██║    §f║",
            "§f║  §b ╚═════╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝       ╚═╝   ╚═╝  ╚═══╝   ╚═╝    §f║",
            "§f║                                                              ║",
            "§f║                    §ePRACTICE TNT ADDON                      §f║",
            "§f║                                                              ║",
            "§f╠══════════════════════════════════════════════════════════════╣",
            "§f║  §aVersion: §f1.0.0                §aAuthor: §fg1ax/AkaTriggered  §f║",
            "§f║  §aGitHub: §fgithub.com/AkaTriggered/G1axPracticeTNT           §f║",
            "§f╠══════════════════════════════════════════════════════════════╣",
            "§f║                        §eFEATURES                            §f║",
            "§f║  §a✓ §fInstant TNT Explosions                                §f║",
            "§f║  §a✓ §fFast Creeper Fuse (1 Second)                         §f║",
            "§f║  §a✓ §fOptimized for PvP Practice                           §f║",
            "§f╠══════════════════════════════════════════════════════════════╣",
            "§f║                   §aSuccessfully Loaded!                    §f║",
            "§f╚══════════════════════════════════════════════════════════════╝"
        };

        getLogger().info(" ");
        for (String line : lines) {
            getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('§', line));
        }
        getLogger().info(" ");
    }

    private void logDisable() {
        String[] lines = {
            "§f╔══════════════════════════════════════════════════════════════╗",
            "§f║                                                              ║",
            "§f║                    §cG1AX PRACTICE TNT                       §f║",
            "§f║                                                              ║",
            "§f║                   §cShutting down safely...                 §f║",
            "§f║                                                              ║",
            "§f║              §fThanks for using our plugin!                 §f║",
            "§f║                                                              ║",
            "§f╚══════════════════════════════════════════════════════════════╝"
        };

        getLogger().info(" ");
        for (String line : lines) {
            getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('§', line));
        }
        getLogger().info(" ");
    }
}
