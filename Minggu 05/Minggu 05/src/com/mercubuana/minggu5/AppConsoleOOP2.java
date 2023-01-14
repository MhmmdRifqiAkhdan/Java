package com.mercubuana.minggu5;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class AppConsoleOOP2 {
	double bil1;
	double bil2;
	double hasil;
	
	public static void main(String[] args) {
		//1. Membuat objek dari class aplikasi
		AppConsoleOOP2 app = new AppConsoleOOP2();
		//2. Memanggil method init
		app.init();
	}
	
	void init() {
		JOptionPane.showMessageDialog(null, "Selamat datang di Kalkulator");
		System.out.println("--------------");
		System.out.println("- Kalkulator -");
		System.out.println("--------------");

		//1. Input bilangan 1
		//1a. Membuat prompt untuk input bilangan 1
		System.out.print("Bilangan 1 : ");
		//1b. Buat Scanner
		Scanner s = new Scanner(System.in);
		//1c. Deklarasikan string temp
		String temp = "";
		//1d. Menerima input string dari keyboard
		temp = s.nextLine();
		bil1 = 0;
		bil1 = Double.parseDouble(temp);
		
		//2. Input bilangan 2
		//2a. Membuat prompt untuk input bilangan 2
		System.out.print("Bilangan 2 : ");
		//2b. Menerima input string dari keyboard
		temp = s.nextLine();
		bil2 = 0;
		bil2 = Double.parseDouble(temp);
		
		//3. Input pilihan operasi (+, -, x, :)
		//3a. Menampilkan menu pilihan
		System.out.println("");
		System.out.println("1. Penjumlahan");
		System.out.println("2. Pengurangan");
		System.out.println("3. Perkalian");
		System.out.println("4. Pembagian");
		System.out.println("");
		//3b. Menampilkan prompt untuk input pilihan
		System.out.print("Silahkan ketikkan pilihan operasi (1-4): ");
		//3c. Menerima input pilihan
		temp = s.nextLine();
		int pilihan = 0;
		pilihan = Integer.parseInt(temp);
		
		hasil = 0;
		
		switch (pilihan) {
		case 1:
			penjumlahan();
			break;
		case 2:
			pengurangan();
			break;
		case 3:
			perkalian();
			break;
		case 4:
			pembagian();
			break;
		}
		
//		switch (pilihan) {
//		case 1:
//			hasil = bil1 + bil2;
//			temp = String.format("%s + %s = %s", bil1, bil2, hasil);
//			System.out.println(temp);
//			break;
//		case 2:
//			hasil = bil1 - bil2;
//			temp = String.format("%s - %s = %s", bil1, bil2, hasil);
//			System.out.println(temp);
//			break;
//		case 3:
//			hasil = bil1 * bil2;
//			temp = String.format("%s x %s = %s", bil1, bil2, hasil);
//			System.out.println(temp);
//			break;
//		case 4:
//			hasil = bil1 / bil2;
//			temp = String.format("%s : %s = %s", bil1, bil2, hasil);
//			System.out.println(temp);
//			break;
//		}
	}
	
	void penjumlahan() {
		hasil = bil1 + bil2;
		String tampilan = "";
		tampilan = String.format("%s + %s = %s", bil1, bil2, hasil);
		System.out.println(tampilan);
	}
	
	void pengurangan() {
		hasil = bil1 - bil2;
		String tampilan = "";
		tampilan = String.format("%s - %s = %s", bil1, bil2, hasil);
		System.out.println(tampilan);
	}
	
	void perkalian() {
		hasil = bil1 * bil2;
		String tampilan = "";
		tampilan = String.format("%s x %s = %s", bil1, bil2, hasil);
		System.out.println(tampilan);
	}
	
	void pembagian() {
		hasil = bil1 / bil2;
		String tampilan = "";
		tampilan = String.format("%s : %s = %s", bil1, bil2, hasil);
		System.out.println(tampilan);
	}
	
}