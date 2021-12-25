package dev.markstanden.SpecialistElectricalTools.DataExtractor.Flow.FlowJSONImporter.FlowJSONStructure;

import java.time.ZonedDateTime;

@SuppressWarnings ("ALL")
public class FlowJSONDataObject {

	private ZonedDateTime created;
	private String fullpath;
	private boolean isFolder;

	public ZonedDateTime getCreated() {
		return this.created;
	}

	public void setCreated(String dateTime) {
		this.created = ZonedDateTime.parse(dateTime);
	}

	public String getFullPath() {
		return this.fullpath;
	}

	public void setFullpath(String path) {
		this.fullpath = path;
	}

	public boolean getIsFolder() {
		return this.isFolder;
	}

	public void setIsFolder(boolean isFolder) {
		this.isFolder = isFolder;
	}

}
