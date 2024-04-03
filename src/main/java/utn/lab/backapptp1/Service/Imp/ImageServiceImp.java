package utn.lab.backapptp1.Service.Imp;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.lab.backapptp1.Service.ImageService;
import utn.lab.backapptp1.Service.NoticiaService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class ImageServiceImp implements ImageService {

    @Autowired
    private NoticiaService noticiaService;


    public String uploadImage(byte[] file, Integer idNoticia) throws IOException {

        try {
            InputStream credentialsStream = new FileInputStream("src/main/resources/firebase.json");
            GoogleCredentials credentials = GoogleCredentials.fromStream(credentialsStream);

            // Inicializa el servicio de Google Cloud Storage
            Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();


            // Nombre del bucket
            String nombreBucket = "tplab4-f8c38.appspot.com";
            // Ruta del archivo en el bucket
            String nombreImagen = "imagen_publicacion" + idNoticia + ".jpg";
            String rutaArchivo = "noticia/" + idNoticia + "/" + nombreImagen;

            // Crea el blob con la ruta del archivo
            BlobId blobId = BlobId.of(nombreBucket, rutaArchivo);
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/jpeg").build();

            // Sube la imagen al bucket
            Blob blob = storage.create(blobInfo, file);
            Acl acl = storage.createAcl(blobId, Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));

            // Obtiene la URL pública del objeto recién creado
            String enlaceImagen = blob.getMediaLink();
            System.out.println("ENLACE ---> "+enlaceImagen);
            noticiaService.subirImagen(enlaceImagen, idNoticia);

            return enlaceImagen;

        }catch (Exception e){
            throw new RuntimeException("Error al subir la imagen a Firebase Storage "+ e.getMessage());
        }
    }
}
