package com.servPet.pdFav.controller;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.servPet.meb.model.MebService;
import com.servPet.meb.model.MebVO;
import com.servPet.pdFav.model.PdFavService;

@Controller
@RequestMapping("/pdFav")
public class PdFavController {

	@Autowired
	private MebService mebService;
	
	@Autowired
    private PdFavService pdFavService;
    
	// 查詢全部商品收藏
    @GetMapping("/list")
    public String listFavorites(Model model, Principal principal) {
    	boolean isLoggedIn = (principal != null);
        model.addAttribute("pdFavList", pdFavService.getAllFavorites());
        return "front_end/pdFav/listAllPdFav"; // 對應 /templates/front_end//pdFav/listAllPdFav.html
    }

    
    
    @PostMapping("/add")
    @ResponseBody
    public String addFavorite(HttpSession session, @RequestParam Integer pdId, Principal principal) {
        // 驗證用戶是否已登入
        if (principal == null) {
            return "請先登入會員";
        }

        Optional<MebVO> optionalMebVO = mebService.findMemberByEmail(principal.getName());
        if (!optionalMebVO.isPresent()) {
            return "請先登入會員";
        }

        MebVO mebVO = optionalMebVO.get();
        String result = pdFavService.addFavorite(mebVO.getMebId(), pdId);
        return result; // 傳回成功或失敗的訊息
    }

    
    
    @PostMapping("/deleteFavorite")
    @ResponseBody
    public ResponseEntity<String> deleteFavorite(@RequestParam Integer pdFavId) {
        if (pdFavId != null) {
            pdFavService.deleteFavoriteById(pdFavId);
            return ResponseEntity.ok("已成功取消收藏！");
        } else {
            return ResponseEntity.badRequest().body("收藏 ID 不存在！");
        }
    }

    
    
    @GetMapping("/isFavorite")
    @ResponseBody
    public boolean isFavorite(@RequestParam Integer mebId, @RequestParam Integer pdId) {
        /*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
        // 驗證傳入的參數是否有效
        if (mebId == null || pdId == null) {
            return false;
        }

        /*************************** 2.開始查詢資料 *****************************************/
        boolean isFavorite = pdFavService.checkIfFavorite(mebId, pdId).isPresent();

        /*************************** 3.查詢完成,返回結果(Send the Success view) **************/
        return isFavorite;
    }
}