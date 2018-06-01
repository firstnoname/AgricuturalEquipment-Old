package se.is.agriculturalequipment.model;

import java.io.Serializable;

/**
 * Created by BlackClover on 10/31/2017.
 */

public class TM31 implements Serializable {

    private String id_customer, identification_no, name;
    private String engineStatus, airChamber, sealSet, adjustSet, dischargeMetal;
    private String suctionMetal;
    private String pistonSet;
    private String starterRopeReel;
    private String pressureGauge;
    private String ballValveSwitch;
    private String oilFilter;
    private String newPaint;
    private String oilTankCap;
    private String dealStatus;
    private String buyDate;
    private String amount;

    public TM31() {

    }

    public TM31(String id_customer, String identification_no, String name, String engineStatus, String airChamber, String sealSet, String adjustSet, String dischargeMetal, String suctionMetal, String pistonSet, String starterRopeReel, String pressureGauge, String ballValveSwitch, String oilFilter, String newPaint, String oilTankCap, String dealStatus, String buyDate, String amount) {
        this.id_customer = id_customer;
        this.identification_no = identification_no;
        this.name = name;
        this.engineStatus = engineStatus;
        this.airChamber = airChamber;
        this.sealSet = sealSet;
        this.adjustSet = adjustSet;
        this.dischargeMetal = dischargeMetal;
        this.suctionMetal = suctionMetal;
        this.pistonSet = pistonSet;
        this.starterRopeReel = starterRopeReel;
        this.pressureGauge = pressureGauge;
        this.ballValveSwitch = ballValveSwitch;
        this.oilFilter = oilFilter;
        this.newPaint = newPaint;
        this.oilTankCap = oilTankCap;
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

    public String getEngineStatus() {
        return engineStatus;
    }

    public void setEngineStatus(String engineStatus) {
        this.engineStatus = engineStatus;
    }

    public String getAirChamber() {
        return airChamber;
    }

    public void setAirChamber(String airChamber) {
        this.airChamber = airChamber;
    }

    public String getSealSet() {
        return sealSet;
    }

    public void setSealSet(String sealSet) {
        this.sealSet = sealSet;
    }

    public String getAdjustSet() {
        return adjustSet;
    }

    public void setAdjustSet(String adjustSet) {
        this.adjustSet = adjustSet;
    }

    public String getDischargeMetal() {
        return dischargeMetal;
    }

    public void setDischargeMetal(String dischargeMetal) {
        this.dischargeMetal = dischargeMetal;
    }

    public String getSuctionMetal() {
        return suctionMetal;
    }

    public void setSuctionMetal(String suctionMetal) {
        this.suctionMetal = suctionMetal;
    }

    public String getPistonSet() {
        return pistonSet;
    }

    public void setPistonSet(String pistonSet) {
        this.pistonSet = pistonSet;
    }

    public String getStarterRopeReel() {
        return starterRopeReel;
    }

    public void setStarterRopeReel(String starterRopeReel) {
        this.starterRopeReel = starterRopeReel;
    }

    public String getPressureGauge() {
        return pressureGauge;
    }

    public void setPressureGauge(String pressureGauge) {
        this.pressureGauge = pressureGauge;
    }

    public String getBallValveSwitch() {
        return ballValveSwitch;
    }

    public void setBallValveSwitch(String ballValveSwitch) {
        this.ballValveSwitch = ballValveSwitch;
    }

    public String getOilFilter() {
        return oilFilter;
    }

    public void setOilFilter(String oilFilter) {
        this.oilFilter = oilFilter;
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

    public String getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}

