package utn.lab.backapptp1.Service;

import utn.lab.backapptp1.Entity.Empresa;

import java.util.List;

public interface EmpresaService {
    public Empresa save(Empresa empresa);
    public Empresa edit(Empresa empresaNueva, Integer id);
    public void delete(Integer id);
    public List<Empresa> findAll();
    public Empresa findById(Integer id);
}
