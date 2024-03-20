package mx.utng.s26.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.utng.s26.model.dao.IEscuelaDao;
import mx.utng.s26.model.entity.Escuela;
/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class EscuelaServiceImpl implements IEscuelaService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IEscuelaDao escuelaDao;

    @Transactional(readOnly = true)
    @Override
    public List<Escuela> list() {
        return escuelaDao.list();
    }

    @Transactional
    @Override
    public void save(Escuela escuela) {
        escuelaDao.save(escuela);
    }

    @Transactional(readOnly = true)
    @Override
    public Escuela getById(Long id) {
        return escuelaDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        escuelaDao.delete(id);
    }
    
}
