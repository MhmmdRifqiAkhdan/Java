package com.mercubauna.minggu08;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SistemInformasiRSXYZ {

	private JFrame frmFromEntriData;
	private JTextField txtJudulBuku;
	private JTextField txtSisaBuku;
	private JComboBox cmbJenisBuku;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SistemInformasiRSXYZ window = new SistemInformasiRSXYZ();
					window.frmFromEntriData.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SistemInformasiRSXYZ() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFromEntriData = new JFrame();
		frmFromEntriData.setTitle("From Entri Data Kamar - RS XYZ");
		frmFromEntriData.setBounds(100, 100, 450, 300);
		frmFromEntriData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFromEntriData.getContentPane().setLayout(null);
		
		JLabel lblJudulBuku = new JLabel("Judul Buku :");
		lblJudulBuku.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJudulBuku.setBounds(12, 12, 111, 16);
		frmFromEntriData.getContentPane().add(lblJudulBuku);
		
		JLabel lblJenisBuku = new JLabel("Jenis Buku :");
		lblJenisBuku.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJenisBuku.setBounds(30, 40, 93, 16);
		frmFromEntriData.getContentPane().add(lblJenisBuku);
		
		JLabel lblSisaBuku = new JLabel("Sisa Buku:");
		lblSisaBuku.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSisaBuku.setBounds(43, 68, 80, 16);
		frmFromEntriData.getContentPane().add(lblSisaBuku);
		
		txtJudulBuku = new JTextField();
		txtJudulBuku.setBounds(130, 10, 114, 20);
		frmFromEntriData.getContentPane().add(txtJudulBuku);
		txtJudulBuku.setColumns(10);
		
		JComboBox cmbJenisBuku = new JComboBox();
		cmbJenisBuku.setModel(new DefaultComboBoxModel(new String[] {"Novel", "Majalah", "Buku Pelajaran"}));
		cmbJenisBuku.setBounds(130, 36, 131, 25);
		frmFromEntriData.getContentPane().add(cmbJenisBuku);
		
		txtSisaBuku = new JTextField();
		txtSisaBuku.setBounds(130, 66, 114, 20);
		frmFromEntriData.getContentPane().add(txtSisaBuku);
		txtSisaBuku.setColumns(10);
		
		JButton btnRekamPeminjamanBuku = new JButton("Rekam Peminjaman Buku");
		btnRekamPeminjamanBuku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rekamPeminjamanBuku();
			}
		});
		btnRekamPeminjamanBuku.setBounds(30, 112, 190, 26);
		frmFromEntriData.getContentPane().add(btnRekamPeminjamanBuku);
	}
	
	 void rekamPeminjamanBuku() {
		 String judulBuku = "";
		 judulBuku = txtJudulBuku.getText();
		 
		 String input = "";
		 input = txtSisaBuku.getText();
		 int sisaBuku = 0;
		 
		 try {
			sisaBuku = Integer.parseInt(input);
			txtSisaBuku.setBackground(Color.white);
			txtSisaBuku.setForeground(Color.black);
		} catch (NumberFormatException e) {
			txtSisaBuku.setBackground(Color.red);
			txtSisaBuku.setForeground(Color.white);
			JOptionPane.showMessageDialog(null, 
					"Sisa buku harus diisi"
					+ "dengan bilangan bulat. \n"
							+ "Silahkan perbaiki.");

			return ; 
		}
		 
		 char jenisBuku = 'N';
		 if (cmbJenisBuku.getSelectedIndex()!=1) {
			 jenisBuku= 'M';
		 }

		 
		 if (cmbJenisBuku.getSelectedIndex()!=2) {
			 jenisBuku= 'P';
			 
		 }
		 
		 Buku bukuBaru = new Buku(judulBuku,
				 jenisBuku,sisaBuku );
		 
		 String tampilan = "";
		 tampilan = String.format("Judul Buku: %s\n"
		 		+ "Jenis Buku: %s\n"
				+ "Sisa Buku: %s\n",
				judulBuku.getJudulBuku(),
				judulBuku.getJenisBuku(),
				judulBuku.getSisaBuku());
		 JOptionPane.showMessageDialog(null,tampilan);
		 }
	 }
	 
