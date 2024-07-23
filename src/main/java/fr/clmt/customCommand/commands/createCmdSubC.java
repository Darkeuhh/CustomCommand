package fr.clmt.customCommand.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class createCmdSubC extends SubCommand {
    public void onCommand(Player player, Command command, String[] args){
        if(player.hasPermission("customcommand.maincmd.createcmd")){


        }
        else{
            player.sendMessage("§cYou don't have the permission to use this command");
        }
    }
    public String getPermission(){
        return "customcommand.createcmd";
    }


}
