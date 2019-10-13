package top.cangtai.setting.service;

import com.jeesite.common.entity.Page;
import top.cangtai.setting.entity.VehicleRegion;

public interface VehicleRegionService {

    VehicleRegion findOneByVehicleRegion();

    VehicleRegion addVehicleRegion(Double longitude, Double dimension, Double radius);

    VehicleRegion addVehicleRegion(Double longitude, Double dimension);

    Page<VehicleRegion> findPage(VehicleRegion vehicleRegion);

    void addVehicleRegion(VehicleRegion vehicleRegion);

    void deleteVehicleRegion(String id);
}
