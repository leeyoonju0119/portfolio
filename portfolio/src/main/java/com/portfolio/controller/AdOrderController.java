package com.portfolio.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.portfolio.domain.AdOrderDetailVO;
import com.portfolio.domain.OrderVO;
import com.portfolio.dto.Criteria;
import com.portfolio.dto.PageDTO;
import com.portfolio.service.AdOrderService;
import com.portfolio.util.FileUtils;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/admin/order/*")
@Controller
public class AdOrderController {

	@Setter(onMethod_ = {@Autowired})
	private AdOrderService adOrderService;

	//업로드폴더 주입
		@Resource(name = "uploadPath") // servlet-context.xml 참조.
		private String uploadPath;  // C:\\dev\\upload\\pds\\
		
		@GetMapping("/order_list")
		public void orderList(@ModelAttribute("cri") Criteria cri, @ModelAttribute("sDate") String sDate, @ModelAttribute("eDate") String eDate, Model model) {
			
			
			log.info("시작날자: " + sDate);
			log.info("종료날자: " + eDate);
			
			List<OrderVO> orderList = adOrderService.orderList(cri, sDate, eDate);
			model.addAttribute("orderList", orderList);
			
			int totalCount = adOrderService.getTotalCount(cri, sDate, eDate);
			model.addAttribute("pageMaker", new PageDTO(totalCount, cri));
		}
		
		// 주문상세정보
		@ResponseBody
		@GetMapping("/order_detail")
		public ResponseEntity<List<AdOrderDetailVO>> orderDetail(Long ord_code) {
			
			ResponseEntity<List<AdOrderDetailVO>> entity = null;
			
			entity = new ResponseEntity<List<AdOrderDetailVO>>(adOrderService.orderDetail(ord_code), HttpStatus.OK);
			
			return entity;
			
		}
		
		@ResponseBody
		@GetMapping("/displayImage")
		public ResponseEntity<byte[]> displayFile(String folderName, String fileName) throws IOException {
			
			//                  C:\\dev\\upload\\pds\\
			return FileUtils.getFile(uploadPath + folderName, fileName);
		}
		
		// 주문상세 상품삭제
		@PostMapping("/order_detail_product_delete")
		@ResponseBody
		public ResponseEntity<String> orderDetailProductDelete(Long ord_code, Integer pro_num) {
			ResponseEntity<String> entity = null;
			
			// db작업
			adOrderService.orderDetailProductDelete(ord_code, pro_num);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			return entity;
		};


	// 주문상품삭제
		@PostMapping("/orderInfoDelete")
		@ResponseBody
		public ResponseEntity<String> orderInfoDelete(Long ord_code) {
			ResponseEntity<String> entity = null;
			
			// db작업
			adOrderService.orderInfoDelete(ord_code);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			return entity;
		};
	
}