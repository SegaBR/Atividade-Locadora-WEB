package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Fabricante;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author kakaz
 */
@Stateful
public class FabricanteDAO<TIPO> extends DAOGenerico<Fabricante> implements Serializable {
    public FabricanteDAO(){
        super();
        classePersistente=Fabricante.class;
    }
}
