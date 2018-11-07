package zhujie.responsitory.impl;

import org.springframework.stereotype.Repository;

import zhujie.responsitory.UserRespository;

@Repository
public class UserJdbc implements UserRespository {

	@Override
	public void showRespository() {
		System.out.println("UserJdbc:showRespository()");

	}

}
