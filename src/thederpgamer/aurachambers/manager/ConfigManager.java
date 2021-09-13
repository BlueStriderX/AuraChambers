package thederpgamer.aurachambers.manager;

import api.mod.config.FileConfiguration;
import thederpgamer.aurachambers.AuraChambers;

/**
 * Manages mod config files and values.
 *
 * @version 1.0 - [06/27/2021]
 * @author TheDerpGamer
 */
public class ConfigManager {

    //Main Config
    private static FileConfiguration mainConfig;
    public static final String[] defaultMainConfig = {
            "debug-mode: false",
            "max-world-logs: 5"
    };

    public static void initialize() {
        mainConfig = AuraChambers.getInstance().getConfig("config");
        mainConfig.saveDefault(defaultMainConfig);
    }

    public static FileConfiguration getMainConfig() {
        return mainConfig;
    }

    public static String getDefaultValue(String field) {
        if(mainConfig.getKeys().contains(field)) {
            for(String s : defaultMainConfig) {
                String fieldName = s.substring(0, s.lastIndexOf(":") - 1).trim().toLowerCase();
                if(fieldName.equals(field.toLowerCase().trim())) return s.substring(s.lastIndexOf(":") + 1).trim();
            }
        }
        return null;
    }
}