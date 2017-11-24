package sakilaspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import sakilaspring.dao.ActorDAO;
import sakilaspring.domain.Actor;

@Controller
@SessionAttributes("actor")
public class ActorController {
	
	@Autowired
	ActorDAO actorDAO;
	
	@RequestMapping(value="/actor", method=RequestMethod.GET)
	public void form() {
	}
	
	@RequestMapping(value="/actor/actorList", method=RequestMethod.GET)
	public String actorList(Model model) {
		List<Actor> list = actorDAO.list();
		model.addAttribute("listlista", list);
		return "/actor/actorList";
	}
	
	@RequestMapping(value="/actor/newActor", method=RequestMethod.GET)
	public void newActor(Model model){
		model.addAttribute("actor", new Actor());
	}
	
	@RequestMapping(value="/actor/newActor", method=RequestMethod.POST)
	public String saveActor(Actor actor, Model model){
		actorDAO.save(actor);
		return "redirect:" + actorList(model);
	}
	
	@RequestMapping(value="/actor/editActor/{actorId}", method=RequestMethod.GET)
	public String editActor(Model model, @PathVariable short actorId){
		Actor a = actorDAO.byId(actorId);
		model.addAttribute("actor", a);
		return "/actor/editActor";
	}
	
	@RequestMapping(value="/actor/editActor/{actorId}", method=RequestMethod.POST)
	public String updateActor(Actor actor, @PathVariable short actorId, Model model){
		actor.setActorId(actorId);
		actorDAO.update(actor);
		return "redirect:" + actorList(model);
	}
	
	@RequestMapping(value="/actor/deleteActor/{actorId}", method=RequestMethod.GET)
	public String deleteActor(Model model, @PathVariable short actorId){
		actorDAO.delete(actorId);
		return "redirect:" + actorList(model);
	}
}
