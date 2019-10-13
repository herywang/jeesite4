package top.cangtai.statistics.entity;

import java.util.List;

public class Statistics {
    private List<Double> numCarss;
    private List<Double> vehicleSpeeds;
    private List<Double> carbonDioxides;
    private List<Double> oils;
    private List<String> times;

    public List<Double> getNumCarss() {
        return numCarss;
    }

    public void setNumCarss(List<Double> numCarss) {
        this.numCarss = numCarss;
    }

    public List<Double> getVehicleSpeeds() {
        return vehicleSpeeds;
    }

    public void setVehicleSpeeds(List<Double> vehicleSpeeds) {
        this.vehicleSpeeds = vehicleSpeeds;
    }

    public List<Double> getCarbonDioxides() {
        return carbonDioxides;
    }

    public void setCarbonDioxides(List<Double> carbonDioxides) {
        this.carbonDioxides = carbonDioxides;
    }

    public List<Double> getOils() {
        return oils;
    }

    public void setOils(List<Double> oils) {
        this.oils = oils;
    }

    public List<String> getTimes() {
        return times;
    }

    public void setTimes(List<String> times) {
        this.times = times;
    }
}
