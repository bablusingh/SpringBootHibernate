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
import com.app.aiolus.entities.User;
import com.app.aiolus.entities.UserDetail;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public UserDetail addUser(UserDetail userDetail) {

		sessionFactory.getCurrentSession().persist(userDetail);
		return userDetail;

	}

	@Override
	public UserDetail updateUser(UserDetail userDetail) {

		sessionFactory.getCurrentSession().update(userDetail);
		return userDetail;

	}

	@Override
	public Map<String, Object> getAllUser(int pageSize, int page) {

		Map<String, Object> data = new HashMap<>();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserDetail.class)
				.addOrder(Order.desc(Constant.ID));
		data.put(Constant.COUNT, criteria.setProjection(Projections.rowCount()).uniqueResult());
		criteria.setProjection(null);
		criteria.setFirstResult((page - 1) * pageSize);
		criteria.setMaxResults(pageSize);
		data.put(Constant.DATA, criteria.list());

		return data;

	}

	@Override
	public UserDetail getSingleUserById(long id) {

		return sessionFactory.getCurrentSession().get(UserDetail.class, id);

	}

	@Override
	public User doLogin(String userId, String userPassword) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("userId", userId));
		criteria.add(Restrictions.eq("userPassword", userPassword));
		return criteria.list().size() > Constant.ZERO ? (User) criteria.list().get(Constant.ZERO) : null;

	}

	@Override
	public User getSingleUserIdUser(long idUser) {

		return sessionFactory.getCurrentSession().get(User.class, idUser);

	}

}
