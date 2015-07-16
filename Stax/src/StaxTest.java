import javax.xml.stream.*;
import javax.xml.stream.XMLInputFactory;
import java.io.*;
import java.net.*;

public class StaxTest {

	public void parseXMLDocument() {
		try {
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			URL myUrl = new URL(
					"http://www.andrew.cmu.edu/user/mm6/95-702/McCarthysSchedule/schedule1.xml");

			URLConnection yc = myUrl.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					yc.getInputStream()));
			// InputStream input = new FileInputStream(new File("test.xml"));
			XMLStreamReader xmlStreamReader = inputFactory
					.createXMLStreamReader(in);

			while (xmlStreamReader.hasNext()) {
				int event = xmlStreamReader.next();
		
				if (event == XMLStreamConstants.START_ELEMENT) {
					System.out.println("Event Type: START_ELEMENT");

					System.out.println("Element Prefix:"
							+ xmlStreamReader.getPrefix());
					System.out.println(xmlStreamReader.getLocalName());
					System.out.println("Namespace URI:"
							+ xmlStreamReader.getNamespaceURI());

					for (int i = 0; i < xmlStreamReader.getAttributeCount(); i++) {

						System.out.println("Attribute Prefix:"
								+ xmlStreamReader.getAttributePrefix(i));
						System.out.println("Attribute Namespace:"
								+ xmlStreamReader.getAttributeNamespace(i));
						System.out.println("Attribute Local Name:"
								+ xmlStreamReader.getAttributeLocalName(i));
						System.out.println("Attribute Value: "
								+ xmlStreamReader.getAttributeValue(i));
					}

				}

				if (event == XMLStreamConstants.CHARACTERS) {
					System.out.println("Event Type: CHARACTERS");
					System.out.println(xmlStreamReader.getText());
				}

				if (event == XMLStreamConstants.END_ELEMENT) {
					System.out.println("Event Type: END_ELEMENT");
				}

			}
		} catch (FactoryConfigurationError e) {
			System.out.println("FactoryConfigurationError" + e.getMessage());
		} catch (XMLStreamException e) {
			System.out.println("XMLStreamException" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException" + e.getMessage());
		}

	}

	public static void main(String[] argv) {

		StaxTest xmlParser = new StaxTest();
		xmlParser.parseXMLDocument();

	}
}