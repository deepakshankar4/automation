package com.tr.daoimpl;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tr.dao.UserDao;
import com.tr.errorandstatuscodes.ErrorCodes;
import com.tr.model.UserInfo;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<UserInfo> LoginDao(String un, String epw) {

		return (List<UserInfo>) sessionFactory.getCurrentSession()
				.createCriteria(UserInfo.class)
				.add(Restrictions.eq("username", un))
				.add(Restrictions.eq("password", epw)).list();

	}

	@SuppressWarnings("unchecked")
	public List<UserInfo> LoginDao(String gmail) {

		return (List<UserInfo>) sessionFactory.getCurrentSession()
				.createCriteria(UserInfo.class)
				.add(Restrictions.eq("email", gmail)).list();
	}

	@SuppressWarnings("unchecked")
	public List<UserInfo> fetchUsers(String usr) {

		try {

			return (List<UserInfo>) sessionFactory.getCurrentSession()
					.createCriteria(UserInfo.class)
					.add(Restrictions.eq("username", usr)).list();

		} catch (HibernateException ex) {
			ex.printStackTrace();
		}

		return null;

	}

	public Integer regNewUser(String un, String pw, String email,
			String referrer) throws HibernateException {

		Integer UID = null;
		try {

			@SuppressWarnings("unchecked")
			List<UserInfo> ifPresnt = (List<UserInfo>) sessionFactory
					.getCurrentSession().createCriteria(UserInfo.class)
					.add(Restrictions.eq("username", un)).list();
			@SuppressWarnings("unchecked")
			List<UserInfo> ifPresnt2 = (List<UserInfo>) sessionFactory
					.getCurrentSession().createCriteria(UserInfo.class)
					.add(Restrictions.eq("email", email)).list();
			if (ifPresnt.size() == 0 && ifPresnt2.size() == 0) {

				File pic = new File("D:\\dump\\default-user-picture.jpg");

				UserInfo user = new UserInfo();
				user.setUsername(un);
				user.setPassword(pw);
				user.setEmail(email);
				user.setUser_identity(user.hashCode());
				user.setProfile_pic(pic);
				UserInfo ref;

				if (referrer != "") {

					try {

						@SuppressWarnings("unchecked")
						List<UserInfo> list = (List<UserInfo>) sessionFactory
								.getCurrentSession()
								.createCriteria(UserInfo.class)
								.add(Restrictions.eq("email", referrer)).list();
						Iterator<UserInfo> it = list.iterator();
						if (it.hasNext()) {
							ref = it.next();
							System.out.println(ref.getUsername());
							user.setReferrer(ref);
							System.out
									.println(user.getReferrer().getUsername());

						}

					}

					catch (Exception ex) {

						ex.printStackTrace();
					}

				} else {
					user.setReferrer(null);

				}

				UID = (Integer) sessionFactory.getCurrentSession().save(user);

			} else {

				return ErrorCodes.getEcommUserRegError();

			}
		} finally {

		}
		return UID;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> fetchUsers(int usr) {
		try {

			return (List<UserInfo>) sessionFactory.getCurrentSession()
					.createCriteria(UserInfo.class)
					.add(Restrictions.eq("user_identity", usr)).list();

		} catch (HibernateException ex) {
			ex.printStackTrace();
		}

		return null;
	}

}
