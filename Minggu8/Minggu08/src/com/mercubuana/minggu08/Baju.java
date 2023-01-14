//Codingan class baju

package com.mercubuana.minggu08;

import java.io.Serializable;

public class Baju implements Serializable {
	private String namaBaju = "";
	private char jenisBaju = 'C';
	private int jumlah = 0;
	private int sisaBaju = 0;
	public Baju(String namaBaju, char jenisBaju, int jumlah, int sisaBaju) {
		super();
		this.namaBaju = namaBaju;
		this.jenisBaju = jenisBaju;
		this.jumlah = jumlah;
		this.sisaBaju = jumlah;
	}
	public String getNamaBaju() {
		return namaBaju;
	}
	public void setNamaBaju(String namaBaju) {
		this.namaBaju = namaBaju;
	}
	public char getJenisBaju() {
		return jenisBaju;
	}
	public void setJenisBaju(char jenisBaju) {
		this.jenisBaju = jenisBaju;
	}
	public int getJumlah() {
		return jumlah;
	}
	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}
	public int getSisaBaju() {
		return sisaBaju;
	}
	public void setSisaBaju(int sisaBaju) {
		this.sisaBaju = sisaBaju;
	}
	public String toString() {
		return namaBaju;
	}
	
}
