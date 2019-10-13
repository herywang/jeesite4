package top.cangtai.realtime.entity;

import org.springframework.data.geo.Circle;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class RealTimeRegionalVehicleInformation extends RealTimeVehicleInformation {
    private Double radius;
    @Override
    public Query getQuery(String orderBy) {
        Query query = super.getQuery(orderBy);
        query.addCriteria(Criteria.where("position").within(new Circle(getLongitude(),getLatitude(),getRadius())));
        return query;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}
