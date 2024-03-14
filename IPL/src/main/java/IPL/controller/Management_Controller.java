package IPL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import IPL.dao.Management_dao;
import IPL.dto.Management;

@Controller
public class Management_Controller 
{
	@Autowired
	Management_dao management_dao;
	
	@RequestMapping("managementsignup")
	@ResponseBody
	public ModelAndView management_signup(@ModelAttribute Management management)
	{
		
		management_dao.Management_save(management);
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("msg","Sign up success");
		modelAndView.setViewName("loginArea.jsp");
		return modelAndView;
		
	}
	
	@PostMapping("managementlogin")
	@ResponseBody
	public ModelAndView management_Login(@RequestParam String name,@RequestParam String password) //in MVC we have use the same var name in the frontend as in the DB beacause the feature of parsing internally 
	{
		
		Management management=management_dao.management_Login_fetch(name);
		ModelAndView  modelAndView=new ModelAndView();
		
		if(management==null)
		{
			modelAndView.addObject("msg","Invalid Username");
			modelAndView.setViewName("loginArea.jsp");
		}
		else 
		{
			if(management.getPassword().equals(password))
			{
				modelAndView.addObject("msg","Login  successfully");
				modelAndView.setViewName("managementHome.jsp");
			}
			else 
			{
				modelAndView.addObject("msg","Invalid password");
				modelAndView.setViewName("loginArea.jsp");
			}
		}
		
		return modelAndView;
	}


}
