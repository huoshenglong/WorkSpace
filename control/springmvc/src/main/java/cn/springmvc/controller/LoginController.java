package cn.springmvc.controller; 
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.springmvc.service.UserService;


@Controller
@RequestMapping("/")
public class LoginController {
 
	@Autowired
	public UserService uss;	
	@RequestMapping("login")
	@ResponseBody
	public String login(HttpServletRequest request) {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean result=uss.loginByName(username, password);
		if (result) {
			System.out.println("login success");
			return "success";
		}else{
			System.out.println("login faile");
			return "faile";
		}	 
	}
	 
}