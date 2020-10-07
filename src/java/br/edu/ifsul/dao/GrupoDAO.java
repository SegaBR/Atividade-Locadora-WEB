package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Grupo;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author sega
 */
@Stateful
public class GrupoDAO<TIPO> extends DAOGenerico<Grupo> implements Serializable {
    public GrupoDAO(){
        super();
        classePersistente=Grupo.class;
    }
}
