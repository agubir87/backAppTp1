package utn.lab.backapptp1.Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.lab.backapptp1.Dto.NoticiaDto;
import utn.lab.backapptp1.Dto.NoticiaEdit;
import utn.lab.backapptp1.Entity.Noticia;
import utn.lab.backapptp1.Repository.NoticiaRepository;
import utn.lab.backapptp1.Service.EmpresaService;
import utn.lab.backapptp1.Service.NoticiaService;

import java.time.LocalDate;
import java.util.List;

@Service
public class NoticiaServiceImp implements NoticiaService {

    @Autowired
    private NoticiaRepository noticiaRepository;

    @Autowired
    private EmpresaService empresaService;

    @Override
    public Noticia save(NoticiaDto noticiaDto) {
        Noticia noticia = new Noticia();
        noticia.setResumenNoticia(noticiaDto.resumenNoticia());
        noticia.setImagenNoticia(noticiaDto.imagenNoticia());
        noticia.setTituloNoticia(noticiaDto.tituloNoticia());
        noticia.setContenidoHTML(noticiaDto.contenidoHTML());
        noticia.setEmpresa(empresaService.findById(noticiaDto.idEmpresa()));
        noticia.setFechaPublicacion(LocalDate.now());
        noticia.setPublicada('Y');
        return noticiaRepository.save(noticia);
    }

    @Override
    public Noticia edit(NoticiaEdit noticiaNueva, Integer id) {
        Noticia noticia = noticiaRepository.findById(id).orElseThrow(() -> new NullPointerException("No se encontro una noticias con el id "+id));
        noticia.setImagenNoticia(noticiaNueva.imagenNoticia());
        noticia.setResumenNoticia(noticiaNueva.resumenNoticia());
        noticia.setTituloNoticia(noticiaNueva.tituloNoticia());
        noticia.setContenidoHTML(noticiaNueva.contenidoHTML());
        return noticiaRepository.save(noticia);
    }

    @Override
    public void delete(Integer id) {
        noticiaRepository.deleteById(id);
    }

    @Override
    public List<Noticia> findAll() {
        return noticiaRepository.findAll();
    }

    @Override
    public Noticia findById(Integer id) {
        return noticiaRepository.findById(id).orElseThrow(()-> new NullPointerException("No se encontro una noticia con el id " + id));
    }

    @Override
    public List<Noticia> findAllPublicadas() {
        return noticiaRepository.findPublicadas();
    }

    @Override
    public List<Noticia> findAllNotPublicadas() {
        return noticiaRepository.findNotPublicadas();
    }

    @Override
    public String publicadaNoPublicada(Integer id) {
        Noticia noticia = noticiaRepository.findById(id).orElseThrow(()-> new NullPointerException("No se encontro una noticia con el id " + id));
        if(noticia.getPublicada() == 'Y'){
            noticia.setPublicada('N');
            noticiaRepository.save(noticia);
            return "La noticia ya no esta publicada";
        }else{
            noticia.setPublicada('Y');
            noticiaRepository.save(noticia);
            return "La noticia ya esta publicada";
        }
    }
}
