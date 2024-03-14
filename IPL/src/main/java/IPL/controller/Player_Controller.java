package IPL.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import IPL.dao.PlayerDao;
import IPL.dto.Players;

@RestController
public class Player_Controller 
{
	@Autowired
	PlayerDao playerDao;
	
  @RequestMapping("playersignup")
  public ModelAndView playerSignup(@ModelAttribute Players players) 
  {
	players.setStatus("pending");
	playerDao.playerSignUpDao(players);
	
	ModelAndView modelAndView=new ModelAndView();
	modelAndView.addObject("msg",players.getName()+" your account has been created successfully");
	modelAndView.setViewName("playerLogin.jsp");
	
	return modelAndView;
  }
  
  @RequestMapping("playerlogin")
  public ModelAndView playerLogin(@RequestParam String username,@RequestParam String password, HttpSession httpSession) 
  {
	Players players=playerDao.playerLoginCheck(username);
	ModelAndView modelAndView=new ModelAndView();
	
	if(players==null)
	{
		modelAndView.addObject("msg","Invalid Username");
		modelAndView.setViewName("loginArea.jsp");
	}
	else 
	{
		if(players.getPassword().equals(password))
		{
			httpSession.setAttribute("player", players); //for future use I am setting the information of player by using session tracking concept 
			modelAndView.addObject("msg","Login success");
			modelAndView.setViewName("playerHome.jsp");
		}
		else 
		{
			modelAndView.addObject("msg","Invalid Password");
			modelAndView.setViewName("loginArea.jsp");
		}
	}
	return modelAndView;
  }
  
  @RequestMapping("editplayersdetails")
  public ModelAndView editPlayeR(HttpSession httpSession)
  {
	  Players  players=(Players) httpSession.getAttribute("player"); //****session tracking
	  
	  ModelAndView modelAndView=new ModelAndView();
	  modelAndView.addObject("player",players);
	  modelAndView.setViewName("editPlayersDetails.jsp");
	  
	  return modelAndView;
	
  } 
  
  
  @PostMapping("updateplayer")
  public ModelAndView updateplayer(@ModelAttribute Players players) 
  {
	playerDao.updateDetails(players);
	
	  ModelAndView modelAndView=new ModelAndView();
	  modelAndView.addObject("msg","Details updated");
	  modelAndView.setViewName("playerHome.jsp");
	  
	  return modelAndView;
  }
  
  @RequestMapping("viewplayers")
  public ModelAndView viewPlayersComingForAuction() 
  {
	List<Players> player1=playerDao.fetchAllPlayers();
	
	ModelAndView modelAndView =new ModelAndView();

	  
		if(player1==null)
		{
			  modelAndView.addObject("msg","There is no Player till now");
			  modelAndView.setViewName("managementHome.jsp");
		}
		
		else 
		{
			modelAndView.addObject("players",player1);
		    modelAndView.setViewName("viewAllPlayers.jsp");
		}
		return modelAndView;
	  
	
  }
  
  @RequestMapping("changeplayerstatus")
  public ModelAndView changeStatus(@RequestParam int id) 
  {
	Players players=playerDao.findFetch(id);
	
	if (players.getStatus().equals("pending")) 
	{
		players.setStatus("available");
		
	}
	else 
	{
		players.setStatus("pending");
	}
	
	playerDao.updateDetails(players);
	
	List<Players> players2=playerDao.fetchAllPlayers();

	ModelAndView modelAndView =new ModelAndView();
	modelAndView.addObject("msg","data got updated");
	modelAndView.addObject("players",players2);

    modelAndView.setViewName("viewAllPlayers.jsp");
    return modelAndView;
  }
  
  
  @RequestMapping("viewavailableplayers")
  public ModelAndView viewPlayersAvailable() 
  {
	List<Players> players=playerDao.viewPlayerDao();
	ModelAndView modelAndView=new ModelAndView();
	if (players.isEmpty()) 
	{
		modelAndView.addObject("msg","No players available");
		modelAndView.setViewName("teamHome.jsp");
	}
	else 
	{
		modelAndView.addObject("players",players);
		modelAndView.setViewName("BuyPlayer.jsp");
	}
	return modelAndView;
  } 
}
