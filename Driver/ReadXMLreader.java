package Driver;

import java.io.File;
import org.jdom2.input.SAXBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class ReadXMLreader {
	public static void main(String[] args) {
		
		try {
			
		 SAXBuilder builder = new SAXBuilder();
		  File xmlFile = new File("C:\\Users\\889128\\Desktop\\Selenium Luna\\responsetesr.xml");
		  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("valuationresult");
			
			System.out.println("Nlis value " +  nList.getLength());

			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
					
				
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				System.out.println("\nCurrent Type :" + nNode.getNodeType());
				System.out.println("\nCurrent Element from UI  :" + Node.ELEMENT_NODE);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					System.out.println("\nCurrent Element  :" + eElement);

					System.out.println("Valuation result: " + eElement.getAttribute("GPID"));
					//System.out.println("Street Name : " + eElement.getElementsByTagName("StreetName").item(0).getTextContent());
					//System.out.println("STreet Type : " + eElement.getElementsByTagName("StreetType").item(0).getTextContent());
					//System.out.println("Suburb is : " + eElement.getElementsByTagName("Suburb").item(0).getTextContent());
					//System.out.println("Post code : " + eElement.getElementsByTagName("PostCode").item(0).getTextContent());

				}
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		  }

		}



		  
		