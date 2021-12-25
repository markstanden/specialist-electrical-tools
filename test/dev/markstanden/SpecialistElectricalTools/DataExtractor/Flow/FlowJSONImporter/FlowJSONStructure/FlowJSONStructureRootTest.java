package dev.markstanden.SpecialistElectricalTools.DataExtractor.Flow.FlowJSONImporter.FlowJSONStructure;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FlowJSONStructureRootTest {

	@Test
	public void checkJSONStructureSettersAndGetters() {
		FlowJSONDataRoot testData = new FlowJSONDataRoot();
		FlowJSONDataObject testObject1 = new FlowJSONDataObject();
		FlowJSONDataObject testObject2 = new FlowJSONDataObject();
		FlowJSONDataObject testObject3 = new FlowJSONDataObject();
		FlowJSONDataObject testObject4 = new FlowJSONDataObject();
		ArrayList<FlowJSONDataObject> dataObjects = new ArrayList<>(4);

		dataObjects.add(testObject1);
		dataObjects.add(testObject2);
		dataObjects.add(testObject3);
		dataObjects.add(testObject4);
		testData.setData(dataObjects);

		assertNotNull(testData.getData(), "Not null");
		assertEquals(dataObjects, testData.getData(), "returned object is identical to the data sent");

		assertEquals(testObject1, testData.getData().get(0), "Objects are as added");
		assertEquals(testObject2, testData.getData().get(1), "Objects are as added");
		assertEquals(testObject3, testData.getData().get(2), "Objects are as added");
		assertEquals(testObject4, testData.getData().get(3), "Objects are as added");

		assertNotEquals(testObject1, testData.getData().get(1), "Objects refs are unique");
		assertNotEquals(testObject1, testData.getData().get(2), "Objects refs are unique");
		assertNotEquals(testObject1, testData.getData().get(3), "Objects refs are unique");
		assertNotEquals(testObject1, testData.getData().get(1), "Objects refs are unique");
		assertNotEquals(testObject2, testData.getData().get(2), "Objects refs are unique");
		assertNotEquals(testObject2, testData.getData().get(3), "Objects refs are unique");
		assertNotEquals(testObject3, testData.getData().get(3), "Objects refs are unique");
	}
}
