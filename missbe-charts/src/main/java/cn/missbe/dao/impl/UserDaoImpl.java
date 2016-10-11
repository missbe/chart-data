package cn.missbe.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.missbe.dao.UserDao;
import cn.missbe.entity.Admin;

@Repository("userDao")
public class UserDaoImpl implements UserDao<Admin> {

	@Autowired
	private SessionFactory sessionFactory;

	public Admin getUser(String username, String password) {
		// TODO Auto-generated method stub
		List<Admin> admins = find("from admin_inf admin where admin.username=? and admin.password=? ",
				username,
				password);
		return admins.get(0);
	}

	@Override
	public List<Admin> find(String hql, Object... params) {
		// 创建查询
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		// 为包含占位符的HQL语句设置参数
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		return (List<Admin>) query.list();

	}

}
