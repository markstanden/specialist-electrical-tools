package dev.markstanden.SpecialistElectricalTools;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class LogItem {
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

	LogItem() {

	}

}

