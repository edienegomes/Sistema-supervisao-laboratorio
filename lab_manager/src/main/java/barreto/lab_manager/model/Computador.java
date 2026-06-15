package barreto.lab_manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "COMPUTADOR")
@PrimaryKeyJoinColumn(name = "id_dispo")
public class Computador extends Dispositivo {

    @Column(name = "sistema_operacional", length = 30)
    private String sistemaOperacional;
}