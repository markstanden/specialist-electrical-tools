package dev.markstanden.specialistElectricalTools;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class FlowJSONFileReader {
	ObjectMapper mapper = new ObjectMapper();
	FlowJSONData data;

	public FlowJSONFileReader(String filePath) throws IOException {
		data = mapper.readValue(new File(filePath), FlowJSONData.class);
	}

	public FlowJSONData getParsedData() {
		return this.data;
	}
}
