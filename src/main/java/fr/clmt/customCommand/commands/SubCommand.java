package fr.clmt.customCommand.commands;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public abstract class SubCommand {

    void onCommand(Player player, Command command, String[] args){

    }

    String getPermission(){
        return "";
    }

}
