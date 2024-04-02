package utn.lab.backapptp1.Service;

import utn.lab.backapptp1.Entity.Noticia;

import java.util.List;

public interface NoticiaService {
    public Noticia save(Noticia noticia);
    public Noticia edit(Noticia noticiaNueva, Integer id);
    public void delete(Integer id);
    public List<Noticia> findAll();
    public Noticia findById(Integer id);
    public List<Noticia> findAllPublicadas();
    public List<Noticia> findAllNotPublicadas();
}
