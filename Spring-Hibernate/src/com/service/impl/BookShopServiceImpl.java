package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BookShopDao;
import com.service.BookShopService;

@Service
public class BookShopServiceImpl implements BookShopService {
	
	@Autowired
	private BookShopDao bookShopDao;
	@Override
	public void buys(String userName,String isbn){
			int price=bookShopDao.findBookPriceByIsbn(isbn);
			bookShopDao.updateBookStock(isbn);
			bookShopDao.updateUserAccount(userName, price);
		}
		
	

}
