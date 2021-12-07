package dev.markstanden.specialistElectricalTools;

import java.time.LocalDate;

/**
 * Interface to add a source of log data.
 */
interface LogInputSource {
	String getLogEntryString();

	String getItemString();

	String getSourceLocation();

	boolean isFolder();

	LocalDate getLogEntryDate();
}
