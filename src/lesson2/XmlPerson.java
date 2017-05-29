package lesson2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class XmlPerson implements Parser, Serializer {

    @Override
    public void serialize(List<PersonInformation> persons, File outputFile) {

        if (persons.isEmpty()) return;

        try (final OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFile))) {
            final Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            final Element rootElement = document.createElement("persons");

            persons.stream()
                    .map(person -> {
                        final Element personNode = document.createElement("person");
                        personNode.appendChild(createChildElement(document, "firstname", person.getFirstName()));
                        personNode.appendChild(createChildElement(document, "lastname", person.getLastName()));
                        personNode.appendChild(createChildElement(document, "age", String.valueOf(person.getAge())));
                        personNode.appendChild(createChildElement(document, "email", person.getEmail()));
                        return personNode;
                    })
                    .forEach(rootElement::appendChild);

            final Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            transformer.transform(new DOMSource(rootElement), new StreamResult(outputStream));

        } catch (IOException | ParserConfigurationException | TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PersonInformation> parse(File inputFile) {

        try {
            final Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputFile);
            doc.getDocumentElement().normalize();
            final NodeList personNodes = doc.getElementsByTagName("person");
            return IntStream.range(0, personNodes.getLength())
                    .boxed()
                    .map(personNodes::item)
                    .filter(node -> Node.ELEMENT_NODE == node.getNodeType())
                    .map(node -> (Element) node)
                    .map(XmlPerson::elementToPersonInformation)
                    .collect(Collectors.toList());
        } catch (SAXException | IOException | ParserConfigurationException e) {
            throw new RuntimeException("Can't parser input file");
        }
    }

    private static PersonInformation elementToPersonInformation(Element element) {

        final String[] rawPeronsInfo = new String[4];
        rawPeronsInfo[0] = element.getElementsByTagName("firstname").item(0).getTextContent();
        rawPeronsInfo[1] = element.getElementsByTagName("lastname").item(0).getTextContent();
        rawPeronsInfo[2] = element.getElementsByTagName("age").item(0).getTextContent();
        rawPeronsInfo[3] = element.getElementsByTagName("email").item(0).getTextContent();

        return new PersonInformation(rawPeronsInfo);
    }

    private static Element createChildElement(final Document document, final String tag, final String content) {

        final Element element = document.createElement(tag);
        element.setTextContent(content);
        return element;
    }
}
