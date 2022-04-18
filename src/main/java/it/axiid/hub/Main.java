package it.axiid.hub;

import it.axiid.hub.commands.MainCommand;
import it.axiid.hub.listeners.PlaceEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        saveDefaultConfig();

        getCommand("blocks").setExecutor(new MainCommand());
        Bukkit.getPluginManager().registerEvents(new PlaceEvent(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
