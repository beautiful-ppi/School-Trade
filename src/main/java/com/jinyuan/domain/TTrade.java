package com.jinyuan.domain;

public class TTrade {
	private Integer _id;
	private Integer _thing;
	private String finished_date;
	private Integer finished;
	private Float price;
	private Integer getThing;
	private Integer seller_id;
	private Integer buyer_id;
	
	public TTrade() {}

	public TTrade(Integer _id, Integer _thing, String finished_date, Integer finished, Float price, Integer getThing, Integer seller_id, Integer buyer_id) {
		this._id = _id;
		this._thing = _thing;
		this.finished_date = finished_date;
		this.finished = finished;
		this.price = price;
		this.getThing = getThing;
		this.seller_id = seller_id;
		this.buyer_id = buyer_id;
	}

	public Integer get_id() {
		return _id;
	}

	public void set_id(Integer _id) {
		this._id = _id;
	}

	public Integer get_thing() {
		return _thing;
	}

	public void set_thing(Integer _thing) {
		this._thing = _thing;
	}

	public String getFinished_date() {
		return finished_date;
	}

	public void setFinished_date(String finished_date) {
		this.finished_date = finished_date;
	}

	public Integer getFinished() {
		return finished;
	}

	public void setFinished(Integer finished) {
		this.finished = finished;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getGetThing() {
		return getThing;
	}

	public void setGetThing(Integer getThing) {
		this.getThing = getThing;
	}

	public Integer getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(Integer seller_id) {
		this.seller_id = seller_id;
	}

	public Integer getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(Integer buyer_id) {
		this.buyer_id = buyer_id;
	}
}
