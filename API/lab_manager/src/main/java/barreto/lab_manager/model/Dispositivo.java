package barreto.lab_manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DISPOSITIVO")
@Inheritance(strategy = InheritanceType.JOINED)
public class Dispositivo {

    @Id
    @Column(length = 30)
    private String id;

    @Column(nullable = false, length = 30)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 30)
    private StatusEquipamento status;

    @ManyToOne
    @JoinColumn(name = "id_lab")
    private Laboratorio laboratorio;
}