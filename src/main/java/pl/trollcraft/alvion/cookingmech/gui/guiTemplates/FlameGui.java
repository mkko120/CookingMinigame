package pl.trollcraft.alvion.cookingmech.gui.guiTemplates;

import me.mattstudios.mfgui.gui.components.util.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.Gui;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.trollcraft.alvion.cookingmech.Storage;
import pl.trollcraft.alvion.cookingmech.gui.GuiUtils;

import java.util.ArrayList;


public class FlameGui {
    private static Gui gui = GuiUtils.createHopperGui("Moc Plomienia");
    public static GuiItem createFlameGui(Material material, Player player) {
        return ItemBuilder.from(material).asGuiItem(event -> {

            ItemStack active = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);

            //TODO getting active flame level
            GuiItem guiItem1 = ItemBuilder.from(Material.RED_STAINED_GLASS_PANE).asGuiItem(event1 -> {
                //flame off

                Storage.activeFlame.put(player, Storage.flameTypes.get(0));
                player.playSound(player.getLocation(), Sound.BLOCK_FIRE_AMBIENT, 1f, 0f);

                //action after
                gui.close(player);
                CookingGui.openCookingGui(player);
            });


            GuiItem guiItem2 = ItemBuilder.from(Material.RED_STAINED_GLASS_PANE).asGuiItem(event1 -> {
                //TODO light flame

                Storage.activeFlame.put(player, Storage.flameTypes.get(1));
                player.playSound(player.getLocation(), Sound.BLOCK_FIRE_AMBIENT, 1f, 0f);

                //action after
                gui.close(player);
                CookingGui.openCookingGui(player);
            });

            GuiItem guiItem3 = ItemBuilder.from(Material.RED_STAINED_GLASS_PANE).asGuiItem(event1 -> {
                //TODO medium flame

                Storage.activeFlame.put(player, Storage.flameTypes.get(2));
                player.playSound(player.getLocation(), Sound.BLOCK_FIRE_AMBIENT, 1f, 0f);

                //action after
                gui.close(player);
                CookingGui.openCookingGui(player);
            });

            GuiItem guiItem4 = ItemBuilder.from(Material.RED_STAINED_GLASS_PANE).asGuiItem(event1 -> {
                //TODO normal flame

                Storage.activeFlame.put(player, Storage.flameTypes.get(3));
                player.playSound(player.getLocation(), Sound.BLOCK_FIRE_AMBIENT, 1f, 0f);

                //action after
                gui.close(player);
                CookingGui.openCookingGui(player);
            });

            GuiItem guiItem5 = ItemBuilder.from(Material.RED_STAINED_GLASS_PANE).asGuiItem(event1 -> {
                //TODO big flame

                Storage.activeFlame.put(player, Storage.flameTypes.get(4));
                player.playSound(player.getLocation(), Sound.BLOCK_FIRE_AMBIENT, 1f, 0f);

                //action after
                gui.close(player);
                CookingGui.openCookingGui(player);
            });




            setLoreAndName("Moc plomienia: 0", "Uzyj zaru z poprzedniego pieczenia", guiItem1);
            setLoreAndName("Moc plomienia: 1", "Uzyj malego plomienia", guiItem2);
            setLoreAndName("Moc plomienia: 2", "Uzyj sredniego plomienia", guiItem3);
            setLoreAndName("Moc plomienia: 3", "Uzyj normalnego plomienia", guiItem4);
            setLoreAndName("Moc plomienia: 4", "Uzyj duzego plomienia", guiItem5);

            gui.addItem(guiItem1);
            gui.addItem(guiItem2);
            gui.addItem(guiItem3);
            gui.addItem(guiItem4);
            gui.addItem(guiItem5);

            if (Storage.activeFlame.get(player).equals(Storage.flameTypes.get(0))) {
                gui.getGuiItem(0).setItemStack(active);
            }else if (Storage.activeFlame.get(player).equals(Storage.flameTypes.get(1))) {
                gui.getGuiItem(1).setItemStack(active);
            }else if (Storage.activeFlame.get(player).equals(Storage.flameTypes.get(2))) {
                gui.getGuiItem(2).setItemStack(active);
            }else if (Storage.activeFlame.get(player).equals(Storage.flameTypes.get(3))) {
                gui.getGuiItem(3).setItemStack(active);
            }else if (Storage.activeFlame.get(player).equals(Storage.flameTypes.get(4))) {
                gui.getGuiItem(4).setItemStack(active);
            }

            gui.update();

            gui.open(player);
        });
    }

    public static void setLoreAndName(String name, String lore, GuiItem item) {
        ItemStack stack = item.getItemStack();
        ItemMeta meta = stack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(name);
        ArrayList<String> itemlore = new ArrayList<>();
        itemlore.add(lore);
        meta.setLore(itemlore);
        stack.setItemMeta(meta);
        item.setItemStack(stack);
    }
}
