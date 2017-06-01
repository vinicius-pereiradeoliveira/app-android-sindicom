package sindicomerciarios.com.br.sindicom.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by vinicius.oliveira on 08/03/2017.
 */
public class Advantages {

    public Long id;

    public String name;

    public String description;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    @Override
    public String toString() {
        return "Vantagem: " + name + " Descrição: " +
                description;
    }
}
