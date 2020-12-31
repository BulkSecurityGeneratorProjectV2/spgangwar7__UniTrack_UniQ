package com.digi.unitouch.em.Meta;

import java.util.List;

import com.digi.unitouch.em.converter.JournalIdConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("journal-meta")
public class JournalMeta {

	@XStreamAlias("journal-id")
	@XStreamImplicit
	@XStreamConverter(JournalIdConverter.class)
	private List<JournaID> journalId;

	@XStreamAlias("issn")
	@XStreamImplicit
	@XStreamConverter(IssnConverter.class)
	private List<Issn> issn;
	
	@XStreamAlias("journal-title-group")
	private JournaltTitel journalTitle;

	@Override
	public String toString() {
		return "JournalMeta [journalId=" + journalId + ", issn=" + issn + ", journalTitle=" + journalTitle + "]";
	}

	
}
