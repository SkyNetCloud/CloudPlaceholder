package ca.skynetcloud.cloudplaceholder;

import ca.skynetcloud.cloudplaceholder.commands.HelpCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkyPlaceholders extends JavaPlugin {

    public void onEnable() {
        this.getCommand("cloudhelp").setExecutor(new HelpCommand());

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            System.out.println("PlaceholderAPI not found, disabling CloudPlaceholder.");
            this.getServer().getPluginManager().disablePlugin((Plugin)this);
        }
        else {
            new SkyExpansion().register();
        }
    }
}
