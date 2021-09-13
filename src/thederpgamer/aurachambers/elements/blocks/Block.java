package thederpgamer.aurachambers.elements.blocks;

import api.config.BlockConfig;
import org.schema.game.common.data.element.ElementCategory;
import org.schema.game.common.data.element.ElementInformation;
import thederpgamer.aurachambers.AuraChambers;
import thederpgamer.aurachambers.elements.ElementManager;

/**
 * Block
 * <Description>
 *
 * @author TheDerpGamer
 * @since 04/23/2021
 */
public abstract class Block {

    protected ElementInformation blockInfo;

    public Block(String name, ElementCategory category) {
        blockInfo = BlockConfig.newElement(AuraChambers.getInstance(), name, new short[6]);
        BlockConfig.setElementCategory(blockInfo, category);
        ElementManager.addBlock(this);
    }

    public final ElementInformation getBlockInfo() {
        return blockInfo;
    }

    public final short getId() {
        return blockInfo.getId();
    }

    public abstract void initialize();
}