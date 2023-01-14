/*	Aplikasi yang berorientasi objek adalah
 * 	aplikasi di dalamnya terdapat objek-objek
 *	yang bekerja dengan menggunakan method-methodnya
 */	

package com.mercubuana.minggu06;

import java.util.Scanner;

public class LatihanPerkalian {

	private int jawaban;
	private int bil1;
	private int bil2;
	private String soal;
	private int hasil;

	public static void main(String[] args) {	
		//1. Membuat objek 	 
		LatihanPerkalian app = new LatihanPerkalian();
		/*2. Melakukan inisialisasi dengan cara memanggil
		 *	 method dari objek class aplikasi
		 */
		app.init();
		
	}
	
	void init() {
		//1. Membuat soal dan menampilkannya
		buatSoalBaru();
		//2. Menerima input jawaban dari user
		inputJawabanUser();
		//3. Memeriksa jawaban user
		periksaJawabanUser();
	}
	
	void buatSoalBaru() {
		bil1 = 0;
		bil2 = 0;
		bil1 = (int) (Math.random()*10+1);
		bil2 = (int) (Math.random()*10+1);
		hasil = 0;
		hasil = bil1 * bil2;
		soal = "";
		soal = String.format("%s x %s = ?", bil1, bil2);
		//4. Menampilkan soal
		System.out.println(soal);
	}
	
	void inputJawabanUser() {
		//1. Membuat objek scanner
		Scanner s = new Scanner(System.in);
		//2. Menerima input dari console
		String input = s.nextLine();
		jawaban = 0;
		jawaban = Integer.parseInt(input);
	}
	
	void periksaJawabanUser() {
		
		/* 1. Jika jawaban sama dengan hasil perkalian,
		 * 	  maka tampilkan pesan "Benar"
		 */
		if (jawaban == hasil) {
			String pesan = "";
			pesan = String.format("Benar, "
					+ "%s x %s = %s",
					bil1, bil2, hasil);
			System.out.println(pesan);
		} else {
			String pesan = "";
			pesan = String.format("Maaf, "
					+ "jawaban masih salah.\n"
					+ "Yang benar adalah "
					+ "%s x %s = %s",
					bil1, bil2, hasil);
			System.out.println(pesan);	
		}				
	}
}
