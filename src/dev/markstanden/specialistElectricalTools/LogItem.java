package dev.markstanden.specialistElectricalTools;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class LogItem {

	private final LogInputSource source;

	private ArrayList<String> assetTagList;
	private Location location;
	private Product product;
	private boolean isFixedItem;
	private boolean isEmIsolation;
	private boolean isAlarmed;
	private String connection;
	private String power;
	private String flexCondition;
	private ArrayList<String> comments;
	private boolean isTested;
	private LocalDateTime testDate;

	LogItem(String filePath, String createdDateString, boolean isFolder) {
		this.source = new FlowData(filePath, createdDateString, isFolder);
	}

	public String getDigitalLocation() {
		return source.getSourceLocation();
	}
}
