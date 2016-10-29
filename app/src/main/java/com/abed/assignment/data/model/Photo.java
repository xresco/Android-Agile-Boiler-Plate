
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

}
