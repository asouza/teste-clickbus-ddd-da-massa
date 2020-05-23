package br.com.deveficiente.desafioclickbus;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private @NotBlank String name;
    private @NotBlank String slug;
    private @NotBlank String city;
    private @NotBlank String state;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

    @Deprecated
    public Place(){

    }

    public Place(@NotBlank String name, @NotBlank String slug, @NotBlank String city, @NotBlank String state) {
        this.name = name;
        this.slug = slug;
        this.city = city;
        this.state = state;
	}

	public void update(Place newInfo) {
        this.name = newInfo.name;
        this.slug = newInfo.slug;
        this.city = newInfo.city;
        this.state = newInfo.state;
        this.updatedAt = LocalDateTime.now();
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

	public Long getId() {
		return id;
	}
        

}
