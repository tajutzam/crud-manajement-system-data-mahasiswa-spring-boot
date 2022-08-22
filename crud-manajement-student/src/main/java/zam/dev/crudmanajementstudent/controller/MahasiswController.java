package zam.dev.crudmanajementstudent.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import zam.dev.crudmanajementstudent.dto.MahasiswaDto;
import zam.dev.crudmanajementstudent.dto.SeacrhKey;
import zam.dev.crudmanajementstudent.model.entity.Mahasiswa;
import zam.dev.crudmanajementstudent.service.MahasiswaService;
import zam.dev.crudmanajementstudent.service.MahasiswaServiceImpl;

@Controller
@RequestMapping("")
public class MahasiswController {
    
    @Autowired
    private MahasiswaServiceImpl mahasiswaService;

  

    @GetMapping("/")
    public String welcome(Model model , SeacrhKey seacrhKey){
        String title ="Welcome to Mahasiswa Manajement";
        model.addAttribute("searchFrom", new SeacrhKey());
        model.addAttribute("title", title);
        model.addAttribute("mahasiswaAll", mahasiswaService.findAll());
        return "indek";
    }

    @GetMapping("/add")
    public String getAddForm(Model model , SeacrhKey seacrhKey ){
    
        model.addAttribute("mahasiswa", new Mahasiswa());
        model.addAttribute("searchFrom", new SeacrhKey());
        return "add";
    }

    @PostMapping("/save_add")
    public String addMahasiswa(Model model , @Valid Mahasiswa mahasiswaDto , BindingResult bindingResult){ 
        
       
        if(bindingResult.hasErrors()){
            model.addAttribute("mahasiswa", mahasiswaDto);
            model.addAttribute("searchFrom", new SeacrhKey());
            return "add";
        }
        model.addAttribute("mahasiswa", mahasiswaService.addMahasiswa(mahasiswaDto));
        model.addAttribute("searchFrom", new SeacrhKey());
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") long id){
        mahasiswaService.removeMahasiswa(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(Model model , @PathVariable("id") long id){
        model.addAttribute("mahasiswa", mahasiswaService.findById(id));
        model.addAttribute("searchFrom", new SeacrhKey());
        return "edit";

    }


    @PostMapping("/update")
    public String updateMahasiswa(Mahasiswa mahasiswa){
        mahasiswaService.editMahasiswa(mahasiswa);
        return "redirect:/";
    }

    @PostMapping("/seacrh")
    public String findByNames( Model model , SeacrhKey seacrhKey ){
        model.addAttribute("searchFrom", seacrhKey);
        model.addAttribute("mahasiswaAll",mahasiswaService.findByName(seacrhKey.getKeyword()));
        return "indek";
    }
}
