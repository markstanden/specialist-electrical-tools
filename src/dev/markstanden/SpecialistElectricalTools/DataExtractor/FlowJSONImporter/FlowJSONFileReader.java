package dev.markstanden.SpecialistElectricalTools.DataExtractor.FlowJSONImporter;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.markstanden.SpecialistElectricalTools.DataExtractor.FlowJSONImporter.JSONStructure.FlowJSONDataRoot;

import java.io.File;
import java.io.IOException;

public class FlowJSONFileReader {
	ObjectMapper mapper = new ObjectMapper();
	FlowJSONDataRoot data;

	public FlowJSONFileReader(String filePath) throws IOException {
		data = mapper.readValue(new File(filePath), FlowJSONDataRoot.class);
	}

	public FlowJSONDataRoot getParsedData() {
		return this.data;
	}
}
