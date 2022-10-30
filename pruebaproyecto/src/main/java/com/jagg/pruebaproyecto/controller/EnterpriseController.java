package com.jagg.pruebaproyecto.controller;

import com.jagg.pruebaproyecto.entities.Enterprise;
import com.jagg.pruebaproyecto.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//@RestController
@Controller
public class EnterpriseController {

    @Autowired
    EnterpriseService enterpriseService;

    @GetMapping("/Enterprise")
    private String enterpriseList(Model model){
        model.addAttribute("enterprisesModel",enterpriseService.seeEnterprises());
        return "empresas";
    }

    @GetMapping("/Enterprise/{id}")
    private String seeEnterpriseById(@PathVariable("id") Long id){
        enterpriseService.seeEnterpriseById(id);
        return "empresas";
    }

    @GetMapping("/nuevaempresa")
    private String nuevaEmpresa(Enterprise enterprise){
        return "nuevaempresa";
    }

    @PostMapping("/Enterprise")
    private String createEnterprise(Enterprise enterprise){
        enterpriseService.createEditEnterprise(enterprise);
        return "redirect:/Enterprise";
    }

    @GetMapping("/Enterprise/borrar/{id}")
    private String deleteEnterprise(@PathVariable("id") Long id){
        enterpriseService.deleteEnterprise(id);
        return "redirect:/Enterprise";
    }

    @GetMapping("/Enterprise/editar/{id}")
    private String seeEnterpriseById(@PathVariable("id") Long id, Model model){
        Enterprise enterprise = enterpriseService.seeEnterpriseById(id);
        model.addAttribute("enterprise", enterprise);
        return "editarempresa";
    }

    @PostMapping("/Enterprise/editar/{id}")
    private String editEnterprise(@PathVariable("id") Long id,Enterprise enterprise){
        enterpriseService.createEditEnterprise(enterprise);
        return "redirect:/Enterprise";
    }

//    @GetMapping("/Enterprise")
//    private List<Enterprise> enterpriseList(){
//        return enterpriseService.seeEnterprises();
//    }
//
//    @PostMapping("/Enterprise")
//    private void createEnterprise(@RequestBody Enterprise enterprise){
//        enterpriseService.createEnterprise(enterprise);
//    }
//
//    @DeleteMapping("/Enterprise/{id}")
//    private void deleteEnterprise(@PathVariable("id") Long id){
//        enterpriseService.deleteEnterprise(id);
//    }
//
//    @PutMapping("/Enterprise")
//    private void editEnterprise(@RequestBody Enterprise enterprise){
//        enterpriseService.createEnterprise(enterprise);
//    }
}
