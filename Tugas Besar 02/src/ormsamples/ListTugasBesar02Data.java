/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class ListTugasBesar02Data {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Pemesan...");
		com.mercubuana.tugasbesar2.Pemesan[] commercubuanatugasbesar2Pemesans = com.mercubuana.tugasbesar2.PemesanDAO.listPemesanByQuery(null, null);
		int length = Math.min(commercubuanatugasbesar2Pemesans.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commercubuanatugasbesar2Pemesans[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Konser...");
		com.mercubuana.tugasbesar2.Konser[] commercubuanatugasbesar2Konsers = com.mercubuana.tugasbesar2.KonserDAO.listKonserByQuery(null, null);
		length = Math.min(commercubuanatugasbesar2Konsers.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commercubuanatugasbesar2Konsers[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Pemesan by Criteria...");
		com.mercubuana.tugasbesar2.PemesanCriteria lcommercubuanatugasbesar2PemesanCriteria = new com.mercubuana.tugasbesar2.PemesanCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommercubuanatugasbesar2PemesanCriteria.idPemesan.eq();
		lcommercubuanatugasbesar2PemesanCriteria.setMaxResults(ROW_COUNT);
		com.mercubuana.tugasbesar2.Pemesan[] commercubuanatugasbesar2Pemesans = lcommercubuanatugasbesar2PemesanCriteria.listPemesan();
		int length =commercubuanatugasbesar2Pemesans== null ? 0 : Math.min(commercubuanatugasbesar2Pemesans.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commercubuanatugasbesar2Pemesans[i]);
		}
		System.out.println(length + " Pemesan record(s) retrieved."); 
		
		System.out.println("Listing Konser by Criteria...");
		com.mercubuana.tugasbesar2.KonserCriteria lcommercubuanatugasbesar2KonserCriteria = new com.mercubuana.tugasbesar2.KonserCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommercubuanatugasbesar2KonserCriteria.idKonser.eq();
		lcommercubuanatugasbesar2KonserCriteria.setMaxResults(ROW_COUNT);
		com.mercubuana.tugasbesar2.Konser[] commercubuanatugasbesar2Konsers = lcommercubuanatugasbesar2KonserCriteria.listKonser();
		length =commercubuanatugasbesar2Konsers== null ? 0 : Math.min(commercubuanatugasbesar2Konsers.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commercubuanatugasbesar2Konsers[i]);
		}
		System.out.println(length + " Konser record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListTugasBesar02Data listTugasBesar02Data = new ListTugasBesar02Data();
			try {
				listTugasBesar02Data.listTestData();
				//listTugasBesar02Data.listByCriteria();
			}
			finally {
				com.mercubuana.tugasbesar2.TugasBesar02PersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
