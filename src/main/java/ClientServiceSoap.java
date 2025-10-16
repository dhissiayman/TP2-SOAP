

import ma.emsi.dhissiayman.Eleve;
import ma.emsi.dhissiayman.EtudiantWService;
import ma.emsi.dhissiayman.ServiceWeb;

import java.util.List;

// Ces 2 classes sont générées automatiquement depuis le WSDL
// et peuvent s'appeler légèrement différemment selon ton WSDL.
// Dans le cours, elles s'appellent ServiceWeb et EtudiantWService.
public class ClientServiceSoap {
    public static void main(String[] args) {
        ServiceWeb service = new ServiceWeb();                 // fabrique générée
        EtudiantWService port = service.getEtudiantWServicePort(); // port généré

        List<Eleve> liste = port.listStudents();
        liste.forEach(elm ->
                System.out.println(elm.getNom() + "----" + elm.getPrenom()));
    }
}