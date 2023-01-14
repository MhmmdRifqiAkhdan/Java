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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class KonserCriteria extends AbstractORMCriteria {
	public final IntegerExpression idKonser;
	public final StringExpression namaKonser;
	public final CharacterExpression jenisTiket;
	public final IntegerExpression jumlahTiket;
	public final IntegerExpression sisaTiket;
	public final CollectionExpression pemesan;
	
	public KonserCriteria(Criteria criteria) {
		super(criteria);
		idKonser = new IntegerExpression("idKonser", this);
		namaKonser = new StringExpression("namaKonser", this);
		jenisTiket = new CharacterExpression("jenisTiket", this);
		jumlahTiket = new IntegerExpression("jumlahTiket", this);
		sisaTiket = new IntegerExpression("sisaTiket", this);
		pemesan = new CollectionExpression("ORM_Pemesan", this);
	}
	
	public KonserCriteria(PersistentSession session) {
		this(session.createCriteria(Konser.class));
	}
	
	public KonserCriteria() throws PersistentException {
		this(TugasBesar02PersistentManager.instance().getSession());
	}
	
	public PemesanCriteria createPemesanCriteria() {
		return new PemesanCriteria(createCriteria("ORM_Pemesan"));
	}
	
	public Konser uniqueKonser() {
		return (Konser) super.uniqueResult();
	}
	
	public Konser[] listKonser() {
		java.util.List list = super.list();
		return (Konser[]) list.toArray(new Konser[list.size()]);
	}
}

