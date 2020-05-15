package com.mal_a.review;

import java.util.List;
import org.apache.log4j.Logger;
import com.mal_a.cmn.DTO;

public class ReviewService {

	 private final Logger LOG = Logger.getLogger(this.getClass());
	 
	 private ReviewDao reviewdao;
	 
	 public ReviewService() {
		 reviewdao = new ReviewDao();
	 }
	

	public DTO doSelectOne(DTO dto) { 
	      return reviewdao.doSelectOne(dto);
	   }
	   
	   public int doUpdate(DTO dto) {
		   return reviewdao.doUpdate(dto);
	   }
	   
	   public int doDelete(DTO dto) {
		   return reviewdao.doDelete(dto);
	   }
	   
	   public int doInsert(DTO dto) {
		   return reviewdao.doInsert(dto);
	   }
	   
	   public List<?> doRetrieve(DTO dto){
		   return reviewdao.doRetrieve(dto);
	   }
	   
	   public DTO doSelectOneAvgStar(DTO dto) {
		   return reviewdao.doSelectOneAvgStar(dto);
	   }
	
	
}
