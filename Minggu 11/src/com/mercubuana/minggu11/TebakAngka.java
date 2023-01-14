package com.mercubuana.minggu11;

import java.util.Scanner;
import javax.sound.sampled.*;

public class TebakAngka {

	private Scanner s;

	public static void main(String[] args) {
		TebakAngka app = new TebakAngka();
		app.init();
	}
	
	void init() {
		do {
			System.out.println("*************");
			System.out.println(" Tebak Angka ");
			System.out.println("*************");
			System.out.println();
			System.out.println("1. Tebak Angka Magic");
			System.out.println("2. Tebak Angka Binary Search");
			System.out.println("3. Tebak Surprise");
			System.out.print("Silahkan pilih (1, 2, 3) : ");
			s = new Scanner(System.in);
			String pilihan = s.nextLine();
			switch (pilihan) {
			case "1":
				magic();
				break;
			case "2":
				binarysearch();
				break;
			case "3":
				surprise();
				break;
			}
		} while (true);
	}
	
	void magic() {
		System.out.println("=============");
		System.out.println("= M A G I C =");
		System.out.println("=============");
		System.out.println();
		System.out.print("Ketikkan jumlah kiri-kanan : ");
		int jumlahKiriKanan = Integer.parseInt(s.nextLine());
		System.out.print("Ketikkan jumlah atas-bawah : ");
		int jumlahAtasBawah = Integer.parseInt(s.nextLine());
		System.out.print("Ketikkan jumlah keliling   : ");
		int jumlahKeliling = Integer.parseInt(s.nextLine());
		System.out.print("Angka di tengah adalah     : ");
		int angkaDiTengah = (jumlahKiriKanan + jumlahAtasBawah - jumlahKeliling) / 2;
		System.out.println(angkaDiTengah);
		System.out.print("Tekan ENTER untuk kembali ke menu...");
		s.nextLine();
		System.out.println("\n\n");
		return;
	}
	
	void binarysearch() {
		
	}

	void surprise() {
			int acak = (int) (Math.random() * 100);
		do {
			System.out.println();
			System.out.println(acak);
			System.out.print("Silahkan tebak (1 - 100) : ");
			int jawab = Integer.parseInt(s.nextLine());
			if (jawab == acak) {
				try {
					Sound.tone(1000, 1000);
					Sound.tone(1200, 1000);
					Sound.tone(1400, 1000);
					Sound.tone(1600, 1000);
					Sound.tone(1800, 1000);
					Sound.tone(2000, 1000);
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return;
			} else if (jawab < acak) {
				System.out.println("Terlalu kecil");
				try {
					Sound.tone(2000 - (acak - jawab) * 10, 500);
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (jawab > acak) {
				System.out.println("Terlalu besar");
				try {
					Sound.tone(2000 + (acak - jawab) * 10, 500);
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (jawab == 0) {
				System.out.println("Yang benar = " + acak);
			} 
		} while (true);
	}

}

class Sound
{
    public static float SAMPLE_RATE = 8000f;
    public static void tone(int hz, int msecs) 
    throws LineUnavailableException 
    {
        tone(hz, msecs, 1.0);
    }

    public static void tone(int hz, int msecs, double vol)
    throws LineUnavailableException 
    {
        byte[] buf = new byte[1];
        AudioFormat af = new AudioFormat(SAMPLE_RATE,8,1,true,false);     
        SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
        sdl.open(af);
        sdl.start();
        for (int i=0; i < msecs*8; i++) {
              double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
              buf[0] = (byte)(Math.sin(angle) * 127.0 * vol);
              sdl.write(buf,0,1);
        }
        sdl.drain();
        sdl.stop();
        sdl.close();
    }

    public static void main(String[] args) throws Exception {
        Sound.tone(15000,1000); 
    }
}