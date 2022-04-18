package it.axiid.hub.listeners;

import it.axiid.hub.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class PlaceEvent implements Listener
{

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {

        FileConfiguration config = Main.getInstance().getConfig();
        Player p = e.getPlayer();
        ItemStack block = new ItemStack(Material.getMaterial(config.getString("block")), 1);

        if(p.hasPermission("blocks.use") || p.hasPermission("blocks.*")) {
            if(e.getBlockPlaced().getType().equals(Material.getMaterial(config.getString("block")))) {

                Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {

                    e.setCancelled(true);

                    if(p.getGameMode() == GameMode.SURVIVAL) {
                        p.getInventory().addItem(block);
                    }

                }, config.getLong("timer"));

            }
        }

    }



}
