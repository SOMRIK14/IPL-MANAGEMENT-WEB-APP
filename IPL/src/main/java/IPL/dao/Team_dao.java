package IPL.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import IPL.dto.Management;
import IPL.dto.Team;

@Component
public class Team_dao {
	@Autowired
	EntityManager entityManager;


	public void teamSave(Team team) 
	{
		EntityTransaction entityTransaction = entityManager.getTransaction();


		entityTransaction.begin();
		entityManager.persist(team);
		entityTransaction.commit();
	}
	

	public Team teamLogin_check(String username) 
	{
		List<Team> list = entityManager.createQuery("select x from Team x where username=?1").setParameter(1, username).getResultList();
		
		if (list.isEmpty())
		{
			return null;
		} else 
		{
			return list.get(0);
		}
	}
	

	
	
	public List<Team> viewAllTeams_details() 
	{
		List<Team> teams = entityManager.createQuery("select x from Team x").getResultList();
		return  teams;
	}
	
	
	
	public Team changeStatusDao(int id)
	{
		Team team=entityManager.find(Team.class,id);
		return team;
	}
	
	
	public void update(Team team) 
	{
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.merge(team);
		entityTransaction.commit();
	}
	
	
	public List<Team> updatedDetails() 
	{
		List<Team> teams = entityManager.createQuery("select x from Team x").getResultList();
		return  teams;
	}


	public Team addAmountDao(int tid)
	{
		Team team=entityManager.find(Team.class,tid);
		return team;		
	}
	
	public Team fetchTeamUsingName(String name) 
	{
		List<Team> teams = entityManager.createQuery("select x from Team x where name=?1").setParameter(1, name).getResultList();
		
		if(teams.isEmpty())
		{
			return null;
		}
		else 
		{
			return teams.get(0);
		}
	}
	
	

}
