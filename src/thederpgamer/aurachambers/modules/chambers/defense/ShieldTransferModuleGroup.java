package thederpgamer.aurachambers.modules.chambers.defense;

import api.network.PacketReadBuffer;
import api.network.PacketWriteBuffer;
import org.schema.game.common.controller.SegmentController;
import org.schema.game.common.controller.elements.ManagerContainer;
import org.schema.game.common.data.blockeffects.config.StatusEffectType;
import org.schema.game.common.data.player.faction.FactionRelation;
import org.schema.schine.graphicsengine.core.Timer;
import thederpgamer.aurachambers.elements.ElementManager;
import thederpgamer.aurachambers.modules.chambers.ChamberModule;
import thederpgamer.aurachambers.modules.chambers.ChamberModuleGroup;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <Description>
 *
 * @author TheDerpGamer
 * @version 1.0 - [09/13/2021]
 */
public class ShieldTransferModuleGroup extends ChamberModuleGroup {

    private final ConcurrentHashMap<SegmentController, Float> entityMap = new ConcurrentHashMap<>();

    public ShieldTransferModuleGroup(SegmentController segmentController, ManagerContainer<?> managerContainer) {
        super(segmentController, managerContainer);
    }

    @Override
    public ChamberModule[] getSubChambers() {
        return new ChamberModule[] {
                new ShieldTransferModule1(segmentController, managerContainer)
        };
    }

    public static class ShieldTransferModule1 extends ChamberModule {

        private float updateTimer = UPDATE_TIMER;

        public ShieldTransferModule1(SegmentController segmentController, ManagerContainer<?> managerContainer) {
            super(segmentController, managerContainer, StatusEffectType.SHIELD_TRANSFER_AURA, ElementManager.getChamber("Shield Transfer 1").getId());
        }

        @Override
        public void handle(Timer timer) {
            updateTimer --;
            if(updateTimer <= 0) {

                updateTimer = UPDATE_TIMER;
            }
        }

        @Override
        public void onTagSerialize(PacketWriteBuffer packetWriteBuffer) throws IOException {

        }

        @Override
        public void onTagDeserialize(PacketReadBuffer packetReadBuffer) throws IOException {

        }

        @Override
        public double getPowerConsumedPerSecondResting() {
            return 0;
        }

        @Override
        public double getPowerConsumedPerSecondCharging() {
            return 0;
        }

        @Override
        public String getName() {
            return "Shield Transfer 1";
        }

        @Override
        public boolean canApplyTo(SegmentController entity) {
            return segmentController.getRelationTo(entity).equals(FactionRelation.RType.FRIEND) && !segmentController.equals(entity);
        }
    }
}
