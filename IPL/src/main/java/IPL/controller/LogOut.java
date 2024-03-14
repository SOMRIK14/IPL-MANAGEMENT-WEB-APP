package IPL.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class LogOut {
	
	@RequestMapping("logOut")
	public void logOutMethod(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException {
		httpServletRequest.getSession().invalidate();;
		
		httpServletResponse.sendRedirect("loginArea.jsp");
		
		
	}

}
