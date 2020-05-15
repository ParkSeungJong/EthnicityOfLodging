package com.mal_a.filemng;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.mal_a.cmn.StringUtil;
import com.mal_a.roomoption.RoomOptionVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class uploadServlet
 */
@WebServlet(description = "파일 업로드", urlPatterns = { "/roxandrea/fileMng.do" })
public class FileMngCont extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(FileMngCont.class);
	private static FileMngService fileMngService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileMngCont() {
        super();
        fileMngService = new FileMngService();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파일 저장 경로
		String savePath = "D:\\java_20191031\\02_Oracle\\dao_workspace\\MAL_A\\WebContent\\roxandrea\\upload";
		
		//파일 사이즈: 50M
		int size = 1024*1024*50;
		
		//인코딩
		String encType = "UTF-8";
		
		//화면 리턴
		//List<FileVO> fileList = new ArrayList<FileVO>();
		JsonArray jsonArray = new JsonArray();
		
		FileMngVO fileMngVO = new FileMngVO();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter  out = response.getWriter();
		
		//upload dir이 없으면 생성
		File dirUpload = new File(savePath);
		if(dirUpload.exists()==false)dirUpload.mkdir();
		
		Date date = new Date();
		
		//년
		SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
		String year = sdfYear.format(date);//2020
		String yearPath = savePath + File.separator + year;
		File yearDir = new File(yearPath);
		if(yearDir.exists()==false)yearDir.mkdir();
		
		//월
		SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
		String month = sdfMonth.format(date);//03
		String monthPath = yearPath + File.separator + month;
		File monthDir = new File(monthPath);
		if(monthDir.exists()==false)monthDir.mkdir();
		
		//savePath -> yearPath + monthPath
		LOG.debug("before savePath"+savePath);
		savePath = monthPath;
		LOG.debug("after savePath"+savePath);
		
		try {
			MultipartRequest multi = new MultipartRequest(request, savePath, size, encType, new DefaultFileRenamePolicy());
			
			//fileId
			String uuid = StringUtil.getUUID();
			String yyyyMMdd = StringUtil.getDate("yyyyMMddHHmmss");
			String fileId = yyyyMMdd + uuid;
			LOG.debug("fileId:" + fileId + " length:" + fileId.length());
			
			Enumeration<String> files = multi.getFileNames();
			
			while(files.hasMoreElements()){
				
				String tmpFile = files.nextElement();
				if(null==multi.getOriginalFileName(tmpFile) || tmpFile.length()==0)continue;
				
				//원본파일
				String orgFileName = multi.getOriginalFileName(tmpFile);
				
				//저장파일
				String saveFileName = multi.getFilesystemName(tmpFile);
				
				//savePath: savePath + saveFileName
				String saveFilePath = savePath + File.separator + saveFileName;
				LOG.debug("------------------------------");
				LOG.debug("-orgFileName-"+orgFileName);
				LOG.debug("-saveFileName-"+saveFileName);
				LOG.debug("-savePath + saveFileName-"+saveFilePath);
				LOG.debug("------------------------------");
				
				//파일 사이즈
				File fileSize = new File(saveFilePath);
				long fileLongSize = fileSize.length();
				
				//확장자
				String ext = "";
				if(saveFileName.lastIndexOf(".")>0) {
					int dotIndex = saveFileName.lastIndexOf(".");
					ext = saveFileName.substring(dotIndex+1);
				}
				
				//fileVO 셋팅
				fileMngVO.setOrgNm(orgFileName);
				fileMngVO.setSaveNm(saveFileName);
				fileMngVO.setFileSize(fileLongSize);
				fileMngVO.setSavePath(savePath);
				fileMngVO.setExt(ext);
				fileMngVO.setFileId(fileId);
				//TODO:Session -> 등록자Id, 수정자Id
				
				//jsonArray 셋팅
				//fileList.add(fileVO);
				jsonArray.add(fileMngVO.getFileId());
				jsonArray.add(fileMngVO.getOrgNm());
				jsonArray.add(fileMngVO.getSaveNm());
				jsonArray.add(fileMngVO.getSavePath());
				jsonArray.add(fileMngVO.getFileSize());
				jsonArray.add(fileMngVO.getExt());
			}
			
			/*
			for(FileVO vo:fileList) {
				LOG.debug("-vo-"+vo);
			}
			*/
			
		}catch(Exception e) {
			LOG.debug("------------------------------");
			LOG.debug("-Exception-"+e.getMessage());
			LOG.debug("------------------------------");
		}
		
		//화면으로 전달
		out.print(jsonArray);
		
		/*
		request.setAttribute("fileList", fileList);
		String retPath = "/roxandrea/testResult.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(retPath);
		requestDispatcher.forward(request, response);
		*/
	}
	
	public static String doRetrieve(String fileId) {
		//VO 객체 생성
		FileMngVO inFileMngVO = new FileMngVO();
		
		//스트링빌더
		StringBuilder sb = new StringBuilder();
		
		//VO에 String 데이터 셋팅
		inFileMngVO.setFileId(fileId);
		
		//VO 데이터 확인
		LOG.debug("================================");
		LOG.debug("=inVO="+inFileMngVO);
		LOG.debug("================================");
		
		//서비스 실행해서 List에 담기
		List<FileMngVO> outListFileMng = (List<FileMngVO>) fileMngService.doRetrieve(inFileMngVO);
		
		for(FileMngVO vo:outListFileMng) {
			sb.append(vo.getSavePath()+vo.getSaveNm());
		}
		
		return sb.toString();
	}

}
