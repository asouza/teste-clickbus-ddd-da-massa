package br.com.deveficiente.desafioclickbus;

public class BasicPlaceResponse {

    private final String name;
    private final String slug;
    private final String city;
    private final String state;
    private final Long id;

    public BasicPlaceResponse(final Place place) {
        this.name = place.getName();
        this.slug = place.getSlug();
        this.city = place.getCity();
        this.state = place.getState();
        this.id = place.getId();
    }


    public String getName() {
        return this.name;
    }

    public String getSlug() {
        return this.slug;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public Long getId(){
        return id;
    }


}
