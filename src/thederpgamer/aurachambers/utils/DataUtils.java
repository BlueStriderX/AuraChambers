package thederpgamer.aurachambers.utils;

import api.common.GameCommon;
import api.mod.ModSkeleton;
import thederpgamer.aurachambers.AuraChambers;

/**
 * <Description>
 *
 * @author TheDerpGamer
 * @version 1.0 - [09/13/2021]
 */
public class DataUtils {

    private static final ModSkeleton instance = AuraChambers.getInstance().getSkeleton();

    public static String getResourcesPath() {
        return instance.getResourcesFolder().getPath().replace('\\', '/');
    }

    public static String getWorldDataPath() {
        return getResourcesPath() + "/data/" + GameCommon.getUniqueContextId();
    }
}