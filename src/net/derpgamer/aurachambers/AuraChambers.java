package net.derpgamer.aurachambers;

import api.DebugFile;
import api.config.BlockConfig;
import api.element.block.Blocks;
import api.element.block.FactoryType;
import api.mod.StarMod;
import net.derpgamer.aurachambers.block.AuraChamber;
import net.derpgamer.aurachambers.block.chambers.MiningBoost1;
import net.derpgamer.aurachambers.block.chambers.MiningBoost2;
import net.derpgamer.aurachambers.block.chambers.MiningBoost3;
import org.schema.game.common.data.element.ElementInformation;
import org.schema.game.common.data.element.FactoryResource;
import java.io.File;

public class AuraChambers extends StarMod {
    static AuraChambers inst;
    public AuraChambers() {
        inst = this;
    }
    private File smDirectory = new File("../");


    @Override
    public void onEnable() {
        super.onEnable();
        this.modName = "AuraChambers";
        this.modAuthor = "DovTech";
        this.modVersion = "0.1.1";
        this.modDescription = "Adds a new reactor chamber type for stations that can be used to apply various effects to nearby ships.";
        DebugFile.log("Enabled", this);
    }

    public void onBlockConfigLoad(BlockConfig config) {

        //Aura Chamber
        AuraChamber auraChamber = new AuraChamber();
        ElementInformation auraChamberInfo = auraChamber.getBlockInfo();
        FactoryResource[] auraChamberRecipe = {
                new FactoryResource(1, Blocks.POWER_REACTOR.getId()),
                new FactoryResource(200, Blocks.THRENS_CAPSULE.getId()),
                new FactoryResource(200, Blocks.FERTIKEEN_CAPSULE.getId())
        };
        BlockConfig.addRecipe(auraChamberInfo, FactoryType.STANDARD, 5, auraChamberRecipe);
        config.add(auraChamberInfo);

        //Mining Boost 1
        MiningBoost1 miningBoost1 = new MiningBoost1();
        ElementInformation miningBoost1Info = miningBoost1.getBlockInfo();
        config.add(miningBoost1Info);

        //Mining Boost 2
        MiningBoost2 miningBoost2 = new MiningBoost2();
        ElementInformation miningBoost2Info = miningBoost2.getBlockInfo();
        config.add(miningBoost2Info);

        //Mining Boost 3
        MiningBoost3 miningBoost3 = new MiningBoost3();
        ElementInformation miningBoost3Info = miningBoost3.getBlockInfo();
        config.add(miningBoost3Info);
    }

    /*
    public void registerListeners() {
        StarLoader.registerListener(BlockPlayerActivateEvent.class, new Listener() {
            @Override
            public void onEvent(Event e) {
                BlockPlayerActivateEvent event = (BlockPlayerActivateEvent) e;
                String name = event.getBlock().getType().getInfo().getFullName();
                if(name.equals("Ship Market")) { //Ship Market
                    ShipMarketGUI shipMarketGUI = new ShipMarketGUI(event.getBlock(), event.getPlayer(), new Station(event.getEntity().internalEntity));
                }
            }
        });
    }
     */
}