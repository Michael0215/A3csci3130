package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Contact implements Serializable {

    public  String uid;
    public  String name;
    public  String email;
    public  String bn;
    public  String pb;
    public  String Ad;
    public  String p;
    public Contact() {

        // Default constructor required for calls to DataSnapshot.getValue
    }

    public Contact(String uid, String name, String email,String bn, String pb,String Ad, String p){//constructor
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.bn = bn;
        this.pb = pb;
        this.Ad = Ad;
        this.p = p;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);
        result.put("email", email);
        result.put("business number", bn);
        result.put("primary business", pb);
        result.put("address", Ad);
        result.put("provincet", p);

        return result;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getUid() {
        return uid;
    }
}
