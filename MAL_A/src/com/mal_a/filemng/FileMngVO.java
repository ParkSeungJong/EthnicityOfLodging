/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.filemng
 * 클래스명 : FileMng.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-17    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-17 오후 4:26:04
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.filemng;

import com.mal_a.cmn.DTO;

/**
 * @author sist
 *
 */
public class FileMngVO extends DTO {
	private	String	fileId		;/**	파일ID			*/
	private	int		seq			;/**	순번				*/
	private	String	orgNm		;/**	원본파일명			*/
	private	String	saveNm		;/**	저장파일명			*/
	private	String	savePath	;/**	저장경로			*/
	private	long	fileSize	;/**	사이즈			*/
	private	String	ext			;/**	확장자			*/
	private	String	filePart	;/**	파일생성페이지분류	*/
	private	String	regId		;/**	등록자아이디		*/
	private	String	regDt		;/**	등록일			*/
	private	String	modId		;/**	수정자아이디		*/
	private	String	modDt		;/**	수정일			*/
		
	public FileMngVO() {
		
	}

	public FileMngVO(String fileId, int seq, String orgNm, String saveNm, String savePath, long fileSize, String ext,
			String filePart, String regId, String regDt, String modId, String modDt) {
		super();
		this.fileId = fileId;
		this.seq = seq;
		this.orgNm = orgNm;
		this.saveNm = saveNm;
		this.savePath = savePath;
		this.fileSize = fileSize;
		this.ext = ext;
		this.filePart = filePart;
		this.regId = regId;
		this.regDt = regDt;
		this.modId = modId;
		this.modDt = modDt;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getOrgNm() {
		return orgNm;
	}

	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}

	public String getSaveNm() {
		return saveNm;
	}

	public void setSaveNm(String saveNm) {
		this.saveNm = saveNm;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getFilePart() {
		return filePart;
	}

	public void setFilePart(String filePart) {
		this.filePart = filePart;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	public String getModId() {
		return modId;
	}

	public void setModId(String modId) {
		this.modId = modId;
	}

	public String getModDt() {
		return modDt;
	}

	public void setModDt(String modDt) {
		this.modDt = modDt;
	}

	@Override
	public String toString() {
		return "FileMngVO [fileId=" + fileId + ", seq=" + seq + ", orgNm=" + orgNm + ", saveNm=" + saveNm
				+ ", savePath=" + savePath + ", fileSize=" + fileSize + ", ext=" + ext + ", filePart=" + filePart
				+ ", regId=" + regId + ", regDt=" + regDt + ", modId=" + modId + ", modDt=" + modDt + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}
