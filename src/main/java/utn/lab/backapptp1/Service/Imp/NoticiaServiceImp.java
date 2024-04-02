package utn.lab.backapptp1.Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.lab.backapptp1.Entity.Noticia;
import utn.lab.backapptp1.Repository.NoticiaRepository;
import utn.lab.backapptp1.Service.NoticiaService;

import java.util.List;

@Service
public class NoticiaServiceImp implements NoticiaService {

    @Autowired
    private NoticiaRepository noticiaRepository;

    @Override
    public Noticia save(Noticia noticia) {
        return noticiaRepository.save(noticia);
    }

    @Override
    public Noticia edit(Noticia noticiaNueva, Integer id) {
        Noticia noticia = noticiaRepository.findById(id).orElseThrow(() -> new NullPointerException("No se encontro una noticias con el id "+id));
        noticia.setImagenNoticia(noticiaNueva.getImagenNoticia());
        noticia.setResumenNoticia(noticiaNueva.getResumenNoticia());
        noticia.setTituloNoticia(noticiaNueva.getTituloNoticia());
        noticia.setContenidoHTML(noticiaNueva.getContenidoHTML());
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
}
