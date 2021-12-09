package dev.markstanden.SpecialistElectricalTools.DataExtractor;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public class FlowData implements LogInputSource {
	public final String ROOT_FOLDER_NAME = "Photolog";
	public final String WORKING_FOLDER_NAME = "ToAdd";

	private final String relativeFolderPath;
	private final String folder;
	private final String filename;
	private final LocalDate fileCreatedDate;
	private final boolean isFolder;

	public FlowData(String filePath, ZonedDateTime createdDate, boolean isFolder) {
		String cleanedFilePath = removeSlashesIfPresent(filePath);
		this.fileCreatedDate = createdDate.toLocalDate();
		this.isFolder = isFolder;
		this.relativeFolderPath = this.stripRelativePathFromFilePath(cleanedFilePath);
		this.folder = this.stripFolderFromFilePath(cleanedFilePath);
		this.filename = this.stripFilenameFromFilePath(cleanedFilePath);
	}

	private String removeSlashesIfPresent(String path) {
		return removeLeadingSlashIfPresent(removeTrailingSlashIfPresent(path));
	}

	private String removeLeadingSlashIfPresent(String path) {
		if (path.startsWith("/")) {
			return path.substring(1);
		}
		return path;
	}

	private String removeTrailingSlashIfPresent(String path) {
		if (path.endsWith("/")) {
			return path.substring(0, path.length() - 1);
		}
		return path;
	}

	private String stripRelativePathFromFilePath(String filePath) {
		int startIndex;
		String rootWorkingPath = ROOT_FOLDER_NAME + "/" + WORKING_FOLDER_NAME;
		if (filePath.contains(rootWorkingPath)) {
			startIndex = filePath.indexOf(rootWorkingPath) + rootWorkingPath.length() + 1;
		} else {
			startIndex = filePath.indexOf(ROOT_FOLDER_NAME) + ROOT_FOLDER_NAME.length() + 1;
		}
		int endIndex = filePath.lastIndexOf("/");
		return filePath.substring(startIndex, endIndex);
	}

	private String stripFolderFromFilePath(String filePath) {
		int lastIndex = filePath.lastIndexOf("/");
		if (this.isFolder) {
			return filePath.substring(lastIndex + 1);
		}

		String filePathWithoutFile = filePath.substring(0, lastIndex);
		int secondToLastIndex = filePathWithoutFile.lastIndexOf("/");
		return filePath.substring(secondToLastIndex + 1, lastIndex);
	}

	private String stripFilenameFromFilePath(String filePath) {
		if (this.isFolder) {
			return null;
		}

		int lastIndex = filePath.lastIndexOf("/");
		return filePath.substring(lastIndex + 1);
	}

	public String getLogEntryString() {
		return this.filename;
	}

	public String getItemString() {
		return this.folder;
	}

	public String getSourceLocation() {
		return this.relativeFolderPath;
	}

	public boolean isFolder() {
		return isFolder;
	}

	public LocalDate getLogEntryDate() {
		return this.fileCreatedDate;
	}
}
