package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/wallet")
public class SmallWalletController {

    @RequestMapping(value = "/list")
    public String list() {
        return "smallWallet/walletList";
    }

    @RequestMapping(value = "/edit")
    public String edit() {
        return "smallWallet/walletEdit";
    }


}
