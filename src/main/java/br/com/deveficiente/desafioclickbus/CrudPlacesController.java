package br.com.deveficiente.desafioclickbus;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudPlacesController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping("/places")
    @Transactional
    public void save(@Valid final BasicPlaceRequest request) {
        manager.persist(request.toModel());
    }

    @PutMapping("/places/{id}")
    @Transactional
    public void update(@PathVariable("id") final Long id, @Valid final BasicPlaceRequest request) {
        final Place currentPlace = manager.find(Place.class, id);
        currentPlace.update(request.toModel());
    }   

    @GetMapping("/places")
    public List<BasicPlaceResponse> list(){
        return manager.createQuery("select p from Place p",Place.class).getResultList().stream().map(BasicPlaceResponse :: new).collect(Collectors.toList());
    }

    @DeleteMapping("/places/{id}")
    @Transactional
    public void delete(@PathVariable("id") Long id){
        Place placeToBeRemoved = manager.find(Place.class, id);    
        //não me culpe, o find retorna nulo e eu jogo com as cartas que existem
        if(placeToBeRemoved == null) {
            return;
        }
        
        manager.remove(placeToBeRemoved);
    }

}