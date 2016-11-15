
package com.abed.assignment.data.model;

import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("id")
    public String id;

    @SerializedName("owner")
    public String owner;

    @SerializedName("secret")
    public String secret;

    @SerializedName("server")
    public String server;

    @SerializedName("farm")
    public Integer farm;

    @SerializedName("title")
    public String title;

    @SerializedName("ispublic")
    public Integer ispublic;

    @SerializedName("isfriend")
    public Integer isfriend;

    @SerializedName("isfamily")
    public Integer isfamily;

    public Photo() {
    }

    public Photo(String id, String owner, String secret, String server, Integer farm, String title, Integer ispublic, Integer isfriend, Integer isfamily) {
        this.id = id;
        this.owner = owner;
        this.secret = secret;
        this.server = server;
        this.farm = farm;
        this.title = title;
        this.ispublic = ispublic;
        this.isfriend = isfriend;
        this.isfamily = isfamily;
    }
}
