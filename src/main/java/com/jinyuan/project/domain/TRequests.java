package com.jinyuan.project.domain;

public class TRequests {
	private Integer _id;
	private Integer _owner;
	private String thing_name;
	private Float new_old;
	private String memo;
	private Float price_low;
	private Float price_high;
	private Integer exchangeable;
	private String publish_date;
	private Integer _thing;
	private Integer finished;
	private String finished_date;
	private Integer _thing2;
	private Float price;
	private Integer request_provider;
	private Integer isComplaint;
	private Integer isResist;
	private Integer isJudged;

	public TRequests(){}

	public TRequests(Integer _id, Integer _owner, String thing_name, Float new_old, String memo, Float price_low, Float price_high, Integer exchangeable, String publish_date, Integer _thing, Integer finished, String finished_date, Integer _thing2, Float price, Integer request_provider, Integer isComplaint, Integer isResist, Integer isJudged) {
		this._id = _id;
		this._owner = _owner;
		this.thing_name = thing_name;
		this.new_old = new_old;
		this.memo = memo;
		this.price_low = price_low;
		this.price_high = price_high;
		this.exchangeable = exchangeable;
		this.publish_date = publish_date;
		this._thing = _thing;
		this.finished = finished;
		this.finished_date = finished_date;
		this._thing2 = _thing2;
		this.price = price;
		this.request_provider = request_provider;
		this.isComplaint = isComplaint;
		this.isResist = isResist;
		this.isJudged = isJudged;
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

	public Float getPrice_low() {
		return price_low;
	}

	public void setPrice_low(Float price_low) {
		this.price_low = price_low;
	}

	public Float getPrice_high() {
		return price_high;
	}

	public void setPrice_high(Float price_high) {
		this.price_high = price_high;
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

	public Integer get_thing() {
		return _thing;
	}

	public void set_thing(Integer _thing) {
		this._thing = _thing;
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

	public Integer get_thing2() {
		return _thing2;
	}

	public void set_thing2(Integer _thing2) {
		this._thing2 = _thing2;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getRequest_provider() {
		return request_provider;
	}

	public void setRequest_provider(Integer request_provider) {
		this.request_provider = request_provider;
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
}
