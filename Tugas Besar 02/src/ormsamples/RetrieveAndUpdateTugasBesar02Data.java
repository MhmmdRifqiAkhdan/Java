/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateTugasBesar02Data {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = com.mercubuana.tugasbesar2.TugasBesar02PersistentManager.instance().getSession().beginTransaction();
		try {
			com.mercubuana.tugasbesar2.Pemesan lcommercubuanatugasbesar2Pemesan = com.mercubuana.tugasbesar2.PemesanDAO.loadPemesanByQuery(null, null);
			// Update the properties of the persistent object
			com.mercubuana.tugasbesar2.PemesanDAO.save(lcommercubuanatugasbesar2Pemesan);
			com.mercubuana.tugasbesar2.Konser lcommercubuanatugasbesar2Konser = com.mercubuana.tugasbesar2.KonserDAO.loadKonserByQuery(null, null);
			// Update the properties of the persistent object
			com.mercubuana.tugasbesar2.KonserDAO.save(lcommercubuanatugasbesar2Konser);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Pemesan by PemesanCriteria");
		com.mercubuana.tugasbesar2.PemesanCriteria lcommercubuanatugasbesar2PemesanCriteria = new com.mercubuana.tugasbesar2.PemesanCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommercubuanatugasbesar2PemesanCriteria.idPemesan.eq();
		System.out.println(lcommercubuanatugasbesar2PemesanCriteria.uniquePemesan());
		
		System.out.println("Retrieving Konser by KonserCriteria");
		com.mercubuana.tugasbesar2.KonserCriteria lcommercubuanatugasbesar2KonserCriteria = new com.mercubuana.tugasbesar2.KonserCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommercubuanatugasbesar2KonserCriteria.idKonser.eq();
		System.out.println(lcommercubuanatugasbesar2KonserCriteria.uniqueKonser());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateTugasBesar02Data retrieveAndUpdateTugasBesar02Data = new RetrieveAndUpdateTugasBesar02Data();
			try {
				retrieveAndUpdateTugasBesar02Data.retrieveAndUpdateTestData();
				//retrieveAndUpdateTugasBesar02Data.retrieveByCriteria();
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
