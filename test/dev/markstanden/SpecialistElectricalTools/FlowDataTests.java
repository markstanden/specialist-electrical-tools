package dev.markstanden.SpecialistElectricalTools;

import dev.markstanden.SpecialistElectricalTools.DataExtractor.FlowData;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings ("SpellCheckingInspection")
public class FlowDataTests {
	final String BASE_PATH = "Root/Sub/Photolog/ToAdd";
	final String BASE_FOLDER = "(Item-Description,Manufacturer,Product-I.D.) {Tag, TagWithValue=Value} [12345678] @Building,RM012.3A,Location@";
	final String BASE_FILENAME = "Test File !Comment#Could Be Anything Here! \"Including This\" {And=This,Or=This}.test";
	final String BASE_RELATIVEPATH = "Building/" + BASE_FOLDER;
	final String BASE_RELATIVEFILEPATH = BASE_RELATIVEPATH + "/" + BASE_FILENAME;
	final String BASE_FULLFILEPATH = BASE_PATH + "/" + BASE_RELATIVEFILEPATH;
	final String BASE_FULLFOLDERPATH = BASE_PATH + "/" + BASE_RELATIVEPATH;
	final ZonedDateTime BASE_DATE = ZonedDateTime.parse("2021-12-01T08:00:00Z");

	@Test
	public void checkRelativePathFromFullFilePath() {
		boolean isFolder = false;
		FlowData flowData = new FlowData(BASE_FULLFILEPATH, BASE_DATE, isFolder);
		assertEquals(BASE_RELATIVEPATH, flowData.getSourceLocation());
	}

	@Test
	public void checkFolderFromFullFilePath() {
		boolean isFolder = false;
		FlowData flowData = new FlowData(BASE_FULLFILEPATH, BASE_DATE, isFolder);
		assertEquals(BASE_FOLDER, flowData.getItemString());
	}

	@Test
	public void checkFolderFromFolderPath() {
		boolean isFolder = true;
		FlowData flowData = new FlowData(BASE_FULLFOLDERPATH, BASE_DATE, isFolder);
		assertEquals(BASE_FOLDER, flowData.getItemString());
	}

	@Test
	public void checkFilenameFromFullPath() {
		boolean isFolder = false;
		FlowData flowData = new FlowData(BASE_FULLFILEPATH, BASE_DATE, isFolder);
		assertEquals(BASE_FILENAME, flowData.getLogEntryString());
	}

	@Test
	public void checkPathWithLeadingOrTrailingSlash() {
		String path = BASE_FULLFILEPATH + "/";
		FlowData flowData = new FlowData(path, BASE_DATE, false);
		assertEquals(BASE_FILENAME, flowData.getLogEntryString(), "Trailing Slash on a file path");

		path = BASE_FULLFOLDERPATH + "/";
		flowData = new FlowData(path, BASE_DATE, true);
		assertEquals(BASE_FOLDER, flowData.getItemString(), "Trailing Slash on a folder path");

		path = "/" + BASE_FULLFILEPATH;
		flowData = new FlowData(path, BASE_DATE, false);
		assertEquals(BASE_FILENAME, flowData.getLogEntryString(), "Leading Slash on a file path");

		path = "/" + BASE_FULLFOLDERPATH;
		flowData = new FlowData(path, BASE_DATE, true);
		assertEquals(BASE_FOLDER, flowData.getItemString(), "Leading Slash on a folder path");

		path = "/" + BASE_FULLFILEPATH + "/";
		flowData = new FlowData(path, BASE_DATE, false);
		assertEquals(BASE_FILENAME, flowData.getLogEntryString(), "Leading and trailing Slash on a file path");

		path = "/" + BASE_FULLFOLDERPATH + "/";
		flowData = new FlowData(path, BASE_DATE, true);
		assertEquals(BASE_FOLDER, flowData.getItemString(), "Leading and trailing Slash on a folder path");
	}

	@Test
	public void checkValidDateGMTTimezone() {
		final ZonedDateTime date = ZonedDateTime.parse("2021-12-01T08:30:59Z");
		boolean isFolder = false;
		FlowData flowData = new FlowData(BASE_FULLFILEPATH, date, false);
		assertEquals(1, flowData.getLogEntryDate().getDayOfMonth(), "Day of Month");
		assertEquals(12, flowData.getLogEntryDate().getMonthValue(), "Month");
		assertEquals(2021, flowData.getLogEntryDate().getYear(), "Year");
	}
}
