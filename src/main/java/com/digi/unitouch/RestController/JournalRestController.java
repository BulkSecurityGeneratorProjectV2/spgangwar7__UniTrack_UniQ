package com.digi.unitouch.RestController;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.digi.unitouch.model.IssueDetail;
import com.digi.unitouch.model.Journal;
import com.digi.unitouch.service.IssueDetailService;
import com.digi.unitouch.service.JournalService;
import com.digi.unitouch.util.LoggerClass;
import com.digi.unitouch.vo.JournalVo;

@RestController
public class JournalRestController extends LoggerClass {
	@Autowired
	JournalService journalService;
	@Autowired
	IssueDetailService issueDetailService;

	@PostMapping("savejournal")
	public ResponseEntity<?> createjournalApi(@RequestBody JournalVo journalVo) {

		Journal journal = new Journal();
		// journal.setJournalName(journalVo.getJournalTitle());
		journal.setPrintIssn(journalVo.getPrintIssn());
		journal.setJournalAcronym(journalVo.getJournalAcronym().toLowerCase());
		journal.setJournalAbbrName(journalVo.getJournalAcronym().toLowerCase());
		journal.setDoiPrefix(journalVo.getDoiPrefix());
		journal.setJournalName(journalVo.getJournalTitle());
		journal.setOpenAccessStatus(journalVo.getoAStatus());
		// journal.setJournalIssn(journalVo.);
		journal.setOnlineIssn(journalVo.getOnlineIssn());
		journal.setStatus("Active");
		journal.setArticleWorkflowId(0);
		journal.setIssueWorkflowId(0);
		journal.setPublisherId(journalVo.getPublisher_id());
		journal.setPublicationType(journalVo.getPublicationType());
		journal.setHouseStyle(journalVo.getHouseStyle());
		journal.setPageLayout(journalVo.getPageLayout());
		// journalService.createJournal(j);
		System.out.println(journal.toString());
		// journalService.savejournal(journal);
		return new ResponseEntity<>(journalVo, HttpStatus.OK);

	}

