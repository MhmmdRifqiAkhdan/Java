package com.umb.minggu01;

import java.util.Scanner;

public class InputOutput {

	public static void main(String[] args) {
		//1. Menampikan output pada layar komputer
		System.out.println("Hai, mahasiswa UMB");
		//2. Menampilkan prompt untuk input data
		System.out.print("Silakan ketikkan nama anda: ");
		//3. Menerima input dari keyboard
		/* 3a. Membuat objek Scanner dan meminta objek
		 * scanner untuk menerima input dari System.in
		 * (dari keyboard melalui layar console)
		 */
		Scanner s = new Scanner(System.in);
		/* 3b. Mendeklarasikan variabel String untuk
		 * menyimpan nilai yang diketikkan dari keyboard
		 * dan melakukan inisialisasi terhadap string
		 */
		String namaUser = "";
		/* 3c. Menunggu user mengetikkan namanya dari
		 * keyboard, dengan bantuan objek Scanner
		 */
		namaUser = s.nextLine();
		//4. Menggabungkan string untuk menyapa user
		System.out.println("Selamat pagi, " + namaUser);
	}

}
