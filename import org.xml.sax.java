import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class XmlToCsv {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean item = false;
                boolean title = false;
                boolean price = false;
                boolean description = false;
                boolean location = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("item")) {
                        item = true;
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("item")) {
                        item = false;
                    }
                }

                public void characters(char ch[], int start, int length) throws SAXException {

                    if (item) {
                        String value = new String(ch, start, length);

                        if (title) {
                            // Do something with the title
                            title = false;
                        } else if (price) {
                            // Do something with the price
                            price = false;
                        } else if (description) {
                            // Do something with the description
                            description = false;
                        } else if (location) {
                            // Do something with the location
                            location = false;
                        }
                    }
                }
            };

            saxParser.parse("items-0.xml", handler);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
