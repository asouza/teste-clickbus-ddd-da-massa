package br.com.deveficiente.desafioclickbus;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.asouza.DataView;
import io.github.asouza.FormFlow;

@RestController
public class CrudPlacesController {

    @PersistenceContext
    private EntityManager manager;
    @Autowired
    private FormFlow<Place> formFlow;

    @PostMapping("/places")
    @Transactional
    public void save(@Valid final BasicPlaceRequest request) {
        formFlow.save(request);
    }

    @PutMapping("/places/{id}")
    @Transactional
    public void update(@PathVariable("id") final Long id, @Valid final BasicPlaceRequest request) {
        final Place currentPlace = manager.find(Place.class, id);
        currentPlace.update(request.toModel());
    }   

    @GetMapping("/places")
    public List<Map<String,Object>> list(){
        List<Place> places = manager.createQuery("select p from Place p",Place.class).getResultList();
        return places.stream().map(place -> {
            return DataView.of(place)
            .add(Place :: getId)
            .add(Place :: getName)
            .add(Place :: getCity)
            .add(Place :: getState)
            .add(Place :: getSlug).build();
        }).collect(Collectors.toList());
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