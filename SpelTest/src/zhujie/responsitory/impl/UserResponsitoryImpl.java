package zhujie.responsitory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zhujie.UserComponent;
import zhujie.responsitory.UserRespository;

@Repository
public class UserResponsitoryImpl implements UserRespository {
	
	@Autowired
	private UserComponent userComponent;

	@Override
	public void showRespository() {
		System.out.println("UserResponsitoryImpl:showRespository............");
		userComponent.showCompont();

	}

}
