package com.digi.unitouch.em.Meta;

import java.util.List;

import com.digi.unitouch.em.converter.ArticleIdConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("article-meta")
public class ArticleMeta {

	@XStreamAlias("article-id")
	@XStreamImplicit
	@XStreamConverter(ArticleIdConverter.class)
	private List<ArticleID> articleId;
	
	@XStreamAlias("article-categories")
	private ArticleCategories articlecategories;

	@XStreamAlias("title-group")
	private TitleGroup titleGroup;
	
	@XStreamAlias("contrib-group")
	private ContribGroup contribGroup;
	
	@XStreamAlias("history")
	private History history;

	
	@XStreamAlias("abstract")
	private ArticleAbstract articleAbstract;
	
	@XStreamAlias("kwd-group")
	private kwdGroup kwdgroup;
	
	@XStreamAlias("funding-group")
	@XStreamImplicit
	private List<String> fundingGroup;
	
	@XStreamAlias("counts")
	private Counts counts;
	
	@XStreamAlias("custom-meta-group")
	private CustoMetaGroup custometaGroup;

	
	
	
	public List<ArticleID> getArticleId() {
		return articleId;
	}




	public void setArticleId(List<ArticleID> articleId) {
		this.articleId = articleId;
	}




	public ArticleCategories getArticlecategories() {
		return articlecategories;
	}




	public void setArticlecategories(ArticleCategories articlecategories) {
		this.articlecategories = articlecategories;
	}




	public TitleGroup getTitleGroup() {
		return titleGroup;
	}




	public void setTitleGroup(TitleGroup titleGroup) {
		this.titleGroup = titleGroup;
	}




	public ContribGroup getContribGroup() {
		return contribGroup;
	}




	public void setContribGroup(ContribGroup contribGroup) {
		this.contribGroup = contribGroup;
	}




	public History getHistory() {
		return history;
	}




	public void setHistory(History history) {
		this.history = history;
	}




	public ArticleAbstract getArticleAbstract() {
		return articleAbstract;
	}




	public void setArticleAbstract(ArticleAbstract articleAbstract) {
		this.articleAbstract = articleAbstract;
	}




	public kwdGroup getKwdgroup() {
		return kwdgroup;
	}




	public void setKwdgroup(kwdGroup kwdgroup) {
		this.kwdgroup = kwdgroup;
	}




	public List<String> getFundingGroup() {
		return fundingGroup;
	}




	public void setFundingGroup(List<String> fundingGroup) {
		this.fundingGroup = fundingGroup;
	}




	public Counts getCounts() {
		return counts;
	}




	public void setCounts(Counts counts) {
		this.counts = counts;
	}




	public CustoMetaGroup getCustometaGroup() {
		return custometaGroup;
	}




	public void setCustometaGroup(CustoMetaGroup custometaGroup) {
		this.custometaGroup = custometaGroup;
	}




	@Override
	public String toString() {
		return "ArticleMeta [articleId=" + articleId + ", articlecategories=" + articlecategories + ", titleGroup="
				+ titleGroup + ", contribGroup=" + contribGroup + ", history=" + history + ", articleAbstract="
				+ articleAbstract + ", kwdgroup=" + kwdgroup + ", fundingGroup=" + fundingGroup + ", counts=" + counts
				+ ", custometaGroup=" + custometaGroup + "]";
	}



	
	


	
}
