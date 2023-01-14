package com.mercubauna.minggu08;

public class Kamar {
	/* Daftar atribut/field/variabel global */
	private String namaKamar = "";
	private char jenisKelamin = 'L';
	private int Kapasitas = 0;
	private int sisaTempat = 0;
	
	/*Constuctor, yaitu method khusus yang dipanggil 
	 * ketika objek dari class dibuat
	 */
	
	public Kamar(String namaKamar, char jenisKelamin, int kapasitas) {
		super();
		this.namaKamar = namaKamar;
		this.jenisKelamin = jenisKelamin;
		this.Kapasitas = kapasitas;
		
	}

	public String getNamaKamar() {
		return namaKamar;
	}

	public void setNamaKamar(String namaKamar) {
		this.namaKamar= namaKamar;
	}

	public char getjenisKelamin() {
		return jenisKelamin;
	}

	public void setJenisKelamin(char jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}

	public int getKapasitas() {
		return Kapasitas;
	}

	public void setKapasitas(int kapasitas) {
		this.Kapasitas= ;
	}

	
	/* Method Getter dan Setter */
	
	
	
}