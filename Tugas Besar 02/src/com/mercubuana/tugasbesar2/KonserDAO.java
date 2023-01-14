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

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class KonserDAO {
	public static Konser loadKonserByORMID(int idKonser) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return loadKonserByORMID(session, idKonser);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Konser getKonserByORMID(int idKonser) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return getKonserByORMID(session, idKonser);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Konser loadKonserByORMID(int idKonser, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return loadKonserByORMID(session, idKonser, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Konser getKonserByORMID(int idKonser, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return getKonserByORMID(session, idKonser, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Konser loadKonserByORMID(PersistentSession session, int idKonser) throws PersistentException {
		try {
			return (Konser) session.load(com.mercubuana.tugasbesar2.Konser.class, Integer.valueOf(idKonser));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Konser getKonserByORMID(PersistentSession session, int idKonser) throws PersistentException {
		try {
			return (Konser) session.get(com.mercubuana.tugasbesar2.Konser.class, Integer.valueOf(idKonser));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Konser loadKonserByORMID(PersistentSession session, int idKonser, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Konser) session.load(com.mercubuana.tugasbesar2.Konser.class, Integer.valueOf(idKonser), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Konser getKonserByORMID(PersistentSession session, int idKonser, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Konser) session.get(com.mercubuana.tugasbesar2.Konser.class, Integer.valueOf(idKonser), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryKonser(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return queryKonser(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryKonser(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return queryKonser(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Konser[] listKonserByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return listKonserByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Konser[] listKonserByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return listKonserByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryKonser(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mercubuana.tugasbesar2.Konser as Konser");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryKonser(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mercubuana.tugasbesar2.Konser as Konser");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Konser", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Konser[] listKonserByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKonser(session, condition, orderBy);
			return (Konser[]) list.toArray(new Konser[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Konser[] listKonserByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKonser(session, condition, orderBy, lockMode);
			return (Konser[]) list.toArray(new Konser[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Konser loadKonserByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return loadKonserByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Konser loadKonserByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return loadKonserByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Konser loadKonserByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Konser[] konsers = listKonserByQuery(session, condition, orderBy);
		if (konsers != null && konsers.length > 0)
			return konsers[0];
		else
			return null;
	}
	
	public static Konser loadKonserByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Konser[] konsers = listKonserByQuery(session, condition, orderBy, lockMode);
		if (konsers != null && konsers.length > 0)
			return konsers[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateKonserByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return iterateKonserByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateKonserByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return iterateKonserByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateKonserByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mercubuana.tugasbesar2.Konser as Konser");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateKonserByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mercubuana.tugasbesar2.Konser as Konser");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Konser", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Konser createKonser() {
		return new com.mercubuana.tugasbesar2.Konser();
	}
	
	public static boolean save(com.mercubuana.tugasbesar2.Konser konser) throws PersistentException {
		try {
			TugasBesar02PersistentManager.instance().saveObject(konser);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(com.mercubuana.tugasbesar2.Konser konser) throws PersistentException {
		try {
			TugasBesar02PersistentManager.instance().deleteObject(konser);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(com.mercubuana.tugasbesar2.Konser konser)throws PersistentException {
		try {
			com.mercubuana.tugasbesar2.Pemesan[] lPemesans = konser.pemesan.toArray();
			for(int i = 0; i < lPemesans.length; i++) {
				lPemesans[i].setKonserid_konser(null);
			}
			return delete(konser);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(com.mercubuana.tugasbesar2.Konser konser, org.orm.PersistentSession session)throws PersistentException {
		try {
			com.mercubuana.tugasbesar2.Pemesan[] lPemesans = konser.pemesan.toArray();
			for(int i = 0; i < lPemesans.length; i++) {
				lPemesans[i].setKonserid_konser(null);
			}
			try {
				session.delete(konser);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(com.mercubuana.tugasbesar2.Konser konser) throws PersistentException {
		try {
			TugasBesar02PersistentManager.instance().getSession().refresh(konser);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(com.mercubuana.tugasbesar2.Konser konser) throws PersistentException {
		try {
			TugasBesar02PersistentManager.instance().getSession().evict(konser);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Konser loadKonserByCriteria(KonserCriteria konserCriteria) {
		Konser[] konsers = listKonserByCriteria(konserCriteria);
		if(konsers == null || konsers.length == 0) {
			return null;
		}
		return konsers[0];
	}
	
	public static Konser[] listKonserByCriteria(KonserCriteria konserCriteria) {
		return konserCriteria.listKonser();
	}
}
