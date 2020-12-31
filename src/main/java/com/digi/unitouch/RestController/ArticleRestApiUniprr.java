package com.digi.unitouch.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.digi.unitouch.emun.EmailEnum;
import com.digi.unitouch.emun.EmunAticleStatus;
import com.digi.unitouch.util.LoggerClass;
import com.digi.unitouch.util.SendEmailUtility;
import com.digi.unitouch.vo.ArticleDataApi;
import com.digi.unitouch.vo.ArticleInfoAPI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ArticleRestApiUniprr extends LoggerClass {

//	@Value("${uniprr.Api}")
	private String uniprrApi = "http://54.214.210.6/uniprroneapi";

//last stage article in unitouch and update to Uniprrr
	public ArticleDataApi setCompleteddata(String manuScriptId) {
		String uri = uniprrApi + "/manuscript/updateManuScriptEditor";
		System.out.println("uri-->" + uri);
		RestTemplate restTemplate = new RestTemplate();
		ArticleDataApi articleApi = null;
		HttpEntity<ArticleDataApi> request = new HttpEntity<>(new ArticleDataApi(manuScriptId, "59"));
		try {
			articleApi = restTemplate.postForObject(uri, request, ArticleDataApi.class);
			System.out.println("result we got from uniprr---->" + articleApi);
			return articleApi;
		} catch (Exception e) {
			LOGGER.info("Api got Exception---------->" + e.getMessage());
			e.printStackTrace();
		}
		return articleApi;

	}

	public ArticleDataApi getAidDOIFromUniprr(String journalAbbr) {
		// ArticleDataApi api = new ArticleDataApi("EJHG_128_20", "59");
		// http://54.214.210.6/uniprrapi/journal/getByJournalCode
		System.out.println("journalAbbr------>" + journalAbbr);
		String uri = uniprrApi + "/journal/updateManuscriptIdByUnitouch";
		System.out.println("uri-->" + uri);
		RestTemplate restTemplate = new RestTemplate();
		ArticleDataApi articleApi = null;
		HttpEntity<ArticleDataApi> request = new HttpEntity<>(new ArticleDataApi(journalAbbr, ""));
		try {
			articleApi = restTemplate.postForObject(uri, request, ArticleDataApi.class);
			System.out.println("result we got from uniprr---->" + articleApi);
			return articleApi;
		} catch (Exception e) {
			LOGGER.info("Api got Exception---------->" + e.getMessage());
			e.printStackTrace();
		}
		return articleApi;

	}

	// xml data of article information to send uniprr
	public ArticleInfoAPI sendArticleInfo(ArticleInfoAPI articleinfoapi) {
		System.out.println("articleinfoapi------>" + articleinfoapi);
		String uri = uniprrApi + "/manuScript/insertDataThroughUnitouch";
		System.out.println("uri-->" + uri);
		RestTemplate restTemplate = new RestTemplate();
		ArticleInfoAPI articleinfo = null;
		ResponseEntity<?> re = new ResponseEntity<>(articleinfoapi, HttpStatus.OK);
		System.out.println(re.getBody());
		ObjectMapper Obj = new ObjectMapper();
		// get Oraganisation object as a json string
		String jsonStr = null;
		try {
			jsonStr = Obj.writeValueAsString(articleinfoapi);
		} catch (JsonProcessingException jsone) {
			LOGGER.error("--------------JsonProcessingException--------JSON DATA--------->" + jsone);
		}

		// Displaying JSON String
		System.out.println(jsonStr);

		HttpEntity<ArticleInfoAPI> request = new HttpEntity<>(articleinfoapi);
		try {
			articleinfo = restTemplate.postForObject(uri, request, ArticleInfoAPI.class);
			System.out.println("result we got from uniprr---->" + articleinfo);
			return articleinfo;
		} catch (Exception apie) {
			LOGGER.info("Api got Exception---------->" + apie.getMessage());
			try {
				SendEmailUtility.mailToCC(EmailEnum.to, "Article not Synchronized", EmunAticleStatus.articleSysnco(articleinfoapi.getArticle().getAid(),apie), EmailEnum.cc);
			} catch (Exception maile) {
				LOGGER.error("Mail Exception--------"+maile);
			} 
			LOGGER.error("Api Exception--------"+apie +"\r\n"+jsonStr);
		}
		LOGGER.info("----------------------JSON DATA--------->" + jsonStr);
		return articleinfo;

	}

}
