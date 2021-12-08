package dev.markstanden.specialistElectricalTools;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FlowJSONFileReaderTest {

	@Test
	public void checkJSONFileImportNotNull() throws IOException {
		final String filePath = "test/resources/flow_test_data.json";
		FlowJSONFileReader reader = new FlowJSONFileReader(filePath);
		assertNotNull(reader.data);
	}

	@Test
	public void checkJSONFileImportsAllValues() throws IOException {
		final String filePath = "test/resources/flow_test_data.json";
		FlowJSONFileReader reader = new FlowJSONFileReader(filePath);
		assertEquals(4, reader.getParsedData().getData().size());
	}


	@Test
	public void checkJSONFileImportsCorrectValues() throws IOException {
		final String filePath = "test/resources/flow_test_data.json";

		FlowJSONFileReader reader = new FlowJSONFileReader(filePath);

		ZonedDateTime created;
		String fullpath;
		boolean isFolder;

		created = ZonedDateTime.parse("2021-01-01T08:00:00Z");
		fullpath = "Root/Sub/Photolog/ToAdd/(Item-Description,Manufacturer,Product-I.D.) {Tag, TagWithValue=Value} [12345678] @Building,RM001,Location@";
		isFolder = true;
		assertEquals(created, reader.getParsedData().getData().get(0).getCreated(), "created");
		assertEquals(fullpath, reader.getParsedData().getData().get(0).getFullPath(), "filepath");
		assertEquals(isFolder, reader.getParsedData().getData().get(0).getIsFolder(), "isFolder");


		created = ZonedDateTime.parse("2021-12-30T09:00:00Z");
		fullpath = "Root/Sub/Photolog/ToAdd/(Item-Description,Manufacturer,Product-I.D.) {Tag, TagWithValue=Value} [12345679] @Building,RM012.3A,Location@/";
//		isFolder = true;
		assertEquals(created, reader.getParsedData().getData().get(1).getCreated(), "created");
		assertEquals(fullpath, reader.getParsedData().getData().get(1).getFullPath(), "filepath");
		assertEquals(isFolder, reader.getParsedData().getData().get(1).getIsFolder(), "isFolder");

		created = ZonedDateTime.parse("2021-06-30T09:59:00Z");
		fullpath = "Root/Sub/Photolog/ToAdd/(Item-Description,Manufacturer,Product-I.D.) {Tag, TagWithValue=Value} [12345679] @Building,RM012.3A,Location@/Test File !Comment#Could Be Anything Here! \"Including This\" {And=This,Or=This}.test";
		isFolder = false;
		assertEquals(created, reader.getParsedData().getData().get(2).getCreated(), "created");
		assertEquals(fullpath, reader.getParsedData().getData().get(2).getFullPath(), "filepath");
		assertEquals(isFolder, reader.getParsedData().getData().get(2).getIsFolder(), "isFolder");

		created = ZonedDateTime.parse("2021-06-30T09:59:00Z");
		fullpath = "Root/Sub/Photolog/ToAdd/(Item-Description,Manufacturer,Product-I.D.){Tag,TagWithValue=Value}[12345679]@Building,RM012.3A,Location@/Test File!Comment=Could Be Anything Here!\"Including This\"{And=This,Or=This}.test";
//		isFolder = false;
		assertEquals(created, reader.getParsedData().getData().get(3).getCreated(), "created");
		assertEquals(fullpath, reader.getParsedData().getData().get(3).getFullPath(), "filepath");
		assertEquals(isFolder, reader.getParsedData().getData().get(3).getIsFolder(), "isFolder");
	}

}