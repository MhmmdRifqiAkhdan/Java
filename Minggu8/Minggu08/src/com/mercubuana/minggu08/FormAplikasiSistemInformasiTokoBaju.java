
//codingan sistem informasi toko baju

package com.mercubuana.minggu08;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class FormAplikasiSistemInformasiTokoBaju {

	private JFrame frmFormEntriData;
	private JTextField txtMerekBaju;
	private JTextField txtJumlahBaju;
	private JComboBox cmbJenisBaju;
	private ArrayList<Baju> daftarBaju =
			new ArrayList<Baju>();
	private JPanel panelDataBaju;
	private JTabbedPane tabbedPane;
	private JList listDaftarBaju;
	private JTextField txtSisaBaju;
	private JScrollPane scrollPane;
	private JButton btnTambahData;
	private JButton btnUbahData;
	private JButton btnHapusData;
	private JButton btnBatal;
	private JButton btnRekamDataBaju;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAplikasiSistemInformasiTokoBaju window = new FormAplikasiSistemInformasiTokoBaju();
					window.frmFormEntriData.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormAplikasiSistemInformasiTokoBaju() {
		initialize();
		bacaDataDariDisk();
		inisialisasiAntarMukaData();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		frmFormEntriData = new JFrame();
		frmFormEntriData.setTitle("Aplikasi Sistem Informasi Toko Baju");
		frmFormEntriData.setBounds(100, 100, 782, 550);
		frmFormEntriData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFormEntriData.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 760, 494);
		frmFormEntriData.getContentPane().add(tabbedPane);
		
		panelDataBaju = new JPanel();
		tabbedPane.addTab("Data Baju", null, panelDataBaju, null);
		panelDataBaju.setLayout(null);

		JLabel lblMerekBaju = new JLabel("Merek Baju :");
		lblMerekBaju.setBounds(11, 254, 124, 16);
		panelDataBaju.add(lblMerekBaju);
		lblMerekBaju.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMerekBaju.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblJenisBaju = new JLabel("Jenis Baju :");
		lblJenisBaju.setBounds(-14, 297, 149, 16);
		panelDataBaju.add(lblJenisBaju);
		lblJenisBaju.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJenisBaju.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblJumlahBaju = new JLabel("Jumlah Baju :");
		lblJumlahBaju.setBounds(11, 338, 124, 16);
		panelDataBaju.add(lblJumlahBaju);
		lblJumlahBaju.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJumlahBaju.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		txtMerekBaju = new JTextField();
		txtMerekBaju.setBounds(142, 253, 181, 20);
		panelDataBaju.add(txtMerekBaju);
		txtMerekBaju.setColumns(10);
		
		txtJumlahBaju = new JTextField();
		txtJumlahBaju.setBounds(142, 336, 53, 20);
		panelDataBaju.add(txtJumlahBaju);
		txtJumlahBaju.setColumns(10);
		
		btnRekamDataBaju = new JButton("Rekam Data Baju");
		btnRekamDataBaju.setEnabled(false);
		btnRekamDataBaju.setBounds(18, 416, 220, 26);
		panelDataBaju.add(btnRekamDataBaju);
		btnRekamDataBaju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rekamDataBajuBaru();
			}
		});
		btnRekamDataBaju.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		
		cmbJenisBaju = new JComboBox();
		cmbJenisBaju.setBounds(142, 294, 155, 25);
		panelDataBaju.add(cmbJenisBaju);
		cmbJenisBaju.setModel(new DefaultComboBoxModel(new String[] {"Casual", "Pakaian Kerja", "Pakaian Pesta"}));
		cmbJenisBaju.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblSisaBaju = new JLabel("Sisa Baju :");
		lblSisaBaju.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSisaBaju.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSisaBaju.setBounds(34, 370, 101, 20);
		panelDataBaju.add(lblSisaBaju);
		
		txtSisaBaju = new JTextField();
		txtSisaBaju.setBounds(142, 372, 53, 20);
		panelDataBaju.add(txtSisaBaju);
		txtSisaBaju.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 34, 725, 135);
		panelDataBaju.add(scrollPane);
		
		listDaftarBaju = new JList();
		listDaftarBaju.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				handlePerubahanPilihanPadaList();
			}
		});
		scrollPane.setViewportView(listDaftarBaju);
		listDaftarBaju.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnTambahData = new JButton("Tambah Data");
		btnTambahData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tambahDataBaju();
			}
		});
		btnTambahData.setBounds(15, 200, 149, 29);
		panelDataBaju.add(btnTambahData);
		
		btnUbahData = new JButton("Ubah Data");
		btnUbahData.setBounds(182, 200, 115, 29);
		panelDataBaju.add(btnUbahData);
		
		btnHapusData = new JButton("Hapus Data");
		btnHapusData.setBounds(312, 200, 115, 29);
		panelDataBaju.add(btnHapusData);
		
		btnBatal = new JButton("Batal");
		btnBatal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				batalkanProsesManipulasiData();
			}
		});
		btnBatal.setEnabled(false);
		btnBatal.setBounds(253, 415, 115, 29);
		panelDataBaju.add(btnBatal);
		
	}
	void rekamDataBajuBaru() {
		String namaBaju = "";
		namaBaju = txtMerekBaju.getText();
		
		String input = "";
		input = txtJumlahBaju.getText();
		int jumlah = 0, sisaBaju = 0;
		try {
			jumlah = Integer.parseInt(input);
			sisaBaju = jumlah;
			txtSisaBaju.setText("" + sisaBaju);
			txtJumlahBaju.setBackground(Color.white); 
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,
			"Isian Jumlah harus diisi"
			+"dengan bilangan bulat.\n"
			+ "Silakan Perbaiki.");
			txtJumlahBaju.setBackground(Color.red); 
			return;
		}
		char jenisBaju = 'C';
		if(cmbJenisBaju.getSelectedIndex()== 1) {
			jenisBaju = 'K';
		} 
		else if (cmbJenisBaju.getSelectedIndex()== 2) {
			jenisBaju = 'P';
		}
		
