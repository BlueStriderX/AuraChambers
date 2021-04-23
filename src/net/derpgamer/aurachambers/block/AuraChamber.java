package net.derpgamer.aurachambers.block;

import api.config.BlockConfig;
import api.element.block.Blocks;
import org.schema.game.common.data.element.ElementInformation;

public class AuraChamber {

    private ElementInformation blockInfo;

    public AuraChamber() {
        blockInfo = BlockConfig.newElement("Aura Chamber", new short[]{ 3200 });
        blockInfo.setFullName("Aura Chamber");
        blockInfo.setDescription("Reactor Chamber to buff nearby ships with effects.\\n\\rNeeds to be physically connected with a Power Reactor by using Reactor Conduit blocks.");
        blockInfo.setArmorValue(0);
        blockInfo.maxHitPointsFull = 100;
        blockInfo.setBuildIconNum(1010);
        blockInfo.setCanActivate(true);
        blockInfo.setShoppable(true);
        blockInfo.setEnterable(false);
        blockInfo.setProducedInFactory(1);
        blockInfo.mass = (float) 0.15;
        blockInfo.volume = (float) 0.1;
        blockInfo.reactorGeneralIconIndex = 1;
        blockInfo.reactorHp = 20;
        blockInfo.chamberGeneral = true;
        blockInfo.chamberChildren.add((short) 3201);
        blockInfo.systemBlock = true;
        blockInfo.chamberAppliesTo = 1;
        blockInfo.type = Blocks.DEFENCE_CHAMBER.getInfo().getType();
        blockInfo.setPrice(100);
    }

    public ElementInformation getBlockInfo() {
        return blockInfo;
    }
}
