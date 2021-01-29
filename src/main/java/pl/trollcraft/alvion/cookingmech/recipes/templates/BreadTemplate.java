package pl.trollcraft.alvion.cookingmech.recipes.templates;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import pl.trollcraft.alvion.cookingmech.CookingMinigame;
import pl.trollcraft.alvion.cookingmech.Storage;
import pl.trollcraft.alvion.cookingmech.recipes.Recipe;
import pl.trollcraft.alvion.cookingmech.recipes.flames.FlameTime;
import pl.trollcraft.alvion.cookingmech.recipes.flames.FlameType;

import java.util.ArrayList;
import java.util.HashMap;

public class BreadTemplate {

    /**
     * Template method for creating base recipes for Cooking GUI.
     */

    public static void load() {
        HashMap<FlameType, FlameTime> times = new HashMap<>();
        times.put(CookingMinigame.getFlameController().find("no flame"), new FlameTime(51,60));
        times.put(CookingMinigame.getFlameController().find("small flame"), new FlameTime(0,51));
        ItemStack[] stacks = new ItemStack[4];
        stacks[0] = new ItemStack(Material.BREAD);
        stacks[1] = new ItemStack(Material.AIR);
        stacks[2] = new ItemStack(Material.AIR);
        stacks[3] = new ItemStack(Material.AIR);
        Storage.basicRecipes.add(new Recipe("bread", times, stacks, new ItemStack(Material.BREAD)));
    }

}
