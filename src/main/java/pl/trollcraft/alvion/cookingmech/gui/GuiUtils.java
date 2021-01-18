package pl.trollcraft.alvion.cookingmech.gui;

import me.mattstudios.mfgui.gui.components.GuiType;
import me.mattstudios.mfgui.gui.guis.Gui;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GuiUtils {


    public static Gui createGui(int size, String title) {
        return new Gui(size,title);
    }

    public static Gui createGui(GuiType type, String title) {
        return new Gui(type,title);
    }

    public static PersistentGui createPersistentGui(int size, String title) {
        return new PersistentGui(size,title);
    }

    public static GuiItem convertToGuiItem(Material material) {
        return new GuiItem(new ItemStack(material));
    }

    public static GuiItem convertToGuiItem(Material material, String name) {
        ItemStack stack = new ItemStack(material);
        ItemMeta meta = stack.getItemMeta();
        assert meta != null;
        try {
            meta.setDisplayName(name);
            stack.setItemMeta(meta);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return new GuiItem(stack);
    }

    public static GuiItem convertToGuiItem(Material material, String name, String lore) {

        ItemStack stack = new ItemStack(material);
        ItemMeta meta = stack.getItemMeta();
        ArrayList<String> list = new ArrayList<>();
        list.add(lore);
        assert meta != null;
        try {
            meta.setDisplayName(name);
            meta.setLore(list);
            stack.setItemMeta(meta);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return new GuiItem(stack);
    }

}
