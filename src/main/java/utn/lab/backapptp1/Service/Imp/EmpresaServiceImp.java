package utn.lab.backapptp1.Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.lab.backapptp1.Entity.Empresa;
import utn.lab.backapptp1.Repository.EmpresaRepository;
import utn.lab.backapptp1.Service.EmpresaService;

import java.util.List;

@Service
public class EmpresaServiceImp implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public Empresa edit(Empresa empresaNueva, Integer id) {
        Empresa empresa = empresaRepository.findById(id).orElseThrow(() -> new NullPointerException("No se encontro una empresa con el id" + id));
        empresa.setDenominacion(empresaNueva.getDenominacion());
        empresa.setDomicilio(empresaNueva.getDomicilio());
        empresa.setEmail(empresaNueva.getEmail());
        empresa.setLatitud(empresaNueva.getLatitud());
        empresa.setLongitud(empresaNueva.getLongitud());
        empresa.setHorarioAtencion(empresaNueva.getHorarioAtencion());
        empresa.setQuienesSomos(empresaNueva.getQuienesSomos());
        return empresaRepository.save(empresa);
    }

    @Override
    public void delete(Integer id) {
        empresaRepository.deleteById(id);
    }

    @Override
    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa findById(Integer id) {
        return empresaRepository.findById(id).orElseThrow(()-> new NullPointerException("No se encontro una empresa con el id " + id));
    }
}
