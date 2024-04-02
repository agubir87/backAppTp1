package utn.lab.backapptp1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.lab.backapptp1.Entity.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
}
