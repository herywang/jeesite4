package top.cangtai.realtime.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import top.cangtai.PageAndQuery;

import java.util.List;

@Component
public class RealTimeVehicleInformationDaoImp implements RealTimeVehicleInformationDao{

    @Autowired
    @Qualifier("initMongoTemplate")
    private MongoTemplate template;
    @Value("${pageSize}")
    private Integer pageSize;


    @Override
    public <T extends PageAndQuery> List<T> findDataByQuery(Query query, Integer pageNo, T t) {
        query.skip((pageNo-1)*pageSize).limit(pageSize);
        return (List<T>) template.find(query, t.getClass());
    }

    @Override
    public <T extends PageAndQuery> long findCount(Query query, T t) {
        return template.count(query, t.getClass());
    }

}
