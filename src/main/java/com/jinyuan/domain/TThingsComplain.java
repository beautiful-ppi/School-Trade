package com.jinyuan.domain;

public class TThingsComplain {
	private Integer _id;
	private Integer _thing;
	private String because;
	private String memo;
	private String complain_date;
	private String photo;
	
	public TThingsComplain() {}

	public TThingsComplain(Integer _id, Integer _thing, String because, String memo, String complain_date, String photo) {
		this._id = _id;
		this._thing = _thing;
		this.because = because;
		this.memo = memo;
		this.complain_date = complain_date;
		this.photo = photo;
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

	public String getBecause() {
		return because;
	}

	public void setBecause(String because) {
		this.because = because;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getComplain_date() {
		return complain_date;
	}

	public void setComplain_date(String complain_date) {
		this.complain_date = complain_date;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
