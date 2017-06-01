package sindicomerciarios.com.br.sindicom.model;

import java.math.BigInteger;

/**
 * Created by vinicius.oliveira on 17/04/2017.
 */

public class Partner {

    private Integer id;
    private String name;
    private String cpf;
    private String celular;
    private String empresa;
    private String dt_nascimento;
    private String password;

    public Partner(String name, String cpf, String celular, String empresa, String dt_nascimento, String password){
        this.name = name;
        this.cpf = cpf;
        this.celular = celular;
        this.empresa = empresa;
        this.dt_nascimento = dt_nascimento;
        this.password = password;
    }
}

