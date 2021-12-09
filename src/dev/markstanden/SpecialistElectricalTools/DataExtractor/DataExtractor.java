package dev.markstanden.SpecialistElectricalTools.DataExtractor;

import dev.markstanden.SpecialistElectricalTools.LogEntry;
import dev.markstanden.SpecialistElectricalTools.LogItem;

import java.util.ArrayList;

public interface DataExtractor {
	ArrayList<LogItem> getItems();

	ArrayList<LogEntry> getEntries();
}
