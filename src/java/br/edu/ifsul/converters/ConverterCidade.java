/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.converters;

import br.edu.ifsul.modelo.Cidade;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author sega
 */
@Named(value="converterCidade")
@RequestScoped
public class ConverterCidade implements Serializable, Converter{
    
    @PersistenceContext(unitName="Atividade-LocadoraWEBPU")
    private EntityManager em;
    
    // vem da tela para o objeto
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       if(value ==null || value.equals("Selecione um registro!")){
           return null;
       }
       return em.find(Cidade.class,Integer.parseInt(value));
    }
    
    // vai do objeto para a tela
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if(value==null){
           return null;
       }
       Cidade obj = (Cidade) value;
       return obj.getId().toString();
    }
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
}
