package dev.markstanden.SpecialistElectricalTools.DataExtractor;

import java.time.LocalDate;

/**
 * Interface to add a source of log data.
 */
public interface LogInputSource {
	String getLogEntryString();

	String getItemString();

	String getSourceLocation();

	boolean isFolder();

	LocalDate getLogEntryDate();
}
