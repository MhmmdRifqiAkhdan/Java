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

public class PemesanDAO {
	public static Pemesan loadPemesanByORMID(int idPemesan) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return loadPemesanByORMID(session, idPemesan);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pemesan getPemesanByORMID(int idPemesan) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return getPemesanByORMID(session, idPemesan);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pemesan loadPemesanByORMID(int idPemesan, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return loadPemesanByORMID(session, idPemesan, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pemesan getPemesanByORMID(int idPemesan, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return getPemesanByORMID(session, idPemesan, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pemesan loadPemesanByORMID(PersistentSession session, int idPemesan) throws PersistentException {
		try {
			return (Pemesan) session.load(com.mercubuana.tugasbesar2.Pemesan.class, Integer.valueOf(idPemesan));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pemesan getPemesanByORMID(PersistentSession session, int idPemesan) throws PersistentException {
		try {
			return (Pemesan) session.get(com.mercubuana.tugasbesar2.Pemesan.class, Integer.valueOf(idPemesan));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pemesan loadPemesanByORMID(PersistentSession session, int idPemesan, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Pemesan) session.load(com.mercubuana.tugasbesar2.Pemesan.class, Integer.valueOf(idPemesan), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pemesan getPemesanByORMID(PersistentSession session, int idPemesan, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Pemesan) session.get(com.mercubuana.tugasbesar2.Pemesan.class, Integer.valueOf(idPemesan), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPemesan(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return queryPemesan(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPemesan(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return queryPemesan(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pemesan[] listPemesanByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return listPemesanByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pemesan[] listPemesanByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return listPemesanByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPemesan(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mercubuana.tugasbesar2.Pemesan as Pemesan");
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
	
	public static List queryPemesan(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mercubuana.tugasbesar2.Pemesan as Pemesan");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Pemesan", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pemesan[] listPemesanByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryPemesan(session, condition, orderBy);
			return (Pemesan[]) list.toArray(new Pemesan[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pemesan[] listPemesanByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryPemesan(session, condition, orderBy, lockMode);
			return (Pemesan[]) list.toArray(new Pemesan[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pemesan loadPemesanByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return loadPemesanByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pemesan loadPemesanByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return loadPemesanByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pemesan loadPemesanByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Pemesan[] pemesans = listPemesanByQuery(session, condition, orderBy);
		if (pemesans != null && pemesans.length > 0)
			return pemesans[0];
		else
			return null;
	}
	
	public static Pemesan loadPemesanByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Pemesan[] pemesans = listPemesanByQuery(session, condition, orderBy, lockMode);
		if (pemesans != null && pemesans.length > 0)
			return pemesans[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePemesanByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return iteratePemesanByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePemesanByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return iteratePemesanByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePemesanByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mercubuana.tugasbesar2.Pemesan as Pemesan");
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
	
	public static java.util.Iterator iteratePemesanByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mercubuana.tugasbesar2.Pemesan as Pemesan");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Pemesan", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pemesan createPemesan() {
		return new com.mercubuana.tugasbesar2.Pemesan();
	}
	
	public static boolean save(com.mercubuana.tugasbesar2.Pemesan pemesan) throws PersistentException {
		try {
			TugasBesar02PersistentManager.instance().saveObject(pemesan);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(com.mercubuana.tugasbesar2.Pemesan pemesan) throws PersistentException {
		try {
			TugasBesar02PersistentManager.instance().deleteObject(pemesan);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(com.mercubuana.tugasbesar2.Pemesan pemesan)throws PersistentException {
		try {
			if (pemesan.getKonserid_konser() != null) {
				pemesan.getKonserid_konser().pemesan.remove(pemesan);
			}
			
			return delete(pemesan);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(com.mercubuana.tugasbesar2.Pemesan pemesan, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (pemesan.getKonserid_konser() != null) {
				pemesan.getKonserid_konser().pemesan.remove(pemesan);
			}
			
			try {
				session.delete(pemesan);
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
	
	public static boolean refresh(com.mercubuana.tugasbesar2.Pemesan pemesan) throws PersistentException {
		try {
			TugasBesar02PersistentManager.instance().getSession().refresh(pemesan);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(com.mercubuana.tugasbesar2.Pemesan pemesan) throws PersistentException {
		try {
			TugasBesar02PersistentManager.instance().getSession().evict(pemesan);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pemesan loadPemesanByCriteria(PemesanCriteria pemesanCriteria) {
		Pemesan[] pemesans = listPemesanByCriteria(pemesanCriteria);
		if(pemesans == null || pemesans.length == 0) {
			return null;
		}
		return pemesans[0];
	}
	
	public static Pemesan[] listPemesanByCriteria(PemesanCriteria pemesanCriteria) {
		return pemesanCriteria.listPemesan();
	}
}
