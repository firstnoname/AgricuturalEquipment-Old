package se.is.agriculturalequipment.model;

import java.io.Serializable;

/**
 * Created by BlackClover on 10/27/2017.
 */

public class G200 implements Serializable {

    private String id_customer, identification_no, name, id_buy_g200;
    private String engineStatus, starter, fuelTank, airFilter, carburetor;
    private String cylinderSet;
    private String ballValveSwitchOil;
    private String muffler;
    private String switchOnOff;
    private String coil;
    private String fuelTankCap;
    private String newPaint;
    private String oilTankCap;
    private String sparkPlug;
    private String dealStatus;
    private String buyDate;
    private String amount;

    public G200() {

    }

    public G200(String id_customer, String identification_no, String name, String id_buy_g200, String engineStatus, String starter,
                String fuelTank, String airFilter, String carburetor, String cylinderSet,
                String ballValveSwitchOil, String muffler, String switchOnOff, String coil,
                String fuelTankCap, String newPaint, String oilTankCap, String sparkPlug,
                String dealStatus, String buyDate, String amount) {

        this.id_customer = id_customer;
        this.identification_no = identification_no;
        this.name = name;
        this.id_buy_g200 = id_buy_g200;
        this.engineStatus = engineStatus;
        this.starter = starter;
        this.fuelTank = fuelTank;
        this.airFilter = airFilter;
        this.carburetor = carburetor;
        this.cylinderSet = cylinderSet;
        this.ballValveSwitchOil = ballValveSwitchOil;
        this.muffler = muffler;
        this.switchOnOff = switchOnOff;
        this.coil = coil;
        this.fuelTankCap = fuelTankCap;
        this.newPaint = newPaint;
        this.oilTankCap = oilTankCap;
        this.sparkPlug = sparkPlug;
        this.dealStatus = dealStatus;
        this.buyDate = buyDate;
        this.amount = amount;
    }

    public String getId_customer() {
        return id_customer;
    }

    public void setId_customer(String id_customer) {
        this.id_customer = id_customer;
    }

    public String getIdentification_no() {
        return identification_no;
    }

    public void setIdentification_no(String identification_no) {
        this.identification_no = identification_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_buy_g200() {
        return id_buy_g200;
    }

    public void setId_buy_g200(String id_buy_g200){
        this.id_buy_g200 = id_buy_g200;
    }

    public String getEngineStatus() {
        return engineStatus;
    }

    public void setEngineStatus(String engineStatus) {
        this.engineStatus = engineStatus;
    }

    public String getStarter() {
        return starter;
    }

    public void setStarter(String starter) {
        this.starter = starter;
    }

    public String getFuelTank() {
        return fuelTank;
    }

    public void setFuelTank(String fuelTank) {
        this.fuelTank = fuelTank;
    }

    public String getAirFilter() {
        return airFilter;
    }

    public void setAirFilter(String airFilter) {
        this.airFilter = airFilter;
    }

    public String getCarburetor() {
        return carburetor;
    }

    public void setCarburetor(String carburetor) {
        this.carburetor = carburetor;
    }

    public String getCylinderSet() {
        return cylinderSet;
    }

    public void setCylinderSet(String cylinderSet) {
        this.cylinderSet = cylinderSet;
    }

    public String getBallValveSwitchOil() {
        return ballValveSwitchOil;
    }

    public void setBallValveSwitchOil(String ballValveSwitchOil) {
        this.ballValveSwitchOil = ballValveSwitchOil;
    }

    public String getMuffler() {
        return muffler;
    }

    public void setMuffler(String muffler) {
        this.muffler = muffler;
    }

    public String getSwitchOnOff() {
        return switchOnOff;
    }

    public void setSwitchOnOff(String switchOnOff) {
        this.switchOnOff = switchOnOff;
    }

    public String getCoil() {
        return coil;
    }

    public void setCoil(String coil) {
        this.coil = coil;
    }

    public String getFuelTankCap() {
        return fuelTankCap;
    }

    public void setFuelTankCap(String fuelTankCap) {
        this.fuelTankCap = fuelTankCap;
    }

    public String getNewPaint() {
        return newPaint;
    }

    public void setNewPaint(String newPaint) {
        this.newPaint = newPaint;
    }

    public String getOilTankCap() {
        return oilTankCap;
    }

    public void setOilTankCap(String oilTankCap) {
        this.oilTankCap = oilTankCap;
    }

    public String getSparkPlug() {
        return sparkPlug;
    }

    public void setSparkPlug(String sparkPlug) {
        this.sparkPlug = sparkPlug;
    }

    public String getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }
}
