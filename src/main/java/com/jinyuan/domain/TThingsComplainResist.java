package com.jinyuan.domain;

import java.lang.ref.PhantomReference;

public class TThingsComplainResist {
	private Integer _id;
	private Integer _complain;
	private String resist;
	private String resist_date;
	
	public TThingsComplainResist() {}

	public TThingsComplainResist(Integer _id, Integer _complain, String resist, String resist_date) {
		this._id = _id;
		this._complain = _complain;
		this.resist = resist;
		this.resist_date = resist_date;
	}

	public Integer get_id() {
		return _id;
	}

	public void set_id(Integer _id) {
		this._id = _id;
	}

	public Integer get_complain() {
		return _complain;
	}

	public void set_complain(Integer _complain) {
		this._complain = _complain;
	}

	public String getResist() {
		return resist;
	}

	public void setResist(String resist) {
		this.resist = resist;
	}

	public String getResist_date() {
		return resist_date;
	}

	public void setResist_date(String resist_date) {
		this.resist_date = resist_date;
	}
}
