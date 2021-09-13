package thederpgamer.aurachambers.elements.blocks.systems.chambers.defense;

import api.config.BlockConfig;
import api.utils.element.Blocks;
import org.schema.game.common.data.blockeffects.config.StatusEffectType;
import org.schema.game.common.data.element.ElementKeyMap;
import org.schema.schine.graphicsengine.core.GraphicsContext;
import thederpgamer.aurachambers.elements.ElementManager;
import thederpgamer.aurachambers.elements.blocks.systems.chambers.ChamberBlock;

/**
 * <Description>
 *
 * @version 1.0 - [04/23/2021]
 * @author TheDerpGamer
 */
public class ShieldAuraChamber extends ChamberBlock {

    public ShieldAuraChamber() {
        super("Shield Aura", (short) 1046, 0.0f);
    }

    @Override
    public void initialize() {
        if(GraphicsContext.initialized) {
            blockInfo.setBuildIconNum(ElementKeyMap.getInfo(1046).getBuildIconNum());
        }
        blockInfo.setInventoryGroup(Blocks.BASE_SHIELD_ENHANCEMENT.getInfo().getInventoryGroup());
        blockInfo.setPlacable(false);
        blockInfo.setInRecipe(false);
        blockInfo.setDescription("null");
        //addExclusives(ElementManager.getChamber("Armor Aura"));
        addChildren(ElementManager.getChamber("Shield Transfer 1"));
        BlockConfig.add(blockInfo);
    }

    public static class ShieldTransferChamber1 extends ChamberBlock {

        public ShieldTransferChamber1() {
            super("Shield Transfer 1", (short) 1046, 5.0f, StatusEffectType.SHIELD_TRANSFER_AURA);
        }

        @Override
        public void initialize() {
            if(GraphicsContext.initialized) {
                blockInfo.setBuildIconNum(ElementKeyMap.getInfo(1046).getBuildIconNum());
            }
            blockInfo.setInventoryGroup(Blocks.BASE_SHIELD_ENHANCEMENT.getInfo().getInventoryGroup());
            blockInfo.setPlacable(false);
            blockInfo.setInRecipe(false);
            blockInfo.setDescription("null");
            setUpgrade(ElementManager.getChamber("Shield Transfer 2"));
            BlockConfig.add(blockInfo);
        }
    }

    public static class ShieldTransferChamber2 extends ChamberBlock {

        public ShieldTransferChamber2() {
            super("Shield Transfer 2", (short) 1046, 7.0f, StatusEffectType.SHIELD_TRANSFER_AURA);
        }

        @Override
        public void initialize() {
            if(GraphicsContext.initialized) {
                blockInfo.setBuildIconNum(ElementKeyMap.getInfo(1046).getBuildIconNum());
            }
            blockInfo.setInventoryGroup(Blocks.BASE_SHIELD_ENHANCEMENT.getInfo().getInventoryGroup());
            blockInfo.setPlacable(false);
            blockInfo.setInRecipe(false);
            blockInfo.setDescription("null");
            setUpgrade(ElementManager.getChamber("Shield Transfer 3"));
            BlockConfig.add(blockInfo);
        }
    }

    public static class ShieldTransferChamber3 extends ChamberBlock {

        public ShieldTransferChamber3() {
            super("Shield Transfer 3", (short) 1046, 10.0f, StatusEffectType.SHIELD_TRANSFER_AURA);
        }

        @Override
        public void initialize() {
            if(GraphicsContext.initialized) {
                blockInfo.setBuildIconNum(ElementKeyMap.getInfo(1046).getBuildIconNum());
            }
            blockInfo.setInventoryGroup(Blocks.BASE_SHIELD_ENHANCEMENT.getInfo().getInventoryGroup());
            blockInfo.setPlacable(false);
            blockInfo.setInRecipe(false);
            blockInfo.setDescription("null");
            BlockConfig.add(blockInfo);
        }
    }
}