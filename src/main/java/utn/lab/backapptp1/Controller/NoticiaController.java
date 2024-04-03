package utn.lab.backapptp1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.lab.backapptp1.Dto.NoticiaDto;
import utn.lab.backapptp1.Dto.NoticiaEdit;
import utn.lab.backapptp1.Entity.Empresa;
import utn.lab.backapptp1.Entity.Noticia;
import utn.lab.backapptp1.Service.EmpresaService;
import utn.lab.backapptp1.Service.NoticiaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/noticia")
public class NoticiaController {

    @Autowired
    private NoticiaService noticiaService;

    @GetMapping()
    public ResponseEntity<?> findAll(){
        Map<String, Object> response = new HashMap<>();
        try {
            List<Noticia> noticias = noticiaService.findAll();
            response.put("noticias", noticias);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("Error ", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/publicadas")
    public ResponseEntity<?> findAllPublicadas(){
        Map<String, Object> response = new HashMap<>();
        try {
            List<Noticia> noticias = noticiaService.findAllPublicadas();
            response.put("noticias", noticias);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("Error ", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/noPublicadas")
    public ResponseEntity<?> findAllNotPublicadas(){
        Map<String, Object> response = new HashMap<>();
        try {
            List<Noticia> noticias = noticiaService.findAllNotPublicadas();
            response.put("noticias", noticias);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("Error ", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try {
            Noticia noticia = noticiaService.findById(id);
            response.put("noticia", noticia);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("Error ", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody NoticiaDto noticia){
        Map<String, Object> response = new HashMap<>();
        try {
            Noticia noticiaResponse = noticiaService.save(noticia);
            response.put("Noticia creada con exito: ", noticiaResponse);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("Error ", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Integer id, @RequestBody NoticiaEdit noticia){
        Map<String, Object> response = new HashMap<>();
        try {
            Noticia noticiaResponse = noticiaService.edit(noticia, id);
            response.put("Noticia editada con exito: ", noticiaResponse);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("Error ", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try {
            noticiaService.delete(id);
            response.put("Noticia eliminada con exito: ", "");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("Error ", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/publicada/{id}")
    public ResponseEntity<?> edit(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try {
            String noticiaResponse = noticiaService.publicadaNoPublicada(id);
            response.put(noticiaResponse, "");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("Error ", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
