package dev.markstanden.specialistElectricalTools;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FlowJSONFileReaderTest {

	@Test
	public void checkJSONFileImportNotNull() throws IOException {
		final String filePath = "test/resources/hatherlyBSU.json";
		FlowJSONFileReader reader = new FlowJSONFileReader(filePath);
		assertNotNull(reader.data);
	}

	@Test
	public void checkJSONFileImportsCorrectValues() throws IOException {
		final String filePath = "test/resources/hatherlyBSU.json";
		FlowJSONFileReader reader = new FlowJSONFileReader(filePath);
		assertEquals(reader.getData().getData().get(0).getCreated(), "2021-12-01T08:11:36Z", "created");
		assertEquals(reader.getData().getData().get(0).getFullPath(), "Shared Documents/Photolog/ToAdd/HatherlyBSU/(Sensor Taps,Broen,El){FixedItem}[] @Ha,F08,Behind IPS Panel@", "filepath");
		assertTrue(reader.getData().getData().get(0).getIsFolder(), "isFolder");
	}

}

//  {
//         "created": "2021-12-01T08:11:36Z",
//         "fullpath": "Shared Documents/Photolog/ToAdd/HatherlyBSU/(Sensor Taps,Broen,El){FixedItem}[] @Ha,F08,Behind IPS Panel@",
//         "isFolder": "True"
//      },