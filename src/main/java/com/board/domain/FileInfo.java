package com.board.domain;

import java.time.LocalDateTime;

public class FileInfo {
	private int fileSeq;
	private int postId;
	private String fileName;
	private String fileType;
	private String encodeFileName;
	private String directoryPath;
	private LocalDateTime saveDt;
	public int getFileSeq() {
		return fileSeq;
	}
	public void setFileSeq(int fileSeq) {
		this.fileSeq = fileSeq;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getEncodeFileName() {
		return encodeFileName;
	}
	public void setEncodeFileName(String encodeFileName) {
		this.encodeFileName = encodeFileName;
	}
	public String getDirectoryPath() {
		return directoryPath;
	}
	public void setDirectoryPath(String directoryPath) {
		this.directoryPath = directoryPath;
	}
	public LocalDateTime getSaveDt() {
		return saveDt;
	}
	public void setSaveDt(LocalDateTime saveDt) {
		this.saveDt = saveDt;
	}
	@Override
	public String toString() {
		return "FileInfo [fileSeq=" + fileSeq + ", postId=" + postId + ", fileName=" + fileName + ", fileType="
				+ fileType + ", encodeFileName=" + encodeFileName + ", directoryPath=" + directoryPath + ", saveDt="
				+ saveDt + "]";
	}
	
}
