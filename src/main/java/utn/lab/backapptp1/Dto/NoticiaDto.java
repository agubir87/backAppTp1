package utn.lab.backapptp1.Dto;

public record NoticiaDto(
        String tituloNoticia,
        String resumenNoticia,
        String imagenNoticia,
        String contenidoHTML,
        Integer idEmpresa
) {
}
