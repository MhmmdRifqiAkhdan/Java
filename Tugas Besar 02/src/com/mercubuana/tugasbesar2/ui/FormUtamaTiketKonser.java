package com.mercubuana.tugasbesar2.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.mercubuana.tugasbesar2.Konser;
import com.mercubuana.tugasbesar2.KonserDAO;
import com.mercubuana.tugasbesar2.TugasBesar02PersistentManager;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JScrollPane;

public class FormUtamaTiketKonser {

	private JFrame frmTiketKonser;
	private JTextField txtNamaKonser;
	private JTextField txtJumlahTiket;
	private JTextField txtSisaTiket;
	private JPanel panelRincianDataKonser;
	private JButton btnTambahData;
	private JList listDaftarKonser;
	private JComboBox cmbJenisTiket;
	private Konser[] dataKonser = null;
	private JButton btnRekamDataKonser;
	private JScrollPane scrollPane;
	private JButton btnHapus;
	private JButton btnUbahData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormUtamaTiketKonser window = new FormUtamaTiketKonser();
					window.frmTiketKonser.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormUtamaTiketKonser() {
		// 1. Inisialiasi dan menampilkan form utama
		initialize();
		/* 2. Membaca data dari database dan menampilkannya 
		 *    pada List daftar kamar
		 */
		bacaDataDariDatabase();
		tampilkanDataKonserPadaList();
		/* 3. Memeriksa jika sudah ada data
		 *    untuk ditampilkan pada list
		 */
		bacaDataDariDatabase();
		if(dataKonser.length>0) {
			tampilkanDataKonserPadaList();
			// 4. Pilih konser teratas pada list
			listDaftarKonser.setSelectedIndex(0);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTiketKonser = new JFrame();
		frmTiketKonser.setTitle("Tiket Konser");
		frmTiketKonser.setBounds(100, 100, 580, 460);
		frmTiketKonser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTiketKonser.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 562, 413);
		frmTiketKonser.getContentPane().add(tabbedPane);
		
		JPanel panelDataKonser = new JPanel();
		tabbedPane.addTab("Data Konser", null, panelDataKonser, null);
		panelDataKonser.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 40, 396, 146);
		panelDataKonser.add(scrollPane);
		
