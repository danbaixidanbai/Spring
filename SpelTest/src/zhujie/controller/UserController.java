package zhujie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import zhujie.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	public void showUserController(){
		System.out.println("showUserControllers");
		userService.showUserService();
	}
}
