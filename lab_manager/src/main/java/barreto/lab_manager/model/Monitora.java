package barreto.lab_manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MONITORA")
public class Monitora {

    @EmbeddedId
    private IdMonitora id;

    @ManyToOne
    @MapsId("idLaboratorio")
    @JoinColumn(name = "id_laboratorio")
    private Laboratorio laboratorio;

    @ManyToOne
    @MapsId("matricula")
    @JoinColumn(name = "matricula")
    private Monitor monitor;
}