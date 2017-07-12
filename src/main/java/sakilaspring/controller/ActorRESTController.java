package sakilaspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sakilaspring.bean.ActorBean;
import sakilaspring.dao.ActorDAO;
import sakilaspring.domain.Actor;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import sakilaspring.toa.ActorTOA;

@RestController("/rest")
public class ActorRESTController {

    @Autowired
    ActorDAO actorDAO;

    @RequestMapping(path="/rest/actor", method=RequestMethod.GET)
    public List<ActorBean> list(){
        List<Actor> l = actorDAO.list();
        List<ActorBean> beans = ActorTOA.toBean(l);
        return beans;
    }

    @RequestMapping(path="/rest/actor/{id}", method=RequestMethod.GET)
    public Actor detail(@PathVariable int id){
        Actor actor = actorDAO.byId(id);
        return actor;
    }
    
    @RequestMapping(path="/rest/actor", method=RequestMethod.POST)
    public void create(@RequestBody ActorBean ab){
        Actor actor = ActorTOA.toModel(ab);
        actorDAO.save(actor);
    }
    
    @RequestMapping(path="/rest/actor", method=RequestMethod.PUT)
    public void update(@RequestBody ActorBean ab){
        Actor actor = ActorTOA.toModel(ab);
        actorDAO.update(actor);
    }
    
    @RequestMapping(path="/rest/actor/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        actorDAO.delete(id);
    }
    
}
