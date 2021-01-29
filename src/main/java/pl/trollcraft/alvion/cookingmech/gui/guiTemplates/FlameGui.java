package pl.trollcraft.alvion.cookingmech.gui.guiTemplates;

import me.mattstudios.mfgui.gui.components.GuiType;
import me.mattstudios.mfgui.gui.components.util.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.Gui;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.trollcraft.alvion.cookingmech.Storage;
import pl.trollcraft.alvion.cookingmech.gui.GuiUtils;
import pl.trollcraft.alvion.cookingmech.Debug;

import java.util.ArrayList;


public class FlameGui {
    private static final Gui gui = GuiUtils.createGui(GuiType.HOPPER, "Moc Plomienia");
    public static void createFlameGui() {
        ItemStack active = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        /*
        * TODO getting active flame level
        */

        Debug.log("Setting up itemstacks...");
        ItemStack guiItemStack1 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemStack guiItemStack2 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemStack guiItemStack3 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemStack guiItemStack4 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemStack guiItemStack5 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        Debug.log("Done!");

        Debug.log("Seeting up names and lores...");
        setLoreAndName("Moc plomienia: 0", "Uzyj zaru z poprzedniego pieczenia", guiItemStack1);
        setLoreAndName("Moc plomienia: 1", "Uzyj malego plomienia", guiItemStack2);
        setLoreAndName("Moc plomienia: 2", "Uzyj sredniego plomienia", guiItemStack3);
        setLoreAndName("Moc plomienia: 3", "Uzyj normalnego plomienia", guiItemStack4);
        setLoreAndName("Moc plomienia: 4", "Uzyj duzego plomienia", guiItemStack5);
        Debug.log("Done!");

        Debug.log("Creating guiitems...");
        GuiItem guiItem1 = new GuiItem(guiItemStack1);
        GuiItem guiItem2 = new GuiItem(guiItemStack2);
        GuiItem guiItem3 = new GuiItem(guiItemStack3);
        GuiItem guiItem4 = new GuiItem(guiItemStack4);
        GuiItem guiItem5 = new GuiItem(guiItemStack5);
        Debug.log("Done!");

        guiItem1.setAction(event1 -> {
            Debug.log("Event: gui1");
            event1.setCancelled(true);
            //flame off
            Debug.log("Storage.activeFlames: " + Storage.activeFlame.getOrDefault((event1.getWhoClicked()), null));
            Storage.activeFlame.put(((Player) event1.getWhoClicked()).getPlayer(), Storage.flameTypes.get(0));
            Debug.log("Storage.activeFlames: " + Storage.activeFlame.getOrDefault((event1.getWhoClicked()), null));
            ((Player) event1.getWhoClicked()).playSound(event1.getWhoClicked().getLocation(), Sound.BLOCK_FIRE_AMBIENT, 1f, 0f);

            //action after
            Bukkit.dispatchCommand(event1.getWhoClicked(), "cook");
        });
        guiItem2.setAction(event2 -> {
            Debug.log("Event: gui2");
            event2.setCancelled(true);
            //light flame


            Storage.activeFlame.put(((Player) event2.getWhoClicked()), Storage.flameTypes.get(1));
            ((Player) event2.getWhoClicked()).playSound(event2.getWhoClicked().getLocation(), Sound.BLOCK_FIRE_AMBIENT, 1f, 0f);

            //action after
            Bukkit.dispatchCommand(event2.getWhoClicked(), "cook");
        });
        guiItem3.setAction(event3 -> {
            Debug.log("Event: gui3");
            event3.setCancelled(true);

            //medium flame

            Storage.activeFlame.put(((Player) event3.getWhoClicked()), Storage.flameTypes.get(2));
            ((Player) event3.getWhoClicked()).playSound(event3.getWhoClicked().getLocation(), Sound.BLOCK_FIRE_AMBIENT, 1f, 0f);

            //action after
            Bukkit.dispatchCommand(event3.getWhoClicked(), "cook");
        });
        guiItem4.setAction(event4 -> {
            Debug.log("Event: gui4");
            event4.setCancelled(true);
            //normal flame

            Storage.activeFlame.put(((Player) event4.getWhoClicked()), Storage.flameTypes.get(3));
            ((Player) event4.getWhoClicked()).playSound(event4.getWhoClicked().getLocation(), Sound.BLOCK_FIRE_AMBIENT, 1f, 0f);

            //action after
            Bukkit.dispatchCommand(event4.getWhoClicked(), "cook");
        });
        guiItem5.setAction(event5 -> {
            Debug.log("Event: gui5");
            event5.setCancelled(true);
            //big flame

            Storage.activeFlame.put(((Player) event5.getWhoClicked()), Storage.flameTypes.get(4));
            ((Player) event5.getWhoClicked()).playSound(event5.getWhoClicked().getLocation(), Sound.BLOCK_FIRE_AMBIENT, 1f, 0f);

            //action after
            Bukkit.dispatchCommand(event5.getWhoClicked(), "cook");
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
        createFlameGui();
        gui.open(player);
    }

    public static Gui getFlameGui() {
        createFlameGui();
        return gui;
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
