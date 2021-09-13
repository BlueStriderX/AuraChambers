package thederpgamer.aurachambers.modules.chambers.logistics;

import api.network.PacketReadBuffer;
import api.network.PacketWriteBuffer;
import org.schema.game.common.controller.SegmentController;
import org.schema.game.common.controller.elements.ManagerContainer;
import org.schema.game.common.data.blockeffects.config.ConfigGroup;
import org.schema.game.common.data.blockeffects.config.StatusEffectType;
import org.schema.schine.graphicsengine.core.Timer;
import thederpgamer.aurachambers.elements.ElementManager;
import thederpgamer.aurachambers.modules.chambers.ChamberModule;
import thederpgamer.aurachambers.modules.chambers.ChamberModuleGroup;
import thederpgamer.aurachambers.utils.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * <Description>
 *
 * @author TheDerpGamer
 * @version 1.0 - [09/13/2021]
 */
public class AuraRangeModuleGroup extends ChamberModuleGroup {

    public static final float BASE_RANGE = 300.0f;
    public static final ConcurrentLinkedQueue<SegmentController> entityList = new ConcurrentLinkedQueue<>();

    public AuraRangeModuleGroup(SegmentController segmentController, ManagerContainer<?> managerContainer) {
        super(segmentController, managerContainer);
    }

    @Override
    public ChamberModule[] getSubChambers() {
        return new ChamberModule[] {

        };
    }

    public static class AuraRange1 extends ChamberModule {

        public static final float ADDITIONAL_RANGE = 1.5f;
        private float updateTimer = UPDATE_TIMER;

        public AuraRange1(SegmentController segmentController, ManagerContainer<?> managerContainer) {
            super(segmentController, managerContainer, StatusEffectType.AURA_RANGE, ElementManager.getChamber("Aura Range 1").getId());
        }

        @Override
        public void handle(Timer timer) {
            updateTimer --;
            if(updateTimer <= 0) {
                float maxRange = BASE_RANGE + (BASE_RANGE * ADDITIONAL_RANGE);
                ArrayList<ChamberModule> chamberModules = EntityUtils.getAllChamberModules(segmentController);

                HashMap<SegmentController, Float> entityMap = EntityUtils.getEntitiesWithinRange(segmentController, maxRange);
                for(Map.Entry<SegmentController, Float> entry : entityMap.entrySet()) {
                    SegmentController entity = entry.getKey();
                    for(ChamberModule chamberModule : chamberModules) {
                        ConfigGroup configGroup = entity.getConfigManager().getConfigPool().poolMapLowerCase.get(chamberModule.getName().toLowerCase());
                        if(configGroup != null && !entity.getConfigManager().isActive(configGroup) && chamberModule.canApplyTo(entity)) {
                            entity.getConfigManager().addEffectAndSend(configGroup, true, entity.getNetworkObject());
                        }
                    }
                    entityList.add(entity);
                }

                for(SegmentController entity : entityList) {
                    if(!entity.equals(segmentController)) {
                        float distance = EntityUtils.getDistance(segmentController, entity);
                        if(distance > maxRange) {
                            for(ChamberModule chamberModule : chamberModules) {
                                ConfigGroup configGroup = entity.getConfigManager().getConfigPool().poolMapLowerCase.get(chamberModule.getName().toLowerCase());
                                if(configGroup != null) entity.getConfigManager().removeEffectAndSend(configGroup, true, entity.getNetworkObject());
                            }
                            entityList.remove(entity);
                        }
                    }
                }

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
            return "Aura Range 1";
        }

        @Override
        public boolean canApplyTo(SegmentController entity) {
            return false;
        }
    }
}
