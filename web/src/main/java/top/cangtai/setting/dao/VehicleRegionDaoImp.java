package top.cangtai.setting.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import top.cangtai.setting.entity.VehicleRegion;

import java.util.Date;
import java.util.List;

@Component
public class VehicleRegionDaoImp implements VehicleRegionDao {

    @Autowired
    @Qualifier("initMongoTemplate")
    private MongoTemplate template;
    @Value("${pageSize}")
    private Integer pageSize;
    @Override
    public VehicleRegion findOneByVehicleRegion() {
        return template.findOne(new Query().with(new Sort(Sort.Direction.DESC,"_id")),VehicleRegion.class);
    }

    @Override
    public void addVehicleRegion(VehicleRegion vehicleRegion) {
        vehicleRegion.setDate(new Date());
        template.save(vehicleRegion);
    }

    @Override
    public List<VehicleRegion> findVehicleRegionByPage(Query query,Integer pageNo) {
        query.skip((pageNo-1)*pageSize).limit(pageSize);
        return template.find(query,VehicleRegion.class);
    }

    @Override
    public long count(Query query) {
        return template.count(query,VehicleRegion.class);
    }

    @Override
    public void deleteById(String id) {
        Query query = Query.query(Criteria.where("id").is(id));
        template.remove(query,VehicleRegion.class);
    }
}
