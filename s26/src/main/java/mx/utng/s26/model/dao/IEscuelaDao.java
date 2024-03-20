package mx.utng.s26.model.dao;

import java.util.List;

import mx.utng.s26.model.entity.Escuela;


public interface IEscuelaDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Escuela> list();

    //Guardar un estudiante
    void save(Escuela escuela);

    //Obterner un estudiante en especifico a partir del id
    Escuela getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}
