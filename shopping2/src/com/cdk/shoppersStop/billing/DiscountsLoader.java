package com.cdk.shoppersStop.billing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Element;
import org.jdom2.input.DOMBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class DiscountsLoader {
	 private static org.jdom2.Document useDOMParser(String fileName)
	            throws ParserConfigurationException, SAXException, IOException {
	        //creating DOM Document
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder;
	        dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(new File(fileName));
	        DOMBuilder domBuilder = new DOMBuilder();
	        return domBuilder.build(doc);
	 
	    }
	
	public static List<DiscountRate>  getDiscounts(String fileName) {
		   
	        org.jdom2.Document jdomDoc;
	        List<DiscountRate> discountList = new ArrayList<>();
	        try {
	            //creating dom parser 
	            jdomDoc = useDOMParser(fileName);
	            Element root = jdomDoc.getRootElement();
	            List<Element> discountListElements = root.getChildren("DiscountRate");
	           
	            for (Element xmlDiscount : discountListElements) {
	            	DiscountRate discountRate = new DiscountRate();
	            	discountRate.setHighterAmount(Float.parseFloat(xmlDiscount.getChildText("highterAmount").trim().equals("")?"0":xmlDiscount.getChildText("highterAmount")));
	            	discountRate.setLowerAmount(Float.parseFloat(xmlDiscount.getChildText("lowerAmount").trim().equals("")?"0":xmlDiscount.getChildText("lowerAmount")));
	            	discountRate.setPercentage(Float.parseFloat(xmlDiscount.getChildText("percentage").trim().equals("")?"0":xmlDiscount.getChildText("percentage")));
	               
	            	discountList.add(discountRate);
	            }
	            //lets print Employees list information
	           Collections.sort(discountList);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return discountList;
	        
	}
}
