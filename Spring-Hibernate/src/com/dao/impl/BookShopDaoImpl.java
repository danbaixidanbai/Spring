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
	
	//���Ƽ�ʹ�� HibernateTemplate �� HibernateDaoSupport
		//��Ϊ�����ᵼ�� Dao �� Spring �� API �������
		//������ֲ�Ա��
	//	private HibernateTemplate hibernateTemplate;
		
		//��ȡ�͵�ǰ�̰߳󶨵� Session.
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * Spring hibernate ���������
	 * 1. �ڷ�����ʼ֮ǰ
	 * ��. ��ȡ Session
	 * ��. �� Session �͵�ǰ�̰߳�, �����Ϳ����� Dao ��ʹ�� SessionFactory ��
	 * getCurrentSession() ��������ȡ Session ��
	 * ��. ��������
	 * 
	 * 2. ��������������, ��û�г����쳣, ��
	 * ��. �ύ����
	 * ��. ʹ�͵�ǰ�̰߳󶨵� Session �����
	 * ��. �ر� Session
	 * 
	 * 3. �����������쳣, ��:
	 * ��. �ع�����
	 * ��. ʹ�͵�ǰ�̰߳󶨵� Session �����
	 * ��. �ر� Session
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
		//��֤��Ŀ���Ƿ����.
		if(kucun==0) throw new BookKuCunException("��治��");
		String hql="update Book  set kucun=kucun-1 where isbn=?";
		getSession().createQuery(hql).setString(0, isbn).executeUpdate();
	}

	@Override
	public void updateUserAccount(String userName, int price) {
		String hql="select a.money from Account a where a.userName=?";
		int money=(Integer)getSession().createQuery(hql).setString(0, userName).uniqueResult();
		//��֤����Ƿ��㹻
		if(money<price) throw new AccountMoneyException("���㣡");
		String hql1 = "update Account a set a.money = a.money - ? WHERE a.userName = ?";
		getSession().createQuery(hql1).setInteger(0, price).setString(1, userName).executeUpdate();

	}

}
