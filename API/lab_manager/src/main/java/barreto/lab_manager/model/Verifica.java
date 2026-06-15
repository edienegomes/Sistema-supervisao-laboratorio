package barreto.lab_manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "VERIFICA")
public class Verifica {
    @EmbeddedId
    private IdVerifica id;

    @ManyToOne
    @MapsId("matricula")
    @JoinColumn(name = "matricula")
    private Monitor monitor;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "id")
    private Dispositivo dispositivo;

    @Column(nullable = false, name = "data_verificacao")
    private LocalDate dataVerificacao;
}