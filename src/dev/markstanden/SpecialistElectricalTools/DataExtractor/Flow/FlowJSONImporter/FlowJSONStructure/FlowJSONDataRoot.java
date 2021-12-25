package dev.markstanden.SpecialistElectricalTools.DataExtractor.Flow.FlowJSONImporter.FlowJSONStructure;

import java.util.ArrayList;

public class FlowJSONDataRoot {
	private ArrayList<FlowJSONDataObject> data;

	public ArrayList<FlowJSONDataObject> getData() {
		return data;
	}

	public void setData(ArrayList<FlowJSONDataObject> data) {
		this.data = data;
	}
}