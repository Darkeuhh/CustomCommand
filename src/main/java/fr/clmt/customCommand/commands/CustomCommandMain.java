package fr.clmt.customCommand.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class CustomCommandMain implements CommandExecutor {
private Map<String, SubCommand> subcommands = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!(commandSender instanceof Player)){
            commandSender.sendMessage("You must be a player to use this command");
            return false;
        }

        Player player = (Player) commandSender;
        if(args.length == 0){
            player.sendMessage("§cUsage: /customcommand <subcommand> <args>");
            return false;
        }
        if(!subcommands.containsKey(args[0].toLowerCase())){
            player.sendMessage("§cThe sub command §a" +'"'+ args[0] + '"' + "§c doesn't exist");
            return false;
        }

        subcommands.get(args[0]).onCommand(player, command, args);
        return true;
    }
    public void registerCommand(String cmd, SubCommand subCommand) {
        subcommands.put(cmd, subCommand);
    }
}
