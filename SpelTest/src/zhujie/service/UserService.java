package zhujie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import zhujie.responsitory.UserRespository;

@Service
public class UserService {
	@Autowired
	@Qualifier("userJdbc")
	private UserRespository userRespository;
	
	public void showUserService(){
		System.out.println("showUserService...........");
		userRespository.showRespository();
	} 
}