//		2. Membuat objek dari class baju
		Baju bajuBaru = new Baju (namaBaju, jenisBaju, jumlah, sisaBaju);
//		3. Menambahkan objek baju baru ke dalam array list daftar baju
		daftarBaju.add(bajuBaru);
		
		
		/*4. Menampilkan kembali data baju yang ada didalam 
		 * array list daftar baju
		 */
		String tampilan = "";
		/*Loop untuk mengambil masing-masing objek
		 * dari array list
		 */
		for (Baju b:daftarBaju) {
			tampilan += String.format("Merek Baju: %s\n"
					+ "Jenis baju: %s\n"
					+ "Jumlah: %s\n"
					+ "Sisa baju: %s\n\n",
					b.getNamaBaju(),
					(b.getJenisBaju() == 'C'?
							"Casual" : b.getJenisBaju() == 'K'?
									"Pakaian Kerja" : "Pakaian Pesta"),
					b.getJumlah(),
					b.getSisaBaju()
					);
		}
		JOptionPane.showMessageDialog(null,tampilan);
//		5.  Merekam objek baju yang baru ke dalam hardisk
		
		rekamDataKeDisk();
		/*6. Melakukan update data baju pada list*/
		tampilkanDataBajuPadaList();
	}
	
	void rekamDataKeDisk(){
		try {
			ObjectOutputStream oos = new 
					ObjectOutputStream(new 
							FileOutputStream("dataTOKO.txt"));	
			oos.writeObject(daftarBaju);
			oos.close();
			JOptionPane.showMessageDialog(null,
					"Data Baju Baru Berhasil Direkam");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Error : Data Tidak Berhasil Direkam");
		}

	}
	
	void bacaDataDariDisk() {
		try {
			ObjectInputStream ois = new 
					ObjectInputStream(new 
							FileInputStream("dataTOKO.txt"));
			daftarBaju = (ArrayList<Baju>)
					ois.readObject(); // cast is needed.
			ois.close();
		} catch (ClassNotFoundException | IOException e) {
			if(e.equals(new IOException())) {
				JOptionPane.showMessageDialog(null,
						"Gagal Membaca Data dari disk");
			}
		}
	}
	protected void tampilkanDataBajuPadaList() {
		/* 1. Mengubah Array list menjadi array */
		/* 1a. Mendeklarasikan array dengan jumlah elemen sebanyak jumlah data pada array list */
		Baju[] dataBaju = new Baju[daftarBaju.size()];
		
		/*1b. Menyalin isi array list ke dalam array */
		dataBaju = daftarBaju.toArray(dataBaju);
		/*2. Menampilkan data dalam array pada list */
		listDaftarBaju.setListData(dataBaju);
	}
	protected void handlePerubahanPilihanPadaList() {
		/*1. Menentukan objek baju yang dipilih */ 
		Baju objekBajuDipilih = (Baju) listDaftarBaju.getSelectedValue();
		/*2. Menampilkan berbagai atribut objek baju pada 
		 * bagian isian (field) data */
		txtMerekBaju.setText(objekBajuDipilih.getNamaBaju());
		cmbJenisBaju.setSelectedIndex(0);
		if (objekBajuDipilih.getJenisBaju()=='K') {
			cmbJenisBaju.setSelectedIndex(1);
		}
		if (objekBajuDipilih.getJenisBaju()=='P') {
			cmbJenisBaju.setSelectedIndex(2);
		}
		txtJumlahBaju.setText("" + objekBajuDipilih.getJumlah());
		txtSisaBaju.setText("" + objekBajuDipilih.getSisaBaju());
	}
	protected void inisialisasiAntarMukaData() {
		tampilkanDataBajuPadaList();
		if(listDaftarBaju.getModel().getSize()!=0) {
		   listDaftarBaju.setSelectedIndex(0);
		}
	}
	protected void tambahDataBaju( ) {
		/*1. Menonaktifkan berbagai tombol pada GUI */
		nonAktifkanSemuaTombolGUI();
		/*2. Aktifkan tombol data yang relevan dengan tambah data */
		btnRekamDataBaju.setEnabled(true);
		btnRekamDataBaju.setText("Rekam Data Baju Baru");
		btnBatal.setEnabled(true);
		/*3 Kosongkan isian data */
		txtMerekBaju.setText("");
		cmbJenisBaju.setSelectedIndex(0);
		txtJumlahBaju.setText("0");
		txtSisaBaju.setText("0");
	}
	protected void nonAktifkanSemuaTombolGUI() {
		btnTambahData.setEnabled(false);
		btnHapusData.setEnabled(false);
		btnUbahData.setEnabled(false);
		btnRekamDataBaju.setEnabled(false);
		btnBatal.setEnabled(false);
		listDaftarBaju.setEnabled(false);
	}
	protected void aktifkanSemuaTombolGUI() {
		btnTambahData.setEnabled(true);
		btnHapusData.setEnabled(true);
		btnUbahData.setEnabled(true);
		btnRekamDataBaju.setEnabled(true);
		btnBatal.setEnabled(true);
		listDaftarBaju.setEnabled(true);
	}
	protected void batalkanProsesManipulasiData() {
		/*1. Aktifkan/NonAktifkan Tombol GUI */
		aktifkanSemuaTombolGUI();
		btnRekamDataBaju.setEnabled(false);
		btnBatal.setEnabled(false);
		
		/*2. Update Tampilan Isian Data Sesuai Pilihan pada list */
		handlePerubahanPilihanPadaList();
	}
}

