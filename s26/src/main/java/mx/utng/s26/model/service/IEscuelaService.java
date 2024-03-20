package mx.utng.s26.model.service;

import java.util.List;

import mx.utng.s26.model.entity.Escuela;


public interface IEscuelaService {
    List<Escuela> list();
    void save(Escuela escuela);
    Escuela getById(Long id);
    void delete(Long id);
}
