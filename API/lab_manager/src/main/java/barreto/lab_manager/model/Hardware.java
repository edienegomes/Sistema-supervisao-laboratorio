
package barreto.lab_manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HARDWARE")
public class Hardware {

    @Id
    @Column(name = "id_hardware")
    private Integer idHardware;

    @Column(nullable = false, length = 30)
    private String nome;

    @Column(nullable = false, length = 30)
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "id_dispositivo")
    private Dispositivo dispositivo;
}