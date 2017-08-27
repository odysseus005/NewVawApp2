package jazevangelio.newvawepp.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class NearCompany extends RealmObject {

    @PrimaryKey
    @SerializedName("company_id")
    @Expose
    private Integer companyId;
    @SerializedName("name")
    @Expose
    private String companyName;
    @SerializedName("description")
    @Expose
    private String companyInfo;
    @SerializedName("contact")
    @Expose
    private String companyContact;
    @SerializedName("hours")
    @Expose
    private String companyHours;
    @SerializedName("opening")
    @Expose
    private String companyHoursOpen;

    @SerializedName("closinge")
    @Expose
    private String companyHoursClose;
    @SerializedName("lat")
    @Expose
    private Double companyLat;
    @SerializedName("lng")
    @Expose
    private Double companyLng;
    @SerializedName("slot")
    @Expose
    private Integer companySlotLeft;
    @SerializedName("image")
    @Expose
    private String companyImage;


    @SerializedName("days")
    @Expose
    private String companyDays;

    @SerializedName("address")
    @Expose
    private String companyAddress;

    private double distance;


    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }


    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }


    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }



    public String getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    public String getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(String companyContact) {
        this.companyContact = companyContact;
    }

    public String getCompanyHours() {
        return companyHours;
    }

    public void setCompanyHours(String companyHours) {
        this.companyHours = companyHours;
    }

    public Double getCompanyLat() {
        return companyLat;
    }

    public void setCompanyLat(Double companyLat) {
        this.companyLat = companyLat;
    }

    public Double getCompanyLng() {
        return companyLng;
    }

    public void setCompanyLng(Double companyLng) {
        this.companyLng = companyLng;
    }

    public Integer getCompanySlotLeft() {
        return companySlotLeft;
    }

    public void setCompanySlotLeft(Integer companySlotLeft) {
        this.companySlotLeft = companySlotLeft;
    }
    public String getCompanyImage() {
        return companyImage;
    }

    public void setCompanyImage(String companyImage) {
        this.companyImage = companyImage;
    }

    public String getCompanyHoursOpen() {
        return companyHoursOpen;
    }

    public void setCompanyHoursOpen(String companyHoursOpen) {
        this.companyHoursOpen = companyHoursOpen;
    }

    public String getCompanyHoursClose() {
        return companyHoursClose;
    }

    public void setCompanyHoursClose(String companyHoursClose) {
        this.companyHoursClose = companyHoursClose;
    }
    public String getCompanyDays() {
        return companyDays;
    }

    public void setCompanyDays(String companyDays) {
        this.companyDays = companyDays;
    }

}
