package com.mercubuana.minggu08;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class LatihanPertemuan1 {

	private JFrame frame;
	private JTextField txtJudulBuku;
	private JTextField txtStokBuku;
	private JComboBox cmbJenisBuku;
	private ArrayList<Buku> daftarBuku = 
			new ArrayList<Buku>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LatihanPertemuan1 window = new LatihanPertemuan1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LatihanPertemuan1() {
		initialize();
		bacaDataDariDisk();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblJudulBuku = new JLabel("Judul Buku :");
		lblJudulBuku.setBounds(29, 16, 96, 20);
		frame.getContentPane().add(lblJudulBuku);
		
		txtJudulBuku = new JTextField();
		txtJudulBuku.setBounds(140, 13, 146, 26);
		frame.getContentPane().add(txtJudulBuku);
		txtJudulBuku.setColumns(10);
		
		JLabel lblJenisBuku = new JLabel("Jenis Buku : ");
		lblJenisBuku.setBounds(29, 65, 96, 20);
		frame.getContentPane().add(lblJenisBuku);
		
		JLabel lblStokBuku = new JLabel("Stok Buku : ");
		lblStokBuku.setBounds(29, 122, 96, 20);
		frame.getContentPane().add(lblStokBuku);
		
		txtStokBuku = new JTextField();
		txtStokBuku.setBounds(140, 119, 146, 26);
		frame.getContentPane().add(txtStokBuku);
		txtStokBuku.setColumns(10);
		
		JButton btnRekamDataPeminjamBuku = new JButton("Rekam Data Peminjam Buku");
		btnRekamDataPeminjamBuku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rekamDataPeminjamBuku();
			}
		});
		btnRekamDataPeminjamBuku.setBounds(30, 180, 253, 29);
		frame.getContentPane().add(btnRekamDataPeminjamBuku);
		
		cmbJenisBuku = new JComboBox();
		cmbJenisBuku.setModel(new DefaultComboBoxModel(new String[] {"Novel", "Majalah", "Buku Pelajaran"}));
		cmbJenisBuku.setBounds(140, 62, 146, 26);
		frame.getContentPane().add(cmbJenisBuku);
	}
	
	void rekamDataPeminjamBuku() {
		String judulBuku = "";
		judulBuku = txtJudulBuku.getText();
		
		String input = "";
		input = txtStokBuku.getText();
		int stokBuku = 0;
		
		/*1a. Konversi string */
		try {
			stokBuku = Integer.parseInt(input);
			txtStokBuku.setBackground(Color.white);
			txtStokBuku.setForeground(Color.black);
		} catch (NumberFormatException e) {
			txtStokBuku.setBackground(Color.red);
			txtStokBuku.setForeground(Color.white);
			JOptionPane.showMessageDialog(null	,
					"Isian Kapasitas harus diisi"
					+ "dengan bilangan bulat.\n"
							+"silahkan diperbaiki");
			return;
		}
		
		/*1b. Membaca data pilihan jenis buku 
		 * dari combo box
		 */
		
		
		char jenisBuku = 'N';
		
		/*1b1. Memeriksa apakah indeks pilihan combo box
		 * adalah sama dengan 0
		 */
		
		if(cmbJenisBuku.getSelectedIndex()==1) {
			/*Jika sama dengan 1, berarti 
			 * yang dipilih adalah indeks = 1, atau
			 * pilihan yang kedua, atau Majalah
			 */
			jenisBuku = 'M';
			
		} else if (cmbJenisBuku.getSelectedIndex()==2){
			/* Jika sama dengan 2, berarti 
			 * yang dipilih adalah indeks = 2, atau
			 * pilihan yang ketiga, atau Buku Pelajaran
			 */
		
			jenisBuku = 'B';
	}
		
	    /* Membuat objek yang baru dari class buku */
		Buku bukuBaru = new Buku(judulBuku,
				jenisBuku, stokBuku);
		
		/* Menambah Objek buku baru ke dalam
		 * array list daftar buku
		 */
		
		daftarBuku.add(bukuBaru);
		
		/* Menampilkan kembali data buku yang 
		 * ada di dalam array list daftar buku
		 */
		String tampilan = "";
		/*Loop untuk mengambil masing masing objek
		 * dari dalam array list
		 */
		for (Buku b:daftarBuku) {
			tampilan += String.format("Judul Buku: %s \n"
					+ "Jenis Buku: %s\n\n"
					+ "Stok Buku: %s\n\n",
					b.getJudulBuku(),
					(b.getJenisBuku()=='N'? "Novel" :
					b.getJenisBuku()=='M'? "Majalah" : "Buku Pelajaran"),
					b.getStokBuku());
			
		}
		
		JOptionPane.showMessageDialog(null, tampilan);
		
		
		rekamDataKeDisk();
	}
	
	void rekamDataKeDisk () {
		try {
			ObjectOutputStream oos = new 
					ObjectOutputStream(new FileOutputStream("dataBuku.txt"));
			oos.writeObject(daftarBuku);
			oos.close();
			JOptionPane.showMessageDialog(null,
					"Data buku baru berhasil direkam");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Error : data ditak berhasil direkam");
			e.printStackTrace();
		}

}
	void bacaDataDariDisk() { 
		try {
			ObjectInputStream ois = new 
					ObjectInputStream(new 
							FileInputStream("dataBuku.txt"));
			daftarBuku = (ArrayList<Buku>)
					ois.readObject(); // cast is needed.
			ois.close();
		} catch (ClassNotFoundException | IOException e) {
			if (e.equals(new IOException())) {
				
			}
			JOptionPane.showMessageDialog(null,
					"Gagal Membaca data dari disk");
		}
	}
}