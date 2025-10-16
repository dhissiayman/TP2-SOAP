
package ma.emsi.dhissiayman;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ma.emsi.dhissiayman package. 
 * <p>An ObjectFactory allows you to programmatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private static final QName _ListStudents_QNAME = new QName("http://Service/", "listStudents");
    private static final QName _ListStudentsResponse_QNAME = new QName("http://Service/", "listStudentsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ma.emsi.dhissiayman
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListStudents }
     * 
     * @return
     *     the new instance of {@link ListStudents }
     */
    public ListStudents createListStudents() {
        return new ListStudents();
    }

    /**
     * Create an instance of {@link ListStudentsResponse }
     * 
     * @return
     *     the new instance of {@link ListStudentsResponse }
     */
    public ListStudentsResponse createListStudentsResponse() {
        return new ListStudentsResponse();
    }

    /**
     * Create an instance of {@link Eleve }
     * 
     * @return
     *     the new instance of {@link Eleve }
     */
    public Eleve createEleve() {
        return new Eleve();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListStudents }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListStudents }{@code >}
     */
    @XmlElementDecl(namespace = "http://Service/", name = "listStudents")
    public JAXBElement<ListStudents> createListStudents(ListStudents value) {
        return new JAXBElement<>(_ListStudents_QNAME, ListStudents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListStudentsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListStudentsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Service/", name = "listStudentsResponse")
    public JAXBElement<ListStudentsResponse> createListStudentsResponse(ListStudentsResponse value) {
        return new JAXBElement<>(_ListStudentsResponse_QNAME, ListStudentsResponse.class, null, value);
    }

}
