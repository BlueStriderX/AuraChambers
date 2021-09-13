package thederpgamer.aurachambers;

import api.config.BlockConfig;
import api.listener.Listener;
import api.listener.events.register.ManagerContainerRegisterEvent;
import api.mod.StarLoader;
import api.mod.StarMod;
import api.utils.game.module.ModManagerContainerModule;
import org.apache.commons.io.IOUtils;
import org.schema.schine.resource.ResourceLoader;
import thederpgamer.aurachambers.elements.ElementManager;
import thederpgamer.aurachambers.elements.blocks.systems.chambers.defense.ShieldAuraChamber;
import thederpgamer.aurachambers.elements.blocks.systems.chambers.logistics.AuraRangeChamber;
import thederpgamer.aurachambers.manager.ConfigManager;
import thederpgamer.aurachambers.manager.LogManager;
import thederpgamer.aurachambers.modules.chambers.defense.ShieldTransferModuleGroup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * <Description>
 *
 * @version 1.0 - [04/23/2021]
 * @author TheDerpGamer
 */
public class AuraChambers extends StarMod {

    //Instance
    private static AuraChambers instance;
    public static AuraChambers getInstance() {
        return instance;
    }
    public static void main(String[] args) {

    }
    public AuraChambers() {

    }

    //Data
    private final String[] overwriteClasses = {
            "StatusEffectCategory",
            "StatusEffectType"
    };

    @Override
    public void onEnable() {
        instance = this;
        ConfigManager.initialize();
        registerListeners();
    }

    @Override
    public byte[] onClassTransform(String className, byte[] byteCode) {
        for(String name : overwriteClasses) if(className.endsWith(name)) return overwriteClass(className, byteCode);
        return super.onClassTransform(className, byteCode);
    }

    @Override
    public void onResourceLoad(ResourceLoader loader) {
        //ResourceManager.loadResources();
    }

    @Override
    public void onBlockConfigLoad(BlockConfig blockConfig) {
        //Logistics Chambers
        ElementManager.addChamber(new AuraRangeChamber.AuraRangeChamber1());
        ElementManager.addChamber(new AuraRangeChamber.AuraRangeChamber2());
        ElementManager.addChamber(new AuraRangeChamber.AuraRangeChamber3());

        //Defensive Chambers
        ElementManager.addChamber(new ShieldAuraChamber());
        ElementManager.addChamber(new ShieldAuraChamber.ShieldTransferChamber1());
        ElementManager.addChamber(new ShieldAuraChamber.ShieldTransferChamber2());
        ElementManager.addChamber(new ShieldAuraChamber.ShieldTransferChamber3());

        ElementManager.initializeBlocks();
    }

    private void registerListeners() {
        StarLoader.registerListener(ManagerContainerRegisterEvent.class, new Listener<ManagerContainerRegisterEvent>() {
            @Override
            public void onEvent(ManagerContainerRegisterEvent event) {
                ShieldTransferModuleGroup shieldModule = new ShieldTransferModuleGroup(event.getSegmentController(), event.getContainer());
                for(ModManagerContainerModule chamber : shieldModule.getSubChambers()) {
                    event.addModMCModule(chamber);
                }
            }
        }, this);
    }

    private byte[] overwriteClass(String className, byte[] byteCode) {
        byte[] bytes = null;
        try {
            ZipInputStream file = new ZipInputStream(new FileInputStream(this.getSkeleton().getJarFile()));
            while(true) {
                ZipEntry nextEntry = file.getNextEntry();
                if(nextEntry == null) break;
                if(nextEntry.getName().endsWith(className + ".class")) bytes = IOUtils.toByteArray(file);
            }
            file.close();
        } catch(IOException exception) {
            exception.printStackTrace();
        }

        if(bytes != null) {
            LogManager.logInfo("Overwrote Class " + className);
            return bytes;
        } else return byteCode;
    }
}
