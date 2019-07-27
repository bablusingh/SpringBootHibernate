package com.app.aiolus.repositories;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.aiolus.constants.Constant;
import com.app.aiolus.entities.Billing;

@Repository
@Transactional
public class BillingRepositoryImpl implements BillingRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Billing addBilling(Billing billing) {
		
		sessionFactory.getCurrentSession().save(billing);
		return  billing;
		

	}

	@Override
	public Billing updateBilling(Billing billing) {

		sessionFactory.getCurrentSession().update(billing);
		return billing;

	}

	@Override
	public Map<String, Object> getBillingByIdUser(long idUser, int pageSize, int page) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Billing.class);
		Map<String, Object> data = new HashMap<>();
		criteria.add(Restrictions.eq("user.idUser", idUser)).addOrder(Order.desc(Constant.ID));
		data.put(Constant.COUNT, criteria.setProjection(Projections.rowCount()).uniqueResult());
		criteria.setProjection(null);
		criteria.setFirstResult((page - 1) * pageSize);
		criteria.setMaxResults(pageSize);
		data.put(Constant.DATA, criteria.list());

		return data;

	}

	@Override
	public Map<String, Object> getAllBilling(int pageSize, int page) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Billing.class)
				.addOrder(Order.desc(Constant.ID));
		Map<String, Object> data = new HashMap<>();
		data.put(Constant.COUNT, criteria.setProjection(Projections.rowCount()).uniqueResult());
		criteria.setProjection(null);
		criteria.setFirstResult((page - 1) * pageSize);
		criteria.setMaxResults(pageSize);

		data.put(Constant.DATA, criteria.list());
		return data;

	}

	@Override
	public Billing getSingleBillingById(long id) {

		return sessionFactory.getCurrentSession().get(Billing.class, id);

	}

}
