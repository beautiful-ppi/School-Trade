package com.jinyuan.domain;

public class TRequestMatch {
	private Integer _id;
	private Integer _user;
	private String title;
	private String message;
	private String message_date;
	private Integer _thing;
	private Integer isRead;
	
	public TRequestMatch() {}

	public TRequestMatch(Integer _id, Integer _user, String title, String message, String message_date, Integer _thing, Integer isRead) {
		this._id = _id;
		this._user = _user;
		this.title = title;
		this.message = message;
		this.message_date = message_date;
		this._thing = _thing;
		this.isRead = isRead;
	}

	public Integer get_id() {
		return _id;
	}

	public void set_id(Integer _id) {
		this._id = _id;
	}

	public Integer get_user() {
		return _user;
	}

	public void set_user(Integer _user) {
		this._user = _user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage_date() {
		return message_date;
	}

	public void setMessage_date(String message_date) {
		this.message_date = message_date;
	}

	public Integer get_thing() {
		return _thing;
	}

	public void set_thing(Integer _thing) {
		this._thing = _thing;
	}

	public Integer getIsRead() {
		return isRead;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}
}
