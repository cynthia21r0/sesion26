package mx.utng.s26.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.s26.model.entity.Escuela;

@Repository
public class EscuelaDaoImpl implements IEscuelaDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Escuela> list() {
        return em.createQuery("from Escuela").getResultList();
    }

    @Override
    public void save(Escuela escuela) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(escuela.getId() != null && escuela.getId()>0){
            em.merge(escuela);
        }else{
            //Registro nuevo al usar persist
            em.persist(escuela);
        }
    }

    @Override
    public Escuela getById(Long id) {
        return em.find(Escuela.class, id);
    }

    @Override
    public void delete(Long id) {
      Escuela escuela = getById(id);
      em.remove(escuela);
    }
    

}