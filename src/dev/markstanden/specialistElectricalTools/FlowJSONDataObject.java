package dev.markstanden.specialistElectricalTools;

import java.time.ZonedDateTime;

@SuppressWarnings ("ALL")
public class FlowJSONDataObject {

	String created;
	String fullpath;
	boolean isFolder;

	public String getCreated() {
		return this.created;
	}

	public void setCreated(String dateTime) {
		this.created = dateTime;
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

//	{
//   "data": [
//      {
//         "created": "2021-12-01T08:11:36Z",
//         "fullpath": "Shared Documents/Photolog/ToAdd/HatherlyBSU/(Sensor Taps,Broen,El){FixedItem}[] @Ha,F08,Behind IPS Panel@",
//         "isFolder": "True"
//      },
//	   ]
//	}

