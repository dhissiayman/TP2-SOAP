package Service;

import DATA.Genre;
import DATA.Student;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService(serviceName = "serviceWeb")
public class EtudiantWService {
    @WebMethod(operationName = "listStudents")
    public List<Student>listEtudiants(){
        return List.of(
                new Student(1,"ET_Nom1","ET_Prénom1", Genre.Homme),
                new Student(2 ,"ET_Nom2","ET_Prénom2", Genre.Femme),
                new Student(3 ,"ET_Nom3","ET_Prénom3", Genre.Homme)
        );
    }
}
