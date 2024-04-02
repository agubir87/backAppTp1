package utn.lab.backapptp1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import utn.lab.backapptp1.Entity.Empresa;
import utn.lab.backapptp1.Entity.Noticia;

import java.util.List;

@Repository
public interface NoticiaEmpresa extends JpaRepository<Noticia, Integer> {

    @Query("SELECT n FROM Noticia n WHERE n.publicada = 'Y'")
    List<Noticia> findPublicadas();

    @Query("SELECT n FROM Noticia n WHERE n.publicada = 'N'")
    List<Noticia> findNoPublicadas();
}
