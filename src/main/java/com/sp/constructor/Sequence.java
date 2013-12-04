package com.sp.constructor;

public class Sequence {
	private String prefix;
	private String suffix;
	private int 	initial;
	
	public Sequence(String prefix, String suffix) {
		this.prefix = prefix;
		this.suffix = suffix;
	}
	
	public Sequence(String prefix, int initial) {
		this.prefix = prefix;
		this.initial = initial;
	}

	
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public int getInitial() {
		return initial;
	}

	public void setInitial(int initial) {
		this.initial = initial;
	}

	@Override
	public String toString() {
		return this.prefix + " " + this.suffix + " " + this.initial;
	}
}
