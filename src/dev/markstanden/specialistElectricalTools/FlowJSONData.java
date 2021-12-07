package dev.markstanden.specialistElectricalTools;

import java.util.ArrayList;

public class FlowJSONData {
	public ArrayList<FlowJSONDataObject> data;

	public ArrayList<FlowJSONDataObject> getData() {
		return data;
	}

	public void setData(ArrayList<FlowJSONDataObject> data) {
		this.data = data;
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
