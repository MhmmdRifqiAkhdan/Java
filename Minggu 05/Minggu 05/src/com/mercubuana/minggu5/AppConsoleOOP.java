package com.mercubuana.minggu5;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class AppConsoleOOP {
	public static void main(String[] args) {
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
		//1e. Konversi dari String ke Double
		double bil1 = 0;
		bil1 = Double.parseDouble(temp);
		
		//2. Input bilangan 2
		//2a. Membuat prompt untuk input bilangan 2
		System.out.print("Bilangan 2 : ");
		//2b. Menerima input string dari keyboard
		temp = s.nextLine();
		//2c. Konversi dari String ke Double
		double bil2 = 0;
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
		
		//4. Menampilkan hasil berdasarkan pilihan operasi
		double hasil = 0;
		switch (pilihan) {
		case 1:
			hasil = bil1 + bil2;
			temp = String.format("%s + %s = %s", bil1, bil2, hasil);
			System.out.println(temp);
			break;
		case 2:
			hasil = bil1 - bil2;
			temp = String.format("%s - %s = %s", bil1, bil2, hasil);
			System.out.println(temp);
			break;
		case 3:
			hasil = bil1 * bil2;
			temp = String.format("%s x %s = %s", bil1, bil2, hasil);
			System.out.println(temp);
			break;
		case 4:
			hasil = bil1 / bil2;
			temp = String.format("%s : %s = %s", bil1, bil2, hasil);
			System.out.println(temp);
			break;
		}
	}
}