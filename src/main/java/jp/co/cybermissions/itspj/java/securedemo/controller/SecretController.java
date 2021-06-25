package jp.co.cybermissions.itspj.java.securedemo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.cybermissions.itspj.java.securedemo.model.CustomUserDetailsImpl;

/**
 * 会員専用（要認証）URLのコントローラー
 */
@Controller
@RequestMapping("/sec")
public class SecretController {

  @GetMapping("")
  public String index(@AuthenticationPrincipal CustomUserDetailsImpl userDetails) {
    // ログインユーザの情報を取得する
    System.out.println("user_id:" + userDetails.getUserId());
    System.out.println("email:" + userDetails.getEmail());
    return "sec/index";
  }
}
