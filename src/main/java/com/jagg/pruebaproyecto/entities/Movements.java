package com.jagg.pruebaproyecto.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "movements")
@Data
public class Movements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "concept")
    private String concept;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "employee_id")
    private String employee;

    @Column(name = "enterprise_id")
    private String enterprise;

    @Column(name = "create_at")
    private Date create_at;

    @Column(name = "update_at")
    private Date update_at;

    @Column(name = "total")
    private Float total;

// Esta metodo realiza operaciones de INGRESO y EGRESO
    public float gestionMovimientos(){
        if (amount > 0){
            total += amount;
            return total;
        }
        if (amount < 0){
            total -= amount;
            return total;
        }
        if (amount.equals(0)){
            return total;
        }
        return total;
    }
}
