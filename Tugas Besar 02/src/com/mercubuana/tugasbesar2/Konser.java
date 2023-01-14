/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package com.mercubuana.tugasbesar2;

public class Konser {
	public Konser() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_KONSER_PEMESAN) {
			return ORM_pemesan;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int idKonser;
	
	private String namaKonser;
	
	private char jenisTiket;
	
	private int jumlahTiket;
	
	private int sisaTiket;
	
	private java.util.Set ORM_pemesan = new java.util.HashSet();
	
	private void setIdKonser(int value) {
		this.idKonser = value;
	}
	
	public int getIdKonser() {
		return idKonser;
	}
	
	public int getORMID() {
		return getIdKonser();
	}
	
	public void setNamaKonser(String value) {
		this.namaKonser = value;
	}
	
	public String getNamaKonser() {
		return namaKonser;
	}
	
	public void setJenisTiket(char value) {
		this.jenisTiket = value;
	}
	
	public char getJenisTiket() {
		return jenisTiket;
	}
	
	public void setJumlahTiket(int value) {
		this.jumlahTiket = value;
	}
	
	public int getJumlahTiket() {
		return jumlahTiket;
	}
	
	public void setSisaTiket(int value) {
		this.sisaTiket = value;
	}
	
	public int getSisaTiket() {
		return sisaTiket;
	}
	
	private void setORM_Pemesan(java.util.Set value) {
		this.ORM_pemesan = value;
	}
	
	private java.util.Set getORM_Pemesan() {
		return ORM_pemesan;
	}
	
	public final com.mercubuana.tugasbesar2.PemesanSetCollection pemesan = new com.mercubuana.tugasbesar2.PemesanSetCollection(this, _ormAdapter, ORMConstants.KEY_KONSER_PEMESAN, ORMConstants.KEY_PEMESAN_KONSERID_KONSER, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		//return String.valueOf(getIdKonser());
		return String.valueOf(getNamaKonser());
	}
	
}
