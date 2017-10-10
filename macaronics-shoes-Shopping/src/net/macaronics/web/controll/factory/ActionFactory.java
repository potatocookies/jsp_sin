package net.macaronics.web.controll.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.macaronics.web.admin.controller.AdminIndexAction;
import net.macaronics.web.admin.controller.AdminProductDetailAction;
import net.macaronics.web.admin.controller.AdminProductListAction;
import net.macaronics.web.admin.controller.AdminProductWriteAction;
import net.macaronics.web.admin.controller.AdminProductWriteFormAction;
import net.macaronics.web.controll.CartDeleteAction;
import net.macaronics.web.controll.CartDeleteAjaxAction;
import net.macaronics.web.controll.CartInsertAction;
import net.macaronics.web.controll.CartInsertAjax;
import net.macaronics.web.controll.CartListAction;
import net.macaronics.web.controll.IndexAction;
import net.macaronics.web.controll.JoinFormAction;
import net.macaronics.web.controll.LogOutAction;
import net.macaronics.web.controll.LoginFormAction;
import net.macaronics.web.controll.MyPageAction;
import net.macaronics.web.controll.OrderAllAction;
import net.macaronics.web.controll.OrderDetailAction;
import net.macaronics.web.controll.OrderInsertAction;
import net.macaronics.web.controll.OrderListAction;
import net.macaronics.web.controll.ProductDetailAction;
import net.macaronics.web.controll.ProductKindAction;
import net.macaronics.web.controll.QnaListAction;
import net.macaronics.web.controll.QnaViewAction;
import net.macaronics.web.controll.QnaWriteAction;
import net.macaronics.web.controll.QnaWriteFormAction;
import net.macaronics.web.controll.action.Action;

public class ActionFactory {
	final Logger logger =LogManager.getLogger(ActionFactory.class);
	//싱글톤설정
	private static ActionFactory instance;
	private ActionFactory(){
		super();
	}
	public static ActionFactory getInstance(){
		if(instance==null){
			instance=new ActionFactory();
		}
		return instance;
	}
	
	
	//command 에서 넘어온 파라미터 값이 존재하면 실행
	//즉 ,존재하면 url 만 실행된다. 
	public Action getAction(String command){
		Action action=null;
		logger.info("ActionFactory : {}  ", command);
		
		if(command.equals("index")) action=new IndexAction();  
		else if(command.equals("product_detail")) action=new ProductDetailAction();//상품 상세보기
		else if(command.equals("category")) action=new ProductKindAction(); //상품종류별 보기
		else if(command.equals("join_form"))action=new JoinFormAction(); //회워가입
		else if(command.equals("login_form"))action=new LoginFormAction(); //로그인
		else if(command.equals("logout")) action=new LogOutAction(); //로그아웃
		else if(command.equals("cart_insert"))action=new CartInsertAction(); //장바구니에 담기
		else if(command.equals("cart_list")) action=new CartListAction(); //장바구니 목록
		else if(command.equals("cart_delete")) action=new CartDeleteAction(); //장바구니 삭제
		else if(command.equals("cart_ajax")) action=new CartInsertAjax(); //장바구니 ajax  담기
		else if(command.equals("cart_delete_ajax")) action=new CartDeleteAjaxAction(); //장바구니 ajax  삭제
		else if(command.equals("order_insert")) action=new OrderInsertAction(); //주문하기
		else if(command.equals("order_list")) action=new OrderListAction(); //주문처리 후 바로 보여지는 주문 목록페이지
		else if(command.equals("mypage")) action=new MyPageAction(); //진행중인 주문내역
		else if(command.equals("order_detail")) action=new OrderDetailAction(); //주문 상세 정보
		else if(command.equals("order_all")) action=new OrderAllAction(); //총 주문 내역 보기
		else if(command.equals("qna_list")) action=new QnaListAction(); //질문 목록 보기
		else if(command.equals("qna_write_form")) action=new QnaWriteFormAction(); //질문 폼으로 이동
		else if(command.equals("qna_write")) action=new QnaWriteAction(); //질문 하기
		else if(command.equals("qna_view")) action=new QnaViewAction(); //질문 게시글 상세 보기
		else if(command.equals("admin_login_form")) action=new AdminIndexAction(); //관리자 로그인 폼
		else if(command.equals("admin_product_list")) action=new AdminProductListAction(); //관리자 상품 목록
		else if(command.equals("admin_product_write_form")) action=new AdminProductWriteFormAction(); //관리자 상품 등록 폼
		else if(command.equals("admin_product_write")) action=new AdminProductWriteAction(); //관리자 상품 등록하기
		else if(command.equals("admin_product_detail")) action=new AdminProductDetailAction(); //관리자 상품 상세보기
		
		return action;
	}
	
		
	
}
