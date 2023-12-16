import java.text.*;
import java.util.*;
import org.xml.sax.XMLReader;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class MySAX extends DefaultHandler
{
    private boolean inItem = false;
    private boolean inCost = false;
    private double totalExpenses = 0;

    public static void main (String args[])
	throws Exception
    {
	XMLReader xr = XMLReaderFactory.createXMLReader();
	MySAX handler = new MySAX();
	xr.setContentHandler(handler);
	xr.setErrorHandler(handler);

	for (int i = 0; i < args.length; i++) {
	    FileReader r = new FileReader(args[i]);
	    xr.parse(new InputSource(r));
	}

	System.out.println("Total expenses: " + handler.totalExpenses);
    }

    public MySAX ()
    {
	super();
    }

    static String strip(String money) {
        if (money.equals(""))
            return money;
        else {
            double am = 0.0;
            NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
            try { am = nf.parse(money).doubleValue(); }
            catch (ParseException e) {
                System.out.println("This method should work for all " +
                                   "money values you find in our data.");
                System.exit(20);
            }
            nf.setGroupingUsed(false);
            return nf.format(am).substring(1);
        }
    }

    ////////////////////////////////////////////////////////////////////
    // Event handlers.
    ////////////////////////////////////////////////////////////////////

    public void startDocument ()
    {
	System.out.println("Start document");
    }

    public void endDocument ()
    {
	System.out.println("End document");
    }

    public void startElement (String uri, String name,
			      String qName, Attributes atts)
    {
	if ("".equals (uri))
	    System.out.println("Start element: " + qName);
	else
	    System.out.println("Start element: {" + uri + "}" + name);
	for (int i = 0; i < atts.getLength(); i++) {
	    System.out.println("Attribute: " + atts.getLocalName(i) + "=" + atts.getValue(i));
	}

	if (qName.equals("item")) {
	    inItem = true;
	} else if (qName.equals("cost")) {
	    inCost = true;
	}
    }

    public void endElement (String uri, String name, String qName)
    {
	if ("".equals (uri))
	    System.out.println("End element: " + qName);
	else
	    System.out.println("End element:   {" + uri + "}" + name);

	if (qName.equals("item")) {
	    inItem = false;
	} else if (qName.equals("cost")) {
	    inCost = false;
	}
    }

    public void characters (char ch[], int start, int length)
    {
	if (inItem && inCost) {
	    String costStr = new String(ch, start, length);
	    totalExpenses += Double.parseDouble(strip(costStr));
	}
    }
}
