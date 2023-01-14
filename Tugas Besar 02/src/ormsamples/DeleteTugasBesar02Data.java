/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class DeleteTugasBesar02Data {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = com.mercubuana.tugasbesar2.TugasBesar02PersistentManager.instance().getSession().beginTransaction();
		try {
			com.mercubuana.tugasbesar2.Pemesan lcommercubuanatugasbesar2Pemesan = com.mercubuana.tugasbesar2.PemesanDAO.loadPemesanByQuery(null, null);
			// Delete the persistent object
			com.mercubuana.tugasbesar2.PemesanDAO.delete(lcommercubuanatugasbesar2Pemesan);
			com.mercubuana.tugasbesar2.Konser lcommercubuanatugasbesar2Konser = com.mercubuana.tugasbesar2.KonserDAO.loadKonserByQuery(null, null);
			// Delete the persistent object
			com.mercubuana.tugasbesar2.KonserDAO.delete(lcommercubuanatugasbesar2Konser);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteTugasBesar02Data deleteTugasBesar02Data = new DeleteTugasBesar02Data();
			try {
				deleteTugasBesar02Data.deleteTestData();
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
