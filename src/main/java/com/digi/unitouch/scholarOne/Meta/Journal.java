package com.digi.unitouch.scholarOne.Meta;

import java.util.List;

import com.digi.unitouch.scholarOne.Main.IssnConverterScholar;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("journal")
public class Journal {

	@XStreamAlias("publisher_name")
	private String publisherName;
	
	@XStreamAlias("full_journal_title")
	private String fullJournalTitle;

	@XStreamAlias("journal_abbreviation")
	private String journalAbbreviation;

	@XStreamAlias("pubmed_abbreviation")
	private String pubmedAbbreviation;

	@XStreamAlias("issn")
	@XStreamImplicit
	@XStreamConverter(IssnConverterScholar.class)
	private List<Issn> issn;

	@Override
	public String toString() {
		return "Journal [publisherName=" + publisherName + ", fullJournalTitle=" + fullJournalTitle
				+ ", journalAbbreviation=" + journalAbbreviation + ", pubmedAbbreviation=" + pubmedAbbreviation
				+ ", issn=" + issn + "]";
	}

	
	
}
