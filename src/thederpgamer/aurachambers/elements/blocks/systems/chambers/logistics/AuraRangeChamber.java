package thederpgamer.aurachambers.elements.blocks.systems.chambers.logistics;

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
 * @version 1.0 - [04/24/2021]
 * @author TheDerpGamer
 */
public class AuraRangeChamber {

    public static class AuraRangeChamber1 extends ChamberBlock {

        public AuraRangeChamber1() {
            super("Aura Range 1", (short) 1015, 5.0f, StatusEffectType.AURA_RANGE);
        }

        @Override
        public void initialize() {
            if(GraphicsContext.initialized) {
                blockInfo.setBuildIconNum(ElementKeyMap.getInfo(1015).getBuildIconNum());
            }
            blockInfo.setInventoryGroup(Blocks.MINING_BONUS_1.getInfo().getInventoryGroup());
            blockInfo.setPlacable(false);
            blockInfo.setInRecipe(false);
            blockInfo.setDescription("null");
            setUpgrade(ElementManager.getChamber("Aura Range 2"));
            BlockConfig.add(blockInfo);
        }
    }

    public static class AuraRangeChamber2 extends ChamberBlock {

        public AuraRangeChamber2() {
            super("Aura Range 2", (short) 1015, 7.0f, StatusEffectType.AURA_RANGE);
        }

        @Override
        public void initialize() {
            if(GraphicsContext.initialized) {
                blockInfo.setBuildIconNum(ElementKeyMap.getInfo(1015).getBuildIconNum());
            }
            blockInfo.setInventoryGroup(Blocks.MINING_BONUS_1.getInfo().getInventoryGroup());
            blockInfo.setPlacable(false);
            blockInfo.setInRecipe(false);
            blockInfo.setDescription("null");
            setUpgrade(ElementManager.getChamber("Aura Range 3"));
            BlockConfig.add(blockInfo);
        }
    }

    public static class AuraRangeChamber3 extends ChamberBlock {

        public AuraRangeChamber3() {
            super("Aura Range 3", (short) 1015, 10.0f, StatusEffectType.AURA_RANGE);
        }

        @Override
        public void initialize() {
            if(GraphicsContext.initialized) {
                blockInfo.setBuildIconNum(ElementKeyMap.getInfo(1015).getBuildIconNum());
            }
            blockInfo.setInventoryGroup(Blocks.MINING_BONUS_1.getInfo().getInventoryGroup());
            blockInfo.setPlacable(false);
            blockInfo.setInRecipe(false);
            blockInfo.setDescription("null");
            BlockConfig.add(blockInfo);
        }
    }
}
