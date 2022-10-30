package com.jagg.pruebaproyecto.controller;

import com.jagg.pruebaproyecto.entities.Employee;
import com.jagg.pruebaproyecto.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    // VER EMPLEADOS
    @GetMapping("/Employee")
    private String seeEmployees(Model model){
        model.addAttribute("employeesModel",employeeService.seeEmployees());
        return "empleados";
    }
    // VER EMPLEADO POR ID
    @GetMapping("/Employee/{id}")
    private String seeEmployeeById(@PathVariable("id") Long id){
        employeeService.seeEmployeeById(id);
        return "empleados";
    }

    @GetMapping("/nuevoempleado")
    // CREAR NUEVO EMPLEADO - Controlador para "nuevoempleado.html"
    private String nuevoEmpleado(Employee employee){
        return "nuevoempleado";
    }
    // CREA NUEVO EMPLEADO
    @PostMapping("/Employee")
    private String createEmployee(Employee employee){
        employeeService.createEditEmployee(employee);
        return "redirect:/Employee";
    }

    // ELIMINAR
    @GetMapping("/Employee/borrar/{id}")
    private String deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return "redirect:/Employee";
    }

    // EDITAR EMPLEADO - Controladores para "editarempleado.html"
    @GetMapping("/Employee/editar/{id}")
    private String seeEmployeeById(@PathVariable("id") Long id, Model model){
        Employee employee =  employeeService.seeEmployeeById(id);
        model.addAttribute("employee", employee);
        return "editarempleado.html";
    }

    @PostMapping("/Employee/editar/{id}")
    private String editEmployee(@PathVariable("id") Long id, Employee employee){
        employeeService.createEditEmployee(employee);
        return "redirect:/Employee";
    }

//    @GetMapping("/Employee")
//    private List<Employee> seeEmployees(){
//        return employeeService.seeEmployees();
//    }
//
//    @GetMapping("/pokemon/{id}")
//    private Employee seeEmployeeById(@PathVariable("id") Long id){
//        return employeeService.seeEmployeeById(id);
//    }
//
//    @PostMapping("/Employee")
//    private void createEmployee(@RequestBody Employee employee){
//        employeeService.createEditEmployee(employee);
//    }
//
//    @DeleteMapping("/Employee/{id}")
//    private void deleteEmployee(@PathVariable("id") Long id){
//        employeeService.deleteEmployee(id);
//    }
//
//    @PutMapping("/Employee")
//    private void editEmployee(@RequestBody Employee employee){
//        employeeService.createEditEmployee(employee);
//    }
}
