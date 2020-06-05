package com.jinyuan.project.domain;

public class TManager {
	private Integer _id;
	private String account;
	private String password;
	private String name;
	private String mobile;
	private String weixin;
	private String photo;
	private String create_date;
	private Integer level;
	private Integer state;
	
	public TManager() {}

	public TManager(Integer _id, String account, String password, String name, String mobile, String weixin, String photo, String create_date, Integer level, Integer state) {
		this._id = _id;
		this.account = account;
		this.password = password;
		this.name = name;
		this.mobile = mobile;
		this.weixin = weixin;
		this.photo = photo;
		this.create_date = create_date;
		this.level = level;
		this.state = state;
	}

	public Integer get_id() {
		return _id;
	}

	public void set_id(Integer _id) {
		this._id = _id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}
