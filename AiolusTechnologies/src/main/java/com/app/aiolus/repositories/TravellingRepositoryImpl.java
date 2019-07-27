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
import com.app.aiolus.entities.Travelling;

@Repository
@Transactional
public class TravellingRepositoryImpl implements TravellingRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Travelling addTravelling(Travelling travellingModel) {

		sessionFactory.getCurrentSession().save(travellingModel);
		return travellingModel;

	}

	@Override
	public Travelling updateTravelling(Travelling travelling) {

		sessionFactory.getCurrentSession().update(travelling);

		return travelling;

	}

	@Override
	public Map<String, Object> getAllTravelling(int pageSize, int page) {

		Map<String, Object> data = new HashMap<>();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Travelling.class)
				.addOrder(Order.desc(Constant.ID));
		data.put(Constant.COUNT, criteria.setProjection(Projections.rowCount()).uniqueResult());
		criteria.setProjection(null);
		criteria.setFirstResult((page - 1) * pageSize);
		criteria.setMaxResults(pageSize);
		data.put(Constant.DATA, criteria.list());
		return data;

	}

	@Override
	public Map<String, Object> getAllTravellingByIdUser(long idUser, int pageSize, int page) {

		Map<String, Object> data = new HashMap<>();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Travelling.class);
		criteria.add(Restrictions.eq("user.idUser", idUser)).addOrder(Order.desc(Constant.ID));
		data.put(Constant.COUNT, criteria.setProjection(Projections.rowCount()).uniqueResult());
		criteria.setProjection(null);
		criteria.setFirstResult((page - 1) * pageSize);
		criteria.setMaxResults(pageSize);
		data.put(Constant.DATA, criteria.list());
		return data;

	}

	@Override
	public Travelling getSingleTravellById(long id) {
		return sessionFactory.getCurrentSession().get(Travelling.class, id);

	}

}
