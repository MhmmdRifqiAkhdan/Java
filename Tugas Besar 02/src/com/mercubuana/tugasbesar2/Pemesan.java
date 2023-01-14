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

public class Pemesan {
	public Pemesan() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_PEMESAN_KONSERID_KONSER) {
			this.konserid_konser = (com.mercubuana.tugasbesar2.Konser) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int idPemesan;
	
	private String namaPemesan;
	
	private char jenisTiket;
	
	private java.util.Date tanggalPemesanan;
	
	private com.mercubuana.tugasbesar2.Konser konserid_konser;
	
	private void setIdPemesan(int value) {
		this.idPemesan = value;
	}
	
	public int getIdPemesan() {
		return idPemesan;
	}
	
	public int getORMID() {
		return getIdPemesan();
	}
	
	public void setNamaPemesan(String value) {
		this.namaPemesan = value;
	}
	
	public String getNamaPemesan() {
		return namaPemesan;
	}
	
	public void setJenisTiket(char value) {
		this.jenisTiket = value;
	}
	
	public char getJenisTiket() {
		return jenisTiket;
	}
	
	public void setTanggalPemesanan(java.util.Date value) {
		this.tanggalPemesanan = value;
	}
	
	public java.util.Date getTanggalPemesanan() {
		return tanggalPemesanan;
	}
	
	public void setKonserid_konser(com.mercubuana.tugasbesar2.Konser value) {
		if (konserid_konser != null) {
			konserid_konser.pemesan.remove(this);
		}
		if (value != null) {
			value.pemesan.add(this);
		}
	}
	
	public com.mercubuana.tugasbesar2.Konser getKonserid_konser() {
		return konserid_konser;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Konserid_konser(com.mercubuana.tugasbesar2.Konser value) {
		this.konserid_konser = value;
	}
	
	private com.mercubuana.tugasbesar2.Konser getORM_Konserid_konser() {
		return konserid_konser;
	}
	
	public String toString() {
		return String.valueOf(getIdPemesan());
	}
	
}
