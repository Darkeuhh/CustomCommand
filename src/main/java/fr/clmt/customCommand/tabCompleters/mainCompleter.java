package fr.clmt.customCommand.tabCompleters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class mainCompleter implements TabCompleter {

    List <String> results = new ArrayList<>();

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            if (
                    command.getLabel().equalsIgnoreCase("customcommand")
                    || command.getLabel().equalsIgnoreCase("cc")
                    || command.getLabel().equalsIgnoreCase("customcmd")
                    || command.getLabel().equalsIgnoreCase("ccmd")
                    || command.getLabel().equalsIgnoreCase("customc")
            )
            {
                results.clear();
                results.add("bc");
            }



        }
        else{
            return null;
        }

        return sortedResults(args[args.length - 1]);
    }

    public List<String> sortedResults(String arg){
        final List<String> completions = new ArrayList<>();
        StringUtil.copyPartialMatches(arg, results, completions);
        Collections.sort(completions);
        results.clear();
        for (String s : completions) {
            results.add(s);
        }


        return results;
    }


}
