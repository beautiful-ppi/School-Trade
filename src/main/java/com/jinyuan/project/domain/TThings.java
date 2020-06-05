package com.jinyuan.project.domain;

public class TThings {
	private Integer _id;
	private Integer _owner;
	private String thing_name;
	private Float new_old;
	private String memo;
	private Float price;
	private Integer exchangeable;
	private String publish_date;
	private Integer finished;
	private String finished_date;
	private Integer _thing;
	private Integer _buyer;
	private Integer isComplaint;
	private Integer isResist;
	private Integer isJudged;
	private String picture1;
	private String picture2;
	private String picture3;
	
	public TThings() {
		
	}

	public TThings(Integer _id, Integer _owner, String thing_name, Float new_old, String memo, Float price, Integer exchangeable, String publish_date, Integer finished, String finished_date, Integer _thing, Integer _buyer, Integer isComplaint, Integer isResist, Integer isJudged, String picture1, String picture2, String picture3) {
		this._id = _id;
		this._owner = _owner;
		this.thing_name = thing_name;
		this.new_old = new_old;
		this.memo = memo;
		this.price = price;
		this.exchangeable = exchangeable;
		this.publish_date = publish_date;
		this.finished = finished;
		this.finished_date = finished_date;
		this._thing = _thing;
		this._buyer = _buyer;
		this.isComplaint = isComplaint;
		this.isResist = isResist;
		this.isJudged = isJudged;
		this.picture1 = picture1;
		this.picture2 = picture2;
		this.picture3 = picture3;
	}

	public Integer get_id() {
		return _id;
	}

	public void set_id(Integer _id) {
		this._id = _id;
	}

	public Integer get_owner() {
		return _owner;
	}

	public void set_owner(Integer _owner) {
		this._owner = _owner;
	}

	public String getThing_name() {
		return thing_name;
	}

	public void setThing_name(String thing_name) {
		this.thing_name = thing_name;
	}

	public Float getNew_old() {
		return new_old;
	}

	public void setNew_old(Float new_old) {
		this.new_old = new_old;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getExchangeable() {
		return exchangeable;
	}

	public void setExchangeable(Integer exchangeable) {
		this.exchangeable = exchangeable;
	}

	public String getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}

	public Integer getFinished() {
		return finished;
	}

	public void setFinished(Integer finished) {
		this.finished = finished;
	}

	public String getFinished_date() {
		return finished_date;
	}

	public void setFinished_date(String finished_date) {
		this.finished_date = finished_date;
	}

	public Integer get_thing() {
		return _thing;
	}

	public void set_thing(Integer _thing) {
		this._thing = _thing;
	}

	public Integer get_buyer() {
		return _buyer;
	}

	public void set_buyer(Integer _buyer) {
		this._buyer = _buyer;
	}

	public Integer getIsComplaint() {
		return isComplaint;
	}

	public void setIsComplaint(Integer isComplaint) {
		this.isComplaint = isComplaint;
	}

	public Integer getIsResist() {
		return isResist;
	}

	public void setIsResist(Integer isResist) {
		this.isResist = isResist;
	}

	public Integer getIsJudged() {
		return isJudged;
	}

	public void setIsJudged(Integer isJudged) {
		this.isJudged = isJudged;
	}

	public String getPicture1() {
		return picture1;
	}

	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}

	public String getPicture2() {
		return picture2;
	}

	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}

	public String getPicture3() {
		return picture3;
	}

	public void setPicture3(String picture3) {
		this.picture3 = picture3;
	}
}
