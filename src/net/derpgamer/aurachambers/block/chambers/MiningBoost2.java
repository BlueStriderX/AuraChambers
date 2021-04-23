package net.derpgamer.aurachambers.block.chambers;

import api.config.BlockConfig;
import org.schema.game.common.data.blockeffects.config.StatusEffectType;
import org.schema.game.common.data.element.ElementInformation;

import java.util.Locale;

public class MiningBoost2 {

    private ElementInformation blockInfo;

    public MiningBoost2() {
        blockInfo = BlockConfig.newElement("Mining Boost 2", new short[]{ 3202 });
        blockInfo.setFullName("Mining Boost 2");
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
        blockInfo.chamberConfigGroupsLowerCase.add(StatusEffectType.CUSTOM_EFFECT_02.name().toLowerCase(Locale.ENGLISH));
        blockInfo.chamberPrerequisites.add((short) 3201);
        blockInfo.chamberParent = 3201;
        blockInfo.chamberRoot = 3200;
        blockInfo.chamberUpgradesTo = 3203;
        blockInfo.chamberChildren.add((short) 3203);
    }

    public ElementInformation getBlockInfo() {
        return blockInfo;
    }
}
