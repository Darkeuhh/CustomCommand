package fr.clmt.customCommand.util;

import fr.clmt.customCommand.main;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.UUID;

public class CmdManager {

    private final main main;
    public CmdManager(main main){
        this.main = main;
    }

    public void createCmd(String cmdName, String permission, Player owner){
        final File file = new File(main.getDataFolder(), "commands.yml");
        final YamlConfiguration cmds = YamlConfiguration.loadConfiguration(file);

        UUID ownerUUID = owner.getUniqueId();
        String cmdPath = ownerUUID.toString()+"."+cmdName;
        cmds.set(cmdPath+".permission", permission);
        cmds.set(cmdPath+".owner", ownerUUID.toString());
        cmds.set(cmdPath+".enabled", true);
        cmds.set(cmdPath+".type", "broadcast");
        try {
            cmds.save(file);
            }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}
