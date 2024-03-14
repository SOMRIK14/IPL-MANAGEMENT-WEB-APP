package IPL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import IPL.dto.Management;
import IPL.dto.Players;
import IPL.dto.Team;

@Controller
public class Signup_Controller 
{
	@Autowired
	Management management;//creating Managemant dto object to send to insert data from frontend using ModelAndView obj
	
	@Autowired
	Team team;
	
	@Autowired
	Players players;
	
    @RequestMapping("signup")
    @ResponseBody                       //one of the MVC annot. used to print the output in frontend like getwriter.print
	public ModelAndView signUp(@RequestParam String role) //@RequestParam it will work as req.getParameter() and here it will be used to received the value from front end one by one
    {
    	ModelAndView modelAndView=new ModelAndView();//its object is used to include another object(Model) inside itself and send to frontend(View)
    	if(role.equals("Management"))
    	{
    		modelAndView.addObject("management",management); //including the object or message inside ModelAndView class object
    		modelAndView.setViewName("management_signup.jsp"); //just like session tracking send the data to corresponding page
    	}
    	else if(role.equals("Team"))
    	{
    		modelAndView.addObject("team",team); //including the object or message inside ModelAndView class object
    		modelAndView.setViewName("teamSignUp.jsp"); //just like session tracking send the data to corresponding page
    	}
    	
    	else
    	{

    		modelAndView.addObject("players",players); //including the object or message inside ModelAndView class object
    		modelAndView.setViewName("playerSignUp.jsp"); //just like session tracking send the data to corresponding page
    		
    	}
    	return modelAndView;
    	
      
	}
}
