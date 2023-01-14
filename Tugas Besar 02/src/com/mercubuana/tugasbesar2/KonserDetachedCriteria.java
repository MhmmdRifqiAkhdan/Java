/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package com.mercubuana.tugasbesar2;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class KonserDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idKonser;
	public final StringExpression namaKonser;
	public final CharacterExpression jenisTiket;
	public final IntegerExpression jumlahTiket;
	public final IntegerExpression sisaTiket;
	public final CollectionExpression pemesan;
	
	public KonserDetachedCriteria() {
		super(com.mercubuana.tugasbesar2.Konser.class, com.mercubuana.tugasbesar2.KonserCriteria.class);
		idKonser = new IntegerExpression("idKonser", this.getDetachedCriteria());
		namaKonser = new StringExpression("namaKonser", this.getDetachedCriteria());
		jenisTiket = new CharacterExpression("jenisTiket", this.getDetachedCriteria());
		jumlahTiket = new IntegerExpression("jumlahTiket", this.getDetachedCriteria());
		sisaTiket = new IntegerExpression("sisaTiket", this.getDetachedCriteria());
		pemesan = new CollectionExpression("ORM_Pemesan", this.getDetachedCriteria());
	}
	
	public KonserDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.mercubuana.tugasbesar2.KonserCriteria.class);
		idKonser = new IntegerExpression("idKonser", this.getDetachedCriteria());
		namaKonser = new StringExpression("namaKonser", this.getDetachedCriteria());
		jenisTiket = new CharacterExpression("jenisTiket", this.getDetachedCriteria());
		jumlahTiket = new IntegerExpression("jumlahTiket", this.getDetachedCriteria());
		sisaTiket = new IntegerExpression("sisaTiket", this.getDetachedCriteria());
		pemesan = new CollectionExpression("ORM_Pemesan", this.getDetachedCriteria());
	}
	
	public PemesanDetachedCriteria createPemesanCriteria() {
		return new PemesanDetachedCriteria(createCriteria("ORM_Pemesan"));
	}
	
	public Konser uniqueKonser(PersistentSession session) {
		return (Konser) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Konser[] listKonser(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Konser[]) list.toArray(new Konser[list.size()]);
	}
}

