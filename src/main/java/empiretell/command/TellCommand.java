package empiretell.command;

import empiretell.Loader;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class TellCommand extends Command {

    public TellCommand() {
        super(Loader.getColoredString("command-name"), "Tell command", Loader.getColoredString("command-usage"), Arrays.asList("t", "w"));
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }

        if (args.length < 1) {
            sender.sendMessage(Loader.getColoredString("command-no-args1") + " " + Loader.getColoredString("command-usage"));
            return false;
        }

        Player player = (Player) sender;
        Player target = player.getServer().getPlayer(args[0]);

        if (args.length < 2) {
            player.sendMessage(Loader.getColoredString("command-no-args2") + " " + Loader.getColoredString("command-usage"));
            return false;
        } else if (target == null) {
            String notFoundMessage = Loader.getColoredString("player-not-found");
            notFoundMessage = notFoundMessage.replace("%target%", args[0]);
            player.sendMessage(notFoundMessage);
            return false;
        }

        StringBuilder string = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            string.append(args[i]);
            if(i < args.length) {
                string.append(" ");
            }
        }

        // TargetMessage
        String targetMessage = Loader.getColoredString("target-send");
        targetMessage = targetMessage.replace("%player%", player.getName());
        targetMessage = targetMessage.replace("%message%", string);
        target.sendMessage(targetMessage);

        // PlayerMessage
        String playerMessage = Loader.getColoredString("player-send");
        playerMessage = playerMessage.replace("%target%", target.getName());
        playerMessage = playerMessage.replace("%message%", string);
        player.sendMessage(playerMessage);
        return true;
    }
}
