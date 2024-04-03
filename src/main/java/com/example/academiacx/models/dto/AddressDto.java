package com.example.academiacx.models.dto;

import com.example.academiacx.models.AddressModel;

public class AddressDto {
    Long id;

     Long iduser;
    String cep;
    String logradouro;
    String bairro;
    String localidade;
    String uf;
    public AddressDto() {
    }
    AddressDto(AddressModel addressModel){
        this.id = addressModel.getId();
        this.cep = addressModel.getCep();
        this.logradouro = addressModel.getLogradouro();
        this.bairro = addressModel.getBairro();
        this.localidade = addressModel.getLocalidade();
        this.uf = addressModel.getUf();
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
