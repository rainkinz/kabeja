/*
   Copyright 2007 Simon Mieth

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package org.kabeja.svg.tools;

import org.apache.batik.dom.svg.SVGDOMImplementation;
import org.apache.batik.dom.util.SAXDocumentFactory;
import org.kabeja.dxf.DXFDocument;
import org.kabeja.svg.SVGGenerator;
import org.kabeja.xml.SAXGenerator;
import org.w3c.dom.Document;
import org.w3c.dom.svg.SVGDocument;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * Build a SVGDocument from DXFDocument.
 * @author simon
 *
 */
public class DXFSAXDocumentFactory extends SAXDocumentFactory {

	public DXFSAXDocumentFactory() {
		super(SVGDOMImplementation.getDOMImplementation(), null);
	}

	public SVGDocument createDocument(DXFDocument doc) throws SAXException {

		XMLReader myReader = XMLReaderFactory.createXMLReader();
		parser = myReader;

		SAXGenerator gen = new SVGGenerator();
		gen.generate(doc, this);
		Document res = document;
		document = null;
		return (SVGDocument) res;

	}



}
