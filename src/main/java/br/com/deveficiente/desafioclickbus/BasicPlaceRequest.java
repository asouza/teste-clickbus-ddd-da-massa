package br.com.deveficiente.desafioclickbus;

import java.util.Map;

import javax.validation.constraints.NotBlank;


public class BasicPlaceRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String slug;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    
    public BasicPlaceRequest(String name, String slug, String city, String state) {
        this.name = name;
        this.slug = slug;
        this.city = city;
        this.state = state;
    }

	public Place toModel() {
		return new Place(name,slug,city,state);
	}

    

}
