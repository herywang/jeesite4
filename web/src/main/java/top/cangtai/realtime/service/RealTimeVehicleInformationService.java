package top.cangtai.realtime.service;

import com.jeesite.common.entity.Page;
import top.cangtai.PageAndQuery;

public interface RealTimeVehicleInformationService {
    <T extends PageAndQuery> Page<T> findPage(T pageAndQuery);

}