		listDaftarKonser = new JList();
		scrollPane.setViewportView(listDaftarKonser);
		listDaftarKonser.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				ubahTampilanPadaPanelRincian();
			}
		});
		listDaftarKonser.setFont(new Font("Dialog", Font.BOLD, 14));
		listDaftarKonser.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblDaftarKonser = new JLabel("Daftar Konser");
		lblDaftarKonser.setBounds(12, 12, 113, 16);
		panelDataKonser.add(lblDaftarKonser);
		lblDaftarKonser.setFont(new Font("Dialog", Font.BOLD, 16));
		
		btnTambahData = new JButton("Tambah Data");
		btnTambahData.setBounds(420, 40, 123, 26);
		panelDataKonser.add(btnTambahData);
		btnTambahData.setFont(new Font("Dialog", Font.BOLD, 14));
		
		panelRincianDataKonser = new JPanel();
		panelRincianDataKonser.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Rincian Data Konser", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelRincianDataKonser.setName("");
		panelRincianDataKonser.setBounds(12, 199, 396, 177);
		panelDataKonser.add(panelRincianDataKonser);
		panelRincianDataKonser.setLayout(null);
		
		JLabel lblNamaKonser = new JLabel("Nama Konser : ");
		lblNamaKonser.setBounds(12, 27, 123, 16);
		panelRincianDataKonser.add(lblNamaKonser);
		lblNamaKonser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNamaKonser.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblJenisTiket = new JLabel("Jenis Tiket : ");
		lblJenisTiket.setBounds(12, 55, 123, 16);
		panelRincianDataKonser.add(lblJenisTiket);
		lblJenisTiket.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJenisTiket.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblJumlahTiket = new JLabel("Jumlah Tiket : ");
		lblJumlahTiket.setBounds(12, 83, 123, 16);
		panelRincianDataKonser.add(lblJumlahTiket);
		lblJumlahTiket.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJumlahTiket.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblSisaTiket = new JLabel("Sisa Tiket : ");
		lblSisaTiket.setBounds(12, 111, 123, 16);
		panelRincianDataKonser.add(lblSisaTiket);
		lblSisaTiket.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSisaTiket.setFont(new Font("Dialog", Font.BOLD, 16));
		
		txtNamaKonser = new JTextField();
		txtNamaKonser.setBounds(139, 27, 150, 20);
		panelRincianDataKonser.add(txtNamaKonser);
		txtNamaKonser.setColumns(10);
		
		txtJumlahTiket = new JTextField();
		txtJumlahTiket.setBounds(139, 83, 60, 20);
		panelRincianDataKonser.add(txtJumlahTiket);
		txtJumlahTiket.setColumns(10);
		
		txtSisaTiket = new JTextField();
		txtSisaTiket.setBounds(139, 111, 60, 20);
		panelRincianDataKonser.add(txtSisaTiket);
		txtSisaTiket.setColumns(10);
		
		cmbJenisTiket = new JComboBox();
		cmbJenisTiket.setBounds(139, 53, 150, 25);
		panelRincianDataKonser.add(cmbJenisTiket);
		cmbJenisTiket.setModel(new DefaultComboBoxModel(new String[] {"Festival", "Tribun", "VIP"}));
		
		btnRekamDataKonser = new JButton("Rekam Data Konser");
		btnRekamDataKonser.setVisible(false);
		btnRekamDataKonser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rekamDataKonser();
			}
		});
		btnRekamDataKonser.setFont(new Font("Dialog", Font.BOLD, 14));
		btnRekamDataKonser.setBounds(22, 139, 175, 26);
		panelRincianDataKonser.add(btnRekamDataKonser);
		
		btnHapus = new JButton("Hapus");
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hapusData();
			}
		});
		btnHapus.setFont(new Font("Dialog", Font.BOLD, 14));
		btnHapus.setBounds(420, 160, 123, 26);
		panelDataKonser.add(btnHapus);
		
		btnUbahData = new JButton("Ubah Data");
		btnUbahData.setFont(new Font("Dialog", Font.BOLD, 14));
		btnUbahData.setBounds(420, 78, 123, 26);
		panelDataKonser.add(btnUbahData);
		btnTambahData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelRincianDataKonser.setVisible(true);
				btnTambahData.setEnabled(false);
				aktifkanPanel();
			}
		});
	}
	
	void rekamDataKonser() {
		// 1. Membaca input User dari GUI
		String namaKonser = "";
		namaKonser = txtNamaKonser.getText();
		
		char jenisTiket = 'F';
		if (cmbJenisTiket.getSelectedIndex()==1) {
			jenisTiket = 'T';
		}
		else if (cmbJenisTiket.getSelectedIndex()==2) {
			jenisTiket = 'V';
		}
		
		int jumlahTiket = 0;
		int sisaTiket = 0;
		try {
			jumlahTiket = Integer.parseInt(txtJumlahTiket.getText());
			txtSisaTiket.setText("" + jumlahTiket);
			sisaTiket = jumlahTiket;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, 
					"Isian Jumlah Tiket harus berupa bilangan bulat");
			return;
		}
		
		// 2. Memulai transaction baru
		PersistentTransaction t = null; 
		try {
			t = TugasBesar02PersistentManager
					.instance().getSession().beginTransaction();
		} catch (PersistentException e) {
			JOptionPane.showMessageDialog(null, 
					"Gagal memulai transaction\n"
					+ "Pesan Error : " + e.getMessage());
			return;
		}
		
		/* 3. Membungkus semua proses perubahan dalam try-catch agar bisa dibatalkan
		 *    (roll-back) seandainya terjadi error
		 */	
		try {
			// 3a. Membuat objek konser baru (memori + database)
			Konser konserBaru = KonserDAO.createKonser();
			// 3b. Mengubah atribut objek konser baru
			konserBaru.setNamaKonser(namaKonser);
			konserBaru.setJenisTiket(jenisTiket);
			konserBaru.setJumlahTiket(jumlahTiket);
			konserBaru.setSisaTiket(sisaTiket); 
			// 3c. Rekam perubahan ke dalam database
			KonserDAO.save(konserBaru);
			// 3d. Jika semua perubahan berhasil, maka lakukan commit
			t.commit();
			JOptionPane.showMessageDialog(null, 
					"Data konser baru berhasil ditambahkan");
		} catch (PersistentException e) {
			JOptionPane.showMessageDialog(null, 
					"Gagal merekam data konser\n"
					+ "Pesan Error : " + e.getMessage());
			try {
				t.rollback();
			} catch (PersistentException e1) {
				JOptionPane.showMessageDialog(null, 
						"Gagal melakukan rollback\n"
						+ "Pesan Error : " + e1.getMessage());
			}
		}
		bacaDataDariDatabase();
		tampilkanDataKonserPadaList();
		nonAktifkanPanel();
	}
	
	void aktifkanPanel() {
		btnRekamDataKonser.setVisible(true);
		txtNamaKonser.setText("");
		cmbJenisTiket.setSelectedIndex(0);
		txtJumlahTiket.setText("");
		txtSisaTiket.setText("");
	}
	
	void nonAktifkanPanel() {
		btnRekamDataKonser.setVisible(false);
		btnTambahData.setEnabled(true);
	}
	
	void bacaDataDariDatabase() {
		try {
			dataKonser = KonserDAO.listKonserByQuery(null, null);
		} catch (PersistentException e) {
			JOptionPane.showMessageDialog(null, 
					"Gagal membaca data kamar\n"
					+ "Pesan Error : " + e.getMessage());
		}
	}
	
	void tampilkanDataKonserPadaList() {
		listDaftarKonser.setListData(dataKonser);
	}
	
	void ubahTampilanPadaPanelRincian() {
		int index = listDaftarKonser.getSelectedIndex();
		if (index==-1) {
			index = dataKonser.length - 1;
		}
		Konser konserDipilihPadaList = (Konser) listDaftarKonser
				.getModel().getElementAt(index);
		txtNamaKonser.setText(konserDipilihPadaList.getNamaKonser());
		cmbJenisTiket.setSelectedIndex(0);
		if (konserDipilihPadaList.getJenisTiket()=='T') {
			cmbJenisTiket.setSelectedIndex(1);
		}
		else if (konserDipilihPadaList.getJenisTiket()=='V') {
			cmbJenisTiket.setSelectedIndex(2);
		}
		txtJumlahTiket.setText("" + konserDipilihPadaList.getJumlahTiket());
		txtSisaTiket.setText("" + konserDipilihPadaList.getSisaTiket());	
	}
	
	void hapusData() {
		// 1. Menentukan objek konser yang sedang dipilih pada list
		int index = listDaftarKonser.getSelectedIndex();
		Konser konserDipilihPadaList = (Konser) listDaftarKonser
				.getModel().getElementAt(index);
		// 2. Hapus data dari database
		PersistentTransaction t = null;
		try {
			t = TugasBesar02PersistentManager
					.instance().getSession().beginTransaction();
			KonserDAO.deleteAndDissociate(konserDipilihPadaList);
			t.commit();
			bacaDataDariDatabase();
			tampilkanDataKonserPadaList();	
		} catch (PersistentException e) {
			try {
				JOptionPane.showMessageDialog(null, 
						"Gagal hapus data\n"
						+ "Pesan Error : " + e.getMessage());
				t.rollback();
			} catch (PersistentException e1) {
				JOptionPane.showMessageDialog(null, 
						"Gagal melakukan rollback\n"
						+ "Pesan Error : " + e1.getMessage());
			}
		}
	}
	
}