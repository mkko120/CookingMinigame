package pl.trollcraft.alvion.cookingmech;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import pl.trollcraft.alvion.cookingmech.recipes.Recipe;
import pl.trollcraft.alvion.cookingmech.recipes.flames.FlameType;
import pl.trollcraft.alvion.cookingmech.recipes.flames.flametypes.DefaultFlameTypes;
import pl.trollcraft.alvion.cookingmech.recipes.templates.BreadTemplate;

import java.util.ArrayList;
import java.util.HashMap;

public class Storage {

    public static ArrayList<Recipe> basicRecipes;
    public static ArrayList<FlameType> flameTypes;
    public static HashMap<Player, FlameType> activeFlame;
    public static YamlConfiguration recipes;

    public static void load() {
        basicRecipes = new ArrayList<>();
        BreadTemplate.load();
        flameTypes = new ArrayList<>();
        DefaultFlameTypes.load();
        activeFlame = new HashMap<>();
        recipes = Config.load("recipes.yml", CookingMinigame.getPlugin(CookingMinigame.class));
    }
}
