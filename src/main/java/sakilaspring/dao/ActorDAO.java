package sakilaspring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sakilaspring.domain.Actor;

@Repository
public class ActorDAO {

	@PersistenceContext
	EntityManager em;
	
	public List<Actor> list(){
		TypedQuery<Actor> q = em.createNamedQuery("Actor.findAll", Actor.class);
		List<Actor> l = q.getResultList();
		return l;
	}
	
	public Actor byId(int id){
		return em.find(Actor.class, id);
	}
	
	@Transactional
	public void delete(int id){
		Actor a = em.find(Actor.class, id);
		em.remove(a);
	}
	
	@Transactional
	public void update(Actor a){
		Actor a1 = em.find(Actor.class, a.getActorId());
		a1.setFirstName(a.getFirstName());
		a1.setLastName(a.getLastName());
		em.persist(a1);
	}

	@Transactional
	public void save(Actor a) {;
		em.persist(a);
	}
	
}
