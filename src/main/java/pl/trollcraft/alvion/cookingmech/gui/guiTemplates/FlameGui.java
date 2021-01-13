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
    public static void createFlameGui(Player player) {
        ItemStack active = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        /*
        //TODO getting active flame level
        */

        ItemStack guiItemStack1 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemStack guiItemStack2 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemStack guiItemStack3 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemStack guiItemStack4 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemStack guiItemStack5 = new ItemStack(Material.RED_STAINED_GLASS_PANE);

        setLoreAndName("Moc plomienia: 0", "Uzyj zaru z poprzedniego pieczenia", guiItemStack1);
        setLoreAndName("Moc plomienia: 1", "Uzyj malego plomienia", guiItemStack2);
        setLoreAndName("Moc plomienia: 2", "Uzyj sredniego plomienia", guiItemStack3);
        setLoreAndName("Moc plomienia: 3", "Uzyj normalnego plomienia", guiItemStack4);
        setLoreAndName("Moc plomienia: 4", "Uzyj duzego plomienia", guiItemStack5);

        GuiItem guiItem1 = new GuiItem(guiItemStack1);
        GuiItem guiItem2 = new GuiItem(guiItemStack2);
        GuiItem guiItem3 = new GuiItem(guiItemStack3);
        GuiItem guiItem4 = new GuiItem(guiItemStack4);
        GuiItem guiItem5 = new GuiItem(guiItemStack5);

        guiItem1.setAction(event -> {
            event.setCancelled(true);
            //flame off

            Storage.activeFlame.put(player, Storage.flameTypes.get(0));
            player.playSound(player.getLocation(), Sound.BLOCK_FIRE_AMBIENT, 1f, 0f);

            //action after
            CookingGui.openCookingGui(player);
        });
        guiItem2.setAction(event -> {
            event.setCancelled(true);
            //light flame

            Storage.activeFlame.put(player, Storage.flameTypes.get(1));
            player.playSound(player.getLocation(), Sound.BLOCK_FIRE_AMBIENT, 1f, 0f);

            //action after
            CookingGui.openCookingGui(player);
        });
        guiItem3.setAction(event -> {
            event.setCancelled(true);
            //medium flame

            Storage.activeFlame.put(player, Storage.flameTypes.get(2));
            player.playSound(player.getLocation(), Sound.BLOCK_FIRE_AMBIENT, 1f, 0f);

            //action after
            CookingGui.openCookingGui(player);
        });
        guiItem4.setAction(event -> {
            event.setCancelled(true);
            //normal flame

            Storage.activeFlame.put(player, Storage.flameTypes.get(3));
            player.playSound(player.getLocation(), Sound.BLOCK_FIRE_AMBIENT, 1f, 0f);

            //action after
            CookingGui.openCookingGui(player);
        });
        guiItem5.setAction(event -> {
            event.setCancelled(true);
            //big flame

            Storage.activeFlame.put(player, Storage.flameTypes.get(4));
            player.playSound(player.getLocation(), Sound.BLOCK_FIRE_AMBIENT, 1f, 0f);

            //action after
            CookingGui.openCookingGui(player);
        });

        gui.setItem(0,guiItem1);
        gui.setItem(1,guiItem2);
        gui.setItem(2,guiItem3);
        gui.setItem(3,guiItem4);
        gui.setItem(4,guiItem5);

        /*
        @Deprecated
        try {
        if (Storage.activeFlame.containsKey(player)) {
            if (Storage.activeFlame.get(player).equals(Storage.flameTypes.get(0))) {
                gui.getGuiItem(0).setItemStack(active);
            } else if (Storage.activeFlame.get(player).equals(Storage.flameTypes.get(1))) {
                gui.getGuiItem(1).setItemStack(active);
            } else if (Storage.activeFlame.get(player).equals(Storage.flameTypes.get(2))) {
                gui.getGuiItem(2).setItemStack(active);
            } else if (Storage.activeFlame.get(player).equals(Storage.flameTypes.get(3))) {
                gui.getGuiItem(3).setItemStack(active);
            } else if (Storage.activeFlame.get(player).equals(Storage.flameTypes.get(4))) {
                gui.getGuiItem(4).setItemStack(active);
            }
        } else {
            gui.getGuiItem(0).setItemStack(active);
        }} catch (NullPointerException e) {
            e.printStackTrace();
        }

        gui.update();
        */
    }

    public static void openFlameGui(Player player) {
        createFlameGui(player);
        gui.open(player);
    }

    public static void setLoreAndName(String name, String lore, ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(name);
        ArrayList<String> itemlore = new ArrayList<>();
        itemlore.add(lore);
        meta.setLore(itemlore);
        item.setItemMeta(meta);
    }
}
