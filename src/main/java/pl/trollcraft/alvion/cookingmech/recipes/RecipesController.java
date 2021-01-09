package pl.trollcraft.alvion.cookingmech.recipes;

import org.bukkit.inventory.ItemStack;
import pl.trollcraft.alvion.cookingmech.Storage;

import java.util.Arrays;

public class RecipesController {

    public Recipe find(String name) {
        for (Recipe recipe : Storage.basicRecipes) {
            if (recipe.getName().equals(name)) {
                return recipe;
            }
        }
        return null;
    }
    public Recipe find(ItemStack[] main) {
        for (Recipe recipe : Storage.basicRecipes) {
            if (Arrays.equals(recipe.getMainIngredients(), main)) {
                return recipe;
            }
        }
        return null;
    }
    public Recipe find(ItemStack[] main, ItemStack[] opt) {
        for (Recipe recipe : Storage.basicRecipes) {
            if (Arrays.equals(recipe.getMainIngredients(), main) && Arrays.equals(recipe.getOptionalIngredients(), opt)) {
                return recipe;
            }
        }
        return null;
    }
}
