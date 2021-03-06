package br.com.romulo.feedhospital.models;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.romulo.feedhospital.R;

/**
 * Created by romul_000 on 19/03/2016.
 */
public class Hospital implements Serializable{

    private int id;

    private String name;

    private String descrpition;

    private String imageURL;
    private HospitalState state;
    private HospitalState votedState;
    private Address address;
    private ArrayList<Contact> contacts;
    private Double distance;

    public Hospital() {
        this.contacts = new ArrayList<>();
        this.distance =  (double) -1;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
        int rate;

        if(distance < 2500) {
            rate = 0;
        } else if(distance < 6000) {
            rate = 1;
        } else {
            rate = 2;
        }

        float mediaRate = (getState().getValue() + rate) / 2;
        this.setState(HospitalState.fromInt(Math.round(mediaRate)));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrpition() {
        return descrpition;
    }

    public void setDescrpition(String descrpition) {
        this.descrpition = descrpition;
    }

    public HospitalState getState() {
        return this.state;
    }

    public HospitalState getVotedState() {
        return votedState;
    }

    public void setVotedState(HospitalState votedState) {
        this.votedState = votedState;
    }

    public void setState(HospitalState state) {
        this.state = state;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }


}
