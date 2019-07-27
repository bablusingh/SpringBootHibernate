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
import com.app.aiolus.entities.Leaves;

@Repository
@Transactional
public class LeavesRepositoryImpl implements LeavesRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Leaves addLeaves(Leaves leaves) {

		sessionFactory.getCurrentSession().save(leaves);

		return leaves;

	}

	@Override
	public Leaves updateLeaves(Leaves leaves) {

		sessionFactory.getCurrentSession().update(leaves);

		return leaves;

	}

	@Override
	public Map<String, Object> getAllLeaves(int pageSize, int page) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Leaves.class)
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
	public Map<String, Object> getAllLeaveByIdUser(long idUser, int pageSize, int page) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Leaves.class);
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
	public Leaves getSingleLeaveById(long idLeave) {

		return sessionFactory.getCurrentSession().get(Leaves.class, idLeave);

	}
}
