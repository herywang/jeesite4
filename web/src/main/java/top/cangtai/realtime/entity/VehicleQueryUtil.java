package top.cangtai.realtime.entity;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;


public class VehicleQueryUtil {

    private static final String FUZZY_MATCHING = ".*";

    private static final String ASC = "asc";

    public static Query getOuery(String orderBy,RealTimeVehicleInformation realTimeVehicleInformation){
        List<Criteria> list = new ArrayList<>();
        addQuery(list,"moduleNumber",realTimeVehicleInformation.getModuleNumber());
        addQuery(list,"idCard",realTimeVehicleInformation.getIdCard());
        addQuery(list,"name",realTimeVehicleInformation.getName());
        addQuery(list,"engineSpeed",realTimeVehicleInformation.getEngineSpeed());
        addQuery(list,"mailbox",realTimeVehicleInformation.getMailbox());
        addQuery(list,"datetime",realTimeVehicleInformation.getDatetime());
        addQuery(list,"carbonDioxide",realTimeVehicleInformation.getCarbonDioxide());

        Criteria datetime = realTimeVehicleInformation.getDatetime() != null ? Criteria.where("datetime").gt(realTimeVehicleInformation.getDatetime()) : null;
        if(datetime!=null){
            list.add(datetime);
        }
        Criteria engineSpeed = realTimeVehicleInformation.getEngineSpeed() != null ? Criteria.where("engineSpeed").gt(realTimeVehicleInformation.getEngineSpeed()) : null;
        if (engineSpeed!=null){
            list.add(engineSpeed);
        }
        Query query;
        Sort sort = null;
        if (orderBy!=null){

            String[] sortStr = orderBy.split(" ");
            if (sortStr[1].toLowerCase().equals(ASC)){
                sort = new Sort(Sort.Direction.ASC,sortStr[0]);
            }else {
                sort = new Sort(Sort.Direction.DESC,sortStr[0]);
            }
        }
        if (list.size()==0){
            if (sort!=null){
                return new Query().with(sort);
            }
            return new Query();
        }
        query = Query.query(Criteria.where("").andOperator(list.toArray(new Criteria[0])));
        if (sort!=null){
            query.with(sort);
        }
        return query;
    }

    public static void addQuery(List<Criteria> criterias,String name,Object data){
        Criteria criteria = null;
        if (data==null||"".equals(data)){
            return;
        }
        if (data instanceof Integer||data instanceof Double){
            criteria = Criteria.where(name).gt(data);
        }else if (data instanceof String){
            criteria = getFuzzyMatching(name, data);
        }
        criterias.add(criteria);
    }

    public static Criteria getFuzzyMatching(String name,Object data){
        if (data==null||"".equals(data)){
            return null;
        }
        return Criteria.where(name).regex("^"+FUZZY_MATCHING+data.toString()+FUZZY_MATCHING+"$","i");
    }
}
