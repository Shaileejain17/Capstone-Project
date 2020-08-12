package com.dbOperations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.SpotLight;

public class HibernateSpotDBOperation {

	private Configuration configuration = null;
	private SessionFactory sessionFactory = null;
	private Session session = null;

	public HibernateSpotDBOperation() {
		configuration = new Configuration();
		sessionFactory = configuration.configure().buildSessionFactory();
		session = sessionFactory.openSession();
	}

	public SpotLight getSL(int id) {
		SpotLight sl = (SpotLight) session.get(SpotLight.class, id);
		return sl;
	}

	public int insertSL(SpotLight sl) {
		int id = -1;
		try {
			Transaction tx = session.beginTransaction();
			id = (int) this.session.save(sl);
			tx.commit();
		} catch (Exception e) {
			id = -1;
		}
		return id;
	}

	public void updateSL(SpotLight sl) {
		Transaction tx = session.beginTransaction();
		SpotLight spotlight = (SpotLight) session.get(SpotLight.class, sl.getId());
		// spotlight.setId(sl.getId());
		spotlight.setTitle(sl.getTitle());
		spotlight.setCountry(sl.getCountry());
		spotlight.setDescription(sl.getDescription());
		spotlight.setKeywords(sl.getKeywords());
		spotlight.setLanguage(sl.getLanguage());
		spotlight.setProductImage(sl.getProductImage());
		spotlight.setSpotlight(sl.getSpotlight());
		spotlight.setEndDate(sl.getEndDate());
		spotlight.setStartDate(sl.getStartDate());

		session.update(spotlight);
		tx.commit();
	}

	public boolean deleteSL(int id) {
		SpotLight sl = getSL(id);
		Transaction tx = session.beginTransaction();
		session.delete(sl);
		tx.commit();

		return true;
	}

	public boolean deleteMSL(int[] arr) {
		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			deleteSL(arr[i]);
			flag = true;
		}
		return flag;
	}

	public List<SpotLight> getAllSL() {
		List<SpotLight> slList = session.createQuery("FROM SpotLight").list();
		int count = slList.size(); // to show the total count
		return slList;
	}

	public void closeSession() {
		session.clear();
		session.close();
	}

}
