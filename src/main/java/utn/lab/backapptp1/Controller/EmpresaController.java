package utn.lab.backapptp1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.lab.backapptp1.Entity.Empresa;
import utn.lab.backapptp1.Service.EmpresaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping()
    public ResponseEntity<?> findAll(){
        Map<String, Object> response = new HashMap<>();
        try {
            List<Empresa> empresas = empresaService.findAll();
            response.put("Empresas: ", empresas);
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
            Empresa empresa = empresaService.findById(id);
            response.put("Empresa: ", empresa);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("Error ", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Empresa empresa){
        Map<String, Object> response = new HashMap<>();
        try {
            Empresa empresaResponse = empresaService.save(empresa);
            response.put("Empresa creada con exito: ", empresaResponse);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("Error ", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Integer id, @RequestBody Empresa empresa){
        Map<String, Object> response = new HashMap<>();
        try {
            Empresa empresaResponse = empresaService.edit(empresa, id);
            response.put("Empresa editada con exito: ", empresaResponse);
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
            empresaService.delete(id);
            response.put("Empresa eliminada con exito: ", "");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("Error ", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
