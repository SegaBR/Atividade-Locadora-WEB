package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CidadeDAO;
import br.edu.ifsul.dao.ClienteDAO;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author sega
 */
@Named(value = "controleCliente")
@ViewScoped
public class ControleCliente implements Serializable {

    @EJB
    private ClienteDAO<Cliente> dao;
    private Cliente objeto;
    @EJB
    private CidadeDAO<Cidade> daoCidade;
    
    public ControleCliente() {
        
    }
    
    public String listar() {
        return "/privado/cliente/listar?faces-redirect=true";
    }
    
    public void novo() {
        objeto = new Cliente();
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
    
    public ClienteDAO<Cliente> getDao() {
        return dao;
    }
    
    public void setDao(ClienteDAO<Cliente> dao) {
        this.dao = dao;
    }
    
    public Cliente getObjeto() {
        return objeto;
    }
    
    public void setObjeto(Cliente objeto) {
        this.objeto = objeto;
    }
    
    public CidadeDAO<Cidade> getDaoCidade() {
        return daoCidade;
    }

    public void setDaoCidade(CidadeDAO<Cidade> daoCidade) {
        this.daoCidade = daoCidade;
    }
}
