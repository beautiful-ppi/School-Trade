package com.jinyuan.domain;

public class TThingsComplainJudge {
	private Integer _id;
	private Integer _complain;
	private String judge;
	private String judge_date;
	private Integer isAccepted;
	
	public TThingsComplainJudge() {}

	public TThingsComplainJudge(Integer _id, Integer _complain, String judge, String judge_date, Integer isAccepted) {
		this._id = _id;
		this._complain = _complain;
		this.judge = judge;
		this.judge_date = judge_date;
		this.isAccepted = isAccepted;
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

	public String getJudge() {
		return judge;
	}

	public void setJudge(String judge) {
		this.judge = judge;
	}

	public String getJudge_date() {
		return judge_date;
	}

	public void setJudge_date(String judge_date) {
		this.judge_date = judge_date;
	}

	public Integer getIsAccepted() {
		return isAccepted;
	}

	public void setIsAccepted(Integer isAccepted) {
		this.isAccepted = isAccepted;
	}
}
