package br.edu.ifsul.controle;

import br.edu.ifsul.dao.GrupoDAO;
import br.edu.ifsul.modelo.Fabricante;
import br.edu.ifsul.modelo.Grupo;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author sega
 */
@Named(value = "controleGrupo")
@ViewScoped
public class ControleGrupo implements Serializable {

    @EJB
    private GrupoDAO<Grupo> dao;
    private Grupo objeto;
    
    public ControleGrupo() {
        
    }
    
    public String listar() {
        return "/privado/grupo/listar?faces-redirect=true";
    }
    
    public void novo() {
        objeto = new Grupo();
    }
    
    public void alterar(Object id) {
        try {
            objeto = dao.getObjectById(id);
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void excluir(Object id) {
        try {
            objeto = dao.getObjectById(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao excluir objeto: " + Util.getMensagemErro(e));
        }        
    }
    
    public void salvar() {
        try {
            if (objeto.getId() == null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao persistir objeto: " + Util.getMensagemErro(e));
        }        
    }
    
    public GrupoDAO<Grupo> getDao() {
        return dao;
    }
    
    public void setDao(GrupoDAO<Grupo> dao) {
        this.dao = dao;
    }
    
    public Grupo getObjeto() {
        return objeto;
    }
    
    public void setObjeto(Grupo objeto) {
        this.objeto = objeto;
    }
    
}
