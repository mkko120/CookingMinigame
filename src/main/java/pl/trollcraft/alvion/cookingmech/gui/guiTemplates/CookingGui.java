package pl.trollcraft.alvion.cookingmech.gui.guiTemplates;

import me.mattstudios.mfgui.gui.components.exception.GuiException;
import me.mattstudios.mfgui.gui.components.util.GuiFiller;
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

public class CookingGui {

    public static PersistentGui gui = GuiUtils.createPersistentGui(53,"Gotowanie");
    private static Recipe recipe;
    private static void cookingGui(Player player) {

        try {
            GuiItem i15 = GuiUtils.convertToGuiItem(Material.NETHER_STAR, "Start baking");
            i15.setAction(event -> {

                ItemStack[] main = new ItemStack[4];
                int i1 = 0;
                for (int i = 10; i < 13; i++) {
                    GuiItem item = gui.getGuiItem(i);
                    if (item.getItemStack() != null) {
                        main[i1] = item.getItemStack();
                    } else {
                        main[i1] = new ItemStack(Material.AIR);
                    }
                    i1++;
                }

                ItemStack[] opt = new ItemStack[4];
                i1 = 0;
                for (int i = 19; i < 22; i++) {
                    GuiItem item = gui.getGuiItem(i);
                    if (item.getItemStack() != null) {
                        opt[i1] = item.getItemStack();
                    } else {
                        opt[i1] = new ItemStack(Material.AIR);
                    }
                    i1++;
                }

                if (opt[0].equals(new ItemStack(Material.AIR))) {
                    recipe = CookingMinigame.getRecipesController().find(main);
                } else {
                    recipe = CookingMinigame.getRecipesController().find(main, opt);

                    new BukkitRunnable() {
                        FlameTime ft = recipe.getFlameTimes().get(Storage.activeFlame.getOrDefault(player, Storage.flameTypes.get(0)));
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
                }});
            gui.setItem(15, i15);
            gui.setItem(37, GuiUtils.convertToGuiItem(Material.GRAY_STAINED_GLASS_PANE, "Progress..."));
            gui.setItem(38, GuiUtils.convertToGuiItem(Material.GRAY_STAINED_GLASS_PANE, "Progress..."));
            gui.setItem(39, GuiUtils.convertToGuiItem(Material.GRAY_STAINED_GLASS_PANE, "Progress..."));
            gui.setItem(40, GuiUtils.convertToGuiItem(Material.GRAY_STAINED_GLASS_PANE, "Progress..."));
            gui.setItem(42, FlameGui.createFlameGui(Material.SMOKER, player));
        } catch (GuiException e) {
            e.printStackTrace();
        }

        GuiFiller filler = new GuiFiller(gui);
        GuiItem fillerMaterial = GuiUtils.convertToGuiItem(Material.GRAY_STAINED_GLASS_PANE);
        try {
            filler.fillBorder(fillerMaterial);
            filler.fillBetweenPoints(4, 1, 4, 9, fillerMaterial);
            filler.fillBetweenPoints(2, 5, 2, 5, fillerMaterial);
            filler.fillBetweenPoints(3, 5, 3, 5, fillerMaterial);
            filler.fillBetweenPoints(5, 5, 5, 5, fillerMaterial);
        }catch (GuiException e) {
            e.printStackTrace();
        }





    }

    public static void openCookingGui(Player player) {
        cookingGui(player);
        gui.open(player);
    }
}
