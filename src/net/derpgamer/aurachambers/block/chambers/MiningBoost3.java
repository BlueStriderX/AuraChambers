package net.derpgamer.aurachambers.block.chambers;

import api.config.BlockConfig;
import org.schema.game.common.data.blockeffects.config.StatusEffectType;
import org.schema.game.common.data.element.ElementInformation;

import java.util.Locale;

public class MiningBoost3 {

    private ElementInformation blockInfo;

    public MiningBoost3() {
        blockInfo = BlockConfig.newElement("Mining Boost 3", new short[]{ 3203 });
        blockInfo.setFullName("Mining Boost 3");
        blockInfo.setArmorValue(0);
        blockInfo.maxHitPointsFull = 100;
        blockInfo.setBuildIconNum(1010);
        blockInfo.setCanActivate(true);
        blockInfo.setShoppable(false);
        blockInfo.setEnterable(false);
        blockInfo.setProducedInFactory(0);
        blockInfo.mass = (float) 0.15;
        blockInfo.volume = (float) 0.1;
        blockInfo.reactorHp = 20;
        blockInfo.chamberGeneral = false;
        blockInfo.systemBlock = true;
        blockInfo.chamberAppliesTo = 0;
        blockInfo.chamberPermission = 6;
        blockInfo.chamberCapacity = (float) 0.1;
        blockInfo.chamberConfigGroupsLowerCase.add(StatusEffectType.CUSTOM_EFFECT_03.name().toLowerCase(Locale.ENGLISH));
        blockInfo.chamberPrerequisites.add((short) 3202);
        blockInfo.chamberParent = 3202;
        blockInfo.chamberRoot = 3200;
    }

    public ElementInformation getBlockInfo() {
        return blockInfo;
    }
}
