package pl.trollcraft.alvion.cookingmech;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class Config {

    public static YamlConfiguration load(String configName, Plugin plugin){
        YamlConfiguration config;
        File file = new File(plugin.getDataFolder() + File.separator + configName);
        if (!file.exists())
            plugin.saveResource(configName, false);
        config = new YamlConfiguration();
        try {
            config.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
            return null;
        }
        return config;
    }

    public static void save(YamlConfiguration c, String name) {
        try {
            c.save(new File(CookingMinigame.getInstance().getDataFolder(), name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static YamlConfiguration reload(YamlConfiguration config) {
        try {
            config.load(config.getName());
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
            return null;
        }
        return config;
    }

}
