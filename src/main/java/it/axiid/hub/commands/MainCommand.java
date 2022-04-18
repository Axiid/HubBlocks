package it.axiid.hub.commands;

import it.axiid.hub.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {
                p.sendMessage("§7Running §cHubBlocks §7by §c@imaxiid");
                p.sendMessage("§e/blocks reload");
            }else if(args.length == 1) {
                if(args[0].equalsIgnoreCase("reload")) {
                    if(p.hasPermission("blocks.reload") || p.hasPermission("blocks.*")) {
                        Main.getInstance().reloadConfig();
                        Main.getInstance().saveConfig();
                        p.sendMessage("§aConfigurazioni ricaricate correttamente.");
                    }else {
                        p.sendMessage("§7Non hai il §cpermesso§7!");
                    }
                }else {
                    p.sendMessage("§7Running §cHubBlocks §7by §c@imaxiid");
                    p.sendMessage("§e/blocks reload");
                }
            }else {
                p.sendMessage("§cArgomento del comando non trovato.");
            }

        }else {
            Main.getInstance().reloadConfig();
            Main.getInstance().saveConfig();
            sender.sendMessage("Configurazioni ricaricate.");
        }
        return true;
    }
}
