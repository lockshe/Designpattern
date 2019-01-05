import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XMLUtil {
	
	private static String name;

	public static Object getBean(double speed) {
		try {
			double gap=0;
			double temp=500;
			DocumentBuilderFactory dFactory=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder =dFactory.newDocumentBuilder();
			
			Document document;
			document =builder.parse(new File("src//Vehicle.xml"));
			
			NodeList n1=document.getElementsByTagName("CLASS");
			for(int i=0;i<n1.getLength();i++) {
				String str=document.getElementsByTagName("NAME").item(i).getFirstChild().getNodeValue();
				String SpeedStr=document.getElementsByTagName("SPEED").item(i).getFirstChild().getNodeValue();
				double tempSpeed=Double.parseDouble(SpeedStr);
				if(tempSpeed>speed) {
					gap=tempSpeed-speed;
				}
				else {
					gap=speed-tempSpeed;
				}
				
				if(gap<temp) {
					temp=gap;
					name=str;
				}
			
			}
			
			Class class1=Class.forName(name);
			Object object=class1.newInstance();
			return object;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
