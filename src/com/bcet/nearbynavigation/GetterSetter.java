package com.bcet.nearbynavigation;

public class GetterSetter {
	String name="",address="",distance="",image="";
	double lat=0,log=0;

	public void setLat(double lat) {
		this.lat = lat;
	}

	public void setLog(double log) {
		this.log = log;
	}

	public double getLat() {
		return lat;
	}

	public double getLog() {
		return log;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}	
}


