package xyz.cryptomaven.mq.maplmq;

import java.io.Serializable;

public class Claim implements Serializable {

    private static final long serialVersionUID = 1L;
    private int hospitalId;
    private String doctorName;
    private String doctorType;
    private String insuranceProvider;
    private double claimAmount;

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public String getInsuranceProvider() {
        return insuranceProvider;
    }

    public void setInsuranceProvider(String insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
