package com.mercubuana.minggu08;

import java.io.Serializable;

public class Buku implements Serializable {
	private String judulBuku = "";
	private char jenisBuku = 'M';
	int stokBuku = 0;
	private int sisaTempat = 0;
	
	public Buku(String judulBuku, char jenisBuku, int stokBuku) {
		super();
		this.judulBuku = judulBuku;
		this.jenisBuku = jenisBuku;
		this.stokBuku = stokBuku;
		this.sisaTempat = stokBuku; 
	}

	public String getJudulBuku() {
		return judulBuku;
	}

	public void setJudulBuku(String judulBuku) {
		this.judulBuku = judulBuku;
	}

	public char getJenisBuku() {
		return jenisBuku;
	}

	public void setJenisBuku(char jenisBuku) {
		this.jenisBuku = jenisBuku;
	}

	public int getStokBuku() {
		return stokBuku;
	}

	public void setStokBuku(int stokBuku) {
		this.stokBuku = stokBuku;
	}

	public int getSisaTempat() {
		return sisaTempat;
	}

	public void setSisaTempat(int sisaTempat) {
		this.sisaTempat = sisaTempat;
	}
	
	public String toString() {
//		return judulBuku;
		return String.valueOf(getJudulBuku());
		
		
		
	}
	
	
	

}
