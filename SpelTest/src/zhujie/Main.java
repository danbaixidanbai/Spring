package zhujie;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zhujie.controller.UserController;
import zhujie.responsitory.UserRespository;
import zhujie.service.UserService;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans-component.xml");
		/*UserComponent uc=(UserComponent) ac.getBean("userComponent");
		uc.showCompont();
		
		UserRespository  ur=(UserRespository) ac.getBean("userRespository");
		ur.showRespository();
		
		UserService us=(UserService) ac.getBean("userService");
		us.showUserService();
		*/
		UserController ucc=(UserController) ac.getBean("userController");
		ucc.showUserController();

	}
}
