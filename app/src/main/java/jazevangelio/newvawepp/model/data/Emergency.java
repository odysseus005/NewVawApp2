package jazevangelio.newvawepp.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Emergency extends RealmObject {

    @PrimaryKey
    @SerializedName("emergency_id")
    @Expose
    private int userId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("contact")
    @Expose
    private String contact;
    @SerializedName("image")
    @Expose
    private String image;




    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }




    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }





}
