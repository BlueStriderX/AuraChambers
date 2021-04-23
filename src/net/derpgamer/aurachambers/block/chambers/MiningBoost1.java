package net.derpgamer.aurachambers.block.chambers;

import api.config.BlockConfig;
import api.element.block.Blocks;
import org.schema.game.common.data.blockeffects.config.StatusEffectType;
import org.schema.game.common.data.element.ElementInformation;

import java.util.Locale;

public class MiningBoost1 {

    private ElementInformation blockInfo;

    public MiningBoost1() {
        blockInfo = BlockConfig.newElement("Mining Boost 1", new short[]{ 3201 });
        blockInfo.setFullName("Mining Boost 1");
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
        blockInfo.chamberConfigGroupsLowerCase.add(StatusEffectType.CUSTOM_EFFECT_01.name().toLowerCase(Locale.ENGLISH));
        blockInfo.chamberParent = 3200;
        blockInfo.chamberRoot = 3200;
        blockInfo.chamberUpgradesTo = 3202;
        blockInfo.chamberChildren.add((short) 3202);
    }

    public ElementInformation getBlockInfo() {
        return blockInfo;
    }
}
