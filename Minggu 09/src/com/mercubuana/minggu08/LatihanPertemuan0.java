package com.mercubuana.minggu08;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class LatihanPertemuan0 {

	private JFrame frame;
	private JTextField txtJudulBuku;
	private JTextField txtStokBuku;
	private JComboBox cmbJenisBuku;
	private ArrayList<Buku> daftarBuku = 
			new ArrayList<Buku>();
	private JPanel panelDataPeminjamanBuku;
	private JTabbedPane tabbedPane;
	private JList listDaftarBuku;
	private JScrollPane scrollPane;
	private JButton btnTambahData;
	private JButton btnUbahData;
	private JButton btnHapusData;
	private JButton btnRekamDataPeminjamBuku;
	private JButton btnBatal;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LatihanPertemuan0 window = new LatihanPertemuan0();
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
	public LatihanPertemuan0() {
		initialize();
		bacaDataDariDisk();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		/* https://www.geeksforgeeks.org/java-swing-look-feel/ */
		try {
			UIManager
			.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 917, 660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 895, 604);
		frame.getContentPane().add(tabbedPane);
		
		panelDataPeminjamanBuku = new JPanel();
		tabbedPane.addTab("Data Peminjaman Buku", null, panelDataPeminjamanBuku, null);
		panelDataPeminjamanBuku.setLayout(null);
		
		JLabel lblJudulBuku = new JLabel("Judul Buku :");
		lblJudulBuku.setBounds(12, 365, 96, 20);
		panelDataPeminjamanBuku.add(lblJudulBuku);
		
		txtJudulBuku = new JTextField();
		txtJudulBuku.setBounds(111, 362, 146, 26);
		panelDataPeminjamanBuku.add(txtJudulBuku);
		txtJudulBuku.setColumns(10);
		
		JLabel lblJenisBuku = new JLabel("Jenis Buku : ");
		lblJenisBuku.setBounds(12, 416, 96, 20);
		panelDataPeminjamanBuku.add(lblJenisBuku);
		
		JLabel lblStokBuku = new JLabel("Stok Buku : ");
		lblStokBuku.setBounds(12, 475, 96, 20);
		panelDataPeminjamanBuku.add(lblStokBuku);
		
		txtStokBuku = new JTextField();
		txtStokBuku.setBounds(111, 472, 146, 26);
		panelDataPeminjamanBuku.add(txtStokBuku);
		txtStokBuku.setColumns(10);
		
		btnRekamDataPeminjamBuku = new JButton("Rekam Data Peminjam Buku");
		btnRekamDataPeminjamBuku.setEnabled(false);
		btnRekamDataPeminjamBuku.setBounds(4, 535, 253, 29);
		panelDataPeminjamanBuku.add(btnRekamDataPeminjamBuku);
		
		cmbJenisBuku = new JComboBox();
		cmbJenisBuku.setBounds(111, 413, 146, 26);
		panelDataPeminjamanBuku.add(cmbJenisBuku);
		cmbJenisBuku.setModel(new DefaultComboBoxModel(new String[] {"Novel", "Majalah", "Buku Pelajaran"}));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 94, 851, 166);
		panelDataPeminjamanBuku.add(scrollPane);
		
		listDaftarBuku = new JList();
		listDaftarBuku.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				handlePerubahanPilihanPadaList();
			}
		});
		scrollPane.setViewportView(listDaftarBuku);
		listDaftarBuku.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnTambahData = new JButton("Tambah Data");
		btnTambahData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tambahDataKamar();
			}
		});
		btnTambahData.setBounds(10, 305, 146, 26);
		panelDataPeminjamanBuku.add(btnTambahData);
		
		btnUbahData = new JButton("Ubah Data");
		btnUbahData.setBounds(168, 305, 122, 26);
		panelDataPeminjamanBuku.add(btnUbahData);
		
		btnHapusData = new JButton("Hapus Data");
		btnHapusData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHapusData.setBounds(323, 305, 116, 26);
		panelDataPeminjamanBuku.add(btnHapusData);
		
		btnBatal = new JButton("Batal");
		btnBatal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			batalkanProsesManipulasiData();	
			}
		});
		btnBatal.setEnabled(false);
		btnBatal.setBounds(278, 536, 98, 26);
		panelDataPeminjamanBuku.add(btnBatal);
		btnRekamDataPeminjamBuku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rekamDataPeminjamBuku();
			}
		});
		
		inisialisasiAntarMukaData () ; 

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
		
		/*3. Melakukan update data kamar pada list */
		tampilkanDataBukuPadaList();
		
		
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
	
	protected void tampilkanDataBukuPadaList () {
		/*1. Mengubah array menjadi list array */
		/*1a. Mendeklarasikan array dengan jumlah elemen sebanyak 
		 * jumlah data pada array list
		 */
		
		Buku[] dataBuku = new Buku[daftarBuku.size()];
		/*1b. Menyalin isi array list ke dalam array */
		dataBuku = daftarBuku.toArray(dataBuku);
		
		/*2. Menampilkan data dalam array pada list */
		listDaftarBuku.setListData(dataBuku);
		
	}
	
	protected void handlePerubahanPilihanPadaList() {
		/*1. Menentukan Objek buku yang dipilih */
		Buku objekBukuDipilih = (Buku) listDaftarBuku.getSelectedValue();
		
		/* 2. Menampilkan berbagai atribut objek buku pada
		 * bagian isi (filed) data
		 */
		txtJudulBuku.setText(objekBukuDipilih.getJudulBuku());
		cmbJenisBuku.setSelectedIndex(0);
		if (objekBukuDipilih.getJenisBuku()== 'N') {
			cmbJenisBuku.setSelectedIndex(1);
		}
		txtStokBuku.setText("" + objekBukuDipilih.getStokBuku());
	}
	
	protected void inisialisasiAntarMukaData () {
		tampilkanDataBukuPadaList();
		if(listDaftarBuku.getModel().getSize()!=0) {
			listDaftarBuku.setSelectedIndex(0);
		}
	}
	
	protected void tambahDataKamar() {
	/*1. Menonaktifkan berbagai tombol pada GUI */
		nonAktifkanSemuaTombolGUI();
		
	/*2. Aktifkan tombol relavan dengan tambah data */
		btnRekamDataPeminjamBuku.setEnabled(true);
		btnRekamDataPeminjamBuku.setText("Rekam Data Buku");
		btnBatal.setEnabled(true);
		/*3. Kosongkan isian data */
		txtJudulBuku.setText("");
		cmbJenisBuku.setSelectedIndex(0);
		txtStokBuku.setText("");
		
	}
	
	protected void nonAktifkanSemuaTombolGUI() {
		btnTambahData.setEnabled(false);
		btnHapusData.setEnabled(false);
		btnUbahData.setEnabled(false);
		btnRekamDataPeminjamBuku.setEnabled(false);
		btnBatal.setEnabled(false);
		listDaftarBuku.setEnabled(false);
	}
	
	protected void aktifkanSemuaTombolGUI() {
		btnTambahData.setEnabled(true);
		btnHapusData.setEnabled(true);
		btnUbahData.setEnabled(true);
		btnRekamDataPeminjamBuku.setEnabled(true);
		btnBatal.setEnabled(true);
		listDaftarBuku.setEnabled(true);
	}
	
	protected void batalkanProsesManipulasiData() {
		aktifkanSemuaTombolGUI();
		btnRekamDataPeminjamBuku.setEnabled(false);
		btnBatal.setEnabled(false);
		
		/*2.Update tampilan isian data sesuai pilihan pada list */
		handlePerubahanPilihanPadaList();
		
	}
}