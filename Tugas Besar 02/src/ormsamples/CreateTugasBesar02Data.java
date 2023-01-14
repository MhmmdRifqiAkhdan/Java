/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class CreateTugasBesar02Data {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = com.mercubuana.tugasbesar2.TugasBesar02PersistentManager.instance().getSession().beginTransaction();
		try {
			com.mercubuana.tugasbesar2.Pemesan lcommercubuanatugasbesar2Pemesan = com.mercubuana.tugasbesar2.PemesanDAO.createPemesan();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : konserid_konser, tanggalPemesanan, jenisTiket, namaPemesan
			com.mercubuana.tugasbesar2.PemesanDAO.save(lcommercubuanatugasbesar2Pemesan);
			com.mercubuana.tugasbesar2.Konser lcommercubuanatugasbesar2Konser = com.mercubuana.tugasbesar2.KonserDAO.createKonser();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : pemesan, sisaTiket, jumlahTiket, jenisTiket, namaKonser
			com.mercubuana.tugasbesar2.KonserDAO.save(lcommercubuanatugasbesar2Konser);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateTugasBesar02Data createTugasBesar02Data = new CreateTugasBesar02Data();
			try {
				createTugasBesar02Data.createTestData();
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
