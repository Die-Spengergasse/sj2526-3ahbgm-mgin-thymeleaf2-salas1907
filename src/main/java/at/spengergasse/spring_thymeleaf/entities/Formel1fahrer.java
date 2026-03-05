package at.spengergasse.spring_thymeleaf.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="drivers")
public class Formel1fahrer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="d_id")
    private int id;
    @Column(name = "d_name")
    private String name;
    @Column(name = "d_team")
    private String team;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

     public int getId() {
        return id;
    }
    public int setId(int id) {
        this.id = id;
        return id;
    }
}
