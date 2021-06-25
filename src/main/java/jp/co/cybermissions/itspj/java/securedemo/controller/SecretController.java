package jp.co.cybermissions.itspj.java.securedemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 会員専用（要認証）URLのコントローラー
 */
@Controller
@RequestMapping("/sec")
public class SecretController {

  @GetMapping("")
  public String index() {
    return "sec/index";
  }
}
