package pl.trollcraft.alvion.cookingmech;

import org.bukkit.plugin.java.JavaPlugin;
import pl.trollcraft.alvion.cookingmech.commands.CookingCommand;
import pl.trollcraft.alvion.cookingmech.recipes.RecipesController;
import pl.trollcraft.alvion.cookingmech.recipes.flames.FlameTypeController;

public final class CookingMinigame extends JavaPlugin {


    private static RecipesController recipesController;
    private static FlameTypeController flameController;


    @Override
    public void onEnable() {
        // Plugin startup logic
        recipesController = new RecipesController();
        flameController = new FlameTypeController();
        getCommand("cook").setExecutor(new CookingCommand());
        Storage.load();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static RecipesController getRecipesController() {
        return recipesController;
    }
    public static FlameTypeController getFlameController() {
        return flameController;
    }
}
