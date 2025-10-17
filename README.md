# 🧩 TP2 – Service Web SOAP (Service-SOAP)

## 🎯 Objectif du TP
Développer et publier un **Service Web SOAP** avec Java selon l’approche *Contract Last* en utilisant les technologies **JAX-WS** et **JAXB**.  
Ce TP suit **mot pour mot** le support de cours d’**A. Ettaoufik** et montre la mise en œuvre complète d’un service SOAP, son WSDL et ses tests via SOAP UI.

---

## 🧱 1. Structure du projet Maven

```
service-soap/
 ├── pom.xml
 └── src/
     └── main/java/org/example/
         ├── Genre.java
         ├── Student.java
         ├── EtudiantWService.java
         └── ServerWS.java
```

---

## ⚙️ 2. Dépendances Maven

Dans le fichier `pom.xml`, ajouter la dépendance suivante :

```xml
<dependency>
  <groupId>com.sun.xml.ws</groupId>
  <artifactId>jaxws-ri</artifactId>
  <version>4.0.2</version>
  <type>pom</type>
</dependency>
```

> Cette dépendance permet d’utiliser les annotations JAX-WS pour publier un service SOAP.

---

## 🧩 3. Entités du Service

### 📘 `Genre.java`
```java
package org.example;

public enum Genre {
    Homme, Femme;
}
```

### 📘 `Student.java`
Version avec Lombok et JAXB (conforme au cours) :
```java
package org.example;

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
```

---

## 🌐 4. Web Service (EtudiantWService)

### 📘 `EtudiantWService.java`
```java
package org.example;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

@WebService(serviceName = "serviceWeb")
public class EtudiantWService {

    @WebMethod(operationName = "listStudents")
    public List<Student> listEtudiants() {
        return List.of(
            new Student(1, "ET_Nom1", "ET_Prénom1", Genre.Homme),
            new Student(2, "ET_Nom2", "ET_Prénom2", Genre.Femme),
            new Student(3, "ET_Nom3", "ET_Prénom3", Genre.Homme)
        );
    }
}
```

- `@WebService` : transforme la classe en service SOAP.
- `@WebMethod` : expose la méthode `listEtudiants()` comme opération du service.

---

## 🚀 5. Publication du Service

### 📘 `ServerWS.java`
```java
package org.example;

import jakarta.xml.ws.Endpoint;

public class ServerWS {
    public static void main(String[] args) {
        String url = "http://localhost:8081/";
        Endpoint.publish(url, new EtudiantWService());
        System.out.println("Service publié à l’adresse : " + url);
        System.out.println("WSDL disponible sur : " + url + "?wsdl");
    }
}
```

Cette classe publie le service SOAP sur l’URL `http://localhost:8081/`.

---

## 🧭 6. Exécution du Service

### ▶️ Étapes :
1. Compiler et exécuter :
   ```bash
   mvn clean package
   java -cp target/service-soap-1.0-SNAPSHOT.jar org.example.ServerWS
   ```
2. Ouvrir un navigateur sur :
   ```
   http://localhost:8081/?wsdl
   ```
   ➜ le fichier WSDL est généré automatiquement par JAX-WS.

---

## 🧪 7. Test du Service avec SOAP UI

### 📘 Créer un projet SOAP dans SOAP UI :
1. Ouvrir SOAP UI → “New SOAP Project”.
2. Coller l’URL du WSDL :  
   ```
   http://localhost:8081/?wsdl
   ```
3. Une opération `listStudents` apparaît dans le panneau de gauche.
4. Exécuter la requête suivante :

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ws="http://ws/">
  <soapenv:Header/>
  <soapenv:Body>
    <ws:listStudents/>
  </soapenv:Body>
</soapenv:Envelope>
```

### ✅ Réponse attendue :
```xml
<listStudentsResponse>
  <return>
    <id>1</id>
    <nom>ET_Nom1</nom>
    <prenom>ET_Prénom1</prenom>
    <genre>Homme</genre>
  </return>
  <return>
    <id>2</id>
    <nom>ET_Nom2</nom>
    <prenom>ET_Prénom2</prenom>
    <genre>Femme</genre>
  </return>
  <return>
    <id>3</id>
    <nom>ET_Nom3</nom>
    <prenom>ET_Prénom3</prenom>
    <genre>Homme</genre>
  </return>
</listStudentsResponse>
```

---

## 🧠 8. Concepts abordés dans le TP

| Élément | Description |
|----------|-------------|
| **Contract Last** | Le WSDL est généré à partir du code Java. |
| **Annotations JAX-WS** | `@WebService`, `@WebMethod`, `@WebParam` |
| **JAXB (XML Binding)** | Sérialisation Java ↔ XML via `@XmlType` |
| **Publication** | `Endpoint.publish()` publie le service sur un port HTTP |
| **Test SOAP** | SOAP UI ou navigateur pour consulter le WSDL |
| **Interopérabilité** | Le service est consommable par tout client SOAP (Java, .NET, Python…) |

---

## 📘 9. Pour aller plus loin
Le TP se poursuit avec la création du **Client SOAP** (dans la branche `client-soap`) qui génère automatiquement le code Java à partir du WSDL via `wsimport`.

Le client appelle ensuite :
```java
EtudiantWService wsdl = new ServiceWeb().getEtudiantWServicePort();
List<Student> liste = wsdl.listStudents();
```
et affiche les noms/prénoms reçus depuis le service SOAP.

---

## 👤 10. Auteur et contexte

- **Nom :** *Ayman Dhissi*  
- **Encadrant :** *A. Ettaoufik*  
- **Module :** Services Web (SOAP)  
- **Établissement :** EMSI  
- **Outils :** IntelliJ IDEA, JDK 17, Maven, SOAP UI  
- **Technologies :** JAX-WS RI 4.0.2, JAXB  

---

## ✅ Résumé global

Ce projet illustre :
- la création d’un **service web SOAP** en Java,  
- la **génération automatique du WSDL**,  
- la **publication** et le **test** via SOAP UI,  
- la compréhension du cycle complet *Contract Last*.

---

> 📘 *TP2 – Web Service SOAP réalisé selon le support de cours d’A. Ettaoufik*
