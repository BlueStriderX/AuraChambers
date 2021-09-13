package thederpgamer.aurachambers.utils;

import api.utils.game.module.ModManagerContainerModule;
import org.schema.common.util.linAlg.Vector3fTools;
import org.schema.game.common.controller.SegmentController;
import org.schema.game.common.controller.Ship;
import org.schema.game.common.controller.SpaceStation;
import org.schema.game.common.controller.elements.ManagerContainer;
import org.schema.game.common.controller.elements.ManagerModuleSingle;
import org.schema.game.common.controller.elements.power.reactor.chamber.ReactorChamberCollectionManager;
import org.schema.game.common.controller.elements.power.reactor.chamber.ReactorChamberElementManager;
import org.schema.game.common.controller.elements.power.reactor.chamber.ReactorChamberUnit;
import org.schema.game.common.data.blockeffects.config.StatusEffectType;
import org.schema.game.common.data.world.Sector;
import org.schema.game.common.data.world.SimpleTransformableSendableObject;
import thederpgamer.aurachambers.modules.chambers.ChamberModule;

import javax.vecmath.Vector3f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <Description>
 *
 * @author TheDerpGamer
 * @version 1.0 - [09/13/2021]
 */
public class EntityUtils {

    public static ArrayList<ChamberModule> getChamberModulesByType(SegmentController segmentController, StatusEffectType effectType) {
        ArrayList<ChamberModule> moduleList = new ArrayList<>();
        ManagerContainer<?> managerContainer = getManagerContainer(segmentController);
        assert managerContainer != null;
        for(Map.Entry<Short, ModManagerContainerModule> entry : managerContainer.getModModuleMap().entrySet()) {
            if(entry.getValue() instanceof ChamberModule && ((ChamberModule) entry.getValue()).getEffectType().equals(effectType)) moduleList.add((ChamberModule) entry.getValue());
        }
        return moduleList;
    }

    public static ArrayList<ChamberModule> getAllChamberModules(SegmentController segmentController) {
        ArrayList<ChamberModule> moduleList = new ArrayList<>();
        ManagerContainer<?> managerContainer = getManagerContainer(segmentController);
        assert managerContainer != null;
        for(Map.Entry<Short, ModManagerContainerModule> entry : managerContainer.getModModuleMap().entrySet()) {
            if(entry.getValue() instanceof ChamberModule) moduleList.add((ChamberModule) entry.getValue());
        }
        return moduleList;
    }

    public static float getDistance(SegmentController entityA, SegmentController entityB) {
        Vector3f entityAPos = new Vector3f(entityA.getWorldTransform().origin);
        Vector3f entityBPos = new Vector3f(entityB.getWorldTransform().origin);
        return Math.abs(Vector3fTools.distance(entityAPos.x, entityAPos.y,entityAPos.z, entityBPos.x, entityBPos.y, entityBPos.z));
    }

    public static HashMap<SegmentController, Float> getEntitiesWithinRange(SegmentController segmentController, float maxRange) {
        Vector3f currentPos = new Vector3f(segmentController.getWorldTransform().origin);
        HashMap<SegmentController, Float> rangeMap = new HashMap<>();
        Sector sector = segmentController.getRemoteSector().getServerSector();
        for(SimpleTransformableSendableObject<?> entity : sector.getEntities()) {
            if(entity instanceof SegmentController) {
                Vector3f entityPos = new Vector3f(entity.getWorldTransform().origin);
                float distance = Math.abs(Vector3fTools.distance(currentPos.x, currentPos.y, currentPos.z, entityPos.x, entityPos.y, entityPos.z));
                if(distance <= maxRange) rangeMap.put((SegmentController) entity, distance);
            }
        }
        return rangeMap;
    }

    public static boolean hasChamber(SegmentController segmentController, short chamberBlockId) {
        return getChamber(segmentController, chamberBlockId) != null;
    }

    public static ManagerModuleSingle<ReactorChamberUnit, ReactorChamberCollectionManager, ReactorChamberElementManager> getChamber(SegmentController segmentController, short chamberBlockId) {
        ManagerContainer<?> managerContainer = getManagerContainer(segmentController);
        assert managerContainer != null;
        ArrayList<ManagerModuleSingle<ReactorChamberUnit, ReactorChamberCollectionManager, ReactorChamberElementManager>> chamberList = (ArrayList<ManagerModuleSingle<ReactorChamberUnit, ReactorChamberCollectionManager, ReactorChamberElementManager>>) managerContainer.getChambers();
        for(ManagerModuleSingle<ReactorChamberUnit, ReactorChamberCollectionManager, ReactorChamberElementManager> chamber : chamberList) {
            if(chamber.getElementID() == chamberBlockId) return chamber;
        }
        return null;
    }

    public static ManagerContainer<?> getManagerContainer(SegmentController segmentController) {
        switch(segmentController.getType()) {
            case SHIP: return ((Ship) segmentController).getManagerContainer();
            case SPACE_STATION: return ((SpaceStation) segmentController).getManagerContainer();
            default: return null;
        }
    }
}
