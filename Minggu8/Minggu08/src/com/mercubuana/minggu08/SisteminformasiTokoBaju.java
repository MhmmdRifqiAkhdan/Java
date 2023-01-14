//codingan sistem informasi toko baju

package com.mercubuana.minggu08;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
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

public class SisteminformasiTokoBaju {

	private JFrame frmFormEntriData;
	private JTextField txtMerekBaju;
	private JTextField txtJumlahBaju;
	private JComboBox cmbJenisBaju;
	private ArrayList<Baju> daftarBaju =
			new ArrayList<Baju>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SisteminformasiTokoBaju window = new SisteminformasiTokoBaju();
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
	public SisteminformasiTokoBaju() {
		initialize();
		bacaDataDariDisk();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFormEntriData = new JFrame();
		frmFormEntriData.setTitle("Form Entri Data Baju");
		frmFormEntriData.setBounds(100, 100, 450, 300);
		frmFormEntriData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFormEntriData.getContentPane().setLayout(null);

		JLabel lblMerekBaju = new JLabel("Merek Baju :");
		lblMerekBaju.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMerekBaju.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMerekBaju.setBounds(0, 12, 124, 16);
		frmFormEntriData.getContentPane().add(lblMerekBaju);

		JLabel lblJenisBaju = new JLabel("Jenis Baju :");
		lblJenisBaju.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJenisBaju.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblJenisBaju.setBounds(-25, 55, 149, 16);
		frmFormEntriData.getContentPane().add(lblJenisBaju);

		JLabel lblJumlahBaju = new JLabel("Jumlah Baju :");
		lblJumlahBaju.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJumlahBaju.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblJumlahBaju.setBounds(0, 96, 124, 16);
		frmFormEntriData.getContentPane().add(lblJumlahBaju);
		
		txtMerekBaju = new JTextField();
		txtMerekBaju.setBounds(131, 11, 155, 20);
		frmFormEntriData.getContentPane().add(txtMerekBaju);
		txtMerekBaju.setColumns(10);
		
		txtJumlahBaju = new JTextField();
		txtJumlahBaju.setBounds(131, 95, 155, 20);
		frmFormEntriData.getContentPane().add(txtJumlahBaju);
		txtJumlahBaju.setColumns(10);
		
		JButton btnRekamDataBaju = new JButton("Rekam Data Baju Baru");
		btnRekamDataBaju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rekamDataBajuBaru();
			}
		});
		btnRekamDataBaju.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRekamDataBaju.setBounds(12, 138, 220, 26);
		frmFormEntriData.getContentPane().add(btnRekamDataBaju);
		
		cmbJenisBaju = new JComboBox();
		cmbJenisBaju.setModel(new DefaultComboBoxModel(new String[] {"Casual", "Pakaian Kerja", "Pakaian Pesta"}));
		cmbJenisBaju.setFont(new Font("Tahoma", Font.BOLD, 15));
		cmbJenisBaju.setBounds(131, 52, 155, 25);
		frmFormEntriData.getContentPane().add(cmbJenisBaju);
	}
	void rekamDataBajuBaru() {
		String namaBaju = "";
		namaBaju = txtMerekBaju.getText();
		
		String input = "";
		input = txtJumlahBaju.getText();
		int jumlah = 0, sisaBaju = 0;
		try {
			jumlah = Integer.parseInt(input);
			txtJumlahBaju.setBackground(Color.white); 
			txtJumlahBaju.setForeground(Color.black);
		} catch (NumberFormatException e) {
			txtJumlahBaju.setBackground(Color.red); 
			txtJumlahBaju.setForeground(Color.white);
			JOptionPane.showMessageDialog(null,
			"Isian Jumlah harus diisi"
			+"dengan bilangan bulat.\n"
			+ "Silakan Perbaiki.");
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
					+ "Jumlah: %s\n\n",
					b.getNamaBaju(),
					(b.getJenisBaju() == 'C'?
							"Casual" : b.getJenisBaju() == 'K'?
									"Pakaian Kerja" : "Pakaian Pesta"),
					b.getJumlah()
					);
		}
		JOptionPane.showMessageDialog(null,tampilan);
//		5.  Merekam objek baju yang baru ke dalam hardisk
		
		rekamDataKeDisk();
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
}

