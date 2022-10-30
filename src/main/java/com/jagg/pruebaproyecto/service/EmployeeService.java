package com.jagg.pruebaproyecto.service;

import com.jagg.pruebaproyecto.entities.Employee;
import com.jagg.pruebaproyecto.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    //Inyeccion de dependencias(Comunicar el Servicio con el Repositorio
    @Autowired
    EmployeeRepository employeeRepository;

    public void createEditEmployee(Employee employee){
        employeeRepository.save(employee);
    }
    public List<Employee> seeEmployees(){
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.addAll(employeeRepository.findAll());
        return employeeList;
    }

    public Employee seeEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
}
