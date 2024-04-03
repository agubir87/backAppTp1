package utn.lab.backapptp1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import utn.lab.backapptp1.Service.ImageService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload-image/{idNoticia}")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file, @PathVariable Integer idNoticia) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Llamar al servicio para cargar la imagen y obtener la URL
            String imageUrl = imageService.uploadImage(file.getBytes(), idNoticia);
            response.put("imagen",imageUrl);
            return ResponseEntity.ok(response); // Devolver la URL de la imagen como respuesta
        } catch (IOException e) {
            response.put("Error ", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
