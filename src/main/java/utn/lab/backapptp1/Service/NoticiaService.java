package utn.lab.backapptp1.Service;

import utn.lab.backapptp1.Dto.NoticiaDto;
import utn.lab.backapptp1.Dto.NoticiaEdit;
import utn.lab.backapptp1.Entity.Noticia;

import java.util.List;

public interface NoticiaService {
    public Noticia save(NoticiaDto noticiaDto);
    public Noticia edit(NoticiaEdit noticiaNueva, Integer id);
    public void delete(Integer id);
    public List<Noticia> findAll();
    public Noticia findById(Integer id);
    public List<Noticia> findAllPublicadas();
    public List<Noticia> findAllNotPublicadas();
    public String publicadaNoPublicada(Integer id);
    public void subirImagen(String imagen, Integer id);
}
