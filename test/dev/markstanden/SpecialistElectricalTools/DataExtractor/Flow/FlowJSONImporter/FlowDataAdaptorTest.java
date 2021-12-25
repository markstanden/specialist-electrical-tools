package dev.markstanden.SpecialistElectricalTools.DataExtractor.Flow.FlowJSONImporter;

import dev.markstanden.SpecialistElectricalTools.DataExtractor.Flow.FlowJSONImporter.FlowJSONStructure.FlowJSONDataObject;
import dev.markstanden.SpecialistElectricalTools.DataExtractor.Flow.FlowJSONImporter.FlowJSONStructure.FlowJSONDataRoot;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FlowDataAdaptorTest{
	FlowJSONDataRoot testData = new FlowJSONDataRoot();
	FlowJSONDataObject testObject1 = new FlowJSONDataObject();
	FlowJSONDataObject testObject2 = new FlowJSONDataObject();
	FlowJSONDataObject testObject3 = new FlowJSONDataObject();
	FlowJSONDataObject testObject4 = new FlowJSONDataObject();


	FlowDataAdaptorTest(){
		ArrayList<FlowJSONDataObject> dataObjects = new ArrayList<>(4);
		testObject1.setCreated("2021-01-01T08:00:00Z");
		testObject1.setFullpath("Root/Sub/Photolog/ToAdd/(Item-Description,Manufacturer,Product-I.D.) {Tag, TagWithValue=Value} [12345678] @Building,RM001,Location@");
		testObject1.setIsFolder(true);
		dataObjects.add(testObject1);

		testObject2.setCreated("2021-12-30T09:00:00Z");
		testObject2.setFullpath("Root/Sub/Photolog/ToAdd/(Item-Description,Manufacturer,Product-I.D.) {Tag, TagWithValue=Value} [12345679] @Building,RM012.3A,Location@");
		testObject2.setIsFolder(true);
		dataObjects.add(testObject2);

		testObject3.setCreated("2021-06-30T09:59:00Z");
		testObject3.setFullpath("Root/Sub/Photolog/ToAdd/(Item-Description,Manufacturer,Product-I.D.) {Tag, TagWithValue=Value} [12345679] @Building,RM012.3A,Location@/Test File !Comment#Could Be Anything Here! \"Including This\" {And=This,Or=This}.test");
		testObject3.setIsFolder(false);
		dataObjects.add(testObject3);

		testObject4.setCreated("2021-06-30T09:59:00Z");
		testObject4.setFullpath("Root/Sub/Photolog/ToAdd/(Item-Description,Manufacturer,Product-I.D.){Tag,TagWithValue=Value}[12345679]@Building,RM012.3A,Location@/Test File!Comment=Could Be Anything Here!\"Including This\"{And=This,Or=This}.test");
		testObject4.setIsFolder(false);
		dataObjects.add(testObject4);

		testData.setData(dataObjects);
	}

	@Test
	public void checkJSONFileImportNotNull() throws IOException {
		final String filePath = "test/resources/flow_test_data.json";
		FlowJSONFileReader reader = new FlowJSONFileReader(filePath);
		assertNotNull(reader.getParsedData());
	}
}
