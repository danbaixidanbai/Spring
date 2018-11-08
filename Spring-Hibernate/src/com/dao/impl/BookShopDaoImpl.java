package com.dao.impl;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.BookShopDao;
import com.exception.AccountMoneyException;
import com.exception.BookKuCunException;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//不推荐使用 HibernateTemplate 和 HibernateDaoSupport
		//因为这样会导致 Dao 和 Spring 的 API 进行耦合
		//可以移植性变差
	//	private HibernateTemplate hibernateTemplate;
		
		//获取和当前线程绑定的 Session.
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * Spring hibernate 事务的流程
	 * 1. 在方法开始之前
	 * ①. 获取 Session
	 * ②. 把 Session 和当前线程绑定, 这样就可以在 Dao 中使用 SessionFactory 的
	 * getCurrentSession() 方法来获取 Session 了
	 * ③. 开启事务
	 * 
	 * 2. 若方法正常结束, 即没有出现异常, 则
	 * ①. 提交事务
	 * ②. 使和当前线程绑定的 Session 解除绑定
	 * ③. 关闭 Session
	 * 
	 * 3. 若方法出现异常, 则:
	 * ①. 回滚事务
	 * ②. 使和当前线程绑定的 Session 解除绑定
	 * ③. 关闭 Session
	 */
	@Override
	public int findBookPriceByIsbn(String isbn) {
		String hql="select b.price from Book b where b.isbn=?";
		int price=(Integer)getSession().createQuery(hql).setString(0, isbn).uniqueResult();
		return price;
	}

	@Override
	public void updateBookStock(String isbn) {
		String hql1="select b.kucun from Book b where b.isbn=?";
		int kucun=(Integer)getSession().createQuery(hql1).setString(0, isbn).uniqueResult();
		//验证书的库存是否充足.
		if(kucun==0) throw new BookKuCunException("库存不足");
		String hql="update Book  set kucun=kucun-1 where isbn=?";
		getSession().createQuery(hql).setString(0, isbn).executeUpdate();
	}

	@Override
	public void updateUserAccount(String userName, int price) {
		String hql="select a.money from Account a where a.userName=?";
		int money=(Integer)getSession().createQuery(hql).setString(0, userName).uniqueResult();
		//验证余额是否足够
		if(money<price) throw new AccountMoneyException("余额不足！");
		String hql1 = "update Account a set a.money = a.money - ? WHERE a.userName = ?";
		getSession().createQuery(hql1).setInteger(0, price).setString(1, userName).executeUpdate();

	}

}
