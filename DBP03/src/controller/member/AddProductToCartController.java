package controller.member;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import service.dto.cartDTO;

public class AddProductToCartController implements Controller, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	
	}
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String p_id = request.getParameter("productId");
		
		if (p_id == null) 
			throw new ServletException("상품코드가 입력되지 않았습니다.");
		
		HttpSession session = request.getSession();
		cartDTO cart = (cartDTO) session.getAttribute("CART");
		
		//세션에서 장바구니 객체가 없을 경우 새로 만들기
		if (cart == null)
			cart = new cartDTO();
		
		//세션에서 장바구니 객체 있을 경우 장바구니에 상품 추가 
		cart.addItem(p_id,  1);
		session.setAttribute("CART", cart);
		
		return "redirect:/cart/result";
	}
}
