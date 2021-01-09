package pl.trollcraft.alvion.cookingmech.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import pl.trollcraft.alvion.cookingmech.gui.guiTemplates.CookingGui;

public class CookingCommand implements CommandExecutor {
    /**
     * Executes the given command, returning its success.
     * <br>
     * If false is returned, then the "usage" plugin.yml entry for this command
     * (if defined) will be sent to the player.
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand( CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            CookingGui.openCookingGui((Player) sender);
        } else
        if (sender instanceof ConsoleCommandSender && args.length >= 1) {

            Player player = Bukkit.getPlayerExact(args[0]);
            if (player == null) {
                sender.sendMessage("Brak gracza!");
            } else {
                if (player.isOnline()) {
                    CookingGui.openCookingGui(Bukkit.getPlayerExact(args[0]));
                } else {
                    sender.sendMessage("Gracz offline!");
                }
            }

        }

        return true;
    }
}
