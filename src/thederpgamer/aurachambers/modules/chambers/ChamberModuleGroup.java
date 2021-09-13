package thederpgamer.aurachambers.modules.chambers;

import org.schema.game.common.controller.SegmentController;
import org.schema.game.common.controller.elements.ManagerContainer;

/**
 * <Description>
 *
 * @author TheDerpGamer
 * @version 1.0 - [09/13/2021]
 */
public abstract class ChamberModuleGroup {

    public static final float UPDATE_TIMER = 50.0f;

    protected final SegmentController segmentController;
    protected final ManagerContainer<?> managerContainer;

    public ChamberModuleGroup(SegmentController segmentController, ManagerContainer<?> managerContainer) {
        this.segmentController = segmentController;
        this.managerContainer = managerContainer;
    }

    public abstract ChamberModule[] getSubChambers();
}
