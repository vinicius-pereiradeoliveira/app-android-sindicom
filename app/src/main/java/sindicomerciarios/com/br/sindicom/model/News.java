package sindicomerciarios.com.br.sindicom.model;

/**
 * Created by vinicius.oliveira on 30/03/2017.
 */

public class News {

    public Long id;

    public String name;

    public String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Notícia: " + name + " Descrição: " +
                description;
    }
}

