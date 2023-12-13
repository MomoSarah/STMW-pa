import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MySAX extends DefaultHandler {
    // Implement SAX methods here
}
@Override
public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    // Handle start element
}

@Override
public void endElement(String uri, String localName, String qName) throws SAXException {
    // Handle end element
}

@Override
public void characters(char[] ch, int start, int length) throws SAXException {
    // Handle text node
}
