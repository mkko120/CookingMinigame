package pl.trollcraft.alvion.cookingmech.recipes;

import org.bukkit.inventory.ItemStack;

import pl.trollcraft.alvion.cookingmech.recipes.flames.FlameTime;
import pl.trollcraft.alvion.cookingmech.recipes.flames.FlameType;

import java.util.HashMap;

public class Recipe {

    /**
     * Recipe system for cooking GUI
     * @author mkko120
     */

    private String name;
    private HashMap<FlameType, FlameTime> flameTimes;
    private ItemStack[] main;
    private ItemStack[] optional;
    private ItemStack result;

    /**
     * First version of recipe, without any optional ingredients
     * @param name name of recipe
     * @param flameTimes hashmap of how much recipe must be in "oven" with specified Flame to be done
     * @param main ingredients for recipe
     * @param result result from all of the ingredients from the Recipe
     */

    public Recipe(String name, HashMap<FlameType, FlameTime> flameTimes, ItemStack[] main, ItemStack result) {
        this.name = name;
        this.flameTimes = flameTimes;
        this.main = main;
        this.result = result;
    }

    /**
     * Second version of recipe, with optional ingredients
     * @param name name of recipe.
     * @param flameTimes hashmap of how much recipe must be in "oven" with specified Flame to be done.
     * @param main ingredients for recipe.
     * @param optional optional ingredients for recipe.
     * @param result result from all of the ingredients from the Recipe
     */

    public Recipe(String name, HashMap<FlameType, FlameTime> flameTimes, ItemStack[] main, ItemStack[] optional, ItemStack result) {
        this.name = name;
        this.flameTimes = flameTimes;
        this.main = main;
        this.optional = optional;
        this.result = result;
    }

/*
    Getters and setters for Recipes listed above.
*/


    public ItemStack[] getMainIngredients() {
        return this.main;
    }

    public void setMainIngredients(ItemStack[] main) {
        this.main = main;
    }

    public ItemStack[] getOptionalIngredients() {
        return optional;
    }

    public void setOptionalIngredients(ItemStack[] optional) {
        this.optional = optional;
    }

    public HashMap<FlameType, FlameTime> getFlameTimes() {
        return flameTimes;
    }

    public void setFlameTimes(HashMap<FlameType, FlameTime> flameTimes) {
        this.flameTimes = flameTimes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemStack getResult() {
        return result;
    }

    public void setResult(ItemStack result) {
        this.result = result;
    }
}