	@PostMapping("createjournalApi")
	public ResponseEntity<?> createjournal(@RequestBody JournalVo journalVo) {

		Journal journal = new Journal();
		// Journal
		// jr=journalService.getJournalbyTitle(journalVo.getJournalAcronym(),journalVo.getJournalTitle());
		Journal jr = journalService.getJournalbyabbrname(journalVo.getJournalAcronym().toLowerCase());
		if (jr != null) {
			// jr.setJournalName(journalVo.getJournalTitle());
			jr.setOnlineIssn(journalVo.getOnlineIssn());
			journal.setPrintIssn(journalVo.getPrintIssn());
			jr.setOpenAccessStatus(journalVo.getoAStatus());
			jr.setDoiPrefix(journalVo.getDoiPrefix());
			jr.setHouseStyle(journalVo.getHouseStyle());
			jr.setOpenAccessStatus(journalVo.getoAStatus());
			jr.setPartnerContact(journalVo.getPartnerContact());
			jr.setJournalType(journalVo.getJournalType());
			journalService.savejournal(jr);
			jr.setJournalId(0);
			jr.setPublicationType("");
		
			return new ResponseEntity<>(jr, HttpStatus.UPGRADE_REQUIRED);
		} else {
			journal.setJournalName(journalVo.getJournalTitle());
			journal.setPrintIssn(journalVo.getPrintIssn());
			journal.setJournalAcronym(journalVo.getJournalAcronym().toLowerCase());
			journal.setJournalAbbrName(journalVo.getJournalAcronym().toLowerCase());
			journal.setDoiPrefix(journalVo.getDoiPrefix());
			journal.setJournalName(journalVo.getJournalTitle());
			journal.setOpenAccessStatus(journalVo.getoAStatus());
			// journal.setJournalIssn(journalVo.);
			journal.setOnlineIssn(journalVo.getOnlineIssn());
			journal.setJournalType(journalVo.getJournalType());
			journal.setStatus("Active");
			journal.setLanguage("English");
			journal.setArticleWorkflowId(0);
			journal.setIssueWorkflowId(0);
			journal.setFromEmail(journalVo.getFromEmail());
		//	journal.setFromPassword(journalVo.getFromPassword());
			journal.setPublisherId(journalVo.getPublisher_id());
			journal.setPublicationType(journalVo.getPublicationType());
			// start volume number is 30, issue number is 1,
			Integer year = Calendar.getInstance().get(Calendar.YEAR);
			journal.setHouseStyle(journalVo.getHouseStyle());
			journal.setPageLayout(journalVo.getPageLayout());
			journal.setPartnerContact(journalVo.getPartnerContact());
			Integer jrid = journalService.savejournal(journal);

			if (journalVo.getPublicationType().equalsIgnoreCase("Quarterly")) {
				String[] issueQuterly = { "Jan-Mar " + year.toString(), "Apr-Jun" + year.toString(),
						" Jul-Sep" + year.toString(), " Oct-Dec" + year.toString() };
				int i = 1;
				for (String issueTitel : issueQuterly) {

					IssueDetail issue = new IssueDetail();
					issue.setIssue_title(issueTitel);
					issue.setCreate_date(new Date());
					issue.setPublisher_id(142);
					issue.setJournalId(jrid);
					issue.setNumber_of_volume_per_year("30");
					issue.setVolume_year(year.toString());
					issue.setLast_issue_number("1");
					issue.setIssueSeqNo(i);
					issue.setIssue_status("Y");
					issue.setIsSupplementary("N");
					issue.setIsScheduled("N");
					Integer issueId = issueDetailService.saveIssue(issue);
					i++;
				}
			}
			if (journalVo.getPublicationType().equalsIgnoreCase("Yearly")) {
				String[] issueYearly = { "Jan-Dec" + year.toString() };
				int i = 1;
				for (String issueTitel : issueYearly) {

					IssueDetail issue = new IssueDetail();
					issue.setIssue_title(issueTitel);
					issue.setCreate_date(new Date());
					issue.setPublisher_id(142);
					issue.setJournalId(jrid);
					issue.setNumber_of_volume_per_year("30");
					issue.setVolume_year(year.toString());
					issue.setLast_issue_number("1");
					issue.setIssueSeqNo(i);
					issue.setIssue_status("Y");
					issue.setIsSupplementary("N");
					issue.setIsScheduled("N");
					Integer issueId = issueDetailService.saveIssue(issue);
					i++;
				}
			}
			if (journalVo.getPublicationType().equalsIgnoreCase("Bimonthly")) {
				int i = 1;
				String[] issueQuterly = { "Jan-Feb" + year.toString(), "Mar-Apr" + year.toString(),
						"May-Jun" + year.toString(), "Jul-Aug" + year.toString() , "Sep-Oct" + year.toString(), "Nov-Dec" + year.toString() };
				for (String issueTitel : issueQuterly) {

					IssueDetail issue = new IssueDetail();
					issue.setIssue_title(issueTitel);
					issue.setCreate_date(new Date());
					issue.setPublisher_id(142);
					issue.setJournalId(jrid);
					issue.setNumber_of_volume_per_year("30");
					issue.setVolume_year(year.toString());
					issue.setLast_issue_number("1");
					issue.setIssueSeqNo(i);
					issue.setIssue_status("Y");
					issue.setIsSupplementary("N");
					issue.setIsScheduled("N");
					Integer issueId = issueDetailService.saveIssue(issue);
					i++;
				}
			}
			if (journalVo.getPublicationType().equalsIgnoreCase("Semiannual")) {
				int i = 1;
				String[] issueQuterly = { "Jan-Jun" + year.toString(),  "Jul-Dec" + year.toString() };
				for (String issueTitel : issueQuterly) {

					IssueDetail issue = new IssueDetail();
					issue.setIssue_title(issueTitel);
					issue.setCreate_date(new Date());
					issue.setPublisher_id(142);
					issue.setJournalId(jrid);
					issue.setNumber_of_volume_per_year("30");
					issue.setVolume_year(year.toString());
					issue.setLast_issue_number("1");
					issue.setIssueSeqNo(i);
					issue.setIssue_status("Y");
					issue.setIsSupplementary("N");
					issue.setIsScheduled("N");
					Integer issueId = issueDetailService.saveIssue(issue);
					i++;
				}
			}
			if (journalVo.getPublicationType().equalsIgnoreCase("Triannual")) {
				int i = 1;
				String[] issueQuterly = { "Jan-Apr" + year.toString(),"May-Aug" + year.toString(),"Sep-Dec" + year.toString() };
				for (String issueTitel : issueQuterly) {

					IssueDetail issue = new IssueDetail();
					issue.setIssue_title(issueTitel);
					issue.setCreate_date(new Date());
					issue.setPublisher_id(142);
					issue.setJournalId(jrid);
					issue.setNumber_of_volume_per_year("30");
					issue.setVolume_year(year.toString());
					issue.setLast_issue_number("1");
					issue.setIssueSeqNo(i);
					issue.setIssue_status("Y");
					issue.setIsSupplementary("N");
					issue.setIsScheduled("N");
					Integer issueId = issueDetailService.saveIssue(issue);
					i++;
				}
			}
			if (journalVo.getPublicationType().equalsIgnoreCase("Monthly")) {
				String[] issueMonthly = { "January-" + year.toString(), "February-" + year.toString(),
						"March-" + year.toString(), "April-" + year.toString(), "May-" + year.toString(),
						"June-" + year.toString(), "July-" + year.toString(), "August-" + year.toString(),
						"September-" + year.toString(), "October-" + year.toString(), "November-" + year.toString(),
						"December-" + year.toString() };
				int i = 1;
				for (String issueTitel : issueMonthly) {

					IssueDetail issue = new IssueDetail();
					issue.setIssue_title(issueTitel);
					issue.setCreate_date(new Date());
					issue.setPublisher_id(142);
					issue.setJournalId(jrid);
					issue.setNumber_of_volume_per_year("30");
					issue.setVolume_year(year.toString());
					issue.setLast_issue_number("1");
					issue.setIssueSeqNo(i);
					issue.setIssue_status("Y");
					issue.setIsSupplementary("N");
					issue.setIsScheduled("N");
					Integer issueId = issueDetailService.saveIssue(issue);
					i++;
				}
			}
			LOGGER.info("journal api createjournalApi --->" + journalVo.toString());
			return new ResponseEntity<>(journal, HttpStatus.OK);
		}
	}
}
