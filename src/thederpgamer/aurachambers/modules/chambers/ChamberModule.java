package thederpgamer.aurachambers.modules.chambers;

import api.utils.game.module.ModManagerContainerModule;
import org.schema.game.common.controller.SegmentController;
import org.schema.game.common.controller.elements.ManagerContainer;
import org.schema.game.common.data.blockeffects.config.StatusEffectType;
import thederpgamer.aurachambers.AuraChambers;

/**
 * <Description>
 *
 * @author TheDerpGamer
 * @version 1.0 - [09/13/2021]
 */
public abstract class ChamberModule extends ModManagerContainerModule {

    protected StatusEffectType effectType;

    public ChamberModule(SegmentController segmentController, ManagerContainer<?> managerContainer, StatusEffectType effectType, short blockId) {
        super(segmentController, managerContainer, AuraChambers.getInstance(), blockId);
        this.effectType = effectType;
    }

    public StatusEffectType getEffectType() {
        return effectType;
    }

    public abstract boolean canApplyTo(SegmentController entity);
}
