package com.digi.unitouch.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Content;
import org.jdom2.Content.CType;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.digi.unitouch.vo.Article;
import com.digi.unitouch.vo.Attachment;
import com.digi.unitouch.vo.Author;

public class ParseXML {
	
	public static Article parseXMLMetadata(String XMLfile) throws JDOMException, IOException {
		SAXBuilder builder = new SAXBuilder();
		Article article = new Article();
		List<Author> authors = new ArrayList<Author>();
		List<Attachment> attachments = new ArrayList<Attachment>();

		Document jdomDoc = builder.build(new File(XMLfile));
		//jdomDoc.toXML();
		Element articleXML = jdomDoc.getRootElement();

		List<Element> contents = articleXML.getChildren();
		Iterator<Element> outerIterator = contents.listIterator();
		while (outerIterator.hasNext()) {
			Content articleContent = outerIterator.next();
			if (!articleContent.getCType().equals(CType.Text) && !articleContent.getCType().equals(CType.Comment)) {
				String key = articleContent.toString().substring(articleContent.toString().indexOf("<") + 1,
						articleContent.toString().indexOf(">") - 1);
				//boolean k= key.equalsIgnoreCase(key);
				switch (key.toLowerCase()) {
				case "id":
					article.setId(articleContent.getValue());
					break;
				case "title":
					article.setTitle(articleContent.getValue());
					break;
				case "articletype":
					article.setArticletype(articleContent.getValue());
					break;
				case "currentphase":
					article.setCurrentPhase(articleContent.getValue());
					break;
				case "keywords":
					article.setKeywords(articleContent.getValue());
					break;
				case "comment_for_production":
					article.setCommentoForProduction(articleContent.getValue());
					break;
				case "articlefile":
					article.setArticleFile(articleContent.getValue());
					break;
				case "firstpagefile":
					article.setFirstpagefile(articleContent.getValue());
					break;
				case "doi":
					article.setDoi(articleContent.getValue());
					break;
				case "qr_code":
					article.setQr_code(articleContent.getValue());
					break;

				
				case "authors":
					List<Element> element = articleXML.getChildren("authors");
					Iterator<Element> iterator = element.iterator();
					while (iterator.hasNext()) {

						Element elementAuthors = (Element) iterator.next();

						Iterator<Element> innerIterator = elementAuthors.getChildren().iterator();
						while (innerIterator.hasNext()) {
							Element elementAuthor = (Element) innerIterator.next();
							Author author = new Author(elementAuthor.getChild("title").getValue(),
									elementAuthor.getChild("fname").getValue(),
									elementAuthor.getChild("mname").getValue(),
									elementAuthor.getChild("lname").getValue(),
									elementAuthor.getChild("email").getValue(),
									elementAuthor.getChild("is_corresponding").getValue(),
									elementAuthor.getChild("orcid").getValue(),
									elementAuthor.getChild("author_order").getValue());
							//,
							//elementAuthor.getChild("copyright_agreement").getValue(),
							//elementAuthor.getChild("copyright_agreement_content").getValue()
							authors.add(author);
						}

					}
					article.setAuthor(authors);
					break;

				case "images":
					List<Element> imageselement = articleXML.getChildren("images");
					Iterator<Element> imagesiterator = imageselement.iterator();
					while (imagesiterator.hasNext()) {

						Element elementimages = (Element) imagesiterator.next();

						Iterator<Element> innerIterator = elementimages.getChildren().iterator();
						while (innerIterator.hasNext()) {
							Element elementimage = (Element) innerIterator.next();
							Attachment attachment = new Attachment(elementimage.getChild("image_file_name").getValue(),
									elementimage.getChild("image_type").getValue(),
									elementimage.getChild("legend").getValue(),
									elementimage.getChild("citation").getValue());
							attachments.add(attachment);

						}
					}
					article.setFiles(attachments);
					break;
				case "forms":
					List<Element> fileelement = articleXML.getChildren("forms");
					Iterator<Element> fileIterator = fileelement.iterator();
					while (fileIterator.hasNext()) {

						Element elementimages = (Element) fileIterator.next();

						Iterator<Element> innerIterator = elementimages.getChildren().iterator();
						while (innerIterator.hasNext()) {
							Element elementimage = (Element) innerIterator.next();

							Attachment attachment = new Attachment(elementimage.getChild("formfile").getValue(),
									elementimage.getChild("formdescription").getValue(), null, null);
							attachments.add(attachment);

						}
					}
					article.setFiles(attachments);
					break;
				case "submission_date":
					article.setSubmissionDate(articleContent.getValue());
					break;
					
				case "review":
					article.setReview(articleContent.getValue());
					break;
					
				case "accepted":
					article.setAcceptedDate(articleContent.getValue());
					break;

				default:
					break;
				}

			}
		}
		return article;
	}

}
