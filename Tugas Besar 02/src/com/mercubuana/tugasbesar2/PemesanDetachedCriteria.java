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

public class PemesanDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idPemesan;
	public final StringExpression namaPemesan;
	public final CharacterExpression jenisTiket;
	public final DateExpression tanggalPemesanan;
	public final IntegerExpression konserid_konserId;
	public final AssociationExpression konserid_konser;
	
	public PemesanDetachedCriteria() {
		super(com.mercubuana.tugasbesar2.Pemesan.class, com.mercubuana.tugasbesar2.PemesanCriteria.class);
		idPemesan = new IntegerExpression("idPemesan", this.getDetachedCriteria());
		namaPemesan = new StringExpression("namaPemesan", this.getDetachedCriteria());
		jenisTiket = new CharacterExpression("jenisTiket", this.getDetachedCriteria());
		tanggalPemesanan = new DateExpression("tanggalPemesanan", this.getDetachedCriteria());
		konserid_konserId = new IntegerExpression("konserid_konser.idKonser", this.getDetachedCriteria());
		konserid_konser = new AssociationExpression("konserid_konser", this.getDetachedCriteria());
	}
	
	public PemesanDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.mercubuana.tugasbesar2.PemesanCriteria.class);
		idPemesan = new IntegerExpression("idPemesan", this.getDetachedCriteria());
		namaPemesan = new StringExpression("namaPemesan", this.getDetachedCriteria());
		jenisTiket = new CharacterExpression("jenisTiket", this.getDetachedCriteria());
		tanggalPemesanan = new DateExpression("tanggalPemesanan", this.getDetachedCriteria());
		konserid_konserId = new IntegerExpression("konserid_konser.idKonser", this.getDetachedCriteria());
		konserid_konser = new AssociationExpression("konserid_konser", this.getDetachedCriteria());
	}
	
	public KonserDetachedCriteria createKonserid_konserCriteria() {
		return new KonserDetachedCriteria(createCriteria("konserid_konser"));
	}
	
	public Pemesan uniquePemesan(PersistentSession session) {
		return (Pemesan) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Pemesan[] listPemesan(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Pemesan[]) list.toArray(new Pemesan[list.size()]);
	}
}

