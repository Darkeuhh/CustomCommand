package fr.clmt.customCommand.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class bcSubC extends SubCommand{
    public void onCommand(Player player, Command command, String[] args){
        if(player.hasPermission("customcommand.bc")){
            if(args.length > 1){
                StringBuilder message = new StringBuilder();
                for(int i = 1; i < args.length; i++){
                    message.append(args[i]).append(" ");
                }
                Bukkit.broadcastMessage(message.toString());
            }else{
                player.sendMessage("§cUsage: /customcommand bc <message>");
            }
        }else{
            player.sendMessage("§cYou don't have the permission to use this command");
        }
    }
    public String getPermission(){
        return "customcommand.bc";
    }

}
