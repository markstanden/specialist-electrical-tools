package dev.markstanden.SpecialistElectricalTools.DataExtractor.Flow.FlowJSONImporter.FlowJSONStructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlowJSONStructureObjectTest {

	@Test
	public void checkCreatedDate() {
		FlowJSONDataObject testObject = new FlowJSONDataObject();
		testObject.setCreated("2021-02-01T08:00:00Z");
		assertEquals(1, testObject.getCreated().getDayOfMonth());
		assertEquals(2, testObject.getCreated().getMonthValue());
		assertEquals(2021, testObject.getCreated().getYear());
	}

	@Test
	public void checkFullPath() {
		FlowJSONDataObject testObject = new FlowJSONDataObject();
		testObject.setFullpath("Path String");
		assertEquals("Path String", testObject.getFullPath());
	}

	@Test
	public void checkIsFolder() {
		FlowJSONDataObject testObject = new FlowJSONDataObject();
		testObject.setIsFolder(true);
		assertTrue(testObject.getIsFolder());
	}
}
