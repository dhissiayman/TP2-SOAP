package DATA;

import jakarta.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor

@NoArgsConstructor

@XmlType(name="eleve")

public class Student {

    int id;

    String nom;

    String prenom;

    Genre genre;

}
