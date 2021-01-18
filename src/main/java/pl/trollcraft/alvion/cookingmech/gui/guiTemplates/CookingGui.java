package pl.trollcraft.alvion.cookingmech.gui.guiTemplates;

import me.mattstudios.mfgui.gui.components.exception.GuiException;
import me.mattstudios.mfgui.gui.components.util.GuiFiller;

import me.mattstudios.mfgui.gui.guis.Gui;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import pl.trollcraft.alvion.cookingmech.CookingMinigame;
import pl.trollcraft.alvion.cookingmech.Storage;
import pl.trollcraft.alvion.cookingmech.gui.GuiUtils;
import pl.trollcraft.alvion.cookingmech.recipes.Recipe;
import pl.trollcraft.alvion.cookingmech.recipes.flames.FlameTime;
import pl.trollcraft.alvion.cookingmech.Debug;

import java.util.Arrays;

public class CookingGui {


    public static PersistentGui gui = GuiUtils.createPersistentGui(6,"Gotowanie");
    public static Gui flameGui = FlameGui.getFlameGui();
    private static Recipe recipe;
    private static void cookingGui(Player player) {
        GuiFiller filler = new GuiFiller(gui);
        GuiItem fillerMaterial = GuiUtils.convertToGuiItem(Material.GRAY_STAINED_GLASS_PANE);
        gui.setDefaultClickAction(event -> event.setCancelled(true));
        try {
            Debug.log("Setting up filler");
            filler.fillBorder(fillerMaterial);
            filler.fillBetweenPoints(4, 1, 4, 9, fillerMaterial);
            filler.fillBetweenPoints(2, 6, 2, 6, fillerMaterial);
            filler.fillBetweenPoints(3, 6, 3, 6, fillerMaterial);
            filler.fillBetweenPoints(5, 6, 5, 6, fillerMaterial);
            filler.fillBetweenPoints(2, 8, 2, 8, fillerMaterial);
            filler.fillBetweenPoints(3, 8, 3, 8, fillerMaterial);
            filler.fillBetweenPoints(5, 8, 5, 8, fillerMaterial);
            Debug.log("Finished!");
        }catch (GuiException e) {
            e.printStackTrace();
        }

        try {
            GuiItem i15 = GuiUtils.convertToGuiItem(Material.NETHER_STAR, "Start baking");
            i15.setAction(event -> {

                event.setCancelled(true);

                ItemStack[] main = new ItemStack[4];
                int i1 = 0;
                for (int i = 10; i < 13; i++) {
                    ItemStack item = gui.getInventory().getItem(i);
                    if (item != null) {
                        main[i1] = item;
                    } else {
                        main[i1] = new ItemStack(Material.AIR);
                    }
                    i1++;
                }

                Debug.log("Zawartosc main:" + Arrays.toString(main));

                ItemStack[] opt = new ItemStack[4];
                i1 = 0;
                for (int i = 19; i < 22; i++) {
                    ItemStack item = gui.getInventory().getItem(i);
                    if (item != null) {
                        opt[i1] = item;
                    } else {
                        opt[i1] = new ItemStack(Material.AIR);
                    }
                    i1++;
                }

                Debug.log("Zawartosc opt: " + Arrays.toString(opt));

                if (opt[0].equals(new ItemStack(Material.AIR))) {
                    recipe = CookingMinigame.getRecipesController().find(main);
                } else {
                    recipe = CookingMinigame.getRecipesController().find(main, opt);
                }
                Debug.log("Zawartosc recipe: " + recipe);
                FlameTime ft = recipe.getFlameTimes().get(Storage.activeFlame.getOrDefault(player, Storage.flameTypes.get(0)));
                Debug.log("Zawartosc ft: " + ft);
                new BukkitRunnable() {
                    int i = ft.getMax();
                    @Override
                    public void run() {
                        if (i <= 0) {
                            this.cancel();
                        } else {
                            i--;
                        }
                    }
                }.runTaskTimer(CookingMinigame.getPlugin(CookingMinigame.class), 20, 20);
                });
            gui.setItem(15, i15);
            gui.setItem(37, GuiUtils.convertToGuiItem(Material.GRAY_STAINED_GLASS_PANE, "Progress..."));
            gui.setItem(38, GuiUtils.convertToGuiItem(Material.GRAY_STAINED_GLASS_PANE, "Progress..."));
            gui.setItem(39, GuiUtils.convertToGuiItem(Material.GRAY_STAINED_GLASS_PANE, "Progress..."));
            gui.setItem(40, GuiUtils.convertToGuiItem(Material.GRAY_STAINED_GLASS_PANE, "Progress..."));
            GuiItem i42 = GuiUtils.convertToGuiItem(Material.SMOKER, "Plomien");
            i42.setAction(event -> FlameGui.openFlameGui(player));
            gui.setItem(42, i42);
        } catch (GuiException e) {
            e.printStackTrace();
        }
    }

    public static void openCookingGui(Player player) {
        cookingGui(player);
        gui.open(player);
    }
}
