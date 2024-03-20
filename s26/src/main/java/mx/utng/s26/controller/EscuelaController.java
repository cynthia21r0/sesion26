package mx.utng.s26.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import jakarta.validation.Valid;
import mx.utng.s26.model.entity.Escuela;
import mx.utng.s26.model.service.IEscuelaService;

@Controller
@SessionAttributes("escuela")
public class EscuelaController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IEscuelaService escuelaService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/escuela/list","/escuela","/escuela/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Escuelas");
    model.addAttribute("escuelas", escuelaService.list());
    return "elist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/escuela/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Escuelas");
        model.addAttribute("escuela", new Escuela());
        return "eform";
    }

    @GetMapping("/escuela/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Escuela escuela = null;
        if (id>0) {
            escuela = escuelaService.getById(id);
        }else{
            return "redirect:elist";
        }

        model.addAttribute("title", "Editar Escuela");
        model.addAttribute("escuela", escuela);
        return "eform";
    }


    @PostMapping ("/escuela/form")
    public String save(@Valid Escuela escuela, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Escuelas");
            return "eform";
        }

        escuelaService.save(escuela);
        return "redirect:/escuela/list";
    }

    @GetMapping("/escuela/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            escuelaService.delete(id);
        }
        return "redirect:/escuela/list";
    }

}

