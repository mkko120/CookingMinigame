package pl.trollcraft.alvion.cookingmech;

import org.bukkit.plugin.java.JavaPlugin;
import pl.trollcraft.alvion.cookingmech.commands.CookingCommand;
import pl.trollcraft.alvion.cookingmech.recipes.RecipesController;
import pl.trollcraft.alvion.cookingmech.recipes.flames.FlameTypeController;

import java.io.File;

public final class CookingMinigame extends JavaPlugin {


    private static RecipesController recipesController;
    private static FlameTypeController flameController;
    private static CookingMinigame instance;

    public static CookingMinigame getInstance() {
        return instance;
    }


    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        recipesController = new RecipesController();
        flameController = new FlameTypeController();
        getCommand("cook").setExecutor(new CookingCommand());
        Storage.load();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Config.save(Storage.recipes, "recipes.yml");
    }
    public static RecipesController getRecipesController() {
        return recipesController;
    }
    public static FlameTypeController getFlameController() {
        return flameController;
    }

}
