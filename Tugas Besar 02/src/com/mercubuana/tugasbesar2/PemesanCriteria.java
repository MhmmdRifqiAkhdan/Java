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

public class PemesanCriteria extends AbstractORMCriteria {
	public final IntegerExpression idPemesan;
	public final StringExpression namaPemesan;
	public final CharacterExpression jenisTiket;
	public final DateExpression tanggalPemesanan;
	public final IntegerExpression konserid_konserId;
	public final AssociationExpression konserid_konser;
	
	public PemesanCriteria(Criteria criteria) {
		super(criteria);
		idPemesan = new IntegerExpression("idPemesan", this);
		namaPemesan = new StringExpression("namaPemesan", this);
		jenisTiket = new CharacterExpression("jenisTiket", this);
		tanggalPemesanan = new DateExpression("tanggalPemesanan", this);
		konserid_konserId = new IntegerExpression("konserid_konser.idKonser", this);
		konserid_konser = new AssociationExpression("konserid_konser", this);
	}
	
	public PemesanCriteria(PersistentSession session) {
		this(session.createCriteria(Pemesan.class));
	}
	
	public PemesanCriteria() throws PersistentException {
		this(TugasBesar02PersistentManager.instance().getSession());
	}
	
	public KonserCriteria createKonserid_konserCriteria() {
		return new KonserCriteria(createCriteria("konserid_konser"));
	}
	
	public Pemesan uniquePemesan() {
		return (Pemesan) super.uniqueResult();
	}
	
	public Pemesan[] listPemesan() {
		java.util.List list = super.list();
		return (Pemesan[]) list.toArray(new Pemesan[list.size()]);
	}
}

