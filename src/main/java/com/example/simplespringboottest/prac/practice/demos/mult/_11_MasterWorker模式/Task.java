package com.example.simplespringboottest.prac.practice.demos.mult._11_MasterWorker模式;

public class Task {
	private int id;
	private int price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", price=" + price + "]";
	}
}
