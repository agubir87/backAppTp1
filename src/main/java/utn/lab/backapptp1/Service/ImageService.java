package utn.lab.backapptp1.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    public String uploadImage(byte[] file, Integer idNoticia) throws IOException;
}
