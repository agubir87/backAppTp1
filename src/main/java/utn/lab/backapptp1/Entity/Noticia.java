package utn.lab.backapptp1.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tituloNoticia;

    private String resumenNoticia;

    private String imagenNoticia;

    private String contenidoHTML;

    private char publicada;

    private LocalDate fechaPublicacion;

    @ManyToOne
    @JoinColumn(name = "idEmpresa")
    private Empresa empresa;

}
