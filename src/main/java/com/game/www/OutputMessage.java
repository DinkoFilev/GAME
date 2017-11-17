package com.game.www;

public class OutputMessage {

	private String from;
	private String text;
	private String time;



	public OutputMessage(String from, String text, String time) {
		super();
		this.from = from;
		this.text = text;
		this.time = time;
	}

	public void setFrom(String from) {
		this.from = from;

	}

	public String getFrom() {
		return this.from;
	}

	public void setText(String text) {
		this.text = text;

	}

	public String getText() {
		return this.text;
	}

	public void setTime(String time) {
		this.text = time;

	}

	public String getTime() {
		return this.time;
	}
}
