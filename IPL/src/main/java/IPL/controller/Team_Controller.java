package IPL.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import IPL.dao.PlayerDao;
import IPL.dao.Team_dao;
import IPL.dto.Players;
import IPL.dto.Team;

//@Controller
@RestController //it will do the work of @Controller also and @ResponseBody also
public class Team_Controller
{
  @Autowired
  Team_dao team_dao;
  
  @Autowired
  PlayerDao playerDao;
  
  @RequestMapping("teamsignup")
//  @ResponseBody
  public ModelAndView loginSignUp(@ModelAttribute Team team) 
  {
	team_dao.teamSave(team);
	
	ModelAndView modelAndView=new ModelAndView();
	modelAndView.addObject("msg","Team account got created ");
	modelAndView.setViewName("loginArea.jsp");
	return modelAndView;
  }
  
  @PostMapping("teamlogin")
//  @ResponseBody
  public ModelAndView teamLogin(@RequestParam String username,@RequestParam String password,HttpSession httpSession) 
  {
	  Team team=team_dao.teamLogin_check(username);
	  ModelAndView modelAndView =new ModelAndView();
	  if(team==null)
	   {

		  modelAndView.addObject("msg","Invalid Username");
		  modelAndView.setViewName("loginArea.jsp");
		  
	    }
	  
	  else 
	   {

	     if(team.getPassword().equals(password))
	     {
	    	 if(team.isStatus()==true)
	    	 {
	    	   httpSession.setAttribute("team",team); //if I want the information in future i CAN GET that from this "team" session tracking
	  		   modelAndView.addObject("msg","Team Login successsfully");
	  		   modelAndView.addObject("img",team.getImageLink());
			   modelAndView.setViewName("teamHome.jsp");
	    	 }
	    	 else 
	    	 {
	    		   modelAndView.addObject("msg","Wait for the Management Approval");
				   modelAndView.setViewName("loginArea.jsp"); 
	    	 }
	      

	      }
	  
	     else 
	       {
		  modelAndView.addObject("msg","Invalid password");
		  modelAndView.setViewName("loginArea.jsp");
	       }
	   }
	  return modelAndView;
	
  }
  
  @RequestMapping("viewAllTeams")
//  @ResponseBody
  public ModelAndView viewAllTeams() 
  {
	List<Team> teams=team_dao.viewAllTeams_details();
	ModelAndView modelAndView =new ModelAndView();

	if(teams.isEmpty())
	{
		  modelAndView.addObject("msg","There is no team till now");
		  modelAndView.setViewName("managementHome.jsp");
	}
	
	else 
	{
		modelAndView.addObject("teams",teams);
	    modelAndView.setViewName("viewTeamDetails.jsp");
	}
	return modelAndView;
  }
  
  @RequestMapping("changestatus")
  public ModelAndView changeStatus(@RequestParam int id) 
  {
	Team team=team_dao.changeStatusDao(id);
	
	if(team.isStatus())
	{
		team.setStatus(false);
	}
	else 
	{
		team.setStatus(true);

	}
	
	team_dao.update(team);
	
	List<Team> teams_dtails=team_dao.updatedDetails();
	
	ModelAndView modelAndView =new ModelAndView();
	modelAndView.addObject("msg","Status got updated");
    modelAndView.setViewName("viewTeamDetails.jsp");

	modelAndView.addObject("teams",teams_dtails); //teams key should be "teams" only as mentioned in the frontend  
    modelAndView.setViewName("viewTeamDetails.jsp");
    return modelAndView;
  }
  
  @PostMapping("addamount")
  public ModelAndView addAmount(@RequestParam double wallet,@RequestParam int tid) 
  {
	Team team=team_dao.addAmountDao(tid);
    team.setWallet(team.getWallet()+wallet);
    team_dao.update(team);
    
	
	ModelAndView modelAndView =new ModelAndView();
	modelAndView.addObject("msg","Amount has been added"+" for"+team.getName()+" successfully");
    modelAndView.setViewName("teamHome.jsp");
    
    return modelAndView;
    
  }
  
  
  @RequestMapping("buyplayer")
  public ModelAndView buyMethod(@RequestParam int id,HttpSession httpSession)
  {
	  Players players=playerDao.findFetch(id);
	  Team team=(Team)httpSession.getAttribute("team");
	  
	  ModelAndView modelAndView=new ModelAndView();
	  
	  if(team.getWallet()<players.getPrice())
	  {
		  modelAndView.addObject("msg","Insufficient balance");
		  modelAndView.setViewName("BuyPlayer.jsp");
	  }
	  else 
	  {
		team.setWallet(team.getWallet()-players.getPrice()); //deducting the value of sold player from team wallet
		players.setStatus("Sold"); //making the player buy to sold
		players.setTeam(team); //setting team data in player table team column
		playerDao.updateDetails(players);   //updating players table
		
		List<Players> players1=team.getList();
		if(players1==null) //null because in DB datatype is null 
		{
			List<Players> players2=new ArrayList<>();
			players2.add(players);
			team.setList(players2);
			team_dao.update(team);
		}
		else 
		{
			
		
		
		List<Players> player3=team.getList(); //getting empty list of Players column in Team table
		player3.add(players);  //adding players list data into the fresh list
		
		team.setList(player3); //setting player list data in Team table players list column
		
		team_dao.update(team); //updating team table
		
				
	   }
		

		modelAndView.addObject("msg","Player has been sold for "+team.getName());
		modelAndView.setViewName("teamHome.jsp");
	 }
	  return modelAndView;
  }
  
  
  @RequestMapping("viewteam")
  public ModelAndView viewTeam(HttpSession httpSession) 
  {
	Team team=(Team) httpSession.getAttribute("team");
	List<Players> players=team.getList();//list means list of players
	
	ModelAndView modelAndView=new ModelAndView();
	
	
	if(players.isEmpty())
	{
		modelAndView.addObject("msg","No players has been sold out");
		modelAndView.addObject("teamname",team.getName());
		modelAndView.setViewName("viewMyTeam.jsp");
	}
	else 
	{
		modelAndView.addObject("players",players);
		modelAndView.addObject("teamname",team.getName());
		modelAndView.setViewName("viewMyTeam.jsp");
	}
	
	return modelAndView;
  }
  
 
  @RequestMapping("viewteambyname")
  public ModelAndView viewTeamByNmae() 
  {
	List<Team> teams=team_dao.viewAllTeams_details();
	
	ModelAndView modelAndView=new ModelAndView();
	modelAndView.addObject("teams",teams);
	modelAndView.setViewName("viewteambyname.jsp");
	
	return modelAndView;
  }
  
  @PostMapping("fetchbyusingteamname")
  public ModelAndView name(@RequestParam String name) 
  {
	Team team=team_dao.fetchTeamUsingName(name);
	List<Players> players=team.getList(); //virat+yuv+chahal
	
	ModelAndView modelAndView=new ModelAndView();
	modelAndView.addObject("players", players);
	
	modelAndView.setViewName("viewMyTeam.jsp");
	return modelAndView;
  }
  
}
