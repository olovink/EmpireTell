package empiretell;

import empiretell.command.TellCommand;
import empiretell.utils.Utils;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;

public final class Loader extends JavaPlugin {

    public static Loader instance;
    @Override
    public void onEnable() {
        instance = this;
        CommandMap commandMap = getServer().getCommandMap();
        commandMap.register("", new TellCommand());

        loadConfig();
    }

    public static String getColoredString(String path) {
        return Utils.colorString(Loader.instance.getConfig().getString(path));
    }

    public static Loader getInstance() {
        return instance;
    }

    public void loadConfig() {
        this.saveDefaultConfig();
        this.saveResource("config.yml", true);
    }
}
